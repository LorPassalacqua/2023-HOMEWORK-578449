package it.uniroma3.giocatore;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;

public class Borsa {

	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
		
		private Attrezzo[] attrezzi;
		private int numeroAttrezzi;
	
		private int pesoMax;
		public Borsa() {
		
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
	
		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	

	public Attrezzo[] ricostruisciArray(Attrezzo attrezzi[] ) {
		int i;
		int j=0;
		int dimensione = attrezzi.length;
		Attrezzo[] temp = new Attrezzo[dimensione];
		
		for(i = 0; i<attrezzi.length; i++) {
			if(attrezzi[i] != null) {
				temp[j] = attrezzi[i];
				j++;
			}
		}
		return temp;
	}

	
	
	public boolean removeAttrezzo(Attrezzo attrezzo) {

		for (int i=0; i<numeroAttrezzi; i++)
			if (attrezzo.getNome().equals(attrezzi[i].getNome())) {
				attrezzi[i] = null;
				numeroAttrezzi--;
				this.attrezzi = ricostruisciArray(attrezzi);					
				return true;
			}
		return false;
	}
		
		
		
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("--| Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("--| Borsa vuota |--");
			return s.toString();
		}
	
	
	//mostra gli ogggetti nella borsa
	
	public void mostraOgettiInBorsa(IOConsole scanner) {
		
		for(int i=0; i<numeroAttrezzi; i++) {
			scanner.mostraMessaggio(attrezzi[i].toString());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
