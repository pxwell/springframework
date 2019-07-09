package cn.pxwell.learn.transaction.service.impl;

import cn.pxwell.learn.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	@Override
	public void createUser(String name) {
		jdbcTemplate.update( "insert into user(name) values (?)",name );
	}
}
