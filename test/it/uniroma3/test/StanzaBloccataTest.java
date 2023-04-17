package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.ambienti.StanzaBloccata;
import it.uniroma3.attrezzi.Attrezzo;

class StanzaBloccataTest {

	Stanza bloccata;
	Attrezzo key;
	
	
	@BeforeEach
	public void setUp() {
		bloccata = new StanzaBloccata("bloccata");
		key = new Attrezzo("chiave",1);
	}
	
	
	@Test
	void testEntroSenzaKey() {
		assertEquals( bloccata ,bloccata.getStanzaAdiacente("est"));
	}
	
	@Test
	void testEntroConKey() {
		bloccata.addAttrezzo(key);
		Stanza seconda = new Stanza("est");
		bloccata.impostaStanzaAdiacente("est", seconda);
		assertEquals( seconda ,bloccata.getStanzaAdiacente("est"));
	}
	

}
