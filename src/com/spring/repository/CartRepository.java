package com.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.spring.beans.ItemBean;
import com.spring.beans.LoginBean;

@Repository
public class CartRepository {
	
	SessionFactory sessionfactory;
	Session session;
	
	public List<ItemBean> getallitems()
	{
/*		List<ItemBean> list=(List<ItemBean>)session.createSQLQuery("SELECT * FROM Item").addEntity(ItemBean.class).list();*/

		
		/*System.out.println(list);*/
		
		List<ItemBean> itemlist = new ArrayList<>();
		itemlist.add(new ItemBean(1,"Potato",120));
		itemlist.add(new ItemBean(2,"Tomato",340));
		itemlist.add(new ItemBean(3,"Okra",42));
		itemlist.add(new ItemBean(4,"Onion",32));
		itemlist.add(new ItemBean(5,"Garlic",40));
		return itemlist;
		
	}

}
