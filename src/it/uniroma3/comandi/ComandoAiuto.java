package it.uniroma3.comandi;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	private List<String> elencoComandi;
	private String intro;
	
	
	public ComandoAiuto() {
		elencoComandi = new LinkedList<>();
		elencoComandi.add("vai");
		elencoComandi.add("aiuto");
		elencoComandi.add("fine");
		elencoComandi.add("prendi");
		elencoComandi.add("posa");
		elencoComandi.add("guarda");
		intro = "--| Ecco i comandi disponibili |--";
	}
	
	
	@Override
	public void esegui(Partita partita, IO io) {
	
		StringBuilder stringa = new StringBuilder();
		for(String comando: elencoComandi) {
			stringa.append("<" + comando +"> " );
		}
		String output = stringa.toString();
		io.mostraMessaggio(intro);
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
	
	public List<String> getListaComandi(){
		return elencoComandi;
	}
	
	public String getIntro() {
		return this.intro;
	}
}
