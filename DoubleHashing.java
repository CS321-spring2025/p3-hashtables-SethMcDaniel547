public class DoubleHashing extends Hashtable{

    public DoubleHashing() {
        super(size);
    }

    protected int hashFunction(HashObject item) {
        int tableIndex = (item.hashCode()) % size;
        int i = 0;
        while (table[tableIndex] != null && i < size) {
            i++;
            tableIndex = (item.hashCode() + i * item.hashCode()) % size;
        }
        if (i == size) {
            return -1;
        }
        return tableIndex;
    }
    
}
