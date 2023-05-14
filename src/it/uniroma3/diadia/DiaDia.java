package it.uniroma3.diadia;

//TODO implementare ioConsole



import it.uniroma3.comandi.FabbricaDiComandiFisarmonica;



import it.uniroma3.ambienti.Labirinto;

import it.uniroma3.ambienti.LabirintoBuilder;
import it.uniroma3.comandi.FabbricaDiComandi;

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

	private Partita partita;

	public DiaDia(Labirinto lab,IO io) {
		this.partita = new Partita(lab);
	}

	public void gioca(IO io) {
		String istruzione; 
		io.mostraMessaggio(getMessaggioBenvenuto());
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione,io));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */

	private boolean processaIstruzione(String istruzione,IO io) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
				comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita,io);
		if (this.partita.vinta())

			io.mostraMessaggio("--| Hai vinto! |--");
		if (!this.partita.giocatoreIsVivo())
			
			io.mostraMessaggio("--| Hai esaurito i CFU... |--");

		return this.partita.isFinita();
	}

	
	public static String getMessaggioBenvenuto() {
		return MESSAGGIO_BENVENUTO;
	}
	
	
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("atrio")
				.addStanzaVincente("uscita")
				.addStanza("corridoio")
				.addAttrezzo("chiave", 1)
				.addAttrezzo("lanterna", 1)
				.addStanzaBloccata("corridoio bloccato","nord","chiave")
				.addStanzaMagica("stanza magica", 1)
				.addStanzaMagica("stanza buia","lanterna")
				.addStanza("Aula 1")
				.addAdiacenza("atrio", "corridoio", "nord")
				.addAdiacenza("corridoio", "atrio", "sud")
				.addAdiacenza("corridoio", "corridoio bloccato", "nord")
				.addAdiacenza("corridoio bloccato", "corridoio", "sud")
				.addAdiacenza("corridoio bloccato", "Aula 1", "nord")
				.addAdiacenza("Aula 1", "corridoio bloccato", "sud")
				.addAdiacenza("Aula 1", "uscita","nord")
				.addAdiacenza("uscita", "Aula 1", "sud")
				.addAdiacenza("corridoio", "stanza magica", "est")
				.addAdiacenza("stanza magica", "corridoio", "ovest")
				.addAdiacenza("corridoio", "stanza buia", "ovest")
				.addAdiacenza("stanza buia", "corridoio", "est")
				.getLabirinto();
				
				
				
				
		DiaDia gioco = new DiaDia(labirinto, io);		
		gioco.gioca(io);
	}

	

}