import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Hashtable {
    protected HashObject[] table;
    protected int size;
    protected int numUniqueItems;
    protected int numInsertions;

    public Hashtable(int size) {
        this.table = new HashObject[size];
        numInsertions = 0;
        numUniqueItems = 0;
        this.size = size;
    }

    public void insert(HashObject newItem) {
        numInsertions++;
        int hashedItemIndex = hashFunction(newItem);
        if (!newItem.equals(table[hashedItemIndex])) {
            numUniqueItems++;
            table[hashedItemIndex] = newItem;
        } else {
            table[hashedItemIndex].incrementFrequency();
        }
        // for (int i = 0; i < size; i++) { //I really dont know why Im looping here
        //     if (table[hashedItemIndex] == null) {
        //         table[hashedItemIndex] = newItem;
        //         numUniqueItems++;
        //         for (int j = numProbes; j > 0; j--) {
        //             table[hashedItemIndex].incrementProbeCount();
        //         }
        //     }
        //     if (table[hashFunction(newItem)].equals(newItem)) {
        //         table[hashFunction(newItem)].incrementFrequency();
        //     }
        //     numProbes++;
        // }
        
    }

    public void delete(HashObject itemToDelete) {
        table[search(itemToDelete)].delete();
    }

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

    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
        }

    
    public void dumpToFile(String fileName) {
        PrintWriter out;
        try {
            out = new PrintWriter(fileName);
            for (HashObject hashObject : table) {
                out.println(hashObject);
            }
            // loop through the hash table, and print non-null entries 
            // using toString() method in the HashObject class
            out.close();
        } catch (Exception e) {
            System.err.println("Error reading the file");
            e.printStackTrace();
        }
       
    }

    public int getProbeCount() {
        int count = 0;
        for (HashObject hashObject : table) {
            if (hashObject != null) {
                count += hashObject.getProbeCount();
            }
        }
        return count;
    }

    public int getNumUniqueItems() {
        return numUniqueItems;
    }

    public int getNumInsertions() {
        return numInsertions;
    }

        

    protected abstract int hashFunction(HashObject item);
}
