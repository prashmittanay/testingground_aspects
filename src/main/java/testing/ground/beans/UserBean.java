package testing.ground.beans;

import java.util.Date;

public class UserBean {
	private int id;
	private String name;
	private String username;
	private String password;
	private String role;
	private String email;
	private Date creationDate;
	private Date deactivationDate;
	private int status;
	private String remarks;
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", username="
				+ username + ", password=" + password + ", role=" + role
				+ ", email=" + email + ", creationDate=" + creationDate
				+ ", deactivationDate=" + deactivationDate + ", status="
				+ status + ", remarks=" + remarks + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getDeactivationDate() {
		return deactivationDate;
	}
	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public UserBean(String name, String username, String password,
			String role, String email, Date creationDate,
			Date deactivationDate, int status, String remarks) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.creationDate = creationDate;
		this.deactivationDate = deactivationDate;
		this.status = status;
		this.remarks = remarks;
	}
	public UserBean() {
		super();
	}
	
	
}
