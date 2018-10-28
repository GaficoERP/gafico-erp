package sn.smart.eco.clients.repositories;

import sn.smart.eco.clients.model.ClientInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientInfoRepository extends JpaRepository<ClientInfo, Long> {

  public Optional<ClientInfo> findByName(String name);
}
