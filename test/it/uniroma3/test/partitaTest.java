package it.uniroma3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.Stanza;
import it.uniroma3.giocatore.Giocatore;

public class partitaTest {
	
	private boolean finita;
	
	private Labirinto labirinto;		
	private Giocatore giocatore;
	private Stanza stanzaCorrente;
	
	
	@Before
	public void setUp() {
		labirinto = new Labirinto();
		stanzaCorrente = labirinto.getStanzaIniziale();
		giocatore = new Giocatore();
		this.finita = false;
		
		
	}
	
	
	
	@Test
	public void setFinitaTest() {
		assertTrue(this.finita = true);
	}
	
	@Test
	public void nonFinitaTest() {
		assertFalse(this.finita = false);
	}

	@Test
	public void getCfuTest() {
		assertEquals(20, this.giocatore.getCFU());
	}
	
	@Test
	public void getCfuFinitiTest() {
		this.giocatore.setCFU(0);
		assertEquals(0,this.giocatore.getCFU());	
	}
	
	
	@Test
	public void setCfuTest() {
		this.giocatore.setCFU(10);
		assertEquals(10,this.giocatore.getCFU());
	}
	
	
	@Test
	public void setStanzaCorrenteTest() {
		assertEquals( "Atrio" , this.stanzaCorrente.getNome());
	}
	
	@Test
	public void setStanzaCorrenteNuovaTest() {
		Stanza Test = new Stanza("Test");
		this.stanzaCorrente = Test;
		assertEquals("Test", this.stanzaCorrente.getNome());
	}
	
	
	
	
	
	
	
	
	
	
}
