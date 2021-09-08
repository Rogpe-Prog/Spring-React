package dev.hereos.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hereos.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
