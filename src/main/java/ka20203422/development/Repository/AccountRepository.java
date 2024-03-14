package ka20203422.development.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ka20203422.development.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

}
