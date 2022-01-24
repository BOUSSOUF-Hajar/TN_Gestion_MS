package com.example.EmissionTransfertNational.entities;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Emetteur")
@Data @NoArgsConstructor @AllArgsConstructor
public class Emetteur extends Client {
	@Column(name="idEmetteur")
	private long idClient;
	private double limite_somme_transfert;
	private int nbr_transfert_envoyes;
	@OneToMany( targetEntity=Transfert.class, mappedBy="emetteur")
	@Transient
	private List<Transfert> transferts;
	@JsonIgnoreProperties(value={"emetteur","transfert"},allowSetters=true)
	@ManyToMany
	@JoinTable(name="Emetteur_Beneficiaire",joinColumns=@JoinColumn(name="idEmetteur"),inverseJoinColumns=@JoinColumn(name="idBeneficiaire"))
	private List<Beneficiaire>beneficiaires;
}