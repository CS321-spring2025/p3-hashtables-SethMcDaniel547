public class DoubleHashing extends Hashtable{

    public DoubleHashing(int size) {
        super(size);
    }

    protected int hashFunction(HashObject item) {
        //int tableIndex = (item.hashCode()) % size;
        Object key = item.getKey();
        int tableIndex = positiveMod(key.hashCode(), size);
        int i = 0;
        while (table[tableIndex] != null && i < size) {
            i++;
            //tableIndex = (item.hashCode() + i * item.hashCode()) % size;
            tableIndex = 1 + positiveMod (key.hashCode(), size - 2);
        }
        if (i == size) {
            return -1;
        }
        return tableIndex;
    }
    
}
