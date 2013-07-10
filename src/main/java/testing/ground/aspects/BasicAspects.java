package testing.ground.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
		System.out.println("method ran successfully");
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
}
