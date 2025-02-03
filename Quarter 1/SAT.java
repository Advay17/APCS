public class SAT {
    public static void main(String[] args) {
        System.out.println(SAT3(26, 1000));
    }
    public static boolean evaluateExpression(String expression, int num_vars){
        // System.out.println(expression);
        for(int i=0; i<1<<num_vars; i++){
            String t=expression;
            String s=BooleanExpressionParser.dec2binString(i, num_vars);
            for(int j=0; j<num_vars; j++){
                // System.out.print(s.charAt(j)=='1'?"T, ": "F, ");
                t=t.replace(String.valueOf(((char) ('A'+j))), s.charAt(j)=='1'?"true": "false");
                // System.out.println(t);
            }
            if(BooleanExpressionParser.parseBooleanExpression(t)) return true;
            // System.out.print(s.charAt(3)=='1'?"T] ": "F] ");
            // System.out.println(String.valueOf(BooleanExpressionParser.parseBooleanExpression(t)).equals("true")? "T": "F");
        }
        return false;
    }
    public static String generateExpression(int num_vars, int num_disjunctions){
        int[] variables=new int[num_vars];
        for(int i=0; i<num_vars; i++){
            variables[i]++;
        }
        for(int i=0; i<num_disjunctions*3-num_vars; i++){
            variables[(int) (Math.random()*num_vars)]++;
        }
        String d=generateDisjunctionTemplate(num_disjunctions);
        while (d.contains("_")){
            int o=(int) (Math.random()*num_vars);
            while(variables[o]==0){
                o=(int) (Math.random()*num_vars);
            }
            variables[o]--;
            d=d.substring(0, d.indexOf("_"))+((((int) (Math.random()*2))==1)?"!":"") +(char)('A'+o)+d.substring(d.indexOf("_")+1);
        }
        // System.out.println(d);
        return d;
    }
    public static double SAT3(int num_vars, int num_disjunctions){
        double t=0;
        double to=0;
        for(int i=0; i<10000; i++){
            if(evaluateExpression(generateExpression(num_vars, num_disjunctions), num_vars)) t++;
            to++;
            System.out.println(t/to);
        }
        return t/to;
    }
    public static String generateDisjunctionTemplate(int num_disjunctions){
        String o="";
        for(int i=0; i<num_disjunctions-1; i++){
            o+="(_ || _ || _) && ";
        }
        return o+"(_ || _ || _)";
    }
}
