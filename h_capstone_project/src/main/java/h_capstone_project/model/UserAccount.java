package h_capstone_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccount")
public class UserAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "pri_acc_num")
	private int primaryAccount_num;
	@Column(name = "sav_acc_num")
	private int savingsAccount_num;
	@Column(name = "pri_acc_bal")
	private int primary_acc_bal;
	@Column(name = "sav_acc_bal")
	private int savings_acc_bal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrimaryAccount_num() {
		return primaryAccount_num;
	}

	public void setPrimaryAccount_num(int primaryAccount_num) {
		this.primaryAccount_num = primaryAccount_num;
	}

	public int getSavingsAccount_num() {
		return savingsAccount_num;
	}

	public void setSavingsAccount_num(int savingsAccount_num) {
		this.savingsAccount_num = savingsAccount_num;
	}

	public int getPrimary_acc_bal() {
		return primary_acc_bal;
	}

	public void setPrimary_acc_bal(int primary_acc_bal) {
		this.primary_acc_bal = primary_acc_bal;
	}

	public int getSavings_acc_bal() {
		return savings_acc_bal;
	}

	public void setSavings_acc_bal(int savings_acc_bal) {
		this.savings_acc_bal = savings_acc_bal;
	}

}
