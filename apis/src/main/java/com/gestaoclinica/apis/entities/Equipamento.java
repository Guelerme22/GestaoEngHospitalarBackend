package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_INVENTARIO", uniqueConstraints = @UniqueConstraint(columnNames = { "inventario" }))
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String inventario;

	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;
	
	@OneToOne
	@NotNull
	private Fornecedor fornecedor;
	
	@NotEmpty
	private String descricao;
	
	@NotNull
	private String dataCadastramento = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

	
	public Inventario() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getInventario() {
		return inventario;
	}


	public void setInventario(String inventario) {
		this.inventario = inventario;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getDataCadastramento() {
		return dataCadastramento;
	}


	public void setDataCadastramento(String dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}


	

}
