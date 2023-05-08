package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.giocatore.Borsa;


//TODO controllare stampe



class MappeTest {
	
	Borsa borsa;
	Attrezzo Libro;
	Attrezzo Piombo;
	Attrezzo Piuma;
	Attrezzo ps;
	
	
	
	@BeforeEach
	public void setUp() {
		borsa = new Borsa();
		
		Libro = new Attrezzo("Libro",5);
		Piombo = new Attrezzo("Piombo",10);
		Piuma = new Attrezzo("Piuma",1);
		ps = new Attrezzo("Ps",5);

		borsa.addAttrezzo(Libro);
		borsa.addAttrezzo(Piombo);
		borsa.addAttrezzo(Piuma);
		borsa.addAttrezzo(ps);
	}
	
	
	// RESTITUICE LA MAPPA DELLA BORSA
	
	
	public void testMappa() {
		System.out.println(borsa);
		fail("Not yet implemented");
	}

	
	//	DEVE RESTITUIRE UN SET
	
	//	{ libro, piombo, piuma, ps }   NOME
	
	@Test
	void testSET() {
		System.out.println(borsa.getContenutoOrdinatoPerNome() + "	" + "SET   NOME");
		fail("Not yet implemented");
	}

	
	
	//	DEVE RESTITUIRE UNA LISTA DI ATTREZZI
	
	//	[ piuma, libro, ps, piombo ]  PESo
	
	@Test
	void testSortedLISTA() {
		System.out.println(borsa.getContenutoOrdinatoPerPeso() + "	LIST   PESO");
		
		fail("Not yet implemented");
	}
	
	
	
	//	DEVE RESTITUIRE UNA MAPPA
	
	//	(1, { piuma } ) ; (5, { libro, ps } ) ; (10, { piombo } )
	
	
	//TODO controllare collisione in mappa per stampa 
	
	@Test
	void testMap() {
		System.out.println(borsa.getContenutoRaggruppatoPerPeso() + "	MAPPA   RAGG");
		
		fail("Not yet implemented");
	}
	
	
	
	@Test
	void testSortedSet() {
		System.out.println(borsa.getSortedSetOrdinatoPerPeso() + "	Sorted   Peso");
		
		fail("Not yet implemented");
	}
	
	
	
	
	
	
	
}
