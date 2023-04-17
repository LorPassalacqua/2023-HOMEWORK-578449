package it.uniroma3.comandi;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Io;
import it.uniroma3.diadia.Partita;
import it.uniroma3.giocatore.Borsa;

public class ComandoPrendi implements Comando{

	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita, Io io) {
	
		if(nomeAttrezzo == null) {
			io.mostraMessaggio("--| Oggetto non Valido |--");
		}
		Borsa borsa = partita.getGiocatore().getBorsa();		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoCercato = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			
			if(borsa.addAttrezzo(attrezzoCercato)) {
				stanzaCorrente.removeAttrezzo(attrezzoCercato);
				io.mostraMessaggio("--| Attrezzo Preso dalla Stanza |--");
				io.mostraMessaggio("--| Ecco il contenuto della Borsa!! |--\n" + partita.getGiocatore().getBorsa().toString());
			}
			else io.mostraMessaggio("--| Non hai abbastanza spazio nella borsa!! |--|\\n--|Posa qualcosa dalla borsa e riprova!! |--");
		}
		else io.mostraMessaggio("--| L'attrezzo selezionato non esiste!! |--\n--| Provane un altro!! |--");
	}
	
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		String comandoPrendi = "comandoPrendi";
		return comandoPrendi;
	}
	
	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}
	
}
