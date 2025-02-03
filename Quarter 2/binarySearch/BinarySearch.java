package binarySearch;

import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] array, int target, int L, int H) {
        int medium = (L+H)/2;
        if(array[medium]==target) return medium;
        else if(L>=H) return -1;
        else if(array[medium]<target) return binarySearch(array, target, medium+1, H);
        else return binarySearch(array, target, L, medium-1);
    }

    public static int binarySearch(int[] array, int target){
        return binarySearch(array, target, 0, array.length-1);
    }

    public static void main(String[] args) {
        boolean end = false;
        Scanner scanner = new Scanner(System.in);
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
        while (!end) {
            System.out.print("Enter a number to search, 0 to end: ");
            int number = scanner.nextInt();
            int result=binarySearch(primes, number);

            if (result ==-1) System.out.println("Not found");
            if (result > -1) System.out.println("Found at index " + result);
            end = (number == 0);
        }
    }
}