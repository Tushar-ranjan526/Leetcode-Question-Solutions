import java.util.*;

public class KSortedArraysSorter {

    public static void sortKSortedArray(int[] arr, int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int index = 0;
        for (int i = 0; i <= k && i < n; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T-- > 0) {
            String[] nk = sc.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] arrStr = sc.nextLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }

            sortKSortedArray(arr, n, k);
        }
    }
}
