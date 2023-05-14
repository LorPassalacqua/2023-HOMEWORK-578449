package it.uniroma3.ambienti;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.uniroma3.attrezzi.Attrezzo;

public class LabirintoBuilder implements Labirinto{
	
	private Stanza StanzaVincente;
	private Stanza StanzaIniziale;
	private Stanza ultimaStanzaAggiunta;		// Ultima stanza aggiunta
	private Map<String,Stanza> stanze;  		// Mappa per salvare le stanze
	
	public LabirintoBuilder() {
		stanze = new HashMap<String,Stanza>();
	}
	
	
	
	
	public LabirintoBuilder addStanzaIniziale(String stanza) {
		Stanza iniziale = new Stanza(stanza);
		this.setStanzaIniziale(iniziale);
		aggiungiEAggiorna(iniziale);
		return this;
	}
	
	
	public LabirintoBuilder addStanzaVincente(String stanza) {
		Stanza vincente = new Stanza(stanza);
		this.setStanzaVincente(vincente);
		aggiungiEAggiorna(vincente);
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		
		Stanza attaule = new Stanza(stanza);
		this.aggiungiEAggiorna(attaule);
		return this;
	}
	
	
	
	
	
	public LabirintoBuilder addAdiacenza(String stanzaAttuale, String daAggiungere , String direzione) {
		if(stanze.containsKey(stanzaAttuale) && stanze.containsKey(daAggiungere)) {
			Stanza attuale = stanze.get(stanzaAttuale);
			Stanza aggiungi = stanze.get(daAggiungere);
			attuale.impostaStanzaAdiacente(direzione, aggiungi);
			
		}
		return this;
	}
	
	public LabirintoBuilder getLabirinto() {
		return this;
	}
	
	
	public void aggiungiEAggiorna(Stanza stanza) {
		ultimaStanzaAggiunta = stanza;
		this.stanze.put(stanza.getNome(), stanza);
	}
	
	
	
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo ogg = new Attrezzo(nome,peso);
		if(ultimaStanzaAggiunta == null) {
			return this;
		}
		this.ultimaStanzaAggiunta.addAttrezzo(ogg);
		return this;
	}




	@Override
	public Stanza getStanzaVincente() {
		return this.StanzaVincente;
	}

	
	@Override
	public Stanza getStanzaIniziale() {
		return this.StanzaIniziale;
	}


	@Override
	public void setStanzaVincente(Stanza stanza) {
		this.StanzaVincente = stanza;
	}

	@Override
	public void setStanzaIniziale(Stanza stanza) {
		this.StanzaIniziale = stanza;
		
	}

	
	public List<Stanza> getListaStanze() {
		
		List<Stanza> output = new LinkedList<>();
		output.addAll(stanze.values());
		return output;
	}

	
	public Map<String, Stanza> getMapStanze(){
		return this.stanze;
	}

	
	
	
	
	

	public LabirintoBuilder addStanzaMagica(String nomeStanzaMagica) {

		Stanza stanzaMagica = new StanzaMagica(nomeStanzaMagica);		
		aggiungiEAggiorna(stanzaMagica);
		
		return this;
	}

	
	public LabirintoBuilder addStanzaMagica(String nome, int i) {
		Stanza stanza = new StanzaMagica(nome, i);
		aggiungiEAggiorna(stanza);
		return this;
	}
	
	
	//quella buia
	
	public LabirintoBuilder addStanzaMagica(String nome, String nomeOggetto) {
		Stanza stanza = new StanzaBuia(nome, nomeOggetto);
		aggiungiEAggiorna(stanza);
		return this;
	}



	public LabirintoBuilder addStanzaBloccata(String string, String string2, String string3) {
		
		Stanza StanzaBloccata = new StanzaBloccata(string, string2, string3);
		aggiungiEAggiorna(StanzaBloccata);
		
		return this;
	}
	
	
	




	

	
	
	
	
}
