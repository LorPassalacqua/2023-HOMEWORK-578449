package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.StanzaMagicaProtected;
import it.uniroma3.attrezzi.Attrezzo;

class StanzaMagicaProtectedTest {

	final static int SOGLIA = 2;
	StanzaMagicaProtected test;
	Attrezzo spada;
	
	@BeforeEach
	public void setUp() {
		test = new StanzaMagicaProtected("Stanza", 2);
		spada = new Attrezzo("spada", 2);
	}
	
	
	@Test
	void testStanzaMagicaProtected() {
		aggiungi(test,spada);
		assertTrue(test.hasAttrezzo("adaps"));
	}
	
	@Test
	public void testStanzaMagicaNonAvviene() {
		test.addAttrezzo(spada);
		assertFalse(test.hasAttrezzo("adaps"));
	}
	
	@Test
	public void testStanzaMagicaUnitario() {
		assertTrue(test.addAttrezzo(spada));
		
	}
	
	@Test
	public void testStanzaMagicaStanzaPiena() {
		for(int i=0; i<10; i++) {
			test.addAttrezzo(spada);
		}
		Attrezzo osso = new Attrezzo("osso", 1);
		assertFalse(test.addAttrezzo(osso));
	}
	
	
	
	
	public void aggiungi(StanzaMagicaProtected test, Attrezzo spada) {
		
		for(int i = 0; i<SOGLIA+1; i++) {
			test.addAttrezzo(spada);
		}
		
	}

}
