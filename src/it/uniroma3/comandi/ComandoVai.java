package it.uniroma3.comandi;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Io;
import it.uniroma3.diadia.Partita;

public class ComandoVai implements Comando{

	private String direzione;
	
	
	@Override
	public void esegui(Partita partita, Io io) {
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione == null) {
			io.mostraMessaggio("dove vuoi andare?");
			io.mostraMessaggio("Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
				return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCFU(partita.getGiocatore().getCFU()-1);
		
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	
	@Override
	public String getNome() {
		String comandoVai = "comandoVai";
		return comandoVai;
	}
	
	@Override
	public String getParametro() {
		return direzione;
	}
	
	
}
