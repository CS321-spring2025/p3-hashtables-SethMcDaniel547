public abstract class Hashtable {
    protected HashObject[] table;
    protected int size;
    public Hashtable(int size) {
        this.table = new HashObject[size];
    }

    public void insert(HashObject newItem) {
        for (int i = 0; i < size; i++) {
            if (table[hashFunction(newItem)] == null) {
                table[hashFunction(newItem)] = newItem;
            }
        }
    }

    public void delete(HashObject itemToDelete) {
        table[search(itemToDelete)].delete();
    }

    public int search(HashObject itemToFind) {
        int i = 0;
        while (table[hashFunction(itemToFind)] != null | i != size) {
            if (table[hashFunction(itemToFind)] == itemToFind) {
                return hashFunction(itemToFind);
            } else {
                i++;
            }
        }
        return -1;
    }

    protected abstract int hashFunction(HashObject item);
}
