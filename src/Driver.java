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

		System.out.println("Hunting " + quarry.name + "! (" + quarry.health
				+ " Health)");
		while (currentBuildup < maxTolerance
				&& quarry.health / 2 > (statusInflictionCount * statusDamage)) {
			currentBuildup += statusPerHit;
			hits++;
			totalHitsEver++;
			if (currentBuildup > initialTolerance) {
				currentBuildup %= initialTolerance;
				initialTolerance += toleranceIncrease;
				statusInflictionCount++;
				System.out.print("Avg Hits for next proc: " + hits);
				System.out.println(" (Cumulative: " + totalHitsEver + ")");
				System.out.print("\tEffective DPH: " + (statusDamage / hits));
				System.out.print("\tTotal status Damage: "
						+ (statusInflictionCount * statusDamage));
				System.out.println("\t(Total Average DPH: " + statusDamage
						/ totalHitsEver + ")");
				hits = 0;
			}
		}
		if (quarry.health <= (statusInflictionCount * statusDamage)) {
			System.out.println("(Monster is definitely dead.)");
		}
	}
}
