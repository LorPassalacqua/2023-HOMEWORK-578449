package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.ambienti.StanzaMagica;
import it.uniroma3.attrezzi.Attrezzo;

class stanzaMagicaTest {

	static final int NUMERO_MAX_IN_STANZA = 10;
	static final int SOGLIA_MAX = 3;
	Stanza test;
	Attrezzo spada;
	Attrezzo lanterna;
	
	@BeforeEach
	public void setUp() {
		test = new StanzaMagica("test", SOGLIA_MAX);
		spada = new Attrezzo("spada", 1);
		lanterna = new Attrezzo("lanterna", 1);
		
	}
	
	
	@Test
	public void testComportamentoMagicoNo() {
		test.addAttrezzo(spada);
		assertFalse(test.hasAttrezzo("adaps"));
	}
	
	@Test
	public void testComportamentoMagico() {
		aggiungiSoglia(test,spada);
		assertTrue(test.hasAttrezzo("adaps"));
	}
	
	@Test
	public void testComportamentoMagicoSuperataSoglia() {
		lanterna = new Attrezzo("osso",1);
		aggiungiMaxStanza(test, spada);
		test.addAttrezzo(lanterna);
		assertFalse(test.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testComportamentoMagicoPeso() {
		aggiungiSoglia(test,spada);
		assertEquals(2, test.getAttrezzo("adaps").getPeso());
	}
	
	@Test
	public void testComportamentoMagicoPesoNo() {
		test.addAttrezzo(spada);
		assertEquals(1, test.getAttrezzo("spada").getPeso());
	}
	
	
	public void aggiungiMaxStanza(Stanza stanza, Attrezzo attrezzo) {
		for(int i=0 ; i<NUMERO_MAX_IN_STANZA; i++) {
			stanza.addAttrezzo(attrezzo);
		}
	}
	
	

	public void aggiungiSoglia(Stanza stanza, Attrezzo attrezzo) {
		for(int i=0 ; i<SOGLIA_MAX+1; i++) {
			stanza.addAttrezzo(attrezzo);
		}
	}
	
	//TODO implementare altri test per non invertito/invertito
	// peso raddoppiato e non raddoppiato
	
}
