package org.acme.model;

public class Cidade {
	
	public Cidade() {
		
	}

	public Cidade(String cep) {
		this.cep = cep;
	}
	
	
	private String cep;
	
	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
