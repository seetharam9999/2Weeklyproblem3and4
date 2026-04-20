
import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

class Main {

    // 🔹 Bubble Sort (by fee)
    public static void bubbleSort(ArrayList<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) break; // early termination
        }

        System.out.println("Bubble Sort Passes: " + passes);
        System.out.println("Bubble Sort Swaps: " + swaps);
    }

    // 🔹 Insertion Sort (by fee + timestamp)
    public static void insertionSort(ArrayList<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // 🔹 Comparator logic
    public static int compare(Transaction t1, Transaction t2) {
        if (t1.fee != t2.fee)
            return Double.compare(t1.fee, t2.fee);
        else
            return t1.timestamp.compareTo(t2.timestamp);
    }

    // 🔹 Outlier detection
    public static void findOutliers(ArrayList<Transaction> list) {
        System.out.println("High-fee outliers:");
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("None");
        }
    }

    // 🔹 Main method
    public static void main(String[] args) {

        ArrayList<Transaction> list = new ArrayList<>();

        // Sample input
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        int size = list.size();

        if (size <= 100) {
            bubbleSort(list);
            System.out.println("Bubble Sorted: " + list);
        } else if (size <= 1000) {
            insertionSort(list);
            System.out.println("Insertion Sorted: " + list);
        }

        findOutliers(list);
    }
}