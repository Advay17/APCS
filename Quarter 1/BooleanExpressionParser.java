import java.util.*;

public class BooleanExpressionParser {

    public static String dec2binString(int dec, int minLength) {
        String o="";
        while(dec>0){
            o=String.valueOf(dec%2)+o;
            dec/=2;
        }
           // return a string representation of the binary
                 // value of "dec". If the string length is less
                 // than minLength, padd with leading zeros
                 // Example input: 17, 7. output: 0010001
        while(o.length()<minLength){
            o="0"+o;
        }
        return o;
    }
    public static int bin2dec(String bin) {
        int o=0;
        for(int i=0; i<bin.length(); i++){
            o+=(bin.charAt(i)-'0'<<bin.length()-i-1);
        }
                    // input is a binary string
                    // output is a base 10 integer
                    // example: input 0010001, output 17
        return o;
    }
    public static void truthTableRows(int numVars) {
        // print the input rows of a truth table
        // that uses numVars number of boolean variables
        for(int i=0; i<1<<numVars; i++){
            String s=dec2binString(i, numVars);
            System.out.print("[");
            for(int j=0; j<numVars-1; j++){
                System.out.print(s.charAt(j)=='1'?"T, ": "F, ");
            }
            System.out.println(s.charAt(numVars-1)=='1'?"T]": "F]");
        }
    }
    public static void evaluateExpression(String input) {
            // print the input rows of a truth table
            // that uses numVars number of boolean variables
            for(int i=0; i<16; i++){
                String t=input;
                String s=dec2binString(i, 4);
                System.out.print("[");
                for(int j=0; j<4-1; j++){
                    System.out.print(s.charAt(j)=='1'?"T, ": "F, ");
                    t=t.replace(String.valueOf(((char) ('A'+j))), s.charAt(j)=='1'?"true": "false");
                    // System.out.println(t);
                }
                t=t.replace(String.valueOf(((char) ('D'))), s.charAt(3)=='1'?"true": "false");
                System.out.print(s.charAt(3)=='1'?"T] ": "F] ");
                System.out.println(String.valueOf(parseBooleanExpression(t)).equals("true")? "T": "F");
            }
    }
    public static boolean parseBooleanExpression(String expression) {
        // Remove any spaces
        expression = expression.replaceAll("\\s+", "");

        // Convert the expression to a list of tokens
        List<String> tokens = tokenize(expression);

        // Parse the expression from tokens and return the result
        return parseExpression(tokens);
    }

    private static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(' || c == ')' || c == '!' || c == '&' || c == '|') {
                // Add the current token if it's non-empty
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }

                // Add operators and parentheses as tokens
                if (c == '&' || c == '|') {
                    // Handle && and ||
                    tokens.add(expression.substring(i, i + 2));
                    i++; // Skip next character
                } else {
                    tokens.add(String.valueOf(c));
                }
            } else {
                currentToken.append(c);
            }
        }

        // Add the last token if it's non-empty
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        return tokens;
    }

    private static boolean parseExpression(List<String> tokens) {
        Stack<Boolean> values = new Stack<>();
        Stack<String> operators = new Stack<>();

        int i = 0;
        while (i < tokens.size()) {
            String token = tokens.get(i);

            if (token.equals("true")) {
                values.push(true);
            } else if (token.equals("false")) {
                values.push(false);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                // Evaluate the expression within the parentheses
                while (!operators.peek().equals("(")) {
                    evaluateTop(values, operators.pop());
                }
                operators.pop(); // Remove '('
            } else if (token.equals("&&") || token.equals("||")) {
                // Handle operator precedence
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    evaluateTop(values, operators.pop());
                }
                operators.push(token);
            } else if (token.equals("!")) {
                operators.push(token);
            }

            i++;
        }

        // Evaluate any remaining operators
        while (!operators.isEmpty()) {
            evaluateTop(values, operators.pop());
        }

        return values.pop();
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "||":
                return 1;
            case "&&":
                return 2;
            case "!":
                return 3;
            default:
                return -1;
        }
    }

    private static void evaluateTop(Stack<Boolean> values, String operator) {
        if (operator.equals("!")) {
            boolean value = values.pop();
            values.push(!value);
        } else {
            boolean b = values.pop();
            boolean a = values.pop();
            if (operator.equals("&&")) {
                values.push(a && b);
            } else if (operator.equals("||")) {
                values.push(a || b);
            }
        }
    }

    public static void main(String[] args) {
        String expression = "true && !(true || false)";
        boolean result = parseBooleanExpression(expression);
        // System.out.println("Output: " + result);  // Output: false
        // truthTableRows(4);
        evaluateExpression("!(A && B) || (A && !B) || (C && !D && !A)");
        // System.out.println(1<<4);
    }
}