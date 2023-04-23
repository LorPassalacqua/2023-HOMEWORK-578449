package it.uniroma3.testStanze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;



public class stanzaTest {
		
	private Stanza stanza;
	private final  int MASSIMI_ATTREZZI = 10;
	
	

	@Before
	public void setUp() {
		this.stanza = new Stanza("Stanza");
		
		Attrezzo osso = new Attrezzo("osso", 10);
		this.stanza.addAttrezzo(osso);
	
	
	}
	
	
	//test per il hasAttrezzo
	
	@Test
	public void testHasAttrezzo() {
		assertTrue(this.stanza.hasAttrezzo("osso"));
		
	}

	@Test
	public void testHasAttrezzoFallito() {
		assertFalse(stanza.hasAttrezzo("sciabola"));
	}
	
	@Test
	public void testHasAttrezzoNull() {
		assertNull(stanza.getAttrezzo(null));	
	}
	
	
	
	//test per il getAttrezzo
	
	@Test
	public void testAddAttrezzo() {
		Attrezzo spada = new Attrezzo("spada",2);
		this.stanza.addAttrezzo(spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	public void testAddAtrezzoOverflow() {
		for(int i = 0; i< MASSIMI_ATTREZZI; i++) {
			Attrezzo Test = new Attrezzo("test", 1);
			stanza.addAttrezzo(Test);
		}
		Attrezzo diTroppo = new Attrezzo("diTroppo", 1);
		assertFalse(stanza.addAttrezzo(diTroppo));
	}
	
	@Test
	public void testAddAttrezzoMultipli() {
		Attrezzo test1 = new Attrezzo("test1", 1);
		Attrezzo test2 = new Attrezzo("test2", 1);
		stanza.addAttrezzo(test1);
		stanza.addAttrezzo(test2);
		assertTrue(stanza.addAttrezzo(test1) &&stanza.addAttrezzo(test2));
	}
	
	
	
	
	
	//test per il removeAttrezzo
	
	@Test
	public void testRemoveAttrezzo() {
		Attrezzo osso = new Attrezzo("osso", 2); 
		this.stanza.addAttrezzo(osso);
		assertTrue(this.stanza.removeAttrezzo(osso));
	}
	
	
	@Test
	public void testRemoveAttrezzoNonEsistente() {
		Attrezzo test = new Attrezzo("test",1);
		assertFalse(stanza.removeAttrezzo(test));
	}
	
	@Test
	public void testRemoveAttrezzoPiuDiUno() {
		Attrezzo test1 = new Attrezzo("test1", 1);
		Attrezzo test2 = new Attrezzo("test2", 1);
		stanza.addAttrezzo(test1);
		stanza.addAttrezzo(test2);
		assertTrue(stanza.removeAttrezzo(test1) && stanza.removeAttrezzo(test2));
	}
	
	
	
	
	//test per il getStanzaAdiacente
	
	@Test
	public void testGetStanzaAdiacente() {
		Stanza n11 = new Stanza("n11");
		stanza.impostaStanzaAdiacente("nord", n11);
		assertEquals(stanza.getStanzaAdiacente("nord").getNome(), n11.getNome());
	}

	@Test
	public void testGetStanzaAdiacenteNonEsistente() {
		assertNull(stanza.getStanzaAdiacente("sud-est"));
	}
	
	
	@Test
	public void testGetStanzaAdiacenteCambiata2Volte() {
		Stanza prima = new Stanza("prima");
		stanza.impostaStanzaAdiacente("sud", prima);
		Stanza seconda = new Stanza("seconda");
		stanza.impostaStanzaAdiacente("sud", seconda);
		assertEquals(seconda,stanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteSingola() {
		Stanza adiacente = new Stanza("adiacente");
		stanza.impostaStanzaAdiacente("sud", adiacente);
	assertEquals(adiacente, stanza.getStanzaAdiacente("sud"));
	}

	
	
	//	test per impostaStanzaAdiacente
	
	//	alcuni test sono identici sia per impostaStanzaAdiacente
	//	che per getDirezioni perciò inutile riscriverli 2 volte
	
	
	@Test
	public void testImpostaStanzaAdiacente() {
		Stanza n14 = new Stanza("n14");
		stanza.impostaStanzaAdiacente("ovest", n14);
		assertEquals(1,stanza.getNumerosatnzeAdiacenti());
	}
	
	
	
	
	//Test per il getDirezioni
	
	
	@Test
	public void testGetDirezioni() {
		Stanza atrio = new Stanza("atrio");
		stanza.impostaStanzaAdiacente("sud", atrio);
		String[] direzioni = new String[1];
		direzioni[0] = "sud";
		assertArrayEquals(direzioni, stanza.getDirezioni());
	}
	
	@Test
	public void testGetDirezioniMultiple() {
		Stanza atrio = new Stanza("atrio");
		Stanza n11 = new Stanza("n11");
		stanza.impostaStanzaAdiacente("sud", atrio);
		stanza.impostaStanzaAdiacente("nord", n11);
		String[] direzioni = new String[2];
		direzioni[0] = "sud";
		direzioni[1] = "nord";
		assertArrayEquals(direzioni, stanza.getDirezioni());
	}
	
	@Test
	public void testGetDirezioniMassime() {
		Stanza atrio = new Stanza("atrio");
		Stanza n11 = new Stanza("n11");
		Stanza n12 = new Stanza("n12");
		Stanza esterno = new Stanza("esterno");
		stanza.impostaStanzaAdiacente("sud", atrio);
		stanza.impostaStanzaAdiacente("nord", n11);
		stanza.impostaStanzaAdiacente("est", n12);
		stanza.impostaStanzaAdiacente("ovest", esterno);
		String[] direzioni = new String[4];
		direzioni[0] = "sud";
		direzioni[1] = "nord";
		direzioni[2] = "est";
		direzioni[3] = "ovest";
		assertArrayEquals(direzioni, stanza.getDirezioni());
	}
	
	
	
	
	
	
	
	
	
	
	
}
	
