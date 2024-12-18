package rng_Stuff;
import java.util.Random;
import java.util.Scanner;
public class RNG {

	public static int menu(Scanner sc) {
		int menu;
		System.out.println("1. Tem Armor");
		System.out.println("2. Other RNG");
		System.out.println("RNG choice:");
		menu=sc.nextInt();
		return menu;
	}
	
	public static void temArmor(Scanner sc, Random a) {
		System.out.println("Specify the hit count (Tem Armor DMG Heal RNG):");
		int times=sc.nextInt();
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
		int rng=a.nextInt(101);
		if (rng==0) {
			System.out.println("The roll landed on 0.");
			rng++;
		}
		System.out.println(rng);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random a= new Random();
		Scanner sc= new Scanner(System.in);
		int menu;
		do {
			switch (menu=menu(sc)) {
			
			case 1:
				temArmor(sc,a);
				break;
				
			case 2:
				otherRNG(a);
				break;
			}
		} while (menu!=1&&menu!=2);
		sc.close();
	}
}
