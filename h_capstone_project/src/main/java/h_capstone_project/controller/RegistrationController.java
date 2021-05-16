package h_capstone_project.controller;

import java.util.ArrayList;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import h_capstone_project.model.User;
import h_capstone_project.model.UserAccount;
@Controller
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
	private SessionFactory sessionFactory;
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
	@PostMapping("/user_registration")
	@org.springframework.transaction.annotation.Transactional
	public String register(@RequestParam("username") String username,@RequestParam("password1") String password,
			@RequestParam("age") String age,@RequestParam("city") String city,
			@RequestParam("gender") String gender,@RequestParam("country") String country,
			@RequestParam("ph_no") String phone_no)
	{
		sessionFactory.openSession();
		Session currentSession = sessionFactory.getCurrentSession();
		User u=new User();
		u.setName(username);
		u.setPassword(password);
		u.setCity(city);
		u.setCountry(country);
		u.setGender(gender);
		u.setPh_no(phone_no);
		u.setAge(age);
		UserAccount ua=new UserAccount();
		ua.setId(hare());
		ua.setPrimary_acc_bal(0);
		ua.setPrimaryAccount_num(hare());
		ua.setSavings_acc_bal(0);
		ua.setSavingsAccount_num(hare());
		
		currentSession.save(u);
		currentSession.save(ua);
		return "redirect:/r_admin_login.jsp";
	}
}
