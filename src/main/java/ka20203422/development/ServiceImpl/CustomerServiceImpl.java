package ka20203422.development.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ka20203422.development.Model.Account;
import ka20203422.development.Model.CustomerModel;
import ka20203422.development.Repository.AccountRepository;
import ka20203422.development.Repository.CustomerRepository;
import ka20203422.development.Service.CustomerService;
import ka20203422.development.dto.AccountDto;
import ka20203422.development.dto.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired 
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<CustomerDto> showAllCustomer() {
		return ((List<CustomerModel>) customerRepository
                .findAll())
                .stream()
                .map(this::convertToCustomerDTO)
				        .collect(Collectors.toList());
	}
	
	@Override
	public CustomerDto getCustomerById(String id) {
		Optional<CustomerModel> customerModel= customerRepository.findById(id); 
		if (customerModel.isPresent()) {
			  CustomerModel customerModel1 = customerModel.get();
			  	CustomerDto customerDto = new CustomerDto();
				customerDto.setCustid(customerModel1.getCustid());
				customerDto.setName(customerModel1.getName());
				customerDto.setAddress(customerModel1.getAddress());
				customerDto.setPhoneno(customerModel1.getPhoneno());
				customerDto.setEmailId(customerModel1.getEmailId());
				customerDto.setAccountno(customerModel1.getAccountno());
				customerDto.setAmount(customerModel1.getAmount());
				customerDto.setAccountType(customerModel1.getAccountType()); 
				return customerDto;
			}
		else
			return null;
		
	}


	@Override
	public void deleteCustomerById(String id) {
		customerRepository.deleteById(id);
		
	}
	

	@Override
	public void deleteAll() {
		customerRepository.deleteAll();
		
	}
	

	@Override
	public void addNewCustomer(CustomerDto customerDto) {
		CustomerModel customerModel=new CustomerModel();
		customerModel.setCustid(customerDto.getCustid());
		customerModel.setName(customerDto.getName());
		customerModel.setEmailId(customerDto.getEmailId());
		customerModel.setPhoneno(customerDto.getPhoneno());
		customerModel.setAddress(customerDto.getAddress());
		customerModel.setAccountno(customerDto.getAccountno());
		customerModel.setAmount(customerDto.getAmount());
		customerModel.setAccountType(customerDto.getAccountType());
		customerRepository.save(customerModel);
		
	}

	@Override
	public CustomerDto updateCustomerDetailsById(String id, CustomerDto customerDto) {
		//System.out.println(id);
		Optional<CustomerModel> customerModel=customerRepository.findById(id);
		if (customerModel.isPresent()) {
			  CustomerModel customerModel1 = customerModel.get();
				customerModel1.setCustid(customerDto.getCustid());
				customerModel1.setName(customerDto.getName());
				customerModel1.setEmailId(customerDto.getEmailId());
				customerModel1.setPhoneno(customerDto.getPhoneno());
//				customerModel1.setAddress(customerDto.getAddress());
				customerModel1.setAccountno(customerDto.getAccountno());
				customerModel1.setAmount(customerDto.getAmount());
				customerModel1.setAccountType(customerDto.getAccountType());
				customerRepository.save(customerModel1);
				return customerDto;
			}
		else
			return null;
	}
	
	
	private CustomerDto convertToCustomerDTO(CustomerModel customerModel) 
	{
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustid(customerModel.getCustid());
		customerDto.setName(customerModel.getName());
		customerDto.setAddress(customerModel.getAddress());
		customerDto.setPhoneno(customerModel.getPhoneno());
		customerDto.setEmailId(customerModel.getEmailId());
		customerDto.setAccountno(customerModel.getAccountno());
		customerDto.setAmount(customerModel.getAmount());
		customerDto.setAccountType(customerModel.getAccountType());

        return customerDto;
	}

	@Override
	public void fundTransfer(String from, String to, String amount) {
		AccountDto accountDto = new AccountDto();
		accountDto.setFromAccount(from);
		accountDto.setToAccount(to);
		accountDto.setAmount(amount);
		
		
		Account account=new Account();
		account.setFromAccount(accountDto.getFromAccount());
		account.setToAccount(accountDto.getToAccount());
		account.setAmount(accountDto.getAmount());
		
		
		Optional<CustomerModel> customerModel=customerRepository.findByName(from);
		if (customerModel.isPresent()) {
			 CustomerModel customerModel1 = customerModel.get();
			 int balance=Integer.parseInt(customerModel1.getAmount());
			 if(balance > Integer.parseInt(amount))
			 {
				 int newBalance=balance-Integer.parseInt(amount);
				 customerRepository.updateAmountByName(String.valueOf(newBalance), from);
			 }
		}
		Optional<CustomerModel> customerModel2=customerRepository.findByName(to);
		if (customerModel2.isPresent()) 
		{
			 CustomerModel customerModel3 = customerModel2.get();
			 int balance1=Integer.parseInt(customerModel3.getAmount());
			 int newBalance1=balance1+Integer.parseInt(amount);
				 customerRepository.updateAmountByName(String.valueOf(newBalance1), to);
		}

		}
}