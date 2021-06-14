package com.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.beans.LoginBean;

@Repository
public class LoginRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean authenticate(LoginBean loginBean) 
	{
		Session session = sessionFactory.getCurrentSession();
		List<LoginBean> itemlist = session.createQuery("from LoginBean").getResultList();
		for(LoginBean item: itemlist) {
			if(item.getUsername().equals(loginBean.getUsername()) &&
				item.getPassword().equals(loginBean.getPassword())) 
			{
				return true;
			}
				
		}
		
		return false;
}
	
}
