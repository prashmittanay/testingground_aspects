package testing.ground.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "second_name")
	private String secondName;
	private int age;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", age=" + age + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String firstName, String secondName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}
	
	
}
