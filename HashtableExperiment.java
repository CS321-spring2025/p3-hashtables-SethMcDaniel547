import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Random;

public class HashtableExperiment {
    private static int size;
    private static double loadFactor;
    private static LinearProbing linearHash;
    private static DoubleHashing doubleHash;
    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        int dataSource = Integer.parseInt(args[0]);
        loadFactor = Double.parseDouble(args[1]);
        int debugLevel = 0; //Use this for gods sake
        if (args.length == 3) {
            debugLevel = Integer.parseInt(args[2]);
        }

        size = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        linearHash = new LinearProbing(size);
        doubleHash = new DoubleHashing(size);
        System.out.print("HashtableExperiment: ");
        if (size <= 0) {
            System.err.println("No prime number found within range");
            return;
        }
        System.out.print("Found a twin prime table capacity: " + size
                        + "\nHashtableExperiment: Input: ");
        if (dataSource == 1) {
            System.out.print("nextInt()");
            dataSource1();
        } else if (dataSource == 2) {
            System.out.print("Date");
            dataSource2();
        } else if (dataSource == 3) {
            System.out.print("Word-List");
            dataSource3();
        } else {
            System.err.println("Error selecting data source");
        }
        System.out.println("   Loadfactor: " + String.format("%.2f", loadFactor));

        System.out.println("\n\tUsing Linear Probing");
        printResults(linearHash);
        
        System.out.println("\n\tUsing Double Hashing");
        printResults(doubleHash);
    }

    private static 
    void printResults(Hashtable hash) {
        System.out.println("HashtableExperiment: size of hash table is " + hash.numUniqueItems
                        + "\n\tInserted " + hash.getNumInsertions() + " elements, of which " + (hash.getNumInsertions() - hash.getNumUniqueItems()) + " were duplicates"
                        + "\n\tAvg. no. of probes = " + String.format("%.2f", ((double)hash.getProbeCount() / hash.getNumUniqueItems())));
    }

    //input until load factor is met size * load factor = n or somethin
    private static void dataSource1() {
        int itemCount = (int) Math.ceil(loadFactor * size);
        Random rand = new Random();
        while (linearHash.numUniqueItems < itemCount) { //use numUniqueItems <---------------------Next Step
            int num = rand.nextInt();
            linearHash.insert(new HashObject(num));
            doubleHash.insert(new HashObject(num));
        }
    }

    private static void dataSource2() {
        int itemCount = (int) Math.ceil(loadFactor * size);
        long current = new Date().getTime();
        while (linearHash.numUniqueItems < itemCount) {
            current += 1000; //increase by 1 second (1000 ms)
            Date date = new Date(current);
            linearHash.insert(new HashObject(date));
            doubleHash.insert(new HashObject(date));
        }
    }

    private static void dataSource3() {
        try {
            int itemCount = (int) Math.ceil(loadFactor * size);
            BufferedReader br = new BufferedReader(new FileReader("word-list.txt"));
            while (linearHash.numUniqueItems < itemCount) {
                String line = br.readLine();
                linearHash.insert(new HashObject(line));
                doubleHash.insert(new HashObject(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Error reading the file");
            e.printStackTrace();
        }
    }

    private static void printUsage() {
        System.out.println(
            "Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]\n" +
            "       <dataSource>: 1 ==> random numbers\n" +
            "                     2 ==> date value as a long\n" +
            "                     3 ==> word list\n" +
            "       <loadFactor>: The ratio of objects to table size, \n" +
            "                       denoted by alpha = n/m\n" +
            "       <debugLevel>: 0 ==> print summary of experiment\n" +
            "                     1 ==> save the two hash tables to a file at the end\n" +
            "                     2 ==> print debugging output for each insert"
        );
    }
        
}

