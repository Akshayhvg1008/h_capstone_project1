package h_capstone_project.controller;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import h_capstone_project.Repository.AdminRepository;
import h_capstone_project.Service.AdminService;
import h_capstone_project.model.BlockedUser;
import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;
import h_capstone_project.model.UserAccount;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	public AdminService adminService;
@Autowired
public AdminRepository adminRepository;

	@PostMapping("/loginValidate")
	public String loginValidate(@RequestParam("username") String username, @RequestParam("password") String password) {
		int k = adminService.valid(username, password);
		if (k == 1)
			return "redirect:/admin/home";
		else
			return "Invalid-username-pass";
	}

	@GetMapping("/home")
	public String h()
	{
		return "home";
	}
	@GetMapping("/pending")
	public String showAccountdetails(Model model)
	{
		List<Transactions> k=adminService.showPendingTransactions();
		model.addAttribute("details",k);
		return "pending";
	}
	@GetMapping("/check")
	public String showCheckbook(Model model)
	{
		List<CheckBook> k=adminService.grantCheckBook();
		model.addAttribute("checkbook",k);
		return "checkbook";
	}
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("/block")
	public String k(Model model)
	{
		List<BlockedUser> k=adminService.blockuser();
		model.addAttribute("blocked",k);
		return "block";
	}
	@GetMapping("/blockUser")
	@org.springframework.transaction.annotation.Transactional
	public String block(@RequestParam("username") String username) {
		sessionFactory.openSession();
		String password1="changed";
		Session currentSession = sessionFactory.getCurrentSession();
		String hari1 = "update User set password = :password1  where username='" + username + "'";
		Query q1 = currentSession.createQuery(hari1).setParameter("password1",password1);
		q1.executeUpdate();
		return "redirect:/admin/home";
	}
	@GetMapping("/confirmPendingTransaction")
	@org.springframework.transaction.annotation.Transactional
	public String tos(@RequestParam("user_id") int id,@RequestParam("someone_id") int someone_id,@RequestParam("amount") int amount,@RequestParam("type") int type,
			@RequestParam("trans_id") int trans_id)
	{
		
		if(type==1)
		{
		int id1 = id;
		String g = Integer.toString(id1);
		
		int pri_acc_bal = 0, sav_acc_bal = 0;
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + g + "'",
				UserAccount.class);
		List<UserAccount> user1 = theQuery.getResultList();
		UserAccount u = new UserAccount();
		for (UserAccount object : user1) {
			pri_acc_bal = object.getPrimary_acc_bal();
			sav_acc_bal = object.getSavings_acc_bal();
			sav_acc_bal = sav_acc_bal + amount;
			pri_acc_bal = pri_acc_bal - amount;

		}

		String hari1 = "update UserAccount set sav_acc_bal=:sav_acc_bal where id='" + g + "'";
		Query q = currentSession.createQuery("update UserAccount set pri_acc_bal=:pri_acc_bal where id='" + g + "'");
		Query q1 = currentSession.createQuery(hari1);
		q.setParameter("pri_acc_bal", pri_acc_bal);
		q1.setParameter("sav_acc_bal", sav_acc_bal);
		q.executeUpdate();
		q1.executeUpdate();
		String status="Accepted";
		String hari2 = "update Transactions set status = :status where trans_id='" + trans_id + "'";
		Query q2 = currentSession.createQuery(hari2).setParameter("status", status);
		q2.executeUpdate();
		}
		else if(type==2)
		{
		int id1 = id;
		String g = Integer.toString(id1);
		int pri_acc_bal = 0, sav_acc_bal = 0;
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + g + "'",
				UserAccount.class);
		List<UserAccount> user1 = theQuery.getResultList();
		UserAccount u = new UserAccount();
		for (UserAccount object : user1) {
			pri_acc_bal = object.getPrimary_acc_bal();
			sav_acc_bal = object.getSavings_acc_bal();
			sav_acc_bal = sav_acc_bal - amount;
			pri_acc_bal = pri_acc_bal + amount;
			String status="Accepted";
			String hari2 = "update Transactions set status = :status where trans_id='" + trans_id + "'";
			Query q2 = currentSession.createQuery(hari2).setParameter("status", status);
			q2.executeUpdate();
		}

		String hari1 = "update UserAccount set sav_acc_bal=:sav_acc_bal where id='" + g + "'";
		Query q = currentSession.createQuery("update UserAccount set pri_acc_bal=:pri_acc_bal where id='" + g + "'");
		Query q1 = currentSession.createQuery(hari1);
		q.setParameter("pri_acc_bal", pri_acc_bal);
		q1.setParameter("sav_acc_bal", sav_acc_bal);
		q.executeUpdate();
		q1.executeUpdate();
		}
		else if(type==3)
		{
			sessionFactory.openSession();
			int id1 = id,id2=someone_id;
			String g = Integer.toString(id1);
			String g1=Integer.toString(someone_id);
			int pri_acc_bal = 0, sav_acc_bal = 0;
			Session currentSession = sessionFactory.getCurrentSession();
			Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + g + "'",
					UserAccount.class);
			List<UserAccount> user1 = theQuery.getResultList();
			for (UserAccount object : user1) {
				sav_acc_bal = object.getSavings_acc_bal();
				sav_acc_bal = sav_acc_bal - amount;
				

			}
			Query<UserAccount> theQuery1 = currentSession.createQuery("from UserAccount where id='" + g1 + "'",
					UserAccount.class);
			List<UserAccount> user2 = theQuery1.getResultList();
			for (UserAccount object : user2) {
			
				pri_acc_bal = object.getPrimary_acc_bal();
				pri_acc_bal = pri_acc_bal + amount;

			}
			String status="Accepted";
			
			String hari1 = "update UserAccount set sav_acc_bal = :sav_acc_bal where id='" + g + "'";
			String hari2 = "update Transactions set status = :status where trans_id='" + trans_id + "'";
			
			Query q = currentSession.createQuery("update UserAccount set  pri_acc_bal = :pri_acc_bal where id='" + g1 + "'").setParameter("pri_acc_bal", pri_acc_bal);
			Query q1 = currentSession.createQuery(hari1).setParameter("sav_acc_bal",sav_acc_bal);
			Query q2 = currentSession.createQuery(hari2).setParameter("status", status);
		
			q.executeUpdate();
			q1.executeUpdate();
			q2.executeUpdate();
		}
		else if(type==4)
		{
		sessionFactory.openSession();
		int id1 = id,id2=someone_id;
		String g = Integer.toString(id1);
		String g1=Integer.toString(someone_id);
		int pri_acc_bal1 = 0, pri_acc_bal2 = 0;
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + g + "'",
				UserAccount.class);
		List<UserAccount> user1 = theQuery.getResultList();
		for (UserAccount object : user1) {
			pri_acc_bal1 = object.getPrimary_acc_bal();
			pri_acc_bal1 = pri_acc_bal1 - amount;

		}
		Query<UserAccount> theQuery1 = currentSession.createQuery("from UserAccount where id='" + g1 + "'",
				UserAccount.class);
		List<UserAccount> user2 = theQuery1.getResultList();
		for (UserAccount object : user2) {
		
			pri_acc_bal1 = object.getPrimary_acc_bal();
			pri_acc_bal1 = pri_acc_bal1 + amount;

		}
		String status="Accepted";
		String hari1 = "update UserAccount set pri_acc_bal = :pri_acc_bal where id='" + g + "'";
		String hari2 = "update Transactions set status = :status where trans_id='" + trans_id + "'";
		
		Query q = currentSession.createQuery("update UserAccount set  pri_acc_bal = :pri_acc_bal2 where id='" + g1 + "'").setParameter("pri_acc_bal2", pri_acc_bal2);
		Query q1 = currentSession.createQuery(hari1).setParameter("pri_acc_bal",pri_acc_bal1);
		Query q2 = currentSession.createQuery(hari2).setParameter("status", status);
	
		q.executeUpdate();
		q1.executeUpdate();
		q2.executeUpdate();
		}
		else if(type==5)
		{
			sessionFactory.openSession();
			int id1 = id;
			String g = Integer.toString(id1);
			String g1=Integer.toString(someone_id);
			int pri_acc_bal = 0, sav_acc_bal = 0;
			Session currentSession = sessionFactory.getCurrentSession();
			Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + g + "'",
					UserAccount.class);
			List<UserAccount> user1 = theQuery.getResultList();
			for (UserAccount object : user1) {
				sav_acc_bal = object.getSavings_acc_bal();
				sav_acc_bal = sav_acc_bal + amount;

			}
			String hari1 = "update UserAccount set sav_acc_bal = :sav_acc_bal where id='" + g + "'";
			Query q1 = currentSession.createQuery(hari1).setParameter("sav_acc_bal",sav_acc_bal);
			q1.executeUpdate();
			String status="Accepted";
			String hari2 = "update Transactions set status = :status where trans_id='" + trans_id + "'";
			Query q2 = currentSession.createQuery(hari2).setParameter("status", status);
			q2.executeUpdate();

			
		}
		else if(type==6)
		{
			sessionFactory.openSession();
			int id1 = id;
			String g = Integer.toString(id1);
			String g1=Integer.toString(someone_id);
			int pri_acc_bal = 0, sav_acc_bal = 0;
			Session currentSession = sessionFactory.getCurrentSession();
			Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + g + "'",
					UserAccount.class);
			List<UserAccount> user1 = theQuery.getResultList();
			for (UserAccount object : user1) {
				pri_acc_bal = object.getPrimary_acc_bal();
				pri_acc_bal = pri_acc_bal + amount;

			}
			String hari1 = "update UserAccount set pri_acc_bal = :pri_acc_bal where id='" + g + "'";
			Query q1 = currentSession.createQuery(hari1).setParameter("pri_acc_bal",pri_acc_bal);
			q1.executeUpdate();
			String status="Accepted";
			String hari2 = "update Transactions set status = :status where trans_id='" + trans_id + "'";
			Query q2 = currentSession.createQuery(hari2).setParameter("status", status);
			q2.executeUpdate();
			
		}
		else if(type==7)
		{
			sessionFactory.openSession();
			int id1 = id;
			String g = Integer.toString(id1);
			String g1=Integer.toString(someone_id);
			int pri_acc_bal = 0, sav_acc_bal = 0;
			Session currentSession = sessionFactory.getCurrentSession();
			Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + g + "'",
					UserAccount.class);
			List<UserAccount> user1 = theQuery.getResultList();
			for (UserAccount object : user1) {
				sav_acc_bal = object.getSavings_acc_bal();
				sav_acc_bal = sav_acc_bal - amount;

			}
			String hari1 = "update UserAccount set sav_acc_bal = :sav_acc_bal where id='" + g + "'";
			Query q1 = currentSession.createQuery(hari1).setParameter("sav_acc_bal",sav_acc_bal);
			q1.executeUpdate();

			String status="Accepted";
			String hari2 = "update Transactions set status = :status where trans_id='" + trans_id + "'";
			Query q2 = currentSession.createQuery(hari2).setParameter("status", status);
			q2.executeUpdate();
			
		}
		else if(type==8)
		{
			sessionFactory.openSession();
			int id1 = id;
			String g = Integer.toString(id1);
			String g1=Integer.toString(someone_id);
			int pri_acc_bal = 0, sav_acc_bal = 0;
			Session currentSession = sessionFactory.getCurrentSession();
			Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount where id='" + g + "'",
					UserAccount.class);
			List<UserAccount> user1 = theQuery.getResultList();
			for (UserAccount object : user1) {
				pri_acc_bal = object.getPrimary_acc_bal();
				pri_acc_bal = pri_acc_bal - amount;

			}
			String hari1 = "update UserAccount set pri_acc_bal = :pri_acc_bal where id='" + g + "'";
			Query q1 = currentSession.createQuery(hari1).setParameter("pri_acc_bal",pri_acc_bal);
			q1.executeUpdate();
			String status="Accepted";
			String hari2 = "update Transactions set status = :status where trans_id='" + trans_id + "'";
			Query q2 = currentSession.createQuery(hari2).setParameter("status", status);
			q2.executeUpdate();
			
		}
		return "redirect:/admin/pending";
	}
	@GetMapping("/confirmCheckBook")
	@org.springframework.transaction.annotation.Transactional
	public String cb(@RequestParam("user_id") int id,@RequestParam("type") String type)
	{
		if(type.equalsIgnoreCase("Primary Account"))
		{
		sessionFactory.openSession();
		int id1 = id;
		String g = Integer.toString(id1);
		String status="Granted Checkbook for Primary Account";
		Session currentSession = sessionFactory.getCurrentSession();
		String hari1 = "update CheckBook set status = :status  where id='" + g + "'";
		Query q1 = currentSession.createQuery(hari1).setParameter("status",status);
		q1.executeUpdate();
		}
		else if(type.equalsIgnoreCase("Savings Account"))
		{
		sessionFactory.openSession();
		int id1 = id;
		String g = Integer.toString(id1);
		String status="Granted Checkbook for Savings Account";
		Session currentSession = sessionFactory.getCurrentSession();
		String hari1 = "update CheckBook set status = :status  where id='" + g + "'";
		Query q1 = currentSession.createQuery(hari1).setParameter("status",status);
		q1.executeUpdate();
		}
		
		return "redirect:/admin/check";
	}
	
	
}
