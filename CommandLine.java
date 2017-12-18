import java.util.ArrayList;

public class CommandLine {
	public boolean syson;
	ContattoDao cd;
	String[] splitted;
	public CommandLine(String instr) {
		syson = true;  //variabile che controlla lo "spegimento del sistema"
		//Divido la striga di input in parole e le metto in un array
		String[] splitted = instr.split("\\s");
		ContattoDao cd = new ContattoDao();
		//Switch sulla prima parola inserita, i casi sono: new, delete, update, view
		switch (splitted[0]) {
		
		case "new":nuovo();
			break;
		case "update":
			
			;
			break;
		case "delete":
			;
			break;
		case "view":
			;
			break;
		default:
			System.out.print("Errore nella ricezione dei comandi");
			break;

		}

	}

	public static boolean isPhone(String num) {
		boolean result = true;
		try {
			Long x = Long.parseLong(num);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

private void nuovo() {
	String[] commands = new String[5];
	int x = 0;
	for(String str : splitted) {
		commands[x] = str;
		x++;
	}
	String nome = null;
	String cognome = null;
	String mail = null;
	String num = null;
	if (splitted.length == 1) {
		System.out.println("Si è verificato un errore, nessun parametro per il comando 'new'");
		
	}
	if (splitted.length == 2) {
		commands[2] = "null";
		commands[3] = "null";
		commands[4] = "null";
	}
	if (splitted.length == 3) {
		commands[3] = "null";
		commands[4] = "null";
	}
	if (splitted.length == 4) {
		commands[4] = "null";
	}

	
	nome = commands[1];
	if (commands[2].contains("@") || CommandLine.isPhone(commands[2])) {}
	else {
		cognome = commands[2];
		if (commands[3].contains("@")) {
			mail = commands[3];
			num = commands[4];
		} else {
			num = commands[3];
		}
	}
	if (commands[2].contains("@")) {
		mail = commands[2];
		num = commands[3];
	}
	if (CommandLine.isPhone(commands[2])) {
		num = commands[2];
	} 
	
	if(cognome == "null") {cognome = null;}
	if(mail == "null") {mail = null;}
	if(num == "null") {num = null;}
	cd.nuovo(nome, cognome, mail, num);
	}

private void aggiorna() {
	String[] commands = new String[6];
	int x = 0;
	for(String str : splitted) {
		commands[x] = str;
		x++;
	}
	String selector = null;
	String newnome = null;
	String newcognome = null;
	String newmail = null;
	String newnum = null;
	if (splitted.length == 1) {
		System.out.println("Errore, nessun selettore per il comando 'update'");
		
	}
	if (splitted.length == 2) {
		System.out.println("Errore, nessun parametro per il comando 'update'");
	}
	if (splitted.length == 3) {
		commands[3] = "null";
		commands[4] = "null";
		commands[5] = "null";
	}
	if (splitted.length == 4) {
		commands[4] = "null";
		commands[5] = "null";
	}
	if (splitted.length == 5) {
		commands[5] = "null";
	}
	}		
}