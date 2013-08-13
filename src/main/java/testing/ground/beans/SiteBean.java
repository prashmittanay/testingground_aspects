package testing.ground.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sites")
public class SiteBean {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "site_id")
	private int id;
	private String url;
	private int special;
	private int status;
	private int docs;
	@Override
	public String toString() {
		return "SiteBean [id=" + id + ", url=" + url + ", special=" + special
				+ ", status=" + status + ", docs=" + docs + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSpecial() {
		return special;
	}
	public void setSpecial(int special) {
		this.special = special;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDocs() {
		return docs;
	}
	public void setDocs(int docs) {
		this.docs = docs;
	}
	public SiteBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SiteBean(String url, int special, int status, int docs) {
		this.url = url;
		this.special = special;
		this.status = status;
		this.docs = docs;
	}
}
