package testing.ground.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import testing.ground.beans.NameBean;
import testing.ground.model.Enhancers;

public class Dummy {
	public static void main(String[] args) {
//		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Documents and Settings\\Owner\\gitProjects\\TestingGround\\src\\main\\webapp\\WEB-INF\\applicationContext.xml");
		
		/*PokeModel pokeModel = (PokeModel) context.getBean("pokeModel");*/
//		Enhancers enhancers = (Enhancers) context.getBean("enhancers");
		/*pokeModel.poke();*/
		/*pokeModel.secondPoke();
		pokeModel.getName();*/
		
/*		pokeModel.throwingException();*/
		
		/*pokeModel.multiplesOfTen();*/
		
		/*enhancers.validateURL("http://google.co.in");*/
		
//		enhancers.removeProtocol("http://google.co.in");
		
		
		Dummy dummy = new Dummy();
		dummy.reorderData(5, 1,	dummy.createBean(), "back");
	}
	
	public List<NameBean> createBean(){
		List<NameBean> nameList = new ArrayList<NameBean>();
		nameList.add(new NameBean(0, "Prashmit", "Tanay", 23, 1));
		nameList.add(new NameBean(1, "Sagar", "Kohli", 28, 2));
		nameList.add(new NameBean(2, "Kumari", "Manisha", 24, 3));
		nameList.add(new NameBean(3, "Akesh", "Dhiman", 21, 4));
		nameList.add(new NameBean(4, "Amresh", "Kumar", 27, 5));
		nameList.add(new NameBean(5, "Anuj", "Upmanyu", 24, 6));
		nameList.add(new NameBean(6, "Binni", "Arora", 21, 7));
		
		return nameList;
	}
	
	public void reorderData(int fromPostion, int toPosition, List<NameBean> nameList, String movment){
		int diff = Math.abs(fromPostion - toPosition);
		if(movment.equals("back")){
			for(int i = 0; i< diff; i++){
				NameBean nameBean = nameList.get((toPosition+i)-1);
				nameBean.setPosition(nameBean.getPosition()+1);
			}
			
			nameList.get(fromPostion-1).setPosition(toPosition);
		}else{
			for(int i = 0; i< diff; i++){
				NameBean nameBean = nameList.get((fromPostion+i));
				nameBean.setPosition(nameBean.getPosition()-1);
			}
			
			nameList.get(fromPostion-1).setPosition(toPosition);
		}
		
		
		Iterator<NameBean> iterator = nameList.iterator();
		
		
		Collections.sort(nameList);
		while (iterator.hasNext()) {
			NameBean nameBean = (NameBean) iterator.next();
			System.out.println(nameBean);
		}
	}
}
