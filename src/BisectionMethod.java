import java.util.function.*;

public class BisectionMethod {
    
    // Constructor
    public BisectionMethod(Function<Double, Double> function) {
        this.function = function;
    }
    
    // Propert: Function
    private Function<Double, Double> function = null;
    public Function<Double, Double> getFunction() { return function; }
    public void setFunction(Function<Double, Double> function) {
        this.function = function;
    }
    
    // Function Evaluation
    public double FunctionValue(double x) {
        if (function == null) return Double.NaN;
        return function.apply(x);
    }
    
    // Bisection Method for Root Fincding
    public double Run(double a, double b, int maxit) {
        
        if (function == null) return Double.NaN;
        
        double fa = FunctionValue(a);
        double fb = FunctionValue(b);
        
        if (fa == 0) return a;
        if (fb == 0) return b;
        
        if (fa*fb>0) return Double.NaN;
        
        for (int it = 0; it < maxit; it++) {
            
            double m = (a+b)/2;
            double fm = FunctionValue(m);
            
            if (fm == 0) return m;
            
            if (fa*fm>0) {
                a = m;
                fa = fm;
            } else {
                b = m;
                fb = fm;
            }
            
        }
        
        return (Math.abs(fa)<Math.abs(fb)) ? a : b;
        
    }
    
}
