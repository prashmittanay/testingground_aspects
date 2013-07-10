package testing.ground.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ParametersAspect {
	
	@Before("execution(public * testing.ground.model.Enhancers.validateURL(..)) && args(link)")
	public void logParametersPassed(String link){
		System.out.println("URL passed for validation was: "+link);
	}
}
