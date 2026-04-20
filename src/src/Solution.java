import java.util.*;
class Main {

    static int linearComparisons = 0;
    static int binaryComparisons = 0;

    // 🔹 Linear Search (First Occurrence)
    public static int linearFirst(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i].equals(target))
                return i;
        }
        return -1;
    }

    // 🔹 Linear Search (Last Occurrence)
    public static int linearLast(String[] arr, String target) {
        for (int i = arr.length - 1; i >= 0; i--) {
            linearComparisons++;
            if (arr[i].equals(target))
                return i;
        }
        return -1;
    }

    // 🔹 Binary Search (Any One Match)
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            binaryComparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // 🔹 Find First Occurrence (Binary)
    public static int binaryFirst(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            binaryComparisons++;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1; // move left
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // 🔹 Find Last Occurrence (Binary)
    public static int binaryLast(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            binaryComparisons++;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1; // move right
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // 🔹 Count Occurrences
    public static int countOccurrences(String[] arr, String target) {
        int first = binaryFirst(arr, target);
        int last = binaryLast(arr, target);

        if (first == -1) return 0;
        return last - first + 1;
    }

    // 🔹 Main
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // 🔸 Linear Search (unsorted)
        int firstLin = linearFirst(logs, "accB");
        int lastLin = linearLast(logs, "accB");

        System.out.println("Linear First accB: index " + firstLin);
        System.out.println("Linear Last accB: index " + lastLin);
        System.out.println("Linear Comparisons: " + linearComparisons);

        // 🔸 Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        // 🔸 Binary Search
        int anyIndex = binarySearch(logs, "accB");
        int count = countOccurrences(logs, "accB");

        System.out.println("Binary accB: index " + anyIndex);
        System.out.println("Count of accB: " + count);
        System.out.println("Binary Comparisons: " + binaryComparisons);
    }
}