package it.uniroma3.ambienti;

public class StanzaBloccata extends Stanza{

	private String direnzioneBloccata;
	private String key;
	
	
	public StanzaBloccata(String nome) {
		super(nome);
		direnzioneBloccata = "est";
		key = "chiave";
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		
		if(dir.equals(direnzioneBloccata)) {
			
			if(this.hasAttrezzo(key)) {
				return super.getStanzaAdiacente(dir);				
			}
			
			else {
				return this; //ritorno il riferimento alla stanza attuale
			}
		}
		else {
			return super.getStanzaAdiacente(dir);
		}
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(key)) {
			return this.toString();
		}
		return "--| stanza bloccata |--";
	}
	
}
