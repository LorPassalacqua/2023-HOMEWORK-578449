package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.ambienti.StanzaMagica;
import it.uniroma3.attrezzi.Attrezzo;

class stanzaMagicaTest {

	Stanza test;
	
	@BeforeEach
	public void setUp() {
		test = new StanzaMagica("test", 1);
	}
	
	//TODO  provare che il comportamento magico non avviene
	
	
	@Test
	void testComportamentoMagico() {
		Attrezzo osso = new Attrezzo("osso", 1);
		Attrezzo spada = new Attrezzo("spada", 1);
		test.addAttrezzo(osso);
		test.addAttrezzo(spada);
		assertTrue(test.hasAttrezzo("adaps"));
	}

}
