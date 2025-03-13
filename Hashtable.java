public abstract class Hashtable {
    private HashObject[] table;
    private int size;
    public HashTable (int size) {
        this.table = new HashObject[size];
    }

    public void insert(HashObject newItem) {
        for (int i = 0; i < size; i++) {
            if (table[hashCode(newItem.getKey())] == null) {
                return hashCode(newItem.getKey());
            }
        }
    }

    public void delete(HashObject itemToDelete) {
        table[search(itemToDelete)].delete();
    }

    public HashObject search(HashObject itemToFind) {
        int i = 0;
        while (table[hashCode(itemToFind.getKey())] != null | i != size) {
            if (table[hashCode(itemToFind.getKey())] == itemToFind) {
                return hashCode(itemToFind.getKey());
            } else {
                i++;
            }
        }
    }
}
