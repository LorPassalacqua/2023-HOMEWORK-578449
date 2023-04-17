package it.uniroma3.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Io;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

	@Override
	public void esegui(Partita partita, Io io) {
		io.mostraMessaggio("Comando non valido!!");
	}
	
	@Override
	public void setParametro(String string) {
	}
	
	@Override
	public String getNome() {
		String comandoNonValido = "comandoNonValido";
		return comandoNonValido;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
}
