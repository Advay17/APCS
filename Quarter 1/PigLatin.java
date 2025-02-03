import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;
//I (do not) apologize
public class PigLatin {
    public static final Set<Character> vowels = new HashSet<Character>();
    public static final Set<Character> punctuation = new HashSet<Character>();
    public static void addVowels(){
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }
    public static void addPunctuation(){
        punctuation.add('.');
        punctuation.add('!');
        punctuation.add('"');
        punctuation.add('?');
    }
    public static void main(String[] args) {
        addVowels();
        addPunctuation();
        Scanner sc = new Scanner(System.in);
        // while(true){
        //     System.out.println("what word would you like to convert?");
        //     String s = sc.nextLine();
        //     String o = pigLatin(s);
        //     if (o==null) break;
        //     else System.out.println(o);
        // }
        System.out.println("What file would you like to convert?");
        filePigLatin(sc.nextLine());
        sc.close();
    }
    public static String pigLatin(String s){
        if(s.equals("__quit__")) return null;
        int tn=0;
        for(; tn<s.length() && punctuation.contains(s.charAt(tn)); tn++);
        int f=s.length()-1;
        int n=tn;
        for(; n<s.length() && punctuation.contains(s.charAt(tn)); f--);
        if(vowels.contains(s.charAt(tn))) return s.substring(0, f+1)+"way"+s.substring(f+1);
        for(; n<s.length(); n++){
            char c = Character.toLowerCase(s.charAt(n));
            if(vowels.contains(c) || (n!=0 && (c=='y'))){
                if(n>0 && c=='u' && Character.toLowerCase(s.charAt(n-1))=='q') n++;
                return new StringBuilder(s.substring(0, tn) + s.substring(n, f+1)+s.substring(tn, n)+"ay" + s.substring(f+1)).replace(tn, tn+1, (Character.isUpperCase(s.charAt(tn)))? Character.toUpperCase(s.charAt(n))+"": s.charAt(n)+"").replace(f+1-n, f+2-n, Character.toLowerCase(s.charAt(tn))+"").toString();
            }
        }
        return "**** INVALID ****";
    }
    public static String preserveCapsLatin(String s){
        String p = pigLatin(s).toLowerCase();
        ArrayList<Integer> ap = new ArrayList<Integer>();
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='\'') ap.add(i);
        }
        p.replace("'", "");
        s.replace("'", "");
        StringBuilder pB = new StringBuilder(p);
        for(int i=0; i<p.length(); i++){
            if(Character.isLowerCase(s.charAt(i))) pB.replace(i, i+1, Character.toUpperCase(p.charAt(i))+"");
        }
        for(int i:ap){
            pB.insert(i, '\'');
        }
        return pB.toString();
    }
    public static String worsePigLatin(String s){
        //This is worse than the first piglatin, I dislike it.
        //Change filePigLatin to use this function if you want to test it, it works.
        if(s.equals("__quit__")) return null;
        int fs=firstVowelIndex(s);
        int fl=Math.min(fs, firstConsonantIndex(s)!=-1?firstConsonantIndex(s):Integer.MAX_VALUE);
        int ll=Math.max(lastConsonantIndex(s), lastVowelIndex(s));
        if(fs<0) return "**** INVALID ****";
        if(firstConsonantIndex(s)<0 || fs<firstConsonantIndex(s)) return s.substring(0, ll+1)+"way"+s.substring(Math.max(lastConsonantIndex(s), lastVowelIndex(s))+1);
        if(fs>0 && s.charAt(fs)=='u'&&s.charAt(fs-1)=='q') fs++;
        return new StringBuilder(s.substring(0, fl)/*beginning punctuation*/+s.substring(fs, ll+1)/*first vowel+1-end punctuation */ + s.substring(fl, fs)/*end of beginning punctuation-first vowel*/+"ay"+s.substring(ll+1)/*end punctuation*/).replace(fl, fl+1, Character.isUpperCase(s.charAt(fl))?Character.toUpperCase(s.charAt(fs))+"":s.charAt(fs)+"").replace(ll+1-fs, ll+2-fs, Character.toLowerCase(s.charAt(fl))+"").toString();
    }
    public static void filePigLatin(String n){
        try{
            Scanner sc = new Scanner(new File(n));
            FileWriter w = new FileWriter("PigLatinOutput.txt");
            while(sc.hasNextLine()){
                for(String s:sc.nextLine().split(" "))
                w.write(pigLatin(s)+" ");
                w.write("\n");
            }
            w.close();
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static boolean charIsInString(char c, String s) {return s.contains(c+"");}
    public static boolean worseIsVowel(char c){return charIsInString(c, "aeiou");}
    public static boolean isVowel(char c){return vowels.contains(c);}
    public static boolean worseIsConsonant(char c){return isVowel(c) && !charIsInString(c, ".?!\"");}
    public static boolean isConsonant(char c){return !vowels.contains(c)&&!punctuation.contains(c);}
    public static int firstVowelIndex(String s){for(int i=0; i<s.length(); i++) if (isVowel(s.charAt(i))||i>0 && s.charAt(i)=='y') return i; return -1;}
    public static int firstConsonantIndex(String s){for(int i=0; i<s.length(); i++) if (isConsonant(s.charAt(i))&&(s.charAt(i)!='y' || i==0)) return i; return -1;}
    public static int lastVowelIndex(String s){for(int i=s.length()-1; i>=0; i--) if (isVowel(s.charAt(i))||i>0 && s.charAt(i)=='y') return i; return -1;}
    public static int lastConsonantIndex(String s){for(int i=s.length()-1; i>=0; i--) if (isConsonant(s.charAt(i))&&(s.charAt(i)!='y' || i==0)) return i; return -1;}
}
