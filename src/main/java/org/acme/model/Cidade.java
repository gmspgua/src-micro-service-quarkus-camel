package org.acme.model;

import java.util.Objects;


public class Cidade {

	private String cep;
	
	public Cidade() {
		
	}

	public Cidade(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (!(obj instanceof Cidade)) {
	            return false;
	        }

	        Cidade other = (Cidade) obj;

	        return Objects.equals(other.cep, this.cep);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(this.cep);
	    }

}
