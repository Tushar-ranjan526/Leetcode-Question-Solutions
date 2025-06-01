public class Main {
    public static void main(String[] args) {
       NumberContainers ns=new NumberContainers();
        System.out.println(ns.find(10));
       ns.change(2,10);
       ns.change(1,10);
       ns.change(3,10);
       ns.change(5,10);
       System.out.println(ns.find(10));
       ns.change(1,20);
       System.out.println(ns.find(10));
//       System.out.println(ns.find(20));
//       System.out.println(ns.find(30));
    }
}