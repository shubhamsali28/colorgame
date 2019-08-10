package com.demo.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springmvc.entity.Customer;

//Handling the exceptions
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Session Factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
	    //Get current session
		Session session = sessionFactory.getCurrentSession();
		
		//Query 
		Query<Customer> queryCustomer = session.createQuery("from Customer order by lastName", Customer.class);
		
		//Execute query and ResultList
		List<Customer> customers = queryCustomer.getResultList();
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		//Get current session
		Session session = sessionFactory.getCurrentSession();
		
		//saving the data
		session.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		
		//Get current session
		Session session = sessionFactory.getCurrentSession();
		
		//Get the customer based on Id
		Customer theCustomer = session.get(Customer.class, theId);
		
		//Careful
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		
		//Get current session
		Session session = sessionFactory.getCurrentSession();
		
		//Delete object with primary key
		Query query = session.createQuery("delete from Customer where id=:customerId");
		
		//setting parameters
		query.setParameter("customerId", theId);
		
		//Execute query
		query.executeUpdate();
		
	}


	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		// TODO Auto-generated method stub
		
Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
		
		
	}

}
