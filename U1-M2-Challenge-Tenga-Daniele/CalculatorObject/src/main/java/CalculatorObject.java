public class CalculatorObject {

    public int add;
    public double addition;
    public int subtract;
    public double subtraction;
    public int multiply;
    public double multiplication;
    public int divide;
    public double division;


    public CalculatorObject() {

    }

    public  int getAdd() {
        return this.add;
    }
    public int setAdd(int a, int b) {
        add = a + b;
        return add;
    }

    public double getAddition() {
        return addition;
    }
    public double setAddition(double a, double b) {
       addition = a + b;
       return addition;
    }


    public int getSubtract(){
        return subtract;
    }
    public int setSubtract(int a, int b) {
        subtract = a - b;
        return subtract;
    }

    public double getSubtraction(){
        return subtraction;
    }
    public double setSubtraction(double a, double b) {
        subtraction = a - b;
        return subtraction;
    }

    public int getMultiply(){
        return multiply;
    }
    public int setMultiply(int a, int b) {
        multiply = a * b;
        return multiply;
    }

    public double getMultiplication(){
        return multiplication;
    }
    public double setMultiplication(double a, double b){
        multiplication = a * b;
        return multiplication;
    }

    public int getDivide(){
        return divide;
    }
    public int setDivide(int a, int b) {
        divide = a / b;
        return divide;
    }

    public double getDivision(){
        return division;
    }
    public double setDivision(double a, double b) {
        division = a / b;
        return division;
    }
}
