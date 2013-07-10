package testing.ground.model;

import org.springframework.stereotype.Component;

@Component
public class PokeModel {
	public void poke(){
		System.out.println("Me pokings you");
	}
	
	public void secondPoke(){
		System.out.println("Now this is getting annoying");
	}
	
	public String getName(){
		return "Prashmit Tanay";
	}
	
	public void throwingException(){
		throw new NullPointerException("Mehh...!!!");
	}
	
	public void multiplesOfTen(){
		for (int i = 1; i <= 10; i++) {
			System.out.println(i*10);
		}
	}
}
