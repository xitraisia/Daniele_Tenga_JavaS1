public class CalculatorObject {
    private int a;
    private int b;
    private double A;
    private double B;

    public CalculatorObject(int a, int b, double A, double B){
        //,int add, double addition, int subtract, double subtraction, int multiply, double multiplication, int divide , double division
        this.a = a;
        this.b = b;
        this.A = A;
        this.B = B;
    }

    public static int add;
    public static int getAdd() {
        return add;
    }
    public int setAdd() {
        add = this.a + this.b;
        return add;
    }

    public static double addition;
    public static double getAddition() {
        return addition;
    }
    public double setAddition() {
       addition = this.A + this.B;
       return addition;
    }

    public static int subtract;
    public static int getSubtract(){
        return subtract;
    }
    public int setSubtract() {
        subtract = this.a - this.b;
        return subtract;
    }

    public static double subtraction;
    public static double getSubtraction(){
        return subtraction;
    }
    public double setSubtraction() {
        subtraction = this.A -this.B;
        return subtraction;
    }

    public static int multiply;
    public static int getMultiply(){
        return multiply;
    }
    public int setMultiply() {
        multiply = this.a * this.b;
        return multiply;
    }

    public static double multiplication;
    public static double getMultiplication(){
        return multiplication;
    }
    public double setMultiplication(){
        multiplication = this.A * this.B;
        return multiplication;
    }

    public static int divide;
    public static int getDivide(){
        return divide;
    }
    public int setDivide() {
        divide = this.a / this.b;
        return divide;
    }

    public static double division;
    public static double getDivision(){
        return multiplication;
    }
    public double setDivision() {
        division = this.A / this.B;
        return division;
    }
}
