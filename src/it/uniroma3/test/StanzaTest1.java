package it.uniroma3.test;

import it.uniroma3.ambienti.Stanza;

public class StanzaTest1 {

	public static void main(String[] args) {
		
		Stanza bar = new Stanza("Bar");
		Stanza mensa = new Stanza("mensa");
		
		mensa.impostaStanzaAdiacente("sud", bar);
		bar.impostaStanzaAdiacente("nord", mensa);
		
		System.out.println("dietro la porta Nord di bar c'è: "+mensa.getDescrizione());
		System.out.println("\ndietro la porta sud di bar c'è: "+bar.getDescrizione());		
		
		
	}
	
}
