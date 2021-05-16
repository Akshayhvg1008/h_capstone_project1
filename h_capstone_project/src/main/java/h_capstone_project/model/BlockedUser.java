package h_capstone_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bl")
public class BlockedUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
private int id;
	@Column
private String username;
	@Column
	private String des;
public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}
