package org.acme.model;

public class Endereco {
	
	
	 public Endereco() {
		super();
	}
	 
	public Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf,
			String ibge, String gia, String ddd, String siafi) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.ibge = ibge;
		this.gia = gia;
		this.ddd = ddd;
		this.siafi = siafi;
	}



	 private String cep;
	 private String logradouro;
	 private String complemento;
	 private String bairro;
	 private String localidade;
	 private String uf;
	 private String ibge;
	 private String gia;
	 private String ddd;
	 private String siafi;



	 public String getCep() {
	  return cep;
	 }

	 public String getLogradouro() {
	  return logradouro;
	 }

	 public String getComplemento() {
	  return complemento;
	 }

	 public String getBairro() {
	  return bairro;
	 }

	 public String getLocalidade() {
	  return localidade;
	 }

	 public String getUf() {
	  return uf;
	 }

	 public String getIbge() {
	  return ibge;
	 }

	 public String getGia() {
	  return gia;
	 }

	 public String getDdd() {
	  return ddd;
	 }

	 public String getSiafi() {
	  return siafi;
	 }


	 public void setCep(String cep) {
	  this.cep = cep;
	 }

	 public void setLogradouro(String logradouro) {
	  this.logradouro = logradouro;
	 }

	 public void setComplemento(String complemento) {
	  this.complemento = complemento;
	 }

	 public void setBairro(String bairro) {
	  this.bairro = bairro;
	 }

	 public void setLocalidade(String localidade) {
	  this.localidade = localidade;
	 }

	 public void setUf(String uf) {
	  this.uf = uf;
	 }

	 public void setIbge(String ibge) {
	  this.ibge = ibge;
	 }

	 public void setGia(String gia) {
	  this.gia = gia;
	 }

	 public void setDdd(String ddd) {
	  this.ddd = ddd;
	 }

	 public void setSiafi(String siafi) {
	  this.siafi = siafi;
	 }}
