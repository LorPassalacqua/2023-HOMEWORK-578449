package it.uniroma3.testComandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.LabirintoBuilder;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.comandi.ComandoPosa;
import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

class ComandoPosaTest {

	
	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	private Comando comando;
	Labirinto labirinto;
	
	
	@BeforeEach
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("seghetto", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("martello", 2);
		comando = new ComandoPosa();
		io = new IOConsole();
	}
	
	
	
	
	
	@Test
	public void testAttrezzoPosatoNull() {
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	
	@Test
	public void testTantiAttrezzi() {
		this.creatoreAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	
	
	
	public void creatoreAttrezzi() {
		for(int i= 0; i<11;i++) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("utensile"+i, 1));

		}
	}
	

}
