package streetnetwork.lpsolve;

import java.io.Console;

public class Kreuzung
{
    public Zufahrt A;
    public Zufahrt B;
    public Zufahrt C;
    public Zufahrt D;

    public static int id = 1;

    private int kreuzungsid;

    public Kreuzung(double alinks, double arechts, double ageradeaus,
            double blinks, double brechts, double bgeradeaus,
            double clinks, double crechts, double cgeradeaus,
            double dlinks, double drechts, double dgeradeaus)
    {
        kreuzungsid = id++;

        A = new Zufahrt("A", kreuzungsid, alinks, arechts, ageradeaus);
        B = new Zufahrt("B", kreuzungsid, blinks, brechts, bgeradeaus);
        C = new Zufahrt("C", kreuzungsid, clinks, crechts, cgeradeaus);
        D = new Zufahrt("D", kreuzungsid, dlinks, drechts, dgeradeaus);
    }

    public String print()
    {
        return "// Kreuzung " + kreuzungsid + "\n"
                + "o" + kreuzungsid + "A = " + B.geradeaus + " i" + kreuzungsid + "B + " + C.links + " i" + kreuzungsid + "C + " + D.rechts + " i" + kreuzungsid + "D" + ";\n"
                + "o" + kreuzungsid + "B = " + A.geradeaus + " i" + kreuzungsid + "A + " + C.rechts + " i" + kreuzungsid + "C + " + D.links + " i" + kreuzungsid + "D" + ";\n"
                + "o" + kreuzungsid + "C = " + A.rechts + " i" + kreuzungsid + "A + " + B.links + " i" + kreuzungsid + "B + " + D.geradeaus + " i" + kreuzungsid + "D" + ";\n"
                + "o" + kreuzungsid + "D = " + A.links + " i" + kreuzungsid + "A + " + B.rechts + " i" + kreuzungsid + "B + " + C.geradeaus + " i" + kreuzungsid + "C" + ";\n";
    }
}
