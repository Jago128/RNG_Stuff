package rng_Stuff;
import java.util.Random;

import utilidades.Utilidades;

public class RNG {

	public static void main(String[] args) {
		Random a= new Random();
		int menu=menu();
		switch (menu) {
		case 1:
			temArmorDMGHealOrConchSlasherCritOrFrostedButlerDaggerFrostSnapRNG(a);
			break;

		case 2:
			otherRNG(a);
			break;

		case 3:
			characterRandom(a);
			break;

		case 4:
			conchDestroyerRNG(a);
			break;
		}
	}

	public static void temArmorDMGHealOrConchSlasherCritOrFrostedButlerDaggerFrostSnapRNG(Random a) {
		System.out.println("10% chance of Temmie Armor DMG Heal, 10% Crit Chance from Conch Slasher, or 10% chance of Frost Snap from the Frosted Butler's Daggers.");
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

		System.out.println("What's the number?");
		num=Utilidades.leerInt();
		System.out.println("How many times?");
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

	public static void characterRandom(Random a) {		
		int times;

		System.out.println("Muse choice depends on number. 1 for Starfish, 2 for Stara, 3 for Chara.");
		System.out.println("How many times?");
		times=Utilidades.leerInt();
		for (int i=0;i<times;i++) {
			int rng=a.nextInt(4);
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
		System.out.println("1. Tem Armor DMG Heal, Conch Slasher Crit, or Frosted Butler's Daggers Frost Snap RNG");
		System.out.println("2. Other RNG");
		System.out.println("3. Character Randomizer");
		System.out.println("4. Conch Destroyer Crit RNG");
		return Utilidades.leerInt("RNG choice:",1,4);
	}
}
