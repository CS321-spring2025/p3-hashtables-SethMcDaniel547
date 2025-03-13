public class HashObject {
    private int key;
    private boolean deleted;

    public HashObject(int key) {
        deleted = false;
    }
    
    public void delete() {
        deleted = true;
    }

    public int getKey() {
        return key;
    }
}
