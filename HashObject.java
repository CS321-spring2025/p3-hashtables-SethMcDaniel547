public class HashObject {
    private Object key;
    private boolean deleted;
    private int frequencyCount;
    private int probeCount;

    public HashObject(Object key) {
        deleted = false;
        this.key = key;
        frequencyCount = 1;
        probeCount = 0;

    }

    public HashObject(int key) {
        deleted = false;
    }

    public void delete() {
        key = null;
        deleted = true;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Object getKey() {
        return key;
    }

    public void incrementFrequency() {
        frequencyCount++;
    }

    public void deccrementFrequency() {
        frequencyCount--;
    }

    public void incrementProbeCount() {
        probeCount++;
    }

    public int getProbeCount() {
        return probeCount;
    }

    public int getFrequencyCount() {
        return frequencyCount;
    }

    public boolean equals(Object itemToCompare) {
        return key.equals(itemToCompare);
    }

    public String toString() {
        //TODO
    }

}
