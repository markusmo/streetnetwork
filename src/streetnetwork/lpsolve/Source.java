package streetnetwork.lpsolve;

public class Source {
	public Zufahrt nach;
	private int value;

	public Source(Zufahrt nach, int value) {
		this.nach = nach;
		this.value = value;
	}

	public String print() {
		return "i" + nach.kreuzungsid + nach.richtung + " = " + value + " c;";
	}

}
