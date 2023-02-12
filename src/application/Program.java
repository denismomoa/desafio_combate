package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Champion;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Champion champion1;
		Champion champion2;
		
		System.out.println("Digite os dados do primeiro campeão: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Vida inicial: ");
		int life = sc.nextInt();
		System.out.print("Ataque: ");
		int attack = sc.nextInt();
		System.out.print("Armadura: ");
		int armor = sc.nextInt();
		
		champion1 = new Champion(name, life, attack, armor);
		
		System.out.println();
		System.out.println("Digite os dados do segundo campeão: ");
		System.out.print("Nome: ");
		sc.nextLine();
		String name2 = sc.nextLine();
		System.out.print("Vida inicial: ");
		int life2 = sc.nextInt();
		System.out.print("Ataque: ");
		int attack2 = sc.nextInt();
		System.out.print("Armadura: ");
		int armor2 = sc.nextInt();
		
		champion2 = new Champion(name2, life2, attack2, armor2);
		
		System.out.println();
		System.out.print("Quantos turnos deseja executar? ");
		int turn = sc.nextInt();
		System.out.println();
		
		for (int i = 0; i < turn; i++) {
			if (champion1.armor > champion2.attack) {
				int danoUm = 1;
				champion1.takeDamage(danoUm);
				champion2.takeDamage(champion1.attack);
			} 
			else if(champion2.armor > champion1.attack) {
				int danoUm = 1;
				champion1.takeDamage(champion2.attack);
				champion2.takeDamage(danoUm);
			}
			else {
				champion1.takeDamage(champion2.attack);
				champion2.takeDamage(champion1.attack);
			}
		
			System.out.printf("Resultado do turno " + (i + 1) + ": ");
			System.out.println();
			System.out.println(champion1.status());
			System.out.println(champion2.status());
			System.out.println();
			if (champion1.life == 0 || champion2.life == 0) {
				i = turn;
			}
		}
		
		System.out.println("FIM DO COMBATE");
		
		sc.close();
		
	}

}
