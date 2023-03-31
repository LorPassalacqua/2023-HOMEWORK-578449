package it.uniroma3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.Partita;
import it.uniroma3.giocatore.Giocatore;


public class partitaTest {
	
	private Partita partita;

	
	@Before
	public void setUp() {
		partita = new Partita();
		
	}
	
	
	
	
	//	Test per il isFinita
	
	
	@Test
	public void IsFinitaGiocatoreCfuTest() {
		partita.getGiocatore().setCFU(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void isFinitaStanzaVincenteTest() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());		
		assertTrue(partita.isFinita());
	}

	@Test
	public void isFinitaFinitaTest() {
		partita.setFinita();
		assertTrue(partita.isFinita());	
	}
	
	@Test
	public void isFinitaFalseTest() {
		assertFalse(partita.isFinita());
	}
	
	
	
	
	//	Test per setCFU
	
	
	//	I test per il set cfu sono la copia speculare dei test per
	//	il getCFU periò inutili da riscrivere

	
	
	
	//	Test per il getCFU
	
	
	@Test
	public void getCfuTest() {
		assertEquals(20, this.partita.getGiocatore().getCFU());
	}
	
	@Test
	public void getCfuFinitiTest() {
		this.partita.getGiocatore().setCFU(0);
		assertEquals(0,this.partita.getGiocatore().getCFU());	
	}
	
	
	
	
	
	//	 Test getStanzaCorrente

	
	@Test
	public void getStanzaCorrenteTest() {
		assertEquals( "Atrio" , this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void getStanzaCorenteNuovaTest() {
		Stanza n11 = new Stanza("n11");
		partita.setStanzaCorrente(n11);
		Stanza n12 = new Stanza("n12");
		partita.setStanzaCorrente(n12);
		assertEquals("n12", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void getStanzaCorrenteNull() {
		Stanza vuota = null;
		partita.setStanzaCorrente(vuota);
		assertNull(partita.getStanzaCorrente());
	}
	
	
	
	
	//	Test setStanzaCorrente
	
	
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
	
	
	
	
	//	test per il setGiocatore
	
	
	@Test
	public void setGiocatoreTest() {
		Giocatore giocatore2 = new Giocatore();
		partita.setGiocatore(giocatore2);
		assertEquals(giocatore2, partita.getGiocatore());
	}
	
	
	@Test
	public void setgiocatoreNullTest() {
		Giocatore vuoto = null;
		partita.setGiocatore(vuoto);
		assertNull(partita.getGiocatore());
	}
	
	
	
	
	
	
	
	
	
}
