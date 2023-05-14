package it.uniroma3.testComandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fixture.Fixture;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

class ComandoFineTest {

	
	List<String> righeDaLeggere;
	
	@BeforeEach
	public void setUp() {
		righeDaLeggere = new ArrayList<String>();
	}
	
	@Test
	public void testPartitaConComandofine() {
		righeDaLeggere.add("fine");
		
		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaEasy(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.getMessaggioBenvenuto(), io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("--| Grazie di aver Giocato!! |--", io.nextMessaggio());
	}
	
	
	
}
