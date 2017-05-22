package cn.zsza.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2017/5/17.
 * 17:18
 */
public class LambdaExpression {


    interface MathOperation{
        int operation(int a,int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operate(int a,int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
        LambdaExpression lambdaExpression = new LambdaExpression();

        /**
         * java8中的参数的类型是可选
         */
        MathOperation addition = (int a,int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;

        /**
         * retrun可以省略
         */
        MathOperation multiplication = (int a,int b) -> {return a * b;};
        MathOperation division  = (int a,int b) -> a / b;

        System.out.println(lambdaExpression.operate(10,5,addition));
        System.out.println(lambdaExpression.operate(10,5,subtraction));
        System.out.println(lambdaExpression.operate(10,3,multiplication));
        System.out.println(lambdaExpression.operate(10,3,division));

        List<String> list = new ArrayList<>();
        GreetingService greetingService = message -> list.add(message);
        greetingService.sayMessage("hgh");

        System.out.println(list);


    }
}
