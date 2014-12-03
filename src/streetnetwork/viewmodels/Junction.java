package streetnetwork.viewmodels;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class Junction implements IStreetNetworkItem
{
    private int id;
    //A
    private double probAB;
    private double probAC;
    private double probAD;
    //B
    private double probBA;
    private double probBC;
    private double probBD;
    //C
    private double probCA;
    private double probCB;
    private double probCD;
    //D
    private double probDA;
    private double probDB;
    private double probDC;
    
    private Source sourceNorth;
    private Source sourceSouth;
    private Source sourceWest;
    private Source sourceEast;

    public Junction(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return id;
    }
    
    public double getProbAB()
    {
        return probAB;
    }

    public void setProbAB(double probAB)
    {
        this.probAB = probAB;
    }

    public double getProbAC()
    {
        return probAC;
    }

    public void setProbAC(double probAC)
    {
        this.probAC = probAC;
    }

    public double getProbAD()
    {
        return probAD;
    }

    public void setProbAD(double probAD)
    {
        this.probAD = probAD;
    }

    public double getProbBA()
    {
        return probBA;
    }

    public void setProbBA(double probBA)
    {
        this.probBA = probBA;
    }

    public double getProbBC()
    {
        return probBC;
    }

    public void setProbBC(double probBC)
    {
        this.probBC = probBC;
    }

    public double getProbBD()
    {
        return probBD;
    }

    public void setProbBD(double probBD)
    {
        this.probBD = probBD;
    }

    public double getProbCA()
    {
        return probCA;
    }

    public void setProbCA(double probCA)
    {
        this.probCA = probCA;
    }

    public double getProbCB()
    {
        return probCB;
    }

    public void setProbCB(double probCB)
    {
        this.probCB = probCB;
    }

    public double getProbCD()
    {
        return probCD;
    }

    public void setProbCD(double probCD)
    {
        this.probCD = probCD;
    }

    public double getProbDA()
    {
        return probDA;
    }

    public void setProbDA(double probDA)
    {
        this.probDA = probDA;
    }

    public double getProbDB()
    {
        return probDB;
    }

    public void setProbDB(double probDB)
    {
        this.probDB = probDB;
    }

    public double getProbDC()
    {
        return probDC;
    }

    public void setProbDC(double probDC)
    {
        this.probDC = probDC;
    }

    public Source getSourceNorth()
    {
        return sourceNorth;
    }

    public void setSourceNorth(Source sourceNorth)
    {
        this.sourceNorth = sourceNorth;
    }

    public Source getSourceSouth()
    {
        return sourceSouth;
    }

    public void setSourceSouth(Source sourceSouth)
    {
        this.sourceSouth = sourceSouth;
    }

    public Source getSourceWest()
    {
        return sourceWest;
    }

    public void setSourceWest(Source sourceWest)
    {
        this.sourceWest = sourceWest;
    }

    public Source getSourceEast()
    {
        return sourceEast;
    }

    public void setSourceEast(Source sourceEast)
    {
        this.sourceEast = sourceEast;
    }
}
