package com.donus.entity;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Movie {
	
	@ApiModelProperty(value = "Código do Filme, gerado automático não precisa ser passado no Json")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String nome;

	@Column
	private Date dataLancamento;

	@Column
	private String censura;

	@Column
	private String direcao;

	@Column
	private ArrayList<String> atores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getCensura() {
		return censura;
	}

	public void setCensura(String censura) {
		this.censura = censura;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public ArrayList<String> getAtores() {
		return atores;
	}

	public void setAtores(ArrayList<String> atores) {
		this.atores = atores;
	}

	public Movie(Long id, String nome, Date dataLancamento, String censura, String direcao,
			ArrayList<String> atores) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.censura = censura;
		this.direcao = direcao;
		this.atores = atores;
	}

	public Movie() {

	}

}
