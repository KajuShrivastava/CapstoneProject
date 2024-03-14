package ka20203422.development.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import ka20203422.development.Model.CustomerModel;
import ka20203422.development.Repository.CustomerRepository;
import ka20203422.development.dto.CustomerDto;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	CustomerService customerService;
		 
	@Mock
	CustomerRepository customerRepository;



	@Test
	public void showAllCustomerTest()
	{

	        List<CustomerModel> list = new ArrayList<CustomerModel>();
        	CustomerModel c1 = new CustomerModel("100", "Kajal", "Sethi Nagar", "65648468","kajal@gmail.com","101","2000","Saving");
        	list.add(c1);
        	when(customerRepository.findAll()).thenReturn(list);
         
        
        	List<CustomerDto> customerList = customerService.showAllCustomer();
         
        	assertEquals(1, customerList.size());
	}


	 @Test
	 public void emptyCustomerListTest() 
	{
	
		 List<CustomerModel> list=new ArrayList<CustomerModel>();
		 
		 when(customerRepository.findAll()).thenReturn(list);
		 
		 List<CustomerDto> customerlist=customerService.showAllCustomer();
		 
		 assertEquals(0,customerlist.size());
	 }


	@Test
	public void getCustomerByIdTest() 
	{

		when(customerRepository.findById("1").get()).thenReturn(new CustomerModel("100", "Kajal", "Sethi Nagar", "65648468","kajal@gmail.com","101","2000","Saving"));
			
		CustomerDto c=customerService.getCustomerById("100");
		assertEquals("100",c.getCustid());
		assertEquals("Kajal",c.getName());
		assertNotEquals("Ujjain",c.getAddress());

	}


	 @Test
	 public void addNewCustomerTest() 
        {
		 CustomerDto cust1=new CustomerDto("100", "Kajal", "Sethi Nagar", "65648468","kajal@gmail.com","101","2000","Saving");
		 
		 customerService.addNewCustomer(cust1);
		 
		 verify(customerService,times(1)).addNewCustomer(cust1);
	 }





	 @Test
	 public void deleteCustomerByIdTest() 
	{
		 CustomerDto cust1=new CustomerDto("100", "Kajal", "Sethi Nagar", "65648468","kajal@gmail.com","101","2000","Saving");		 
		 customerService.addNewCustomer(cust1);
		 customerService.deleteCustomerById("100");
		 
		 verify(customerRepository,times(1)).deleteById("100");
	 }


	 @Test
	 public void deleteAllTest() {
		 CustomerDto cust1=new CustomerDto("100", "Kajal", "Sethi Nagar", "65648468","kajal@gmail.com","101","2000","Saving");
		 
		 customerService.addNewCustomer(cust1);
		 customerService.deleteAll();
		 
		 verify(customerRepository,times(1)).deleteAll();
	 }



	 @Test
	 public void updateCustomerDetailsByIdTest() {
		 CustomerDto cust1=new CustomerDto("100", "Kajal", "Sethi Nagar", "65648468","kajal@gmail.com","101","2000","Saving");
		 
		 customerService.addNewCustomer(cust1);
		 
		 CustomerDto cust2=new CustomerDto("200", "Kajal Shrivastava", "Sethi Nagar Ujjain", "55435458535","kajal1@gmail.com","111","20000","Fixed");
		 
		 customerService.updateCustomerDetailsById("200", cust2);
		 
		 //verify(customerRepository,times(1)).save(cust2);
	 }
	 



}
