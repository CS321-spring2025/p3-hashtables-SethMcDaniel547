public class LinearProbing extends Hashtable {

    public LinearProbing() {
        super(size);
    }

    //Yeah
    protected int hashFunction(HashObject item) {
        int i = 0;
        while (table[hashCode(item.getKey() + i)] != null && i < size) {
            i++;
        }
        if (table[hashCode(item.getKey() + i)] == null) {
            return hashCode(item.getKey() + i);
        } else {
            return -1;
        }

    }
    
}
