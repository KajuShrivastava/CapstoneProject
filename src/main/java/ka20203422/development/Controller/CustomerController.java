package ka20203422.development.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ka20203422.development.Service.CustomerService;
import ka20203422.development.dto.CustomerDto;

@RestController
public class CustomerController {
	
	@Autowired 
	CustomerService customerService;

	@GetMapping("/bank/showAllCustomer")
	private ResponseEntity<List<CustomerDto>> showAllCustomer()
	{
		List<CustomerDto> customerDto;
		customerDto = customerService.showAllCustomer();
		if(customerDto.isEmpty())
			throw new NoDataFoundException();
		return new ResponseEntity<>(customerDto,HttpStatus.OK);
	}
	
	 @GetMapping("/bank/getEmployeeById/{id}")
	 public ResponseEntity<CustomerDto> getEmployeeById(@PathVariable String id) {
		 CustomerDto cDTO=customerService.getCustomerById(id);
			if(cDTO==null)
				throw new NoDataFoundException();
			else
				return new ResponseEntity<>(cDTO,HttpStatus.ACCEPTED);
	 }
	
	@DeleteMapping("/bank/deleteCustomer/{id}") 
	private ResponseEntity<String> deleteCustomerById(@PathVariable("id") String id)
	{	String s=id;
		customerService.deleteCustomerById(id);
		return new ResponseEntity<>(s+"Successfully Deleted",HttpStatus.OK);
	}
	
	 @DeleteMapping("/bank/deleteAllCustomer")
	 private ResponseEntity<String> deleteAllCustomer() {
		 customerService.deleteAll();
		 return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
	 }
	 
	
	@PostMapping("/bank/addNewCustomer") 
	private ResponseEntity<String> addNewCustomer(@RequestBody CustomerDto customerDto)
	{
		String s="";
		customerService.addNewCustomer(customerDto);
		s=customerDto.getCustid();
		 return new ResponseEntity<>(s+"Successfully Added",HttpStatus.OK);
	}
	
	@PutMapping("/bank/updateCustomer/{id}") 
	private ResponseEntity<CustomerDto> updateCutomerDetailsById(@PathVariable("id") String id,@RequestBody CustomerDto customerDto)
	{
		CustomerDto cDTO=customerService.updateCustomerDetailsById(id,customerDto);
		if(cDTO==null)
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			 return new ResponseEntity<>(cDTO,HttpStatus.OK);
	}
	

	@GetMapping("/fundTransfer/{from}/{to}/{amount}")
	private ResponseEntity<String> fundTransfer(@PathVariable("from") String from,@PathVariable("to")String to,@PathVariable("amount") String amount)
	{
		customerService.fundTransfer(from,to,amount);
		return new ResponseEntity<>("Transfer Successfull",HttpStatus.OK);
		
	}
	
	
}
