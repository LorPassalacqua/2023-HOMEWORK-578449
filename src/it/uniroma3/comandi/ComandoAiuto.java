package it.uniroma3.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Io;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	
	@Override
	public void esegui(Partita partita, Io io) {
	
		StringBuilder stringa = new StringBuilder();
		for(int i=0; i<elencoComandi.length; i++) {
			stringa.append("<" + elencoComandi[i] +">  " );
		}
		String output = stringa.toString();
		io.mostraMessaggio("--| Ecco i comandi disponibili |--");
		io.mostraMessaggio(output);
	}
	
	
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getNome() {
		String comandoAiuto = "comandoAiuto";
		return comandoAiuto;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
}
