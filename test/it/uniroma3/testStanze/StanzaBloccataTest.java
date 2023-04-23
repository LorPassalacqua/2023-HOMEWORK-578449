package it.uniroma3.testStanze;

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
		Stanza seconda = new Stanza("est");
		bloccata.impostaStanzaAdiacente("est", seconda);
		assertEquals( bloccata ,bloccata.getStanzaAdiacente("est"));
	}
	
	@Test
	void testEntroConKey() {
		bloccata.addAttrezzo(key);
		Stanza seconda = new Stanza("est");
		bloccata.impostaStanzaAdiacente("est", seconda);
		assertEquals( seconda ,bloccata.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testProvoAltreStanze() {
		Stanza seconda = new Stanza("nord");
		bloccata.impostaStanzaAdiacente("nord", seconda);
		Stanza terza = new Stanza("sud");
		bloccata.impostaStanzaAdiacente("sud", terza);
		Stanza quarta = new Stanza("ovest");
		bloccata.impostaStanzaAdiacente("ovest", quarta);
		assertEquals( seconda ,bloccata.getStanzaAdiacente("nord"));
		assertEquals( terza ,bloccata.getStanzaAdiacente("sud"));
		assertEquals( quarta ,bloccata.getStanzaAdiacente("ovest"));
		assertEquals( bloccata ,bloccata.getStanzaAdiacente("est"));
	}
	

}
