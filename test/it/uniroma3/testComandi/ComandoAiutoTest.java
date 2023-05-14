package it.uniroma3.testComandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fixture.Fixture;
import it.uniroma3.comandi.ComandoAiuto;
import it.uniroma3.comandi.ComandoFine;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

class ComandoAiutoTest {

	List<String> righeDaLeggere;
	ComandoAiuto aiuto;
	ComandoFine fine;
	
	

	@BeforeEach
	public void setUp() {
		righeDaLeggere = new ArrayList<>();
		aiuto = new ComandoAiuto();
		fine = new ComandoFine();
	}
	
	
	
	//TODO aggiustare
	
	
	@Test
	public void testPartitaConComandoAiuto() {
		righeDaLeggere.add("aiuto");
		righeDaLeggere.add("fine");
		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaEasy(righeDaLeggere);
		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.getMessaggioBenvenuto(), io.nextMessaggio());
		
		assertEquals(aiuto.getIntro(), io.nextMessaggio());
		
		StringBuilder stringa = new StringBuilder();
		for(String comando: aiuto.getListaComandi()) {
			stringa.append("<" + comando +"> " );
		}
		
		
		assertTrue(io.hasNextMessaggio());
		assertEquals(stringa , io.nextMessaggio());
		
		assertTrue(io.hasNextMessaggio());
		io.nextMessaggio();
		assertEquals(ComandoFine.getMessaggiofine(), io.nextMessaggio());
	}

}
