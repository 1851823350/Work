import java.util.Scanner;

class Calculator {
    double num1;
    double num2;
    double result;
    char sign;

    Calculator() {
    }

    ;

    void getNumber() {
        Scanner sc1 = new Scanner(System.in);
        num1 = sc1.nextDouble();
        sign = sc1.next().charAt(0);
        num2 = sc1.nextDouble();
    }

    double CalculatorWays() {
        if (sign == '+') {
            result = num1 + num2;
        } else if (sign == '*') {
            result = num1 * num2;
        } else if (sign == '-') {
            result = num1 - num2;
        } else {
            result = num1 / num2;
        }
        return result;
    }
    void showResult(){
        System.out.println("结果是；" + result);
    }
    void startCalculator(){
        System.out.println("请输入计算的数字和符号");
        getNumber();
        CalculatorWays();
        showResult();
    }
}
public class Test1 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.startCalculator();
    }
}
