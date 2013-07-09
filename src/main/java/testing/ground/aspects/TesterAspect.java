package testing.ground.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TesterAspect {

	@Before("execution(public * testing.ground.model.PokeModel.*(..))")
	public void sayHello(){
		System.out.println("hello there....i see you are executing a method");
	}
}
