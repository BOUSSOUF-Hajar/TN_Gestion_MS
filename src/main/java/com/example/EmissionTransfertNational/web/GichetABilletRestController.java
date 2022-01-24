package com.example.EmissionTransfertNational.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmissionTransfertNational.entities.GichetABillet;
import com.example.EmissionTransfertNational.repositories.GichetABilletRepository;

@RestController
public class GichetABilletRestController {
	private GichetABilletRepository gichetABilletR;
	public GichetABilletRestController(GichetABilletRepository cR){
			this.gichetABilletR=cR;
	}
	@GetMapping(path="/get_GichetABillets")
	public List<GichetABillet>listGichetABillets(){
		return gichetABilletR.findAll();
		
	}
	@GetMapping(path="/get_GichetABillet/{id}")
	public GichetABillet getGichetABillet(@PathVariable Long id){
		return gichetABilletR.findById(id).get();
		
	}
	@PostMapping(path="/add_GichetABillet")
	public GichetABillet saveGichetABillet(@RequestBody GichetABillet GichetABillet){
		
		return gichetABilletR.save(GichetABillet);
		
	}
	@PutMapping(path="/update_GichetABillet/{id}")
	public GichetABillet updateGichetABillet(@PathVariable Long id,@RequestBody GichetABillet gab){
		gab.setId(id);
		return gichetABilletR.save(gab);
		
	}
	@DeleteMapping(path="/delete_GichetABillet/{id}")
	public void deleteGichetABillet(@PathVariable Long id){
		gichetABilletR.deleteById(id);
		
	}
}
