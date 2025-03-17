import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Hashtable {
    protected HashObject[] table;
    protected int size;

    public Hashtable(int size) {
        this.table = new HashObject[size];
    }

    public void insert(HashObject newItem) {
        int numProbes = 1;
        for (int i = 0; i < size; i++) {
            if (table[hashFunction(newItem)] == null) {
                table[hashFunction(newItem)] = newItem;
                for (int j = numProbes; j > 0; j--) {
                    table[hashFunction(newItem)].incrementProbeCount();
                }

            }
            if (table[hashFunction(newItem)].equals(newItem)) {
                table[hashFunction(newItem)].incrementFrequency();
            }
            numProbes++;
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

    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
        }

    
    public void dumpToFile(String fileName) {
        PrintWriter out;
        try {
            out = new PrintWriter(fileName);
            for (HashObject hashObject : table) {
                out.println(hashObject);
            }
            // loop through the hash table, and print non-null entries 
            // using toString() method in the HashObject class
            out.close();
        } catch (Exception e) {
            System.err.println("Error reading the file");
            e.printStackTrace();
        }
       
    }

        

    protected abstract int hashFunction(HashObject item);
}
