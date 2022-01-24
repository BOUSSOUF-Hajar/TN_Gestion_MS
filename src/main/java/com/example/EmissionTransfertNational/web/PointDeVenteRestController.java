package com.example.EmissionTransfertNational.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmissionTransfertNational.entities.PointDeVente;
import com.example.EmissionTransfertNational.repositories.PointDeVenteRepository;

@RestController
public class PointDeVenteRestController {
	private PointDeVenteRepository pointDeVenteR;
	public PointDeVenteRestController(PointDeVenteRepository cR){
			this.pointDeVenteR=cR;
	}
	@GetMapping(path="/get_PointDeVentes")
	public List<PointDeVente>listPointDeVentes(){
		return pointDeVenteR.findAll();
		
	}
	@GetMapping(path="/get_PointDeVente/{id}")
	public PointDeVente getPointDeVente(@PathVariable Long id){
		return pointDeVenteR.findById(id).get();
		
	}
	@PostMapping(path="/add_PointDeVente")
	public PointDeVente savePointDeVente(@RequestBody PointDeVente PointDeVente){
		
		return pointDeVenteR.save(PointDeVente);
		
	}
	@PutMapping(path="/update_PointDeVente/{id}")
	public PointDeVente updatePointDeVente(@PathVariable Long id,@RequestBody PointDeVente pv){
		pv.setId(id);
		return pointDeVenteR.save(pv);
		
	}
	@DeleteMapping(path="/delete_PointDeVente/{id}")
	public void deletePointDeVente(@PathVariable Long id){
		pointDeVenteR.deleteById(id);
		
	}
}
