package h_capstone_project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import h_capstone_project.Repository.AdminRepository;
import h_capstone_project.model.BlockedUser;
import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	@Transactional
	public int valid(String username, String password) {
		return adminRepository.valid(username, password);
	}
	@Override
	@Transactional
	public List<Transactions> showPendingTransactions() {
		return adminRepository.showPendingTransactions();
	}
	@Override
	@Transactional
	public List<CheckBook> grantCheckBook() {
		return adminRepository.grantCheckBook();
	}
	@Override
	@Transactional
	public List<BlockedUser> blockuser() {
		return adminRepository.blockuser();
	}

}
