package org.java.spring.db.service;

import java.util.List;

import org.java.spring.db.pojo.OffertaSpeciale;
import org.java.spring.db.repo.OffertaSpecialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaSpecialeService {

	@Autowired
	private OffertaSpecialeRepository offertaSpecialeRepository;
	
	public List<OffertaSpeciale> findAll() {
		
		return offertaSpecialeRepository.findAll();
	}
	public OffertaSpeciale findById(int id) {
		
		return offertaSpecialeRepository.findById(id).get();
	}
	public void save(OffertaSpeciale offertaSpeciale) {
		
		offertaSpecialeRepository.save(offertaSpeciale);
	}
	
	
	public void delete(OffertaSpeciale offertaSpeciale) {
		
		offertaSpecialeRepository.delete(offertaSpeciale);
	}
}
