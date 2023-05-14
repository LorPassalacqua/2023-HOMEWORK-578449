package it.uniroma3.testComandi;

import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.LabirintoBuilder;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.comandi.ComandoPrendi;
import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

class ComandoPrendiTest {

	
	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	
	private Comando comando;
	private IO io;
	Labirinto labirinto;
	
	@BeforeEach
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("martello", 2);
		attrezzoPesante = new Attrezzo("incudine", 11);
		comando = new ComandoPrendi();
		io = new IOConsole();
	}
	
	
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));

	}
	
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("incudine");
		comando.esegui(partita,io);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("incudine"));

	}
	
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	
	
}
