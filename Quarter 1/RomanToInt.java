import java.util.HashMap;
public class RomanToInt {
public static HashMap<Character, Integer> conversions = new HashMap<Character, Integer>();
public static int romanToInt(String s) {
        int i=0;
        int o=0;
        for(;i<s.length()-1; i++){
            if(conversions.get(s.charAt(i))>=conversions.get(s.charAt(i+1))){
                o+=conversions.get(s.charAt(i));
            }
            else{
                o+=conversions.get(s.charAt(i+1))-conversions.get(s.charAt(i));
                i++;
            }
        }
        if(i==s.length()-1){
            o+=conversions.get(s.charAt(i));
        }
        return o;
}
public static void check(String in, int out) {
        System.out.print("Input " + in + "...");
        System.out.print("Output " + romanToInt(in) + "...");
        if (romanToInt(in) == out) {
                System.out.println("PASSED.");
        } else {
                System.out.println("FAILED. Expected: " + out);
        }
}

public static void main(String args[]) {
        conversions.put('I', 1);
        conversions.put('V', 5);
        conversions.put('X', 10);
        conversions.put('L', 50);
        conversions.put('C', 100);            
        conversions.put('D', 500);
        conversions.put('M', 1000);
        check("XVIII", 18);
        check("MMLXVII", 2067);
        check("XXIV", 24);
        check("LXIV", 64);
        check("CCCXLIV", 344);
        check("CCXXX", 230);
    }
}