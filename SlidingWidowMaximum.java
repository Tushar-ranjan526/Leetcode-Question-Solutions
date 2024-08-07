package Leetcode;

import java.util.*;

public class SlidingWidowMaximum {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] ans=maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(ans));
//        maxSlidingWindow(nums,3);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!deque.isEmpty() && deque.contains(i-k))deque.removeFirst();
            while(!deque.isEmpty() && nums[i]>nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i>=k-1)list.add(nums[deque.getFirst()]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
