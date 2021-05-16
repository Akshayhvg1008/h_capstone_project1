package h_capstone_project.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.persistence.Parameter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.transaction.jta.platform.internal.TransactionManagerAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import h_capstone_project.model.BlockedUser;
import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;
import h_capstone_project.model.User;
import h_capstone_project.model.UserAccount;

@Repository(value = "userRepository")
public class UserRepositoryImpl implements UserRepository {
	
	private static final ArrayList<Integer> rand = new ArrayList<Integer>();
	public int hare() {
		int n;
	Random r = new Random();
	n = 10000 + r.nextInt(90000);
	while (rand.contains(n)) {
		n = 10000 + r.nextInt(90000);
	}
	return n;
	}
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserAccount> showAccountDetails(int id) {
		String hari = Integer.toString(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + hari + "'",
				UserAccount.class);
		List<UserAccount> user1 = theQuery.getResultList();
		return user1;
	}

	@Override
	public int valid(String username, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from User where username=:username and password=:password");
		theQuery.setParameter("username", username);
		theQuery.setParameter("password", password);
		User hari = (User) theQuery.uniqueResult();
		if (hari != null)
			return 1;
		else
			return 0;
	
	}
	
	@Override
	public void withdrawMoney(int id,int amount, String from_which_account){
		if(from_which_account.equalsIgnoreCase("Primary Account"))
		{
		Transactions t = new Transactions();
		Session ram = sessionFactory.getCurrentSession();
		t.setTrans_id(hare());
		t.setUser_id(id);
		t.setFrom("Primary Account");
		t.setTo("Self");
		t.setAmount(amount);
		t.setStatus("Pending");
		t.setType(8);
		ram.save(t);
		}
		else if(from_which_account.equalsIgnoreCase("Savings Account"))
		{
			Transactions t = new Transactions();
			Session ram = sessionFactory.getCurrentSession();
			t.setTrans_id(hare());
			t.setUser_id(id);
			t.setFrom("Savings Account");
			t.setTo("Self");
			t.setAmount(amount);
			t.setStatus("Pending");
			t.setType(7);
			ram.save(t);
			
		}
	}
	
	@Override
	public void deposit(int id,int amount, String to_which_account) {
		if(to_which_account.equalsIgnoreCase("Primary Account"))
		{
		Transactions t = new Transactions();
		Session ram = sessionFactory.getCurrentSession();
		t.setTrans_id(hare());
		t.setUser_id(id);
		t.setFrom("Self");
		t.setTo("Primary Account");
		t.setAmount(amount);
		t.setStatus("Pending");
		t.setType(6);
		ram.save(t);
		}
		else if(to_which_account.equalsIgnoreCase("Savings Account"))
		{
			Transactions t = new Transactions();
			Session ram = sessionFactory.getCurrentSession();
			t.setTrans_id(hare());
			t.setUser_id(id);
			t.setFrom("Self");
			t.setTo("Savings Account");
			t.setAmount(amount);
			t.setStatus("Pending");
			t.setType(5);
			ram.save(t);
			
		}
	}
	
	@Override
	public void requestCheckbook(int id,String type) {
		if(type.equalsIgnoreCase("Primary Account"))
		{
		CheckBook c=new CheckBook();
		Session ram = sessionFactory.getCurrentSession();
		c.setUser_id(id);
		c.setStatus("Pending");
		c.setDes("Requested for Primary Account Checkbook");
		c.setType("Primary Account");

		ram.save(c);
		}
		else if(type.equalsIgnoreCase("Savings Account"))
		{
		CheckBook c=new CheckBook();
		Session ram = sessionFactory.getCurrentSession();
		c.setUser_id(id);
		c.setStatus("Pending");
		c.setDes("Requested for Savings Account Checkbook");
		c.setType("Savings Account");
		ram.save(c);
		}
	}
	@Override
	public void transferToSomeoneAccount(int id,int someone_id,int amount,String from_which_account) {
		if(from_which_account.equalsIgnoreCase("Primary Account"))
		{
		Transactions t = new Transactions();
		Session ram = sessionFactory.getCurrentSession();
		t.setTrans_id(hare());
		t.setUser_id(id);
		t.setFrom("Primary Account");
		t.setTo("Someone Account");
		t.setAmount(amount);
		t.setStatus("Pending");
		t.setType(4);
		t.setSome_id(someone_id);
		ram.save(t);
		}
		else if(from_which_account.equalsIgnoreCase("Savings Account"))
		{
			Transactions t = new Transactions();
			Session ram = sessionFactory.getCurrentSession();
			t.setTrans_id(hare());
			t.setUser_id(id);
			t.setFrom("Savings Account");
			t.setTo("Someone Account");
			t.setAmount(amount);
			t.setStatus("Pending");
			t.setType(3);
			t.setSome_id(someone_id);
			ram.save(t);
			
		}
	}

