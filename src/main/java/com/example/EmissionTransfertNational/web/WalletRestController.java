package com.example.EmissionTransfertNational.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmissionTransfertNational.entities.Wallet;
import com.example.EmissionTransfertNational.repositories.WalletRepository;

@RestController
public class WalletRestController {
	private WalletRepository walletR;
	public WalletRestController(WalletRepository cR){
			this.walletR=cR;
	}
	@GetMapping(path="/get_Wallets")
	public List<Wallet>listWallets(){
		return walletR.findAll();
		
	}
	@GetMapping(path="/get_Wallet/{id}")
	public Wallet getWallet(@PathVariable Long id){
		return walletR.findById(id).get();
		
	}
	@PostMapping(path="/add_Wallet")
	public Wallet saveWallet(@RequestBody Wallet Wallet){
		
		return walletR.save(Wallet);
		
	}
	@PutMapping(path="/update_Wallet/{id}")
	public Wallet updateWallet(@PathVariable Long id,@RequestBody Wallet wallet){
		wallet.setId(id);
		return walletR.save(wallet);
		
	}
	@DeleteMapping(path="/delete_Wallet/{id}")
	public void deleteWallet(@PathVariable Long id){
		walletR.deleteById(id);
		
	}
}
