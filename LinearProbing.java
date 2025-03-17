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
        //int tableIndex = (item.hashCode()) % size;
        Object key = item.getKey();
        int tableIndex = positiveMod(key.hashCode(), size);
        int i = 0;
        int numProbe = 1;
        while (!item.equals(table[tableIndex]) && table[tableIndex] != null && i < size) {
            i++;
            //item.incrementProbeCount(); <---------------------------------------------- This doesnt go here, but I think this function needs to increase the probeCount
            //tableIndex = (item.hashCode() + i) % size;
            numProbe++;
            tableIndex = positiveMod(key.hashCode() + i, size);
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
