package h_capstone_project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import h_capstone_project.Repository.UserRepository;
import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;
import h_capstone_project.model.UserAccount;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public int valid(String username, String password) {
		return userRepository.valid(username, password);
	}

	@Override
	@Transactional
	public List<UserAccount> showAccountDetails(int id) {
		return userRepository.showAccountDetails(id);
	}

	@Override
	@Transactional
	public void transferToPrimaryAccount(int id, int amount) {
		userRepository.transferToPrimaryAccount(id, amount);
	}

	@Override
	@Transactional
	public void transferToSavingsAccount(int id, int amount) {
		userRepository.transferToSavingsAccount(id, amount);
		
	}
	@Override
	@Transactional
	public void withdrawMoney(int id,int amount, String from_which_account) {
		userRepository.withdrawMoney(id, amount, from_which_account);
	}
	@Override
	@Transactional
	public void deposit(int id,int amount, String from_which_account) {
		userRepository.deposit(id, amount, from_which_account);
	}
	@Override
	@Transactional
	public void transferToSomeoneAccount(int id,int someone_id,int amount,String from_which_account) {
		userRepository.transferToSomeoneAccount(id, someone_id, amount, from_which_account);
	}
	@Override
	@Transactional
	public void requestCheckbook(int id,String type) {
		userRepository.requestCheckbook(id,type);
	}

	@Override
	@Transactional
	public List<Transactions> transactionDetails(int id) {
		return userRepository.transactionDetails(id);
	}

	@Override
	@Transactional
	public List<CheckBook> checkBookDetails(int id) {
		return userRepository.checkBookDetails(id);
	}

	@Override
	public void blockuser(String username, String password) {
userRepository.blockuser(username, password);		
	}
	

}
