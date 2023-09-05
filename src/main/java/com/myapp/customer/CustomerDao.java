package com.myapp.customer;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
///import org.springframework.web.bind.annotation.RequestBody;



@Repository
public class CustomerDao {
	@Autowired
	CustomerRepository custRepo;
	public String addCustomerifsc(Customer c) {
		custRepo.save(c);
		return "Succesfully added";

	}
	public Customer getCustomerId(int id) {
		return custRepo.findById(id).get();
		
		
	}
	public String updateName(Customer e , int id) {
		Customer temp = getCustomerId(id);
		temp.setName(e.getName());
		temp.setBranch(temp.getBranch());
		temp.setId(temp.getId());
		temp.setIfscCode(temp.getIfscCode());
		temp.setAccountNumber(temp.getAccountNumber());
		 custRepo.save(temp);
		 return "Update Successfully";
}
	public List<Customer> getCustomers(){
		PropertyConfigurator.configure("log.properties");
		//log.info(custRepo.findAll());
		return custRepo.findAll();
	}
}
