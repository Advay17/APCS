public class Hanoi {
    public static void main(String[] args) {
        hanoi(4, "A", "B", "C");
    }
    public static void hanoi(int n, String s, String e, String t){
        if(n>0){
            hanoi(n-1, s, t, e);
            System.out.println("move " + n + " from " + s + " to " + e);
            hanoi(n-1, t, e, s);
        }
    }
}
