package testing.ground.beans;

public class NameBean implements Comparable<NameBean>{
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private int position;
	@Override
	public String toString() {
		return "NameBean [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + ", position="
				+ position + "]";
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public NameBean(int id, String firstName, String lastName, int age,
			int position) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.position = position;
	}
	public NameBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(NameBean o) {
		int compareTo = ((Integer)this.position).compareTo(o.position);
		return compareTo;
	}
	
	
	
}
