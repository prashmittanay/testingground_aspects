package testing.ground.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BasicAspects {
	
	@Before("execution(public * testing.ground.model.PokeModel.*(..))")
	public void sayHello(){
		System.out.println("hello there....i see you are executing a method");
	}
	
	@AfterReturning("execution(public * testing.ground.model.PokeModel.*(..))")
	public void methodEnd(){
		System.out.println("A PokeModel.class method ran successfully");
	}
	
	@AfterReturning(pointcut = "execution(public String testing.ground.model.PokeModel.*(..))",
			returning = "result")
	public void getResult(String result){
		System.out.println("Returned value is: "+result);
	}
	
	@AfterThrowing("execution(public * testing.ground.model.PokeModel.*(..))")
	public void errorReporting(){
		System.out.println("Seems to be an error");
	}
	
	@AfterThrowing(pointcut="execution(public * testing.ground.model.PokeModel.*(..))",
			throwing="ex")
	public void getDetailsAboutError(Exception ex){
		System.out.println("Error Message: "+ex.getMessage());
	}
	
	//Typically used for releasing resources
	@After("execution(public * testing.ground.model.*.*(..))")
	public void notifyEveryMethodExecution(){
		System.out.println("A method just completed");
	}
	
	@Around("execution(* testing.ground.model.PokeModel.multiplesOfTen())")
	public void getExecutionTime(ProceedingJoinPoint pjp) throws Throwable{
		long then = System.currentTimeMillis();
		pjp.proceed();
		long now = System.currentTimeMillis();
		System.out.println("Execution time: "+(now-then)+" ms");
	}
}
