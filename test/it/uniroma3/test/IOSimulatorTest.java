package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;

class IOSimulatorTest {

	private IOSimulator io;
	
	
	@BeforeEach
	void setUP() throws Exception{
		
	}
	
	
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
	public void testSimuloStanzaMagica() {
		io = new IOSimulator("prendi chiave","vai sud","guarda stanza");
		assertEquals("prendi chiave", io.leggiRiga());
		
		assertEquals("vai sud", io.leggiRiga());

		assertEquals("guarda stanza", io.leggiRiga());
		
	}
	
	
	
	
	
	
	
	
	@Test
	public void testTroppeLetture() {
		IOSimulator io = new IOSimulator("fine");
		assertEquals("fine", io.leggiRiga());
		assertNull(io.leggiRiga())
		;
	}
	
	
	

}
