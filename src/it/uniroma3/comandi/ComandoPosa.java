package it.uniroma3.comandi;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Io;
import it.uniroma3.diadia.Partita;
import it.uniroma3.giocatore.Borsa;

public class ComandoPosa implements Comando{


	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita, Io io) {
		if(nomeAttrezzo == null) {
			io.mostraMessaggio("--| Oggetto non valido |--\n");
		}
		
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		
		if(borsa.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoCercato = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			
			if(stanzaCorrente.addAttrezzo(attrezzoCercato)) {
				borsa.removeAttrezzo(attrezzoCercato);
				io.mostraMessaggio("--| L'Attrezzo selezionato rimosso con successo dalla Borsa |--");
				io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			}
			else {
				io.mostraMessaggio("--| Rimozione Fallita controlla che ci sia spazio nella stanza!! |--");
			}
		}
		else {
			io.mostraMessaggio("--| L'Oggetto selezionato non è nella Borsa |--");
		}
	
	}
	
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		String comandoPosa = "comandoPosa";
		return comandoPosa;
	}
	
	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}
	
	
}
