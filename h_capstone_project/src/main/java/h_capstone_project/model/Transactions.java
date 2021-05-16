package h_capstone_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "trans")
public class Transactions {
	@Id
	@Column(name = "trans_id")
	private int trans_id;

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "from_acc")
	private String from;

	@Column(name = "to_acc")
	private String to;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "type_dec")
	private int type;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "some_id")
	private int some_id;
	
	public int getSome_id() {
		return some_id;
	}

	public void setSome_id(int some_id) {
		this.some_id = some_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	
	
	
	
}
