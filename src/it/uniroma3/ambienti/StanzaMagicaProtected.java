package it.uniroma3.ambienti;

import it.uniroma3.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{

final static private int SOGLIA_MAGICA_DEFAULT = 3;
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	
	//in protected va aggiunto l'attrezzo a mano.
	
	
	//public boolean addAttrezzo2(Attrezzo attrezzo) {
		
	//	if(this.contatoreAttrezziPosati< this.sogliaMagica) {
	//		this.contatoreAttrezziPosati++;
	//	}
	//		attrezzo = modificaAttrezzo(attrezzo);
		
	//		if(this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
	//			this.attrezzi[numeroAttrezzi] = attrezzo;
	//			this.numeroAttrezzi++;
	//		}
	//		return false;
	//}
	
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
	
		if(this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			
			if(this.contatoreAttrezziPosati< this.sogliaMagica) {
				this.contatoreAttrezziPosati++;
			}
			else {
				attrezzo = modificaAttrezzo(attrezzo);
			}
			this.attrezzi[numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		
	
		return false;
	}
	
	

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		
		return attrezzo;
	}
	

	
}
