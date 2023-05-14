package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.giocatore.Borsa;


class BorsaTest {
	
	Borsa borsa;
	Attrezzo Libro;
	Attrezzo Piombo;
	Attrezzo Piuma;
	Attrezzo ps;
	
	
	@BeforeEach
	public void setUp() {
		borsa = new Borsa();
		
		Libro = new Attrezzo("Libro",2);
		Piombo = new Attrezzo("Piombo",4);
		Piuma = new Attrezzo("Piuma",1);
		ps = new Attrezzo("Ps",2);

		borsa.addAttrezzo(Libro);
		borsa.addAttrezzo(Piombo);
		borsa.addAttrezzo(Piuma);
		borsa.addAttrezzo(ps);
	}
		

	
	//	DEVE RESTITUIRE UN SET
	
	//	{ libro, piombo, piuma, ps }   NOME
	
	@Test
	void testSetPerNome() {
		SortedSet<Attrezzo> borsa2 = new TreeSet<>();
		
		borsa2.add(Libro);
		borsa2.add(Piombo);
		borsa2.add(Piuma);
		borsa2.add(ps);		
		
		assertEquals(borsa2,borsa.getContenutoOrdinatoPerNome());
	}

	
	
	//	DEVE RESTITUIRE UNA LISTA DI ATTREZZI
	
	//	[ piuma, libro, ps, piombo ]  PESo
	
	@Test
	void testSortedListaPerPeso() {
		List<Attrezzo> ordinato = new LinkedList<>();
		
		ordinato.add(Piuma);
		ordinato.add(Libro);
		ordinato.add(ps);
		ordinato.add(Piombo);

		assertEquals(ordinato, borsa.getContenutoOrdinatoPerPeso());	
	}
	
	
	
	//	DEVE RESTITUIRE UNA MAPPA
	
	//	(1, { piuma } ) ; (5, { libro, ps } ) ; (10, { piombo } )
	
	
	//TODO controllare collisione in mappa per stampa 
	
	@Test
	void testMapPerPeso() {
		Map<Integer, Set<Attrezzo>> ordinato = new HashMap<>();
		
		Set<Attrezzo> set1 = new HashSet<>();
		set1.add(Piuma);
		ordinato.put(1, set1);
		
		Set<Attrezzo> set2 = new HashSet<>();
		set2.add(Libro);
		set2.add(ps);
		ordinato.put(2, set2);
		
		Set<Attrezzo> set3 = new HashSet<>();
		set3.add(Piombo);
		ordinato.put(4, set3);
		
		assertEquals(ordinato,borsa.getContenutoRaggruppatoPerPeso());
	}
	
	
	
	@Test
	void testSortedSetPerPeso() {
		SortedSet<Attrezzo> ordinato = new TreeSet<>();
		
		ordinato.add(Piuma);
		ordinato.add(Libro);
		ordinato.add(ps);
		ordinato.add(Piombo);
		
		assertEquals(ordinato,borsa.getSortedSetOrdinatoPerPeso());
	}
	
	
	//TODO chiedere al prof se va bene implementare come test delle collisioni che non vengono risolte
	
	
	
	
	
	
}
