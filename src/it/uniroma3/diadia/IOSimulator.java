package it.uniroma3.diadia;

public class IOSimulator implements IO{

	private String[] comandiLetti;
	private int indiceProxComando;
	
	
	//il costruttore di IOSimulator crea l'array di comandi
	
	public IOSimulator(String... comandiLetti) {
		this.comandiLetti = comandiLetti;
		this.indiceProxComando = 0;
	}
	
	/**
	 * consentirà di conoscere i messaggi
	 * stampati durante la partita
	 * (a supporto di eventuali asserzioni)
	 */
	
	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);	
	}

	
	/**
	 * consentirà di “iniettare” le righe che
	 * desideriamo far figurare come istruzioni
	 * (di solito immesse dall’utente)
	 */
	
	@Override
	public String leggiRiga() {
		if(this.comandiLetti.length == 0) return null;
		
		if(this.indiceProxComando >= this.comandiLetti.length) return null;
		
		return this.comandiLetti[this.indiceProxComando++];
	}

}
