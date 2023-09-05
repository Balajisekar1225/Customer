package com.myapp.customer;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
///import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping (value="/admin")
public class CustomerController {
	static Logger log = Logger.getLogger(CustomerController.class);
	@Autowired
	CustomerService custser;
	RestTemplate rest = new RestTemplate();
	@PostMapping (value="/postifsc") 
	public String addCustomerifsc(@RequestBody Customer c) {
		String url = "http://localhost:8080/bank/getifscCode/";
		ResponseEntity<String> res = rest.exchange(url+c.getBranch(),HttpMethod.GET,null,String.class );
		String ifsc = res.getBody();
		c.setIfscCode(ifsc);
		return custser.addCustomerifsc(c);
}
	@GetMapping (value="/getid/{id}")
	//public Customer getCustomerId(@PathVariable int id) {
	//	PropertyConfigurator.configure("log.properties");
		//return custser.getCustomerId(id);
//	}
	@PutMapping(value="/updateName/{id}")
	public String updateName(@RequestBody Customer e ,@PathVariable int id) {
		return custser.updateName(e,id);
	}
	@GetMapping(value="/getList")
	public List<Customer> getCustomers() {
		PropertyConfigurator.configure("log.properties");
		log.info(custser.getCustomers());
		return custser.getCustomers();
	
	}
	

}
  