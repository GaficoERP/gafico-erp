package sn.smart.eco.budget.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.clients.model.ClientEntity;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long>
 {

	Budget findByClient(ClientEntity client);
	
}
