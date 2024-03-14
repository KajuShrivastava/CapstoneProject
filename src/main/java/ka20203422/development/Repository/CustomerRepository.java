package ka20203422.development.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import ka20203422.development.Model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,String> {

	Optional<CustomerModel> findByName(String name);
	
	@Modifying
	@Query("update CustomerModel c set c.amount=?1 where c.name=?2")
	@Transactional
	void updateAmountByName(@Param(value="amount") String amount,@Param(value="name")String name);
}
