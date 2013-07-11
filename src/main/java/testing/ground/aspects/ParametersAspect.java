package testing.ground.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
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
	
	//same as above
	@Before(value="execution(public * testing.ground.model.Enhancers.removeProtocol(String)) && target(bean) && args(url)",
			argNames = "bean, url")
	public void logParametersPassed(Object bean, String url){
		System.out.println("Executing class:"+bean.getClass().getName());
		System.out.println("Passed url: "+url);
	}
	
	
	@Before("execution(public * testing.ground.model.Enhancers.removeProtocol(..)) && target(bean) && args(url)")
	public void logParametersPassed(JoinPoint joinPoint, Object bean, String url){
		System.out.println("==============");
		System.out.println("Arguments: "+Arrays.asList(joinPoint.getArgs()));
		System.out.println("Kind: "+joinPoint.getKind());
		System.out.println("To Long String: "+ joinPoint.toLongString());
		System.out.println("To Short String: "+ joinPoint.toShortString());
		System.out.println("Signature: "+ joinPoint.getSignature());
		System.out.println("Source Location: "+ joinPoint.getSourceLocation());
		System.out.println("Static part: "+ joinPoint.getStaticPart());
		System.out.println("THIS: "+ joinPoint.getTarget());
		System.out.println("=====================");
	}
}
