package it.uniroma3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.Partita;


public class partitaTest {
	
	private Partita partita;
	
	@Before
	public void setUp() {
		partita = new Partita();
	}
	
	
	
	@Test
	public void testIsFinitaGiocatoreCfu() {
		partita.getGiocatore().setCFU(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void nonFinitaTestStanzaVincente() {
		
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());		
		assertTrue(partita.isFinita());
	}

	@Test
	public void isFinitaFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());	
	}
	
	@Test
	public void isFinitaFalse() {
		assertFalse(partita.isFinita());
	}
	
	
	@Test
	public void getCfuTest() {
		assertEquals(20, this.partita.getGiocatore().getCFU());
	}
	
	@Test
	public void getCfuFinitiTest() {
		this.partita.getGiocatore().setCFU(0);
		assertEquals(0,this.partita.getGiocatore().getCFU());	
	}
	
	
	@Test
	public void setStanzaCorrenteTest() {
		assertEquals( "Atrio" , this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void setStanzaCorrenteNuovaTest() {
		Stanza Test = new Stanza("Test");
		this.partita.setStanzaCorrente(Test);
		assertEquals("Test", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void setStanzaCorrenteNullTest() {
		this.partita.setStanzaCorrente(null);
		assertNull(this.partita.getStanzaCorrente());
	}
	
	
	
	
	
	
	
	
	
	
}
