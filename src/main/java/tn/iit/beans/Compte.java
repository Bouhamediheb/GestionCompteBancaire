package tn.iit.beans;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@NoArgsConstructor // obligatoire selon JPA
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity 
@Table(name = "t_compte")
public class Compte implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id // rib --> PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Include // equals et hashCode générés à base du RIB
	private Integer rib;
	@Column(name = "client")
	private String nomClient;
	private float solde;
	public Compte(String nomClient, float solde) {
		super();
		this.nomClient = nomClient;
		this.solde = solde;
	}

	public Integer getRib() {
		return rib;
	}

	public String getNomClient() {
		return nomClient;
	}

	public float getSolde() {
		return solde;
	}

	public void setRib(Integer rib) {
		this.rib = rib;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
}