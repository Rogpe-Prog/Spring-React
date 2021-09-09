package dev.hereos.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.hereos.dsvendas.dto.SalesSuccessDTO;
import dev.hereos.dsvendas.dto.SalesSumDTO;
import dev.hereos.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new dev.hereos.dsvendas.dto.SalesSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SalesSumDTO> amountGroupdBySeller();
	
	@Query("SELECT new dev.hereos.dsvendas.dto.SalesSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SalesSuccessDTO> successGroupdBySeller();
	
}
