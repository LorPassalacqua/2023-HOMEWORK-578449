package it.uniroma3.ambienti;

public class StanzaBuia extends Stanza{

	private String key;			//	salva il nome dell oggetto per sbloccare
								//	la descrizione completa della stanza
	
	public StanzaBuia(String nome, String oggetto) {
		super(nome);
		key = oggetto;
	}


	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(key)) {
			return this.toString();
		}
		else {
			return "--| qui c'è buio pesto |--";
		}
	}
	
	
}
