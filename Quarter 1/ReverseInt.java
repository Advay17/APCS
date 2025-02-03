public class ReverseInt {
    public static int reverse(int n) {
        boolean neg=n<0;
        n = Math.abs(n);
        int o=0;
        if((int) Math.abs(Math.log10(n))>=9){
            int[] m={7,4,6,3,8,4,7,4,1,2};
            int c=0;
            while(n>0){
                if(m[c]>n%10){
                    return -1;
                }
                if(m[c]<n%10){
                    break;
                }
                c++;
                o*=10;
                o+=n%10;
                n/=10;
            }
        }
        else{
            while(n>0){
                o*=10;
                o+=n%10;
                n/=10;
            }
        }
        if(neg){
            o*=-1;
        }
        return o;
    }

    public static void check(int in, int out) {
        System.out.print("Input " + in + "...");
        System.out.print("Output " + reverse(in) + "...");
        if (reverse(in) == out) {
                System.out.println("PASSED.");
        } else {
                System.out.println("FAILED. Expected: " + out);
        }
    }

public static void main(String args[]) {
        check(1423, 3241);
        check(1001, 1001);
        check(1234567, 7654321);
        check(12300, 321);
        check(1, 1);
        check(0, 0);
        check(100,1);
        check(1000000005, -1);
    }
}