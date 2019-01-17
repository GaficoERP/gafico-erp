package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.commonjpa.model.Provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, String> {

}
