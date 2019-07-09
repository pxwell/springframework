package cn.pxwell.learn.transaction.service.impl;

import cn.pxwell.learn.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	UserServiceImpl userServiceImpl;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	@Override
	public void createAccount(String name, Double sale) {
		jdbcTemplate.update( "insert into account(name,sale) values (?,?)",name,sale );
		userServiceImpl.createUser( name );
		int i= 1/0;
	}

	@Override
	public void updateAccount(String name) {
		jdbcTemplate.update( "update  account set sale = sale+1 where name=?",name );

	}
}
