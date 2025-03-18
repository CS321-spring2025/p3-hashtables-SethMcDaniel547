/**
 * A linear probing method to hashing
 * 
 * @author Seth McDaniel
 */

public class LinearProbing extends Hashtable {

    /**
     *Constructor for hash table that uses linearProbing
     * 
     * @param size The size of the table
     */
    public LinearProbing(int size) {
        super(size);
    }

    /**
     * Finds an open position in the hash table with linear probing
     * 
     * @param item the item to hash
     * @return the result of the hashing on item
     */
    protected int hashFunction(HashObject item) {
        Object key = item.getKey();
        int tableIndex = positiveMod(key.hashCode(), size);
        int i = 0;
        int numProbe = 1;

        //While spot is not empty and item to insert does not equal item in table rehash
        while (!item.equals(table[tableIndex]) && table[tableIndex] != null && i < size) {
            i++;
            numProbe++;
            tableIndex = positiveMod(key.hashCode() + i, size);
        }

        //If no spot is found, return -1
        if (i == size) {
            return -1;
        }

        //Increment the probecount only if it is a unique item
        if (!item.equals(table[tableIndex])) {
            item.incrementProbeCount(numProbe);
        }
        return tableIndex;
    }
    
}
