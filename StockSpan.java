package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        StockSpanner sp=new StockSpanner();
        System.out.println(sp.next(100));
        System.out.println(sp.next(80));
        System.out.println(sp.next(60));
        System.out.println(sp.next(70));
        System.out.println(sp.next(60));
        System.out.println(sp.next(75));
        System.out.println(sp.next(85));
    }
}

class StockSpanner {
    Stack<Integer> st;
    List<Integer> list;
    public StockSpanner() {
            st=new Stack<>();
            list=new ArrayList<>();
    }
    public int next(int price) {
        list.add(price);
        while(!st.isEmpty() && list.get(st.peek())<=price){
            st.pop();
        }
        int pgi=(st.isEmpty())?-1:st.peek();
        int curr=list.size()-1;
        st.push(curr);
        return curr-pgi;
    }
}