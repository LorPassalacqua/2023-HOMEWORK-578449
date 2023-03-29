package it.uniroma3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;



public class stanzaTest {
		
	private Stanza stanza;
	

	@Before
	public void setUp() {
		this.stanza = new Stanza("Stanza");
		
		Attrezzo osso = new Attrezzo("osso", 10);
		this.stanza.addAttrezzo(osso);
	
	
	}
	
	
	@Test
	public void hasAttrezzoTest() {
		assertTrue(this.stanza.hasAttrezzo("osso"));
		
	}

	@Test
	public void hasAttrezzoFallitoTest() {
		assertFalse(stanza.hasAttrezzo("sciabola"));
	}
	
	
	@Test
	public void addAttrezzoTest() {
		Attrezzo spada = new Attrezzo("spada",2);
		this.stanza.addAttrezzo(spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	public void removeAttrezzoTest() {
		Attrezzo osso = new Attrezzo("osso", 2); 
		this.stanza.addAttrezzo(osso);
		assertTrue(this.stanza.removeAttrezzo(osso));
	}
	
	@Test
	public void getStanzaAdiacenteTest() {
		Stanza n11 = new Stanza("n11");
		stanza.impostaStanzaAdiacente("nord", n11);
		assertEquals(stanza.getStanzaAdiacente("nord").getNome(), n11.getNome());
	}

	@Test
	public void impostaStanzaAdiacenteTest() {
		Stanza n14 = new Stanza("n14");
		stanza.impostaStanzaAdiacente("ovest", n14);
		assertEquals(1,stanza.getNumerosatnzeAdiacenti());
	}
	
	@Test
	public void stanzaAdiacenteNonEsistenteTest() {
		assertNull(stanza.getStanzaAdiacente("sud-est"));
	}
	
	
	
	
	
}
	
