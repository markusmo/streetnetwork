package streetnetwork.solver;

public class Street {
	public Direction from;
	public Direction to;
	public double max;

	public Street(Direction from, Direction to,  double max) {
		this.from = from;
		this.to = to;
		this.max = max;
	}

	public String print() {
		String s1 = "o" + from.intersection_id + from.direction + " = i" + to.intersection_id + to.direction;
		String s2 = "o" + from.intersection_id + from.direction + " < " + max + ";";
		return s1 + ";\n" + s2 + "\n";
	}
}
