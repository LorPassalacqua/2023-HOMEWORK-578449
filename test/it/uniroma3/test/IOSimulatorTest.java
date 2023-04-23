package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;

class IOSimulatorTest {

	private IOSimulator io;
	
	
	@Test
	void testUnSoloComando() {
		assertEquals("fine", new IOSimulator("fine").leggiRiga());
	}
	
	
	@Test
	public void testPiuComandi() {
		io = new IOSimulator("vai nord", "fine");
		assertEquals("vai nord", io.leggiRiga());
		assertEquals("fine", io.leggiRiga());
	}

	
	@Test
	public void testComandoNullo() {
		assertNull(new IOSimulator().leggiRiga());
	}

	
	@Test
	public void testTroppeLetture() {
		IOSimulator io = new IOSimulator("fine");
		assertEquals("fine", io.leggiRiga());
		assertNull(io.leggiRiga());
	}
	
	
	@Test
	public void testSimuloStanzaMagica() {
		io = new IOSimulator("prendi chiave","vai sud","guarda stanza", "posa chiave",
							 "prendi chiave", "posa chiave", "prendi chiave","posa chiave",
							 "prendi chiave", "posa chiave", "guarda stanza", "fine");
		
		assertEquals("prendi chiave", io.leggiRiga());
		assertEquals("vai sud", io.leggiRiga());
		assertEquals("guarda stanza", io.leggiRiga());
		posaPrendi();
		assertEquals("guarda stanza", io.leggiRiga());
		assertEquals("fine", io.leggiRiga());
	}
	
	
	@Test
	public void testEsistenzaStanzaBloccata() {
		io = new IOSimulator("prendi chiave","vai est","guarda stanza","posa chiave", "vai est", "fine");
		assertEquals("prendi chiave", io.leggiRiga());
		assertEquals("vai est", io.leggiRiga());
		assertEquals("guarda stanza", io.leggiRiga());
		assertEquals("posa chiave", io.leggiRiga());
		assertEquals("vai est", io.leggiRiga());
		assertEquals("fine", io.leggiRiga());
	}
	
	
	@Test
	public void testStanzaBuia() {
		io = new IOSimulator("prendi EXCALIBUR", "vai ovest", "guarda stanza", "posa EXCALIBUR", "guarda stanza", "fine");
		assertEquals("prendi EXCALIBUR", io.leggiRiga());
		assertEquals("vai ovest", io.leggiRiga());
		assertEquals("guarda stanza", io.leggiRiga());
		assertEquals("posa EXCALIBUR", io.leggiRiga());
		assertEquals("guarda stanza", io.leggiRiga());
		assertEquals("fine", io.leggiRiga());
	}
	
	
	@Test
	public void testMorte() {
		io = new IOSimulator("vai sud", "vai nord", "vai sud", "vai nord", "vai sud",
							 "vai nord", "vai sud", "vai nord", "vai sud", "vai nord",
							 "vai sud", "vai nord", "vai sud", "vai nord", "vai sud",
							 "vai nord", "vai sud", "vai nord", "vai sud", "vai nord");
		morte();
	}
	
	@Test
	public void testGiroLabirinto() {
		io = new IOSimulator("vai sud","vai nord","vai ovest","vai est","vai est","vai ovest","vai nord");
		assertEquals("vai sud", io.leggiRiga());
		assertEquals("vai nord", io.leggiRiga());
		assertEquals("vai ovest", io.leggiRiga());
		assertEquals("vai est", io.leggiRiga());
		assertEquals("vai est", io.leggiRiga());
		assertEquals("vai ovest", io.leggiRiga());
		assertEquals("vai nord", io.leggiRiga());
	}
	
	//funzioni di appoggio
	
	public void posaPrendi() {
		for(int i=0; i<7;i++) {
			if(i%2==0) {
				assertEquals("posa chiave", io.leggiRiga());
			}
			else {
				assertEquals("prendi chiave", io.leggiRiga());
			}
				
		}
	}
	
	
	public void morte() {
		for(int i = 0; i<20;i++) {
			if(i%2==0) {
				assertEquals("vai sud", io.leggiRiga());
			}
			else {
				assertEquals("vai nord", io.leggiRiga());
			}
		}
	}
	

}
