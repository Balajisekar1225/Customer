package com.myapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
///import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CustomerService {
	@Autowired
	CustomerDao custdao;
	public String addCustomerifsc(Customer c) {
		return custdao.addCustomerifsc(c);
	}
	public Customer getCustomerId(int id) {
		return custdao.getCustomerId(id);
	}
	public  String updateName(Customer e ,int id) {
		return custdao.updateName(e,id);
	
	}

}
