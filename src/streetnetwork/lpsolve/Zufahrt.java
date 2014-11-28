package streetnetwork.lpsolve;

public class Zufahrt
{
    public String richtung;
    int kreuzungsid;

    public Zufahrt(String string, int kreuzungsid, double links, double rechts, double geradeaus)
    {
        richtung = string;
        this.kreuzungsid = kreuzungsid;

        this.links = links;
        this.rechts = rechts;
        this.geradeaus = geradeaus;
    }

    public double links = 0.25;
    public double rechts = 0.25;
    public double geradeaus = 0.5;
}
