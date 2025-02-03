package Palindrome;

import java.util.Scanner;

public class PalindromeMaker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(palindrome(sc.nextInt()));
    }
    public static String palindrome(int length, String... S){
        String s = (S.length>0)?S[0]: "S";
        if(s.length()==length+1) return s.replace("S", "");
        if(s.length()==length) return s.replace('S', randChar());
        char r = randChar();
        return palindrome(length, r+s+r);
    }
    public static char randChar(){
        return "abc ".charAt((int) (Math.random()*4));
    }
}