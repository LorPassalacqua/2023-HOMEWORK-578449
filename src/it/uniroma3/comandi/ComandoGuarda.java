package it.uniroma3.comandi;


import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Io;
import it.uniroma3.diadia.Partita;



public class ComandoGuarda implements Comando{

		private String cosa;
		
		
	@Override
	public void esegui(Partita partita, Io io) {
		if(cosa == null) {
			io.mostraMessaggio("--| La Cosa o la Stanza selezionata non è visualizzabile!! |--");
		}
		else if(cosa.equals("borsa")) {
			io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
		else if(cosa.equals("stanza")) {
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
		else {
			io.mostraMessaggio("--| Oggetto o Stanza non Esistente!! |--");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.cosa = parametro;
	}
	
	@Override
	public String getNome() {
		String comandoGuarda = "comandoGuarda";
		return comandoGuarda;
	}
	
	@Override
	public String getParametro() {
		return cosa;
	}
	
}
