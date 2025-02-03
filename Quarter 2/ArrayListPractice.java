import java.util.ArrayList;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("cat");
        words.add("dog");
        words.add(1, "bird");
        words.remove(0);
        words.add("fish");
        words.remove("bird");
        System.out.println("Final Answer: " + words);
        
    }
}
