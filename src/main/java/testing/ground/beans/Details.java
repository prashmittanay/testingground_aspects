package testing.ground.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "details")
public class Details {
	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "forign", parameters = @Parameter(name = "property", value = "person"))
	@Column(name = "person_id")
	private int id;
	private String address;
	private String sex;
	@OneToOne
    @PrimaryKeyJoinColumn
    private Person person;
	@Override
	public String toString() {
		return "Details [id=" + id + ", address=" + address + ", sex=" + sex
				+ ", person=" + person + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Details(int id, String address, String sex, Person person) {
		this.id = id;
		this.address = address;
		this.sex = sex;
		this.person = person;
	}
}
