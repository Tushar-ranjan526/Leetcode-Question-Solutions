import java.util.*;

public class MedianCalculator {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianCalculator() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public float getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((float) maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return (float) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of operations
        MedianCalculator mc = new MedianCalculator();
        List<Float> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val == 999999) {
                results.add(mc.getMedian());
            } else {
                mc.addNum(val);
            }
        }

        for (float res : results) {
            System.out.printf("%.1f ", res);
        }

    }
}