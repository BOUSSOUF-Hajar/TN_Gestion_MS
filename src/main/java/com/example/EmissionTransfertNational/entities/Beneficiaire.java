package com.example.EmissionTransfertNational.entities;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Entity
@Table(name="Beneficiaire")
@Data @NoArgsConstructor  @Getter @Setter
public class Beneficiaire extends Client {
	@Column(name="idBeneficiaire")
	private long idClient;
	private int nbr_transfert_recus;
	@JsonIgnoreProperties({"beneficiaire"})
	@OneToMany( targetEntity=Transfert.class, mappedBy="emetteur")
	@Transient
	private List <Transfert> transferts;
	@JsonIgnoreProperties({"beneficiaires","transfert"})
	@ManyToMany
	@JoinTable(name="Emetteur_Beneficiaire",joinColumns=@JoinColumn(name="idBeneficiaire"),inverseJoinColumns=@JoinColumn(name="idEmetteur"))
	private List<Emetteur> emetteurs;
}
