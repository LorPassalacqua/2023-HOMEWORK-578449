package it.uniroma3.diadia;


//TODO implementare mostra oggetti in borsa.


import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.giocatore.Borsa;
import java.lang.StringBuilder;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IOConsole scanner) {
		String istruzione; 
		scanner.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = scanner.leggiRiga();
		while (!processaIstruzione(istruzione, scanner));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione,IOConsole scanner) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.sconosciuto()) {
			scanner.mostraMessaggio("Comando Sconosciuto");
			return false;
		}
		else if(comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro(), scanner);

		}
		else if(comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro(), scanner);			
		}

		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(scanner); 
			return true;
		}
		
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro(),scanner);
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto(scanner);
		
		else
			scanner.mostraMessaggio("Comando sconosciuto");
		
		if (this.partita.vinta()) {
			scanner.mostraMessaggio("Hai vinto!");
			return true;
		
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole scanner) {
			stringBuilder(scanner);
		System.out.println();
		}
	
	//implemantere stringbuilder per una stampa piu carina del comando aiuto
	
	public void stringBuilder(IOConsole scanner) {
		
		StringBuilder stringa = new StringBuilder();
		for(int i=0; i<elencoComandi.length;i++) {
			stringa.append(elencoComandi[i] + " ");
		}
		String output = stringa.toString();
		scanner.mostraMessaggio(output);
	}
	
	
	private void prendi(String nomeAttrezzo, IOConsole scanner) {
		
		//controlla spazio in borsa se ok prendilo
		//poi cancellalo dalla stanza
		
		if(nomeAttrezzo == null) {
			scanner.mostraMessaggio("--| Oggetto non valido!! |--");
		}
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)){
			Attrezzo attrezzoCercato = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			
			if(borsa.addAttrezzo(attrezzoCercato)) {
				stanzaCorrente.removeAttrezzo(attrezzoCercato);
				scanner.mostraMessaggio("--| Attrezzo preso! |--");
			}
			else scanner.mostraMessaggio("--| Non hai abbastanza spazio nella borsa!! |--|\n--|Posa qualcosa dalla borsa e riprova!! |--");
		}
		else scanner.mostraMessaggio("--| L'attrezzo selezionato non esiste!! |--\n--| Provane un altro!! |--");
		
	}
		
	
	
	
	private void posa(String nomeAttrezzo, IOConsole scanner) {
		
		//controlla se ce spazio nella stanza se ok
		//posalo e cacellalo dalla borsa
		
		if(nomeAttrezzo == null) {
			scanner.mostraMessaggio("--| Oggetto non valido |--\n");
		}
		
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		
		if(borsa.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoCercato = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			
			if(stanzaCorrente.addAttrezzo(attrezzoCercato)) {
				borsa.removeAttrezzo(attrezzoCercato);
			}
		}
	}
	
	

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione, IOConsole scanner) {
		if(direzione==null)
			scanner.mostraMessaggio("--| Direzione non valida |--");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			scanner.mostraMessaggio("--| Inserire un altra direzione |--");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCFU();
			this.partita.setCFU(cfu--);
		}
		scanner.mostraMessaggio("\n" + this.partita.getStanzaCorrente().getDescrizione() + "\n" );
	}

	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole scanner) {
		scanner.mostraMessaggio("-- | Grazie di aver giocato! |--");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IOConsole scanner = new IOConsole();		
		gioco.gioca(scanner);
	}
}