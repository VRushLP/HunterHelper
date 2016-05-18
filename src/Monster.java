import java.util.Arrays;

public class Monster {

	public static final int INITIAL = 0;
	public static final int INCREASE = 1;
	public static final int MAX = 2;
	public static final int DAMAGE = 3;

	public String name;
	public int health;
	public int[] poisonStats;
	public int[] blastStats;

	public static Monster KushalaDaora = new Monster("Kushala Daora", 4200, new int[] { 150, 50, 350, 240 },
			new int[] { 55, 45, 1090, 200 });

	private Monster(String name, int health, int[] poison, int[] blast) {
		this.name = name;
		this.health = health;
		poisonStats = Arrays.copyOf(poison, poison.length);
		blastStats = Arrays.copyOf(blast, blast.length);
	}

	// TODO for later
	public enum Poison {
		initial, increase, max, damage
	}

	public enum Blast {
		initial, increase, max, damage
	}
}
