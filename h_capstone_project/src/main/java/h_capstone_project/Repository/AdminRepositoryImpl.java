package h_capstone_project.Repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import h_capstone_project.model.Admin;
import h_capstone_project.model.BlockedUser;
import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;
import h_capstone_project.model.UserAccount;


@Repository(value = "adminRepository")
public class AdminRepositoryImpl implements AdminRepository {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int valid(String username, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Admin where username=:username and password=:password");
       theQuery.setParameter("username", username);
       theQuery.setParameter("password", password);
       Admin hari=(Admin)theQuery.uniqueResult();
       if(hari!=null)
    	   return 1;
else return 0;
       /* if(theQuery!=null)
       return 1;*/
	}
	@Override
	public List<Transactions> showPendingTransactions() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Transactions> theQuery = currentSession.createQuery("from Transactions",Transactions.class);
		List<Transactions> user1 = theQuery.getResultList();
		return user1;
	}
	@Override
	public List<CheckBook> grantCheckBook() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CheckBook> theQuery = currentSession.createQuery("from CheckBook",CheckBook.class);
		List<CheckBook> user1 = theQuery.getResultList();
		return user1;
	}
	@Override
	public List<BlockedUser> blockuser() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<BlockedUser> theQuery = currentSession.createQuery("from BlockedUser",BlockedUser.class);
		List<BlockedUser> user1 = theQuery.getResultList();
		return user1;
	}
	
	

}
