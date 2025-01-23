package rng_Stuff;
import java.util.Random;

import utilidades.Utilidades;

public class RNG {

	public static void main(String[] args) {
		Random a= new Random();
		int menu=menu();

		switch (menu) {
		case 1:
			temArmor(a);
			break;

		case 2:
			otherRNG(a);
			break;

		case 3:
			conchSlasherRNG(a);
			break;

		case 4:
			conchDestroyerRNG(a);
			break;

		case 0:
			System.out.println("Program end.");
		}
	}

	public static void temArmor(Random a) {
		System.out.println("Temmie Armor Damage Heal. 10% of triggering");
		System.out.println("Specify the hit count:");
		int times=Utilidades.leerInt();
		for (int i=0;i<times;i++) {
			int rng=a.nextInt(11);
			if (rng==0) {
				System.out.println("RNG roll landed at 0.");
				rng++;
			}
			System.out.println(rng);
		}
	}

	public static void otherRNG(Random a) {
		int num, times;
		System.out.println("Number:");
		num=Utilidades.leerInt();
		System.out.println("Times:");
		times=Utilidades.leerInt();
		for (int i=0;i<times;i++) {
			int rng=a.nextInt(num+1);
			if (rng==0) {
				System.out.println("RNG roll landed at 0.");
				rng++;
			}
			System.out.println(rng);
		}
	}

	public static void conchSlasherRNG(Random a) {
		int times;
		System.out.println("Conch Slasher. 10% chance of critting.");
		System.out.println("Attack count:");
		times=Utilidades.leerInt();
		for (int i=0;i<times;i++) {
			int rng=a.nextInt(11);
			if (rng==0) {
				System.out.println("RNG roll landed at 0.");
				rng++;
			}
			System.out.println(rng);
		}
	}

	public static void conchDestroyerRNG(Random a) {
		int times;
		System.out.println("Conch Destroyer. 20% chance of critting.");
		System.out.println("Attack count:");
		times=Utilidades.leerInt();
		for (int i=0;i<times;i++) {
			int rng=a.nextInt(6);
			if (rng==0) {
				System.out.println("RNG roll landed at 0.");
				rng++;
			}
			System.out.println(rng);
		}
	}

	public static int menu() {
		System.out.println("1. Tem Armor");
		System.out.println("2. Other RNG");
		System.out.println("3. Conch Slasher Crit RNG");
		System.out.println("4. Conch Destroyer Crit RNG");
		return Utilidades.leerInt("RNG choice:",1,4);
	}
}
