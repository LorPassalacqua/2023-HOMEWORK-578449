package it.uniroma3.ambienti;

import it.uniroma3.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public Labirinto(){
		init();
	}
	
	private void init() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo exca = new Attrezzo("EXCALIBUR",5);
		Attrezzo key = new Attrezzo("chiave", 1);
		
		
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new StanzaBloccata("Aula N11");
		Stanza aulaN10 = new StanzaMagica("Aula N10", 2);
		Stanza laboratorio = new StanzaBuia("Stanza Buia");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
	
	    /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(exca);
		atrio.addAttrezzo(key);
	
		// il gioco comincia nell'atrio
	    stanzaIniziale = atrio;  
		stanzaVincente = biblioteca;
		
		}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
	

		
}
