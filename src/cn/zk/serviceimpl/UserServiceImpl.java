package cn.zk.serviceimpl;

import java.util.List;

import cn.zk.dao.UserDAO;
import cn.zk.entity.Sys_role;
import cn.zk.entity.Sys_user;
import cn.zk.service.UserService;
import cn.zk.util.PageUtil;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Sys_user findlogin(String username, String password)
			throws Exception {
		// TODO Auto-generated method stub
		return userDAO.login(username, password);
	}

	public List<Sys_user> findAllMgr() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getAllMgr();
	}

	public List<Sys_role> findAllRole() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getAllRole();
	}

	public Sys_role findOneRole(int roleId) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getOneRole(roleId);
	}

	public void updateRole(Sys_role role) throws Exception {
		// TODO Auto-generated method stub
		userDAO.updateRole(role);
	}

	public PageUtil<Sys_user> findAllUser(int curpage, int row)
			throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getAllUser(curpage, row);
	}


	
}
