package streetnetwork.solver;

public class Intersection {
	public Direction A;
	public Direction B;
	public Direction C;
	public Direction D;

	public static int id = 1;

	private int intersectionId;

	public Intersection(double aLeft, double aRight, double aStraight, double bLeft, double bRight,
			double bStraight, double cLeft, double cRight, double cStraight, double dLeft, double dRight,
			double dStraight) {
		intersectionId = id++;

		A = new Direction("A", intersectionId, aLeft, aRight, aStraight);
		B = new Direction("B", intersectionId, bLeft, bRight, bStraight);
		C = new Direction("C", intersectionId, cLeft, cRight, cStraight);
		D = new Direction("D", intersectionId, dLeft, dRight, dStraight);
	}

	public String print() {
		return "// Intersection " + intersectionId + "\n" + "o" + intersectionId + "A = " + B.straight + " i" + intersectionId
				+ "B + " + C.left + " i" + intersectionId + "C + " + D.right + " i" + intersectionId + "D" + ";\n" + "o"
				+ intersectionId + "B = " + A.straight + " i" + intersectionId + "A + " + C.right + " i" + intersectionId
				+ "C + " + D.left + " i" + intersectionId + "D" + ";\n" + "o" + intersectionId + "C = " + A.right + " i"
				+ intersectionId + "A + " + B.left + " i" + intersectionId + "B + " + D.straight + " i" + intersectionId + "D"
				+ ";\n" + "o" + intersectionId + "D = " + A.left + " i" + intersectionId + "A + " + B.right + " i"
				+ intersectionId + "B + " + C.straight + " i" + intersectionId + "C" + ";\n";
	}
}
