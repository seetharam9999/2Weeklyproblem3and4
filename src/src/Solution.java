import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

class Main {

    // 🔹 Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;

                    // visualization of swap
                    System.out.println("Swap: " + arr[j] + " <-> " + arr[j + 1]);
                }
            }

            if (!swapped) break;
        }

        System.out.println("Total Swaps: " + swaps);
    }

    // 🔹 Insertion Sort (Descending by riskScore, then accountBalance)
    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 🔹 Comparator: DESC riskScore + accountBalance
    public static int compare(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore) {
            return Integer.compare(c1.riskScore, c2.riskScore);
        } else {
            return Double.compare(c1.accountBalance, c2.accountBalance);
        }
    }

    // 🔹 Top 10 highest risk clients
    public static void topRisks(Client[] arr, int k) {
        System.out.println("Top " + k + " Highest Risk Clients:");

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.println(arr[i].name + "(" + arr[i].riskScore + ")");
        }
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 2000),
                new Client("clientA", 20, 5000),
                new Client("clientB", 50, 3000)
        };

        // 🔸 Bubble Sort (Ascending)
        System.out.println("Bubble Sort (Ascending):");
        bubbleSort(clients);
        System.out.println(Arrays.toString(clients));

        // 🔸 Insertion Sort (Descending)
        insertionSort(clients);
        System.out.println("Insertion Sort (Descending):");
        System.out.println(Arrays.toString(clients));

        // 🔸 Top Risks
        topRisks(clients, 10);
    }
}