package it.uniroma3.diadia;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.Stanza;
import it.uniroma3.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
	private boolean finita;
	
	
	private Labirinto lab;		
	private Giocatore giocatore;
	private Stanza stanzaCorrente;
	
	public Partita(Labirinto labirinto){
		this.lab = labirinto;
		stanzaCorrente = this.lab.getStanzaIniziale();
		giocatore = new Giocatore();
		this.finita = false;
		
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente == this.lab.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCFU() == 0); 
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Labirinto getLabirinto(){
		return this.lab;
	}
	
	public int getCFU() {
		return this.giocatore.getCFU();
	}
	
	public void setCFU(int cfu) {
		this.giocatore.setCFU(cfu);
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	public void setStanzaCorrente(Stanza nuovaStanza) {
		this.stanzaCorrente = nuovaStanza;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCFU()>0) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
}






















