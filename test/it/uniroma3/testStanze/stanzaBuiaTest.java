package it.uniroma3.testStanze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.ambienti.StanzaBuia;
import it.uniroma3.attrezzi.Attrezzo;

class stanzaBuiaTest {


	Stanza buia;
	Attrezzo key;
	
	
	
	@BeforeEach
	public void setUp() {
		buia = new StanzaBuia("buia");
		key = new Attrezzo("EXCALIBUR", 5);
	}
	
	
	
	
	@Test
	public void testEntroSensaChiave() {
		assertEquals("--| qui c'è buio pesto |--", buia.getDescrizione());
	}

	@Test
	public void testEntroConChiave() {
		Stanza test = new Stanza("buia");
		test.addAttrezzo(key);
		
		buia.addAttrezzo(key);
		assertEquals(test.getDescrizione(), buia.getDescrizione());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
