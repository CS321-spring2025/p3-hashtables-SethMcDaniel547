/**
 * A wrapper class for the items within the Hash Table
 * 
 * @author Seth McDaniel
 */
public class HashObject {
    private Object key;
    private boolean deleted;
    private int frequencyCount;
    private int probeCount;

    /**
     * Wrap an object to store it within the hash table
     * 
     * @param key Item to wrap
     */
    public HashObject(Object key) {
        deleted = false;
        this.key = key;
        frequencyCount = 1;
        probeCount = 0;

    }

    /**
     * Delete this hash object by wiping it's key value and flagging it as deleted
     */
    public void delete() {
        key = null;
        deleted = true;
    }

    /**
     * Check if item is deleted
     * 
     * @return true if the item is marked as deleted
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Get the value of the item that has been wrapped
     * 
     * @return key value
     */
    public Object getKey() {
        return key;
    }

    /**
     * increment the frequency of the item by one
     */
    public void incrementFrequency() {
        frequencyCount++;
    }

    /**
     * decrement the frequency of the item by one
     */
    public void decrementFrequency() {
        frequencyCount--;
    }

    /**
     * increment the probe count by one
     */
    public void incrementProbeCount() {
        probeCount++;
    }

    /**
     * increment the probe count by specified amount
     * @param amount The amount to increase probe count by
     */
    public void incrementProbeCount(int amount) {
        probeCount += amount;
    }

    /**
     * Get probe count on this item
     * 
     * @return probe count
     */
    public int getProbeCount() {
        return probeCount;
    }

    /**
     * Get the amount of this item there is
     * 
     * @return frequency of this item
     */
    public int getFrequencyCount() {
        return frequencyCount;
    }

    /**
     * Check if another hashobject is equal to this hash object
     * 
     * @param itemToCompare Item to check if equal to
     * @return true if equal, false otherwise
     */
    public boolean equals(HashObject itemToCompare) {
        if (itemToCompare == null) {
            return false;
        }
        if (key == itemToCompare.getKey()) {
            return true;
        }
        return key.equals(itemToCompare.getKey());
    }

    /**
     * Format properties as a string
     */
    public String toString() {
        return(key.toString() + " " + getFrequencyCount() + " " + getProbeCount());
    }

}
