package com.spring.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.beans.LoginBean;

public class DbConnection {

	private SessionFactory sessionfactory;

	
	
	public DbConnection() {
		 try {
			 sessionfactory =
		   			    new Configuration().configure("spring-mvc-crud-demo-servlet.xml")
		   			    .addAnnotatedClass(LoginBean.class)
		   			    .buildSessionFactory();
		   	  
		   	  } 
			 catch (Exception e) { 
		        System.err.println(e.getMessage());
		     }

	}

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	public DbConnection(SessionFactory sessionfactory) {
		
		this.sessionfactory = sessionfactory;
	}
	
	
	
	
}
