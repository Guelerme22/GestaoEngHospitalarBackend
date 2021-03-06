package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
public class Entrega implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private Long cpf;
	@NotNull
	private Long cnpjUsuario;
	@NotNull
	private Long cepOrigem;



	public Entrega(Long id, Long cpf, @NotNull Long cnpjUsuario, @NotNull Long cepOrigem) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.cnpjUsuario = cnpjUsuario;
		this.cepOrigem = cepOrigem;
	}
	public Entrega() {
	
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public Long getCnpjUsuario() {
		return cnpjUsuario;
	}


	public void setCnpjUsuario(Long cnpjUsuario) {
		this.cnpjUsuario = cnpjUsuario;
	}


	public Long getCepOrigem() {
		return cepOrigem;
	}


	public void setCepOrigem(Long cepOrigem) {
		this.cepOrigem = cepOrigem;
	}




	
}
