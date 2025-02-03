import java.util.Scanner;
public class CreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long c=sc.nextLong();
        long length=(long) Math.floor(Math.floor(Math.log10(c)));
        // System.out.println(length);
        switch ((int) Math.floor(c/Math.pow(10, length))){
            case 4:
                System.out.print("Visa ");
                break;
            case 5:
                System.out.print("Mastercard ");
                break;
            case 3:
                if((int) (((Math.floor(c/Math.pow(10, length-1))))%10)==4 || (int) (((Math.floor(c/Math.pow(10, length-1))))%10)==7){
                    System.out.print("AMEX ");
                    break;
                }
            case 6:
                System.out.print("Discover ");
                break;
            default:
                System.out.println("Unknown card is invalid.");
                return;
        }
        int sum=0;
        boolean d=false;
        for(long i=0; i<=length; i++){
            int digit=(int) (((Math.floor(c/Math.pow(10, i))))%10);
            // System.out.println(digit);
            if(d){
                // System.out.println(digit);
                digit*=2;
                System.out.println(digit%10+(Math.floor(digit/10)));
                sum+=digit%10+(Math.floor(digit/10));
            }
            else{
                System.out.println(digit);
                sum+=digit;
            }
            d=!d;
        }
        System.out.println(sum);
        System.out.print(c + " is ");
        if (sum%10==0){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }
    }
}
