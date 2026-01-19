//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

	// Input da tastiera
	static Scanner input = new Scanner(System.in);

	// Inserisce il simbolo x oppure o nella grigla di gioco in riga i e colonna j.
	// Se la mossa non è valida (pedina già presente o le coordinate sono fuori la
	// g) allora ritorno falso.
	static boolean inserisciIng(String[][] G, int i, int j, String s) {
		i--;
		j--;

		if (i >= 0 && i < 3 && j >= 0 && j < 3) {
			if (G[i][j].equals("-")) {
				G[i][j] = s;
				return true;
			}
		}
		return false;
	}

	// Azzero la g di gioco inserendo la stringa "-" in tutte le celle.
	static void azzerag(String[][] G, int n, int m) {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				G[r][c] = "-";
			}
		}
	}

	// Controlla se nella g c'è una vincita.
	// s può valore "O" oppure "X"
	static boolean controllaVincita(String[][] G, String s) {

		if (
		// righe
		(G[0][0].equals(s) && G[0][1].equals(s) && G[0][2].equals(s)) ||
				(G[1][0].equals(s) && G[1][1].equals(s) && G[1][2].equals(s)) ||
				(G[2][0].equals(s) && G[2][1].equals(s) && G[2][2].equals(s)) ||

				// colonne
				(G[0][0].equals(s) && G[1][0].equals(s) && G[2][0].equals(s)) ||
				(G[0][1].equals(s) && G[1][1].equals(s) && G[2][1].equals(s)) ||
				(G[0][2].equals(s) && G[1][2].equals(s) && G[2][2].equals(s)) ||

				// diagonali
				(G[0][0].equals(s) && G[1][1].equals(s) && G[2][2].equals(s)) ||
				(G[0][2].equals(s) && G[1][1].equals(s) && G[2][0].equals(s))) {
			return true;
		}

		return false;
	}

	// Conta quante caselle libere ci sono ancora.
	// Se non ci sono caselle libere e non si è vinto allora è un pareggio
	static int contaCaselleLibere(Stringπ[][] G) {
		int count = 0;
		for (int i = 0; i <= 2; i = i + 1) {
			for (int j = 0; j <= 2; j = j + 1) {
				if (G[i][j].equals("-")) {
					count = count + 1;
				}
			}
		}
		return count;
	}

	public static void main(String args[]) {
		String[][] g = new String[3][3];
		azzerag(g, 3, 3);


		System.out.println("griglia di gioco:");
		UtilsMatrice.visualizza(g);
		String s = "X";
		boolean vincita = false;
		boolean pareggio = false;
		boolean mossaCorretta;
		do {
			int mossaI, mossaJ;
			do {
				System.out.println("Giocatore " + s + " inserisci la tua mossa:");
				mossaI = Integer.parseInt(input.nextLine());
				mossaJ = Integer.parseInt(input.nextLine());
				mossaCorretta = inserisciIng(g, mossaI, mossaJ, s);
			} while (!(mossaCorretta));

			System.out.println("griglia di gioco:");
			UtilsMatrice.visualizza(g);

			vincita = controllaVincita(g, s);
			if (vincita) {
				System.out.println(s + "ha vinto");
			}

			int caselleLibere = contaCaselleLibere(g);
			pareggio = !(vincita) && (caselleLibere == 0);
			if (pareggio) {
				System.out.println("Pareggio");
			}
			if (s.equals("X")) {
				s = "O";
			} else {
				s = "X";
			}

		} while (!(vincita) && !(pareggio));

	}
}

// LEGGERE LE ISTRUZIONI NEL FILE README.md