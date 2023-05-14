package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO{

	private List<String> righeLette;
	private int indiceProxComando;
	
	private List<String> messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	
	//il costruttore di IOSimulator crea l'array di comandi
	
	public IOSimulator(List<String> comandiLetti) {
		this.righeLette = comandiLetti;
		this.indiceProxComando = 0;
		this.indiceMessaggiMostrati = 0;
		this.messaggiProdotti = new ArrayList<String>();
	}
	
	/**
	 * consentirà di conoscere i messaggi
	 * stampati durante la partita
	 * (a supporto di eventuali asserzioni)
	 */
	
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti.add(this.indiceMessaggiProdotti,msg);
		this.indiceMessaggiProdotti++;
	}

	
	/**
	 * consentirà di “iniettare” le righe che
	 * desideriamo far figurare come istruzioni
	 * (di solito immesse dall’utente)
	 */
	
	@Override
	public String leggiRiga() {
		
			String riga = null;

			riga = this.righeLette.get(indiceProxComando);
			this.indiceProxComando++;
			return riga;
	}

	
	public List<String> getMessaggiProdotti(){
		return messaggiProdotti;
	}
	
	public void MessaggiProdotti(List<String> messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti.get(indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
