/**
 * An abstract Hash table that requires an implementation of the hashFunction
 * 
 * @author Seth McDaniel
 */
import java.io.PrintWriter;

public abstract class Hashtable {
    protected HashObject[] table;
    protected int size;
    protected int numUniqueItems;
    protected int numInsertions;

    /**
     * A constructor for the hash table
     * 
     * @param size The size of the table
     */
    public Hashtable(int size) {
        this.table = new HashObject[size];
        numInsertions = 0;
        numUniqueItems = 0;
        this.size = size;
    }

    /**
     * Insert a HashObject into the hash table using the hashFunction
     * 
     * @param newItem The hashObject to add
     */
    public void insert(HashObject newItem) {
        numInsertions++;
        int hashedItemIndex = hashFunction(newItem);
        if (!newItem.equals(table[hashedItemIndex])) {
            numUniqueItems++;
            table[hashedItemIndex] = newItem;
        } else {
            table[hashedItemIndex].incrementFrequency();
        }  
    }

    /**
     * Deletes an item by wiping it's key and flagging it as deleted
     * 
     * @param itemToDelete The item to delete
     */
    public void delete(HashObject itemToDelete) {
        table[search(itemToDelete)].delete();
    }

    /**
     * Searches the hash table for specified item
     * 
     * @param itemToFind The item to find
     * @return The index within the hash table of the item
     */
    public int search(HashObject itemToFind) {
        int i = 0;
        while (table[hashFunction(itemToFind)] != null | i != size) {
            if (table[hashFunction(itemToFind)] == itemToFind) {
                return hashFunction(itemToFind);
            } else {
                i++;
            }
        }
        return -1;
    }

    /**
     * A mod function that ensures no negative values are returned
     * 
     * @param dividend The quantity to be modded
     * @param divisor The quantity to mod by
     * @return
     */
    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
        }

    
    /**
     * Formats data in hash table for a file
     * 
     * @param fileName The name of the file to save to
     */
    public void dumpToFile(String fileName) {
        PrintWriter out;
        try {
            out = new PrintWriter(fileName);
            for (int i = 0; i < size; i++) {
                if (table[i] != null) {
                    out.println("table[" + i + "]: " + table[i].getKey() + " " + table[i].getFrequencyCount() + " " + table[i].getProbeCount());
                }
            }
            out.close();
        } catch (Exception e) {
            System.err.println("Error reading the file");
            e.printStackTrace();
        }
       
    }

    /**
     * Counts up the amount of probes used so far
     * 
     * @return probe count
     */
    public int getProbeCount() {
        int count = 0;
        for (HashObject hashObject : table) {
            if (hashObject != null) {
                count += hashObject.getProbeCount();
            }
        }
        return count;
    }

    /**
     * Get the number of unique items in the hash table
     * 
     * @return Number of unique items in the table
     */
    public int getNumUniqueItems() {
        return numUniqueItems;
    }

    /**
     * Get the number of insertions, including duplicates and unique values
     * 
     * @return number of insertions
     */
    public int getNumInsertions() {
        return numInsertions;
    }

    protected abstract int hashFunction(HashObject item);
}
