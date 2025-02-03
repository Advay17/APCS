public class ArrayMethods {
    public static double maxValue(double[] a){
        if(a.length==0) return Double.NaN;
        double m = a[0];
        for(int i=1; i<a.length; i++) m=Math.max(m, a[i]);
        return m;
    }
    public static double minValue(double[] a){
        if(a.length==0) return Double.NaN;
        double m = a[0];
        for(int i=1; i<a.length; i++) m=Math.min(m, a[i]);
        return m;
    }
    public static int maxIndex(double[] a){
        if(a.length==0) return -1;
        int m = 0;
        for(int i=1; i<a.length; i++) if(a[m]<a[i]) m=i;
        return m;
    }
    public static int minIndex(double[] a){
        if(a.length==0) return -1;
        int m = 0;
        for(int i=1; i<a.length; i++) if(a[m]>a[i]) m=i;
        return m;
    }
    public static double secondHighest(double[] a){
        if(a.length<2) return Double.NaN;
        double f = Math.max(a[0], a[1]);
        double s = Math.min(a[0], a[1]);
        for(int i=2; i<a.length; i++)
            if(a[i]>f){
                s=f;
                f=a[i];
            }
            else if(a[i]>s) s=a[i];
        return s;
    }
    public static double findClosest(double[] a, double c){
        if(a.length==0) return Double.NaN;
        double o=a[0];
        for(int i=1; i<a.length; i++) if(Math.abs(o-c)>Math.abs(a[i]-c)) o=a[i];
        return o;
    }
    public static double[] findClosestPair(double[] a){
        double[] o = {a[0], a[1]};
        for(int i=0; i<a.length; i++) for(int j=i+1; j<a.length; j++) if(Math.abs(o[0]-o[1])>Math.abs(a[i]-a[j])){
            o[0]=a[i];
            o[1]=a[j];
        }
        return o;
    }
    public static double[] swap(double[] a, int f, int s){
        double t=a[f];
        a[f]=a[s];
        a[s]=t;
        return a;
    }
    public static int count(double[] a, double n){
        int c=0;
        for(double i:a) if(i==n) c++;
        return c;
    }
    public static int findFirst(double[] a, int n){
        for(int i=0; i<a.length; i++) if(a[i]==n) return i;
        return -1;
    }
}
