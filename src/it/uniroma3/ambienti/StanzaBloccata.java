package it.uniroma3.ambienti;

public class StanzaBloccata extends Stanza{

	private String direnzioneBloccata;
	private String key;
	
	
	public StanzaBloccata(String nome, String dir, String chiave) {
		super(nome);
		direnzioneBloccata = dir;
		key = chiave;
	}
	
	public String getDirezioneBloccata() {
		return this.direnzioneBloccata;
	}
	
	public String getChiaveStanza() {
		return this.key;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		
		if(dir.equals(direnzioneBloccata) && !this.hasAttrezzo(key)) {
			return this; //ritorno il riferimento alla stanza attuale
		}
		
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(key)) {
			return super.getDescrizione();
		}
		return "--| stanza bloccata |--";
	}


	@Override
	public boolean equals(Object o) {
		boolean check = super.equals(o);
		StanzaBloccata that =  (StanzaBloccata) o;
		return check && this.getDirezioneBloccata().equals(that.getDirezioneBloccata()) &&
						this.getChiaveStanza().equals(that.getChiaveStanza());
	}
	
	
	
}
