package it.uniroma3.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


public class ComandoFine implements Comando{
	
	@Override
	public void esegui(Partita partita, IO io) {
		partita.setFinita();
		io.mostraMessaggio("--| Grazie di aver Giocato!! |--");
	}
	
	
	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		String comandoFine = "comandoFine";
		return comandoFine;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
}
