package h_capstone_project.controller;

import java.util.List;

import javax.persistence.Parameter;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import h_capstone_project.Service.UserService;
import h_capstone_project.model.BlockedUser;
import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;
import h_capstone_project.model.User;
import h_capstone_project.model.UserAccount;
@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	private UserService userService;
	static int incorrect_login=0,i=0;
	@Autowired
	private SessionFactory sessionFactory;
	@PostMapping("user/loginValidate")
	@org.springframework.transaction.annotation.Transactional
	public String loginValidate(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model,HttpServletRequest req) {
		int k = userService.valid(username, password);
		if (k == 1 && incorrect_login<3)
		{
			incorrect_login=0;
			System.out.println(incorrect_login);
			String user="select id from User where username='"+username+"'";
			sessionFactory.openSession();
			Session currentSession = sessionFactory.getCurrentSession();
			int k1=0;
			Query<User> theQuery = currentSession.createQuery("from User where username='"+username+"'", User.class);
			List<User> user1 = theQuery.getResultList();
			for(User object:user1)
			{
				 k1=object.getId();
			}
			System.out.println("k1"+k1);
			String hari=Integer.toString(k1);
			model.addAttribute("h",hari);
			return "redirect:/user/home1";
		}
		else
		{
			incorrect_login++;
			String ram="";
			System.out.println(incorrect_login);
			if(incorrect_login>=3)
			{
				userService.blockuser(username, password);
				ram="Sorry!!! Your Account is Blocked...Please Contact Administrator!!!";
				incorrect_login=0;
			}
			model.addAttribute("hari", ram);
			return "Invalid-username-pass";
		}
	}
	@GetMapping("user/req_cb")
	public String id() {
		return "req_cb";
	}
	@GetMapping("user/home1")
	public String home() {
		return "home1";
	}
	@GetMapping("user/show_withdraw")
	public String wd() {
		return "show_withdraw";
	}
	@GetMapping("user/show_deposit")
	public String dp() {
		return "show_deposit";
	}
	@PostMapping("user/get_acc_details")
	public String showAccountdetails(@RequestParam("id") int Id,Model model)
	{
		List<UserAccount> k=userService.showAccountDetails(Id);
		model.addAttribute("details",k);
		return "show_acc_details";
	}
	@PostMapping("user/checkbookDetails")
	public String checkbookDetails(@RequestParam("id") int id,Model model)
	{
		List<CheckBook> k=userService.checkBookDetails(id);
		model.addAttribute("checkbook1",k);
		return "checkbook1";
	}
	@PostMapping("user/show_transtions")
	public String show_transtions(@RequestParam("id") int id,Model model)
	{
		List<Transactions> k=userService.transactionDetails(id);
		model.addAttribute("trans",k);
		return "transactions";
	}
	@PostMapping("user/req_checkbook")
	public String reqcb(@RequestParam("id") int id,@RequestParam("type") String type)
	{
		userService.requestCheckbook(id, type);
		return "redirect:/user/home1";
	}
	@PostMapping("user/transferToPrimaryAccount")
	public String tos(@RequestParam("id") int id,@RequestParam("amount") int amount)
	{
		userService.transferToPrimaryAccount(id, amount);
		return "redirect:/user/home1";
	}
	@PostMapping("user/transferToSavingsAccount")
	public String sot(@RequestParam("id") int id,@RequestParam("amount") int amount)
	{
		userService.transferToSavingsAccount(id, amount);
		return "redirect:/user/home1";
	}
	@PostMapping("user/toSomeoneAccount")
	public String tts(@RequestParam("id") int id,@RequestParam("someone_id") int someone_id,@RequestParam("amount") int amount,
			@RequestParam("acc_type") String acc_type)
	{
		userService.transferToSomeoneAccount(id,someone_id, amount,acc_type);
		return "redirect:/user/home1";
	}
	@PostMapping("user/withdraw")
	public String withdraw(@RequestParam("id") int id,@RequestParam("amount") int amount,
			@RequestParam("type") String acc_type)
	{
		userService.withdrawMoney(id, amount, acc_type);
		return "redirect:/user/home1";
	}
	@PostMapping("user/deposit")
	public String deposit(@RequestParam("id") int id,@RequestParam("amount") int amount,
			@RequestParam("type") String acc_type)
	{
		userService.deposit(id, amount, acc_type);
		return "redirect:/user/home1";
	}
	

}
