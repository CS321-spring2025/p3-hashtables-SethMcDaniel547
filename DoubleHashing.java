public class DoubleHashing extends Hashtable{

    public DoubleHashing(int size) {
        super(size);
    }

    protected int hashFunction(HashObject item) {
        //int tableIndex = (item.hashCode()) % size;
        Object key = item.getKey();
        int tableIndex = positiveMod(key.hashCode(), size);
        int i = 0;
        int numProbe = 1;
        while (!item.equals(table[tableIndex]) && table[tableIndex] != null && i < size) {
            i++;
            //tableIndex = (item.hashCode() + i * item.hashCode()) % size;
            //tableIndex = 1 + positiveMod(key.hashCode(), size - 2);
            tableIndex = positiveMod((positiveMod(key.hashCode(), size) + i * (1 + positiveMod(key.hashCode(), size - 2))), size); //Straight from the textbook
            numProbe++;
        }
        if (i == size) {
            return -1;
        }
        if (!item.equals(table[tableIndex])) {
            item.incrementProbeCount(numProbe);
        }
        return tableIndex;
    }
    
}
