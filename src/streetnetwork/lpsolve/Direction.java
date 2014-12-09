package streetnetwork.lpsolve;

public class Direction {
	public String direction;
	int intersection_id;

	public Direction(String direction, int intersection_id, double left, double rechts, double straight) {
		this.direction = direction;
		this.intersection_id = intersection_id;

		this.left = left;
		this.right = rechts;
		this.straight = straight;
	}

	public double left = 0.25;
	public double right = 0.25;
	public double straight = 0.5;
}
