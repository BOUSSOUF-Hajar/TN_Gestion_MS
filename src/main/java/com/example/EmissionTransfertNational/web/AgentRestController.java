package com.example.EmissionTransfertNational.web;

import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.example.EmissionTransfertNational.entities.*;
import com.example.EmissionTransfertNational.repositories.*;
@RestController @CrossOrigin("*")
public class AgentRestController {
	private AgentRepository agentR;
	private CompteRepository cptR;
	private PieceIdentiteRepository pR;
	private PointDeVenteRepository pdvR;
	private WalletRepository wR;
	private CarteDeCreditRepository cdcR;
	public AgentRestController(AgentRepository agentR,PointDeVenteRepository pdvR,ClientRepository cR,PieceIdentiteRepository pR, CompteRepository cptR,WalletRepository wr,CarteDeCreditRepository cdcR){
		this.pdvR=pdvR;
		this.cptR=cptR;
		this.pR=pR;
		this.agentR=agentR;
		this.wR=wr;
		this.cdcR=cdcR;
	}
	@GetMapping(path="/get_Agents")
	public List<Agent>listAgents(){
		return agentR.findAll();
		
	}
	@GetMapping(path="/get_Agent/{id}")
	public Agent getAgent(@PathVariable Long id){
		return agentR.findById(id).get();
		
	}
	@PostMapping(path="/add_Agent")
	public Agent saveAgent(@RequestBody Agent agent){
		if(agent==null){
			System.out.println("agent null");
			return null;
		}
		
		agent.setPassword("simo1234");
		PieceIdentite pi=agent.getPiece_identite();
		agent.setRole("agent");
		agent.setTransferts(null);
		if(pi!=null){
			pR.save(pi);
		}
		PointDeVente pdv=agent.getPointdevente();
		if(pdv!=null){
			pdvR.save(pdv);
		}
		Wallet w=agent.getWallet();
		if(w!=null){
			List<CarteDeCredit>lcartes=w.getCartes();
			wR.save(w);
			if(lcartes!=null){
				for(CarteDeCredit cdc:lcartes){
					cdc.setWallet(w);
					cdcR.save(cdc);
				}
			}
			
			
		}
		 List<Compte>l=agent.getComptes();
		 if(l!=null){
			 agent.setComptes(null);
		 agentR.save(agent);
		 for(Compte c:l){
			 c.setClient(agent);
			 cptR.save(c);
		 }
		 }
		 
		return agentR.save(agent);
		
	}
	@PutMapping(path="/update_Agent/{id}")
	public Agent updateAgent(@PathVariable Long id,@RequestBody Agent nvAgent){
		nvAgent.setIdClient(id);
		Agent aOriginal=agentR.getById(id);
		nvAgent.setComptes(aOriginal.getComptes());
		nvAgent.setPointdevente(aOriginal.getPointdevente());
		nvAgent.setTransferts(aOriginal.getTransferts());
		nvAgent.setPiece_identite(aOriginal.getPiece_identite());
		nvAgent.setWallet(aOriginal.getWallet());
		return agentR.save(nvAgent);
		
	}
	@DeleteMapping(path="/delete_Agent/{id}")
	public void deleteAgent(@PathVariable Long id){
		agentR.deleteById(id);
		
	}
}
