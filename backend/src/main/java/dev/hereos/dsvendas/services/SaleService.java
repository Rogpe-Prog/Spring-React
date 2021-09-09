package dev.hereos.dsvendas.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hereos.dsvendas.dto.SaleDTO;
import dev.hereos.dsvendas.dto.SalesSuccessDTO;
import dev.hereos.dsvendas.dto.SalesSumDTO;
import dev.hereos.dsvendas.entities.Sale;
import dev.hereos.dsvendas.repositories.SaleRepository;
import dev.hereos.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository; 
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SalesSumDTO> amountGroupdBySeller() {
		return repository.amountGroupdBySeller();
	}

	@Transactional(readOnly = true)
	public List<SalesSuccessDTO> successGroupdBySeller() {
		return repository.successGroupdBySeller();
	}

	
}
