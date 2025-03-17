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

    public void decrementFrequency() {
        frequencyCount--;
    }

    public void incrementProbeCount() {
        probeCount++;
    }

    public void incrementProbeCount(int amount) {
        probeCount += amount;
    }

    public int getProbeCount() {
        return probeCount;
    }

    public int getFrequencyCount() {
        return frequencyCount;
    }

    public boolean equals(HashObject itemToCompare) {
        if (itemToCompare == null) {
            return false;
        }
        if (key == itemToCompare.getKey()) {
            return true;
        }
        return key.equals(itemToCompare.getKey());
    }

    public String toString() {
        //TODO
        return(key.toString() + " " + getFrequencyCount() + " " + getProbeCount());
    }

}
