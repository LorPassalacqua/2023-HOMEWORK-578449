package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;


class IOSimulatorTest {

	private IOSimulator io;
	
	
	List<String> comandi;
	
	@BeforeEach
	public void setUp() {
		comandi = new ArrayList<String>();
	}
	
	
	
	
	@Test
	void testUnSoloComando() {
		comandi.add("fine");
		assertEquals("fine", new IOSimulator(comandi).leggiRiga());
	}
	
	
	@Test
	public void testPiuComandi() {
		comandi.add("vai nord");
		comandi.add("fine");
		io = new IOSimulator(comandi);
		assertEquals("vai nord", io.leggiRiga());
		assertEquals("fine", io.leggiRiga());
	}

	
	@Test
	public void testSimuloStanzaMagica() {
		comandi.add("prendi chiave");
		comandi.add("vai sud");
		comandi.add("guarda stanza");
		comandi.add("posa chiave");
		comandi.add("prendi chiave");
		comandi.add("posa chiave");
		comandi.add("prendi chiave");
		comandi.add("posa chiave");
		comandi.add("prendi chiave");
		comandi.add("posa chiave");
		comandi.add("guarda stanza");
		comandi.add("fine");
		io = new IOSimulator(comandi);
		
		assertEquals("prendi chiave", io.leggiRiga());
		assertEquals("vai sud", io.leggiRiga());
		assertEquals("guarda stanza", io.leggiRiga());
		posaPrendi();
		assertEquals("guarda stanza", io.leggiRiga());
		assertEquals("fine", io.leggiRiga());
	}
	
	
	@Test
	public void testEsistenzaStanzaBloccata() {
		comandi.add("prendi chiave");
		comandi.add("vai est");
		comandi.add("guarda stanza");
		comandi.add("posa chiave");
		comandi.add("vai est");
		comandi.add("fine");
		io = new IOSimulator(comandi);
		assertEquals("prendi chiave", io.leggiRiga());
		assertEquals("vai est", io.leggiRiga());
		assertEquals("guarda stanza", io.leggiRiga());
		assertEquals("posa chiave", io.leggiRiga());
		assertEquals("vai est", io.leggiRiga());
		assertEquals("fine", io.leggiRiga());
	}
	
	
	@Test
	public void testStanzaBuia() {
		comandi.add("prendi EXCALIBUR");
		comandi.add("vai ovest");
		comandi.add("guarda stanza");
		comandi.add("posa EXCALIBUR");
		comandi.add("guarda stanza");
		comandi.add("fine");
		io = new IOSimulator(comandi);
		assertEquals("prendi EXCALIBUR", io.leggiRiga());
		assertEquals("vai ovest", io.leggiRiga());
		assertEquals("guarda stanza", io.leggiRiga());
		assertEquals("posa EXCALIBUR", io.leggiRiga());
		assertEquals("guarda stanza", io.leggiRiga());
		assertEquals("fine", io.leggiRiga());
	}
	
	
	@Test
	public void testMorte() {
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai sud");
		comandi.add("vai nord");
		io = new IOSimulator(comandi);
		morte();
	}
	
	@Test
	public void testGiroLabirinto() {
		comandi.add("vai sud");
		comandi.add("vai nord");
		comandi.add("vai ovest");
		comandi.add("vai est");
		comandi.add("vai est");
		comandi.add("vai ovest");
		comandi.add("vai nord");
		io = new IOSimulator(comandi);
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
