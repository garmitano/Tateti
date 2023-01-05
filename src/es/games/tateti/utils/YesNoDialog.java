package es.games.tateti.utils;

import java.util.Scanner;

public class YesNoDialog {
	public Scanner sc = new Scanner(System.in);
	private String answer = "";
	private boolean error;
	
	      
	public boolean isAfirmative() {
		return answer.equalsIgnoreCase("si");
	}
	public boolean isNegative() {
		return answer.equalsIgnoreCase("no");
	}
	
	public boolean read() {
		do {
			System.out.println("Desea jugar otra vez?");
			this.answer = sc.nextLine(); 
			error = !this.isAfirmative() && !this.isNegative();
			if (error) {
				System.out.println("Debe completar con si o no");
			}
		} while (error);
		return error;
	}

}

