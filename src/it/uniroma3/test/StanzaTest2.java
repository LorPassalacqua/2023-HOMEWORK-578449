package it.uniroma3.test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;

public class StanzaTest2 {

	public static void main(String[] args) {
		
		Stanza Bar = new Stanza("bar");
		Stanza Mensa = new Stanza("mensa");
		
		Attrezzo tazzina = new Attrezzo("tazzina",1);
		Attrezzo piatto = new Attrezzo("piatto",2);
		
		Bar.addAttrezzo(tazzina);
		Mensa.addAttrezzo(piatto);
		
		Bar.impostaStanzaAdiacente("nord", Mensa);
		Mensa.impostaStanzaAdiacente("sud", Mensa);
		
		System.out.println("dietro la porta Nord del Bar c'è: " + Mensa.getDescrizione());
		System.out.println("dietro la porta Sud della Mensa c'è: " + Bar.getDescrizione());

		
		
		
		
		
		
		
		
	}
	
}
