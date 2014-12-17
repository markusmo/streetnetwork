package streetnetwork.solver;

public class Source {
	public Direction to;
	private double value;

	public Source(Direction to, double value) {
		this.to = to;
		this.value = value;
	}
        
        public String getName()
        {
            return "i" + to.intersection_id + to.direction;
        }
        
	public String print() {
		return this.getName()+ " = " + value + " c;";
	}
}
