
public class Driver {

	static Monster quarry = Monster.KushalaDaora;

	public static void main(String[] args) {

		int initialTolerance = quarry.blastStats[Monster.INITIAL];
		int toleranceIncrease = quarry.blastStats[Monster.INCREASE];
		int maxTolerance = quarry.blastStats[Monster.MAX];
		int statusDamage = quarry.blastStats[Monster.DAMAGE];

		int statusPerHit = 8; // Listed (Blast or Poison) / 10 * Chance on hit
								// (1/3)
		int hits = 0;
		int totalHitsEver = 0;

		int currentBuildup = 0;
		int statusInflictionCount = 0;

		while (currentBuildup < maxTolerance && quarry.health > (statusInflictionCount * statusDamage)) {
			currentBuildup += statusPerHit;
			hits++;
			totalHitsEver++;
			if (currentBuildup > initialTolerance) {
				currentBuildup %= initialTolerance;
				initialTolerance += toleranceIncrease;
				statusInflictionCount++;
				System.out.print(hits);
				System.out.print(" Average Damage: " + (statusDamage / hits));
				System.out.print("\t| Total Damage: " + statusInflictionCount * statusDamage);
				System.out.println("\t(Total Average Damage: " + statusDamage / totalHitsEver + ")");
				hits = 0;
			}
		}
		if (quarry.health <= (statusInflictionCount * statusDamage)) {
			System.out.println("(Monster is definitely dead.)");
		}

	}
}
