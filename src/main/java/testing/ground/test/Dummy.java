package testing.ground.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import testing.ground.model.Enhancers;

public class Dummy {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Documents and Settings\\Owner\\gitProjects\\TestingGround\\src\\main\\webapp\\WEB-INF\\applicationContext.xml");
		
		/*PokeModel pokeModel = (PokeModel) context.getBean("pokeModel");*/
		Enhancers enhancers = (Enhancers) context.getBean("enhancers");
		/*pokeModel.poke();*/
		/*pokeModel.secondPoke();
		pokeModel.getName();*/
		
/*		pokeModel.throwingException();*/
		
		/*pokeModel.multiplesOfTen();*/
		
		/*enhancers.validateURL("http://google.co.in");*/
		
		enhancers.removeProtocol("http://google.co.in");
	}
}
