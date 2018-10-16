package com.stefanini.dto;

import java.io.Serializable;

public class EnderecoDTO implements Serializable{
	
	private static final long serialVersionUID = -1787266419428567474L;

	private String cidade;
	private String bairro;
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}
