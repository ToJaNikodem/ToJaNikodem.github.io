import java.util.Scanner;

class Critter {
	String name;
	int hunger;
	float boredom;

	private void pass_time() {
		this.hunger += 1;
		this.boredom += 1;
	}

	public String mood() {
		float unhappiness = this.boredom + this.hunger;
		if (unhappiness < 5)
			return "szczęśliwy";
		else if (unhappiness <= 10)
			return "zadowolony";
		else if (unhappiness <= 15)
			return "poddenerwowany";
		else
			return "wściekły";
	}

	public void talk() {
		System.out.println("Nazywam się: " + this.name + " i jestem " + this.mood() + " teraz");
		this.pass_time();
	}

	public void eat() {
		System.out.println("Podaj ile jedzenia chesz dać zwierzakowi (1-3): !");
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		if (temp >= 1 && temp <= 3) {
			System.out.println("Mniam, mniam. Pyszne!");
			this.hunger -= 4 * temp;
			if (this.hunger < 0)
				this.hunger = 0;
			this.pass_time();
		}
	}

	public void play() {
		System.out.println("Podaj ile minut chesz się bawić ze zwierzakiem (10-30): !");
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		if (temp >= 10 && temp <= 30) {
			System.out.println("Zabawa? Hurrrrrra!!!");
			this.boredom -= 4 * (temp / 10);
			if (this.boredom < 0)
				this.boredom = 0;
			this.pass_time();
		}
	}

	public Critter(String wname) {
		this.name = wname;
		this.boredom = 0;
		this.hunger = 0;
	}
}

class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Jakie imię nadasz zwierzakowi? ");
		String imie = scan.nextLine();
		Critter crit = new Critter(imie);
		
		crit.talk();
		
		int choice = 4;
		while (choice != 0) {
			System.out.println("Opiekun zwierzaka v.0.1");
			System.out.println("\t0 - zakończ działanie");
			System.out.println("\t1 - słuchaj zwierzaka");
			System.out.println("\t2 - nakarm zwierzaka");
			System.out.println("\t3 - pobaw się z nim");
			
			choice = scan.nextInt();
			System.out.println("Wybrałeś: " + choice);
			if (choice == 0)
			System.out.println("Do widzenia!");
			if (choice == 1)
			crit.talk();
			if (choice == 2)
			crit.eat();
			if (choice == 3)
			crit.play();
		}
	}
}