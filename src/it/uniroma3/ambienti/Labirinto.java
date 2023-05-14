package it.uniroma3.ambienti;

import java.util.Map;

public interface Labirinto {

	Stanza getStanzaVincente();

	Stanza getStanzaIniziale();

	void setStanzaVincente(Stanza stanza);

	void setStanzaIniziale(Stanza stanza);


}