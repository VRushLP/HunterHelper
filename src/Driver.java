
public class Driver {
	public static void main(String[] args) {

		int initialTolerance = 140;
		int toleranceIncrease = 75;
		int maxTolerance = 2015;
		int explosionDamage = 300;

		int blastPerHit = 12; // Listed Blast / 10 * Chance on hit (1/3)
		int hits = 0;
		int totalHitsEver = 0;

		int current = 0;

		int explosionCount = 0;

		while (current < maxTolerance) {
			current += blastPerHit;
			hits++;
			totalHitsEver++;
			if (current > initialTolerance) {
				current %= initialTolerance;
				initialTolerance += toleranceIncrease;
				explosionCount++;
				System.out.print(hits);
				System.out.print(" Average Damage: " + (explosionDamage / hits));
				System.out.print("\t| Total Damage: " + explosionCount * explosionDamage);
				System.out.println("\t(Total Average Damage: " + explosionDamage / totalHitsEver + ")");
				hits = 0;
			}
		}

	}
}
