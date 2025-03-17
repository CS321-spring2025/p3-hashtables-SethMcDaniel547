public class LinearProbing extends Hashtable {

    public LinearProbing(int size) {
        super(size);
    }

    //Yeah
    // protected int hashFunction(HashObject item) {
    //     int i = 0;
    //     while (table[hashCode(item.getKey() + i)] != null && i < size) {
    //         i++;
    //     }
    //     if (table[hashCode(item.getKey() + i)] == null) {
    //         return hashCode(item.getKey() + i);
    //     } else {
    //         return -1;
    //     }

    // }

    protected int hashFunction(HashObject item) {
        int tableIndex = (item.hashCode()) % size;
        int i = 0;
        while (table[tableIndex] != null && i < size) {
            i++;
            tableIndex = (item.hashCode() + i) % size;
        }
        if (i == size) {
            return -1;
        }
        return tableIndex;
    }
    
}
