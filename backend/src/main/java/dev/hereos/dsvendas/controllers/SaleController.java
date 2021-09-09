package dev.hereos.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hereos.dsvendas.dto.SaleDTO;
import dev.hereos.dsvendas.dto.SalesSuccessDTO;
import dev.hereos.dsvendas.dto.SalesSumDTO;
import dev.hereos.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}

	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SalesSumDTO>> amountGroupdBySeller() {
		List<SalesSumDTO> list = service.amountGroupdBySeller();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SalesSuccessDTO>> successGroupdBySeller() {
		List<SalesSuccessDTO> list = service.successGroupdBySeller();
		return ResponseEntity.ok(list);
	}
	
}
