package com.example.repository;

import com.example.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value="SELECT * FROM clients", nativeQuery = true)
    List<Client> getAll();

    @Transactional
    @Modifying
    @Query(value="UPDATE clients c SET c.name=:name, c.email=:email WHERE c.id=:id", nativeQuery = true)
    void updateClient(@Param("name") String name, @Param("email") String email, @Param("id") Long id);
}