package it.uniroma3.giocatore;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.attrezzi.ComparatoreOggetti;
import it.uniroma3.diadia.IOConsole;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
		
	private Map<String, Attrezzo> attrezzi;
	private int pesoTotOggetti;
	
		
		
		
	public Borsa() {
		this.attrezzi = new HashMap<>();
		this.pesoTotOggetti = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {		
		if(pesoTotOggetti < DEFAULT_PESO_MAX_BORSA) {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			this.pesoTotOggetti += attrezzo.getPeso();
			return true;
		}
		return false;
	}
	
	
	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	public int getPeso() {
		int peso = 0;
		for(Attrezzo attrezzo: attrezzi.values()) {
			peso += attrezzo.getPeso();
		}
		return peso;
	}
	
	
	public boolean isEmpty() {
		return attrezzi.isEmpty();
	}
	
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null) {
			attrezzi.remove(attrezzo.getNome());
			return true;
		}
		return false;
	}
		
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			
			s.append("--| Contenuto borsa ("+this.getPeso()+"kg/"+DEFAULT_PESO_MAX_BORSA+"kg): ");
			for(Attrezzo attrezzo: attrezzi.values()) {
				s.append(attrezzo.toString()+", ");
			}			
		}
		
		else {
			s.append("--| Borsa vuota |--");
		}
			return s.toString();
	}
	
	
	//mostra gli ogggetti nella borsa
	
	public void mostraOgettiInBorsa( IOConsole scanner) {
		
		for(Attrezzo attrezzo: attrezzi.values()){
			scanner.mostraMessaggio(attrezzo.toString());
		}
	}
	
	// 	crea una lista di tipo linked passandogli i valori della mappa attrezzi
	//	utilizzo il metodo statico collections fa il sort passandogli la lista di output
	//	ed il criterio di ordinamento.
	//	nel caso non venga passato il criterio utilizza quello interno della classe attrezzi
	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> ordinato = new LinkedList<>(attrezzi.values());
		Collections.sort(ordinato,new ComparatoreOggetti());
		return ordinato;
	}
	
	
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> ordinato = new TreeSet<>(attrezzi.values());
		return ordinato;
	}
	
	
	// mappa di mappe che vengono raggruppate se il peso degli oggetti sono uguali.
	// non serve il comaratore perche non e ordinato
	
	
	//	creo la mappa di output 
	//	controllo con il for tutte le values peso nella mappa
	//	trasformo l'attrezzo in un set
	//	se non esiste una casella con quel peso la aggiungo
	//	e ci metto dentro l'oggetto con quel peso
	//	se esiste la aggiungo alla sezione gia esistente.
	
	
	// controllare collisione in mappa per stampa
	
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> map = new HashMap<>();
		
		for(Attrezzo attr : attrezzi.values()) {
			
			// La chiave (peso) è già presente nella HashMap, quindi si aggiunge l'oggetto al set di trabocco
			
			// se esiste gia un oggetto con quell peso prende il set esistente e gli aggiunge un nuovo attrezzo
			
			if(map.containsKey(attr.getPeso())) {
				Set<Attrezzo> setTrabocco = map.get(attr.getPeso());
				setTrabocco.add(attr);
			}
			
			// La chiave (peso) non è presente nella HashMap, quindi si crea un nuovo set con l'oggetto
			
			// se non esiste un set con quella chiave ne crea uno e lo aggiunge alla mappa.
			
			else {
				Set<Attrezzo> nuovoSet = new HashSet<>();
				nuovoSet.add(attr);
				map.put(attr.getPeso(), nuovoSet);
				
			}
			
		}
		return map;
	}
	
	
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> set = new TreeSet<>(new ComparatoreOggetti());
		set.addAll(attrezzi.values());
		return set;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
