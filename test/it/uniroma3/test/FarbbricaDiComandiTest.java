package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.comandi.ComandoFine;
import it.uniroma3.comandi.ComandoNonValido;
import it.uniroma3.comandi.ComandoVai;
import it.uniroma3.comandi.FabbricaDiComandi;
import it.uniroma3.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.Comando;


class FarbbricaDiComandiTest{
	
	FabbricaDiComandi factory;
	private Comando expected;
	
	@BeforeEach
	public void setUp() {
		factory = new FabbricaDiComandiFisarmonica();
		
	}
	
	@Test
	public void testCoamndoAiuto() {
		String istruzione = "aiuto";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoAiuto", output.getNome());
	}
	
	@Test
	public void testCoamndoFine() {
		String istruzione = "fine";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoFine", output.getNome());
	}
	
	@Test
	public void testCoamndoGuardaVuoto() {
		String istruzione = "guarda";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoGuarda", output.getNome());
	}
	
	@Test
	public void testCoamndoGuardaBorsa() {
		String istruzione = "guarda borsa";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoGuarda", output.getNome());
		assertEquals("borsa", output.getParametro());
	}
	
	@Test
	public void testCoamndoGuardaStanza() {
		String istruzione = "guarda stanza";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoGuarda", output.getNome());
		assertEquals("stanza", output.getParametro());
	}
	
	public void testCoamndoGuardaNonValido() {
		String istruzione = "";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoNonValido", output.getNome());
	}
	
	@Test
	public void testCoamndoPosaNulla() {
		String istruzione = "posa";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoPosa", output.getNome());
	}

	@Test
	public void testCoamndoPosaOggetto() {
		String istruzione = "posa osso";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoPosa", output.getNome());
		assertEquals("osso", output.getParametro());
	}
	
	@Test
	public void testCoamndoprendiNulla() {
		String istruzione = "prendi";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoPrendi", output.getNome());
	}
	
	
	@Test
	public void testCoamndoPrendiOggetto() {
		String istruzione = "prendi osso";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoPrendi", output.getNome());
		assertEquals("osso", output.getParametro());
	}
	
	@Test
	public void testCoamndoVaiNullo() {
		String istruzione = "vai";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoVai", output.getNome());
	}
	
	@Test
	public void testCoamndoVaiDirezione() {
		String istruzione = "vai sud";
		Comando output = factory.costruisciComando(istruzione);
		assertEquals("comandoVai", output.getNome());
		assertEquals("sud", output.getParametro());
	}
	
	@Test
	public void testComandoNonValido() {
		expected = new ComandoNonValido();
		assertEquals( expected.getNome(), factory.costruisciComando("pippo").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		expected = new ComandoVai();
		expected.setParametro("nord");
		Comando current = factory.costruisciComando("vai nord");
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		expected = new ComandoFine();
		assertEquals( expected.getNome(), factory.costruisciComando("fine").getNome());
	}
	
	
}



