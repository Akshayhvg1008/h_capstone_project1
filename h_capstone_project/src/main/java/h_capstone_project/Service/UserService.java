package h_capstone_project.Service;

import java.util.List;

import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;
import h_capstone_project.model.UserAccount;



public interface UserService {

	/*
	 * public List<Product> getProducts(); public List<User> getAllUserData();
	 * public List<User> getUserData(String user);
	 */
	public List<UserAccount> showAccountDetails(int id);
	public int valid(String username,String password);
	public void transferToPrimaryAccount(int id,int amount);
	public void transferToSavingsAccount(int id,int amount);
	public void withdrawMoney(int id,int amount, String from_which_account);
	public void deposit(int id,int amount, String from_which_account);	
	public void transferToSomeoneAccount(int id,int someone_id,int amount,String from_which_account);
	public void requestCheckbook(int id,String type);
	public List<Transactions> transactionDetails(int id);
	public List<CheckBook> checkBookDetails(int id);
	public void blockuser(String username,String password);
}
