package com.autobots.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {
    public static void main(String[] args) {
        MathOperation addition=(a,b)->a+b;
        MathOperation mul=(a,b)->a*b;


        System.out.println("5 + 3= "+ addition.operation(5,3));
        System.out.println("5 * 3= "+ mul.operation(5,3));


        Predicate<String> isNotEmpty=b->!b.isEmpty();
        System.out.println(isNotEmpty.test("Java"));

        Function<Integer,String> toStringFun=i->"число: "+i;
        System.out.println(toStringFun.apply(10));

        Consumer<String> print=s->System.out.println("Writing: "+s);
        print.accept("Hello world");

    }
}
