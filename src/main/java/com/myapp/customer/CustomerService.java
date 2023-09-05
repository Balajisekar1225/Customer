package com.myapp.customer;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
///import org.springframework.web.bind.annotation.RequestBody;


@Service
public class CustomerService {
	static Logger log = Logger.getLogger(CustomerService.class);
	@Autowired
	CustomerDao custdao;
	public String addCustomerifsc(Customer c) {
		return custdao.addCustomerifsc(c);
	}
	public Customer getCustomerId(int id) {
		PropertyConfigurator.configure("log.properties");
		log.info("This information is wrong");
		log.warn("this is a warning");
		log.error("this is error");
		log.fatal("fatal message");
		log.debug("debug message");
		return custdao.getCustomerId(id);
	}
	public  String updateName(Customer e ,int id) {
		return custdao.updateName(e,id);
	
	}
	public List<Customer> getCustomers(){
		PropertyConfigurator.configure("log.properties");
		log.info(custdao.getCustomers());
	
		return custdao.getCustomers();
	}
}
