// import java.util.Scanner;
public class AtoIProblem {

    public static int myAtoi(String s) {
        int n=0;
        boolean neg=false;
        while(s.charAt(n)==' '){
            n++;
        }
        if(s.charAt(n)=='-'){
            neg=true;
        }
        while(n<s.length() && (s.charAt(n)=='0'|| s.charAt(n)=='+' || s.charAt(n)=='-')){
            n++;
        }
        int o=0;
        for(int i=n; i<s.length(); i++){
            int n1=(int) s.charAt(i);
            if(n1>=(int)'0' && n1<= (int) '9'){
                o*=10;
                o+=(int) s.charAt(i)-48;
            }
            else{
                break;
            }
        }
        if(neg){
            o*=-1;
        }
        return o;
    }

public static void check(String in, int out) {
        System.out.print("Input " + in + "...");
        System.out.print("Output " + myAtoi(in) + "...");
        if (myAtoi(in) == out) {
                System.out.println("PASSED.");
        } else {
                System.out.println("FAILED. Expected: " + out);
        }
}

public static void main(String args[]) {
        check("12345", 12345);
        check("   123", 123);
        check("0", 0);
        check("-0", 0);
        check("-123", -123);
        check("    +401", 401);
        check("  234.12E", 234);
        check("  12 34 40", 12);

}
}
