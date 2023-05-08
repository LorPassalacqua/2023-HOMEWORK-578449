package it.uniroma3.ambienti;

import java.util.HashMap;
import java.util.Map;
import it.uniroma3.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/


public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;

	
	private String nome;
	
	private Map<String,Attrezzo> attrezzi;
  
    
    private Map<String,Stanza> stanzeAdiacenti;
    
       
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        
        this.attrezzi = new HashMap<>();
        this.stanzeAdiacenti = new HashMap<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        if(stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI) {
        	this.stanzeAdiacenti.put(direzione, stanza);
        	
        }
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get(direzione);
	}
	
	
	public int getNumerosatnzeAdiacenti() {
		return this.stanzeAdiacenti.size();
	}
    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Map<String,Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }
    
    public Map<String,Stanza> getStanzeAdiacenti(){
    	return this.stanzeAdiacenti;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {	
        return this.attrezzi.put(attrezzo.getNome(),attrezzo) != null;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	
    	for (String direzione : this.stanzeAdiacenti.keySet()) {
    		risultato.append(" " + direzione);
    	}
    	
    	risultato.append("\nAttrezzi nella stanza: ");
    	
    	for (Attrezzo attrezzo : this.attrezzi.values()) {
    		risultato.append(attrezzo.toString()+", ");
    	}
    	
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return attrezzi.get(nomeAttrezzo);
		
	}


		
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al oggetto).
	 * @param oggetto
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo.getNome()) != null;
	}
	
	
	@Override
	public boolean equals (Object object) {
		
		Stanza that = (Stanza) object;
		
		if( that == null) return false;
		
		return this.getNome().equals(that.getNome()) &&
			   this.getAttrezzi().equals(that.getAttrezzi()) &&
			   this.getStanzeAdiacenti().equals(that.getStanzeAdiacenti());
	}
	
	
	@Override
	public int hashCode() {
		return nome.hashCode() + attrezzi.hashCode() + stanzeAdiacenti.hashCode();
	}
	
	
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	