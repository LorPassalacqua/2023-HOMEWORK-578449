package it.uniroma3.giocatore;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	
	private int CFU;
	
	private Borsa borsa;
	
	
	//costruttore che gli vengoo passati i cfu per iniziare e crea l'oggetto borsa;
	
	public Giocatore() {
		this.CFU = CFU_INIZIALI;
		borsa = new Borsa();
	}
	
	
	public int getCFU() {
		return this.CFU;
	}
	
	public void setCFU(int cfu) {
		this.CFU = cfu;
	}
	
	//aggiunta in borsa
	
	public Borsa getBorsa() {
		return this.borsa;
		
	}
	
	
	//rimozione dalla borsa
	
	public boolean addAttrezzo(Attrezzo attrezo) {
		return borsa.addAttrezzo(attrezo);
	}
	  
	  
	public void removeAttrezzo(Attrezzo attrezzo) {
		borsa.removeAttrezzo(attrezzo);
	}
	
	public void mostraOggettiInBorsa(IOConsole scanner) {
		borsa.mostraOgettiInBorsa(scanner);
	}
	
	
	
}
