package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderDetail;

@Repository("orderDetailDAO")
@Transactional
public class OrderDeatilDAoImpl implements OrderDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
    
	public boolean insertOrderDetail(OrderDetail orderDetail)
	{
    	try
    	{
    		sessionFactory.getCurrentSession().save(orderDetail);
    		return true;
    	}

    	catch(Exception e)
    	{
    		return false;
    		
    	}
	}
    public boolean updateOrderDetail(String username)
    {
    	try
    	{
    		Session session=sessionFactory.openSession();
    		Query query=session.createQuery("update CartItem set Status='p' where username=:myusername and status='NA'");
    		query.setParameter("myusername", username);
    		int row_eff=query.executeUpdate();
    		if(row_eff>0)
    			return true;
    			else
    				return  false;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }


	
	}


