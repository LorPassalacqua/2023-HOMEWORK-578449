package it.uniroma3.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


public class ComandoFine implements Comando{
	
	static final private String fine = "--| Grazie di aver Giocato!! |--";
	
	@Override
	public void esegui(Partita partita, IO io) {
		partita.setFinita();
		io.mostraMessaggio(fine);
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
	
	
	public static String getMessaggiofine() {
		return fine;
	}
	
	
}
