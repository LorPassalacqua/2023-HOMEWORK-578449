package it.uniroma3.testComandi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fixture.Fixture;
import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.LabirintoBuilder;
import it.uniroma3.ambienti.Stanza;
import it.uniroma3.comandi.ComandoFine;
import it.uniroma3.comandi.ComandoVai;
import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;

class ComandoVaiTest {


	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;
	private IO io;

	@BeforeEach
	public void setUp() throws Exception {
		io = new IOConsole();
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		vai = new ComandoVai();
		 labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		p = new Partita(labirinto);
		righeDaLeggere = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();

	}

	@Test
	public void testVaiNull() {
		p.setStanzaCorrente(s1);
		vai.esegui(p,io);
		assertEquals(s1, p.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("sud-ovest");
		vai.esegui(p,io);
		assertEquals(s2, p.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneInesistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("in fondo a destra");
		vai.esegui(p,io);
		assertNotEquals(s2, p.getStanzaCorrente());
	}

	@Test
	public void testPartitaConComandoVai() {
		righeDaLeggere.add("vai nord");

		String bib = "Biblioteca\n"
				+ "Uscite:  sud\n"
				+ "Attrezzi nella stanza: ";
		
		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaEasy(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.getMessaggioBenvenuto(), io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(bib, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("--| Hai vinto! |--", io.nextMessaggio());
		
	}
	
	@Test
	public void testPartitaConComandoVaiOvest() {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("fine");

		String studio = "Studio\n" + "Uscite:  est\n" + "Attrezzi nella stanza: ";
		
		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaHard(righeDaLeggere2);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.getMessaggioBenvenuto(), io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(studio, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.getMessaggiofine(), io.nextMessaggio());
	}
	
	@Test
	public void testPartitaConComandoVaiOvestEst() {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("vai est");
		righeDaLeggere2.add("fine");

		String studio = "Studio\n" + "Uscite:  est\n" + "Attrezzi nella stanza: ";
		String atrio = "Atrio\n" + "Uscite:  nord ovest\n" + "Attrezzi nella stanza: martello (3kg), ";
		
		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaHard(righeDaLeggere2);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.getMessaggioBenvenuto(), io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(studio, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(atrio, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.getMessaggiofine(), io.nextMessaggio());
	}
	
	

}
