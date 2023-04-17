package it.uniroma3.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.Partita;
import it.uniroma3.giocatore.Giocatore;


public class partitaTest {
	
	private Partita partita;

	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
		
	}
	
	
	
	
	//	Test per il isFinita
	
	
	@Test
	public void testIsFinitaGiocatoreCfu() {
		partita.getGiocatore().setCFU(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaStanzaVincente() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());		
		assertTrue(partita.isFinita());
	}

	@Test
	public void testIsFinitaFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());	
	}
	
	@Test
	public void testIsFinitaFalse() {
		assertFalse(partita.isFinita());
	}
	
	
	
	
	//	Test per setCFU
	
	
	//	I test per il set cfu sono la copia speculare dei test per
	//	il getCFU periò inutili da riscrivere

	
	
	
	//	Test per il getCFU
	
	
	@Test
	public void testGetCfu() {
		assertEquals(20, this.partita.getGiocatore().getCFU());
	}
	
	@Test
	public void testGetCfuFiniti() {
		this.partita.getGiocatore().setCFU(0);
		assertEquals(0,this.partita.getGiocatore().getCFU());	
	}
	
	
	
	
	
	//	 Test getStanzaCorrente

	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals( "Atrio" , this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaCorenteNuova() {
		Stanza n11 = new Stanza("n11");
		partita.setStanzaCorrente(n11);
		Stanza n12 = new Stanza("n12");
		partita.setStanzaCorrente(n12);
		assertEquals("n12", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrenteNull() {
		Stanza vuota = null;
		partita.setStanzaCorrente(vuota);
		assertNull(partita.getStanzaCorrente());
	}
	
	
	
	
	//	Test setStanzaCorrente
	
	
	@Test
	public void testSetStanzaCorrenteNuova() {
		Stanza Test = new Stanza("Test");
		this.partita.setStanzaCorrente(Test);
		assertEquals("Test", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrenteNull() {
		this.partita.setStanzaCorrente(null);
		assertNull(this.partita.getStanzaCorrente());
	}
	
	
	
	
	//	test per il setGiocatore
	
	
	@Test
	public void testSetGiocatore() {
		Giocatore giocatore2 = new Giocatore();
		partita.setGiocatore(giocatore2);
		assertEquals(giocatore2, partita.getGiocatore());
	}
	
	
	@Test
	public void testSetgiocatoreNull() {
		Giocatore vuoto = null;
		partita.setGiocatore(vuoto);
		assertNull(partita.getGiocatore());
	}
	
	
	
	
	
	
	
	
	
}
