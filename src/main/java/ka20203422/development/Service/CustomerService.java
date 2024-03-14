package ka20203422.development.Service;

import java.util.List;

import ka20203422.development.dto.CustomerDto;

public interface CustomerService {

	List<CustomerDto> showAllCustomer();

	void deleteCustomerById(String id);

	void addNewCustomer(CustomerDto customerDto);

	CustomerDto updateCustomerDetailsById(String id, CustomerDto customerDto);

	void deleteAll();

	CustomerDto getCustomerById(String id);

	void fundTransfer(String from, String to, String amount);

}
