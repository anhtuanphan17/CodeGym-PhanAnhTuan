package ss8_clean_code_and_refactoring.thuc_hanh.thuc_hanh1;



class CalculatorTest {

    public static void main(String[] args) {
       double result1 =  Calculator.calculate(2,5,'+');
        System.out.println(result1);

        double result2= Calculator.calculate(2,5,'/');
        System.out.println(result2);

        double result3= Calculator.calculate(2,5,'*');
        System.out.println(result3);

        double result4= Calculator.calculate(2,5,'-');
        System.out.println(result4);

    }

}