	@Override
	public void transferToPrimaryAccount(int id, int amount) {
		
		Transactions t = new Transactions();
		Session ram = sessionFactory.getCurrentSession();
		t.setTrans_id(hare());
		t.setUser_id(id);
		t.setFrom("Savings Account");
		t.setTo("Primary Account");
		t.setAmount(amount);
		t.setStatus("Pending");
		t.setType(2);
		ram.save(t);
	}

	@Override
	public void transferToSavingsAccount(int id, int amount) {
		/*
		 * int id1 = id; String g = Integer.toString(id1); int pri_acc_bal = 0,
		 * sav_acc_bal = 0; Session currentSession = sessionFactory.getCurrentSession();
		 * Query<UserAccount> theQuery =
		 * currentSession.createQuery("from UserAccount where id='" + g + "'",
		 * UserAccount.class); List<UserAccount> user1 = theQuery.getResultList();
		 * UserAccount u = new UserAccount(); for (UserAccount object : user1) {
		 * pri_acc_bal = object.getPrimary_acc_bal(); sav_acc_bal =
		 * object.getSavings_acc_bal(); sav_acc_bal = sav_acc_bal + amount; pri_acc_bal
		 * = pri_acc_bal - amount;
		 * 
		 * }
		 * 
		 * String hari1 = "update UserAccount set sav_acc_bal=:sav_acc_bal where id='" +
		 * g + "'"; Query q = currentSession.
		 * createQuery("update UserAccount set pri_acc_bal=:pri_acc_bal where id='" + g
		 * + "'"); Query q1 = currentSession.createQuery(hari1);
		 * q.setParameter("pri_acc_bal", pri_acc_bal); q1.setParameter("sav_acc_bal",
		 * sav_acc_bal); q.executeUpdate(); q1.executeUpdate();
		 */

		Transactions t = new Transactions();

		Session ram = sessionFactory.getCurrentSession();

		t.setTrans_id(hare());
		t.setUser_id(id);
		t.setFrom("Primary Account");
		t.setTo("Savings Account");
		t.setAmount(amount);
		t.setStatus("Pending");
		t.setType(1);
		ram.save(t);

		

	}

	@Override
	public List<Transactions> transactionDetails(int id) {
		String hari = Integer.toString(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Transactions> theQuery = currentSession.createQuery("from Transactions where user_id='" + hari + "'",
				Transactions.class);
		List<Transactions> t = theQuery.getResultList();
		return t;
	}

	@Override
	public List<CheckBook> checkBookDetails(int id) {
		String hari = Integer.toString(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CheckBook> theQuery = currentSession.createQuery("from CheckBook where user_id='" + hari + "'",
				CheckBook.class);
		List<CheckBook> checkbook = theQuery.getResultList();
		return checkbook;
	}
int i=0;
	@Override
	public void blockuser(String username, String password) {
		i++;
		sessionFactory.openSession();
		BlockedUser l=new BlockedUser();
		l.setId(i);
		l.setUsername(username);
		l.setDes("Threat");
		Session currentSession = sessionFactory.getCurrentSession();
		/*
		 * String hari1 = "update 	BlockedUser set username = :username "; Query q1 =
		 * currentSession.createQuery(hari1).setParameter("username",username);
		 * q1.executeUpdate();
		 */
		currentSession.save(l);
	}

//	@Override
//	public List<User> getid() {
//		String hari = Integer.toString(id);
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<User> theQuery = currentSession.createQuery("from User where username='" + hari + "'",
//				User.class);
//		List<UserAccount> checkbook = theQuery.getResultList();
//		return checkbook;
//	}

}
