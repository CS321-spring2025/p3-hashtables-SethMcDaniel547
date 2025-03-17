import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Random;

public class HashtableExperiment {
    private static int size;
    private static LinearProbing linearHash;
    private static DoubleHashing doubleHash;
    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        int dataSource = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel = 0;
        if (args.length == 3) {
            debugLevel = Integer.parseInt(args[2]);
        }

        size = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        if (dataSource == 1) {
            dataSource1();
        } else if (dataSource == 2) {
            dataSource2();
        } else if (dataSource == 3) {
            dataSource3();
        } else {
            System.err.println("Error selecting data source");
        }
    }

    private static void dataSource1() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt();
            linearHash.insert(new HashObject(num));
            doubleHash.insert(new HashObject(num));
        }
    }

    private static void dataSource2() {
        long current = new Date().getTime();
        for (int i = 0; i < size; i++) {
            current += 1000; //increase by 1 second (1000 ms)
            Date date = new Date(current);
            linearHash.insert(new HashObject(date));
            doubleHash.insert(new HashObject(date));
        }
    }

    private static void dataSource3() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("word-list.txt"));
            for (int i = 0; i < size; i++) {
                String line = br.readLine();
                linearHash.insert(new HashObject(line));
                doubleHash.insert(new HashObject(line));
            }
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

