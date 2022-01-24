package com.example.EmissionTransfertNational.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.EmissionTransfertNational.entities.Client;
@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client,Long> {
	@Query("select c from Client c where c.idClient=:idclient")
	Client findWithIdClient(@Param("idclient")long id);
	
	Client findByIdClient(long id);
}
