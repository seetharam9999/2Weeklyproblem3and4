import java.util.*;

class Main {

    static int linearComparisons = 0;
    static int binaryComparisons = 0;

    // 🔹 Linear Search (unsorted)
    public static boolean linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i] == target)
                return true;
        }
        return false;
    }

    // 🔹 Binary Search (Insertion Point / Lower Bound)
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            binaryComparisons++;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low; // insertion index
    }

    // 🔹 Floor (largest ≤ target)
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            binaryComparisons++;

            if (arr[mid] == target)
                return arr[mid];
            else if (arr[mid] < target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // 🔹 Ceiling (smallest ≥ target)
    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            binaryComparisons++;

            if (arr[mid] == target)
                return arr[mid];
            else if (arr[mid] > target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    // 🔹 Main
    public static void main(String[] args) {

        int[] unsorted = {50, 10, 100, 25};
        int[] sorted = {10, 25, 50, 100};

        int target = 30;

        // 🔸 Linear Search (unsorted)
        boolean found = linearSearch(unsorted, target);
        System.out.println("Linear Search (" + target + "): " + (found ? "Found" : "Not Found"));
        System.out.println("Linear Comparisons: " + linearComparisons);

        // 🔸 Binary Operations
        int index = lowerBound(sorted, target);
        int floorVal = floor(sorted, target);
        int ceilVal = ceiling(sorted, target);

        System.out.println("\nSorted Array: " + Arrays.toString(sorted));
        System.out.println("Insertion Index (lower_bound): " + index);
        System.out.println("Floor(" + target + "): " + floorVal);
        System.out.println("Ceiling(" + target + "): " + ceilVal);
        System.out.println("Binary Comparisons: " + binaryComparisons);
    }
}