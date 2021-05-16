package h_capstone_project.Repository;
import java.util.*;

import h_capstone_project.model.BlockedUser;
import h_capstone_project.model.CheckBook;
import h_capstone_project.model.Transactions;
public interface AdminRepository {
	 public int valid(String username,String password);
	 public List<Transactions> showPendingTransactions();
	 public List<CheckBook> grantCheckBook();
	 public List<BlockedUser> blockuser();
	}
