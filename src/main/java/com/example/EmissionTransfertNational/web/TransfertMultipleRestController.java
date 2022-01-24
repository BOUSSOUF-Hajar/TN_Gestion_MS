package com.example.EmissionTransfertNational.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmissionTransfertNational.entities.TransfertMultiple;
import com.example.EmissionTransfertNational.repositories.TransfertMultipleRepository;

@RestController
public class TransfertMultipleRestController {
	private TransfertMultipleRepository transfertMultipleR;
	public TransfertMultipleRestController(TransfertMultipleRepository transfertRep){
			this.transfertMultipleR=transfertRep;
	}
	@GetMapping(path="/get_TransfertMultiples")
	public List<TransfertMultiple>listTransfertMultiples(){
		return transfertMultipleR.findAll();
		
	}
	@GetMapping(path="/get_TransfertMultiple/{id}")
	public TransfertMultiple getTransfertMultiple(@PathVariable Long id){
		return transfertMultipleR.findById(id).get();
		
	}
	@PostMapping(path="/add_TransfertMultiple")
	public TransfertMultiple saveTransfertMultiple(@RequestBody TransfertMultiple TransfertMultiple){
		
		return transfertMultipleR.save(TransfertMultiple);
		
	}
	@PutMapping(path="/update_TransfertMultiple/{id}")
	public TransfertMultiple updateTransfertMultiple(@PathVariable Long id,@RequestBody TransfertMultiple transfertMultiple){
		transfertMultiple.setId(id);
		return transfertMultipleR.save(transfertMultiple);
		
	}
	@DeleteMapping(path="/delete_TransfertMultiple/{id}")
	public void deleteTransfertMultiple(@PathVariable Long id){
		transfertMultipleR.deleteById(id);
		
	}
}
