package it.polito.model.numero.tdp;

import java.security.InvalidParameterException;

public class NumeroModel {

	private final int nMax = 100;
	private final int tMax = 8;
	
	private int numero;
	private int tentativiFatti;
	private boolean inGioco;
	
	public int getNumero() {
		return numero;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public boolean isInGioco() {
		return inGioco;
	}

	public NumeroModel() {
		inGioco = false;
	}
	
	public int gettMax() {
		return tMax;
	}

	public void newGame() {
		inGioco = true;
		this.numero = (int)(Math.random()* nMax + 1);
		this.tentativiFatti = 0;
	}
	
	public int newTentativo(int t) {
		
		if(!inGioco)
			throw new IllegalStateException("La partita è terminata");
		
		if(!TentativoValido(t)) 
			throw new InvalidParameterException(String.format("Devi inserire un numero tra 1 e "+nMax));
		 
		tentativiFatti++;
		if(tentativiFatti == this.tMax) {
			this.inGioco = false;
		}
			
		if(t > this.numero)
				return 1;
		
		if(t == this.numero) {
				inGioco=false;
				return 0;
		}
		
		return -1;
	}
	
	public boolean TentativoValido(int t) {
		if(t > nMax || t < 1)
			return false;
		else return true;
	}
}
