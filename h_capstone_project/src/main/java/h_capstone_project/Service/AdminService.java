package h_capstone_project.Service;

import java.util.List;

import h_capstone_project.model.BlockedUser;
import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;

public interface AdminService {
	 public int valid(String username,String password);
	 public List<Transactions> showPendingTransactions();
	 public List<CheckBook> grantCheckBook();
	 public List<BlockedUser> blockuser();


}
