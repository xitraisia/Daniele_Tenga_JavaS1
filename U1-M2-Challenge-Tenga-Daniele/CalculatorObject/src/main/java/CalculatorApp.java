public class CalculatorApp {

    public static void main(String[] args) {
        CalculatorObject calculatorObject = new CalculatorObject();

        calculatorObject.setAdd(1,1); {
            System.out.println("1 + 1 = " + calculatorObject.getAdd());
        }
        calculatorObject.setAddition(3.4,2.3); {
            System.out.println("1.0 + 1.0 = " + calculatorObject.getAddition());
        }
        calculatorObject.setSubtract(23, 52); {
            System.out.println("23 - 52 = " + calculatorObject.getSubtract());
        }
        calculatorObject.setSubtraction(5.5,0.5); {
            System.out.println("5.5 - 0.5 = " + calculatorObject.getSubtraction());
        }
        calculatorObject.setMultiply(34, 2); {
            System.out.println("34 * 2 = " + calculatorObject.getMultiply());
        }
        calculatorObject.setMultiplication(6.7, 4.4); {
            System.out.println("6.7 * 4.4 = " + calculatorObject.getMultiplication());
        }
        calculatorObject.setDivide(12, 3); {
            System.out.println("12 / 3 = " + calculatorObject.getDivide());
        }
        calculatorObject.setDivide(12, 7); {
            System.out.println("12 / 7 = " + calculatorObject.getDivide());
        }
        calculatorObject.setDivision(10, 2.2); {
            System.out.println(" 10.8 / 2.2 = " + calculatorObject.getDivision());
        }
    }
}
