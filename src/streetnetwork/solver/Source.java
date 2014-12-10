package streetnetwork.solver;

public class Source {
	public Direction to;
	private double value;

	public Source(Direction to, double value) {
		this.to = to;
		this.value = value;
	}

	public String print() {
		return "i" + to.intersection_id + to.direction + " = " + value + " c;";
	}
}
