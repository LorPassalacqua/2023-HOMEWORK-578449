
package it.uniroma3.attrezzi;

import it.uniroma3.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo>{

	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */

	@Override
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		Attrezzo that = (Attrezzo)o;
		return this.getNome().equals(that.getNome()) && this.getPeso() == that.getPeso();
	}

	
	@Override
	public int hashCode() {
		return nome.hashCode() + peso;
	}
	
	
	//TODO implementare la comparazione che va fatta prima tramite il peso poi con il nome else return differenza peso.
	// da cambiare facendogli 
	
	//@Override
	//public int compareTo(Attrezzo o) {
	//	if(this.getPeso() == o.getPeso())
	//		return this.getNome().compareTo(o.getNome());
	//	return this.getPeso() - o.getPeso();
	//}
	
	
	@Override
	public int compareTo(Attrezzo o) {
		if(this.getNome().equals(o.getNome())) {
			return this.getPeso() - o.getPeso();
		}
		return this.getNome().compareTo(o.getNome());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}