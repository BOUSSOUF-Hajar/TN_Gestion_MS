package com.example.EmissionTransfertNational.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmissionTransfertNational.entities.Emetteur;
import com.example.EmissionTransfertNational.entities.Transfert;
import com.example.EmissionTransfertNational.repositories.EmetteurRepository;
import com.example.EmissionTransfertNational.repositories.TransfertRepository;
@RestController
public class TransfertRestController {
	private EmetteurRepository eR;
	private TransfertRepository tR;
	public TransfertRestController(TransfertRepository cR,EmetteurRepository eR){
			this.tR=cR;
			this.eR=eR;
	}
	@GetMapping(path="/get_Transferts")
	public List<Transfert>listTransferts(){
		return tR.findAll();
		
	}
	@GetMapping(path="/get_Transfert/{id}")
	public Transfert getTransfert(@PathVariable Long id){
		return tR.findById(id).get();
		
	}
	@PostMapping(path="/add_Transfert")
	public Transfert saveTransfert(@RequestBody Transfert transfert){
		Emetteur em=transfert.getEmetteur();
		//en suppossant que l'emetteur et le beneficiaire existent
		tR.save(transfert);
		
		
		return tR.save(transfert);
		
	}
	@PutMapping(path="/update_Transfert/{id}")
	public Transfert updateTransfert(@PathVariable Long id,@RequestBody Transfert cl){
		cl.setId(id);
		return tR.save(cl);
		
	}
	@DeleteMapping(path="/delete_Transfert/{id}")
	public void deleteTransfert(@PathVariable Long id){
		tR.deleteById(id);
		
	}
}
