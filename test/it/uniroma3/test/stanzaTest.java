package it.uniroma3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;



public class stanzaTest {
	
	private Stanza vuota;
	private Stanza nonVuota;

	@Before
	public void setUp() {
		this.vuota = new Stanza("Vuota");
		
		
		
		
	}
	
	
	@Test
	public void hasAttrezzo() {
		assertEquals("sai fare le somme?", 4, 2+2);
		
	}
	
	@Test
	public void addAttrezzo() {
		
		this.vuota.addAttrezzo(new Attrezzo("osso", 1));
		assertTrue(this.vuota.hasAttrezzo("osso"));

	}
}
	
