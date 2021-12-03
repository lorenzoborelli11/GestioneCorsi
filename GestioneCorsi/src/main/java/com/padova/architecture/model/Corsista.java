package com.padova.architecture.model;

public class Corsista {
	private String nomeCorsista;
	private String cognomeCorsista;
	private int codCorsista;
	private int precedentiFormativi;
	
	public String getNomeCorsista() {
		return nomeCorsista;
	}
	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}
	public String getCognomeCorsista() {
		return cognomeCorsista;
	}
	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}
	public int getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(int codCorsista) {
		this.codCorsista = codCorsista;
	}
	public int getPrecedentiFormativi() {
		return precedentiFormativi;
	}
	public void setPrecedentiFormativi(int precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nomeCorsista + ", Cognome: " + cognomeCorsista + ", Codice: "
				+ codCorsista + ", Precedenti: " + precedentiFormativi;
	}
}
