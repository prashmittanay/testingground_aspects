package testing.ground.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import testing.ground.model.PokeModel;

public class Dummy {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("//home/prashmit/Documents/projects/TestingGround/src/main/webapp/WEB-INF/applicationContext.xml");
		
		PokeModel pokeModel = (PokeModel) context.getBean("pokeModel");
		/*pokeModel.poke();*/
		/*pokeModel.secondPoke();
		pokeModel.getName();*/
		
/*		pokeModel.throwingException();*/
		
		pokeModel.multiplesOfTen();
	}
}
