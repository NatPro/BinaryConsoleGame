package view;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;


@Aspect
public class MyFirstAspect {

    //@Pointcut("execution(* org.bk.inventory.service.*.*(..))")
    @Pointcut("execution(* InputHandler.readInputFromConsole(..)")
    public void readInputFromConsole() {
        //
    }

    @Before("readInputFromConsole()")
    public void beforeMethod() {
        System.out.println("before readInputFromConsole()");
    }

}
