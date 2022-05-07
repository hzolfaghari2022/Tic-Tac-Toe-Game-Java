public class Project059 {
    public static void main(String[] args) {
        
        BisectionMethod bm = new BisectionMethod(Problem::f);
        double x = bm.Run(1, 4, 50);
        System.out.println("f(" + x + ") = " + bm.FunctionValue(x));
        
        bm.setFunction(Problem::g);
        double y = bm.Run(-1, 6, 50);
        System.out.println("g(" + y + ") = " + bm.FunctionValue(y));

        bm.setFunction((s) -> (s*s-10*s+16));
        double z = bm.Run(5, 15, 50);
        System.out.println("h(" + z + ") = " + bm.FunctionValue(z));
    
    }
}

class Problem {
    public static double f(double x) {
        return 8-4.5*(x-Math.sin(x));
    }
    
    public static double g(double x) {
        return x*x-10*x+16;
    }
}