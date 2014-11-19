package streetnetwork.lpsolve;

public class Strasse {
	public Zufahrt von;
	public Zufahrt nach;
	public int max;

	public Strasse(Zufahrt von, Zufahrt nach, int max) {
		this.von = von;
		this.nach = nach;
		this.max = max;
	}

	public String print() {
		String s1 = "o" + von.kreuzungsid + von.richtung + " = i"
				+ nach.kreuzungsid + nach.richtung;
		String s2 = "o" + von.kreuzungsid + von.richtung + " < " + max + ";";
		return s1 + ";\n" + s2 + "\n";
	}
}
