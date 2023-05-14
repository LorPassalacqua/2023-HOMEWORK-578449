package it.uniroma3.ambienti;



import it.uniroma3.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{

	final static private int SOGLIA_MAGICA_DEFAULT = 1;
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
		
	}

	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		
		return attrezzo;
	}

	
	public Boolean isMagica() {
		if(sogliaMagica >= 1) return true;
		return false;
	}
	

}
