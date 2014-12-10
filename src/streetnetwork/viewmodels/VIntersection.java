package streetnetwork.viewmodels;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class VIntersection
{
    private int id;
    //A
    private double probAB;
    private double probAC;
    private double probAD;
    private int flowA;
    //B
    private double probBA;
    private double probBC;
    private double probBD;
    private int flowB;
    //C
    private double probCA;
    private double probCB;
    private double probCD;
    private int flowC;
    //D
    private double probDA;
    private double probDB;
    private double probDC;
    private int flowD;
    
    private VSource sourceNorth;
    private VSource sourceSouth;
    private VSource sourceWest;
    private VSource sourceEast;

    public VIntersection(int id)
    {
        this.id = id;
        this.setDefault();
    }
    
    public int getId()
    {
        return id;
    }

    public int getFlowA()
    {
        return flowA;
    }

    public void setFlowA(int flowA)
    {
        this.flowA = flowA;
    }

    public int getFlowB()
    {
        return flowB;
    }

    public void setFlowB(int flowB)
    {
        this.flowB = flowB;
    }

    public int getFlowC()
    {
        return flowC;
    }

    public void setFlowC(int flowC)
    {
        this.flowC = flowC;
    }

    public int getFlowD()
    {
        return flowD;
    }

    public void setFlowD(int flowD)
    {
        this.flowD = flowD;
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

    public VSource getSourceNorth()
    {
        return sourceNorth;
    }

    public void setSourceNorth(VSource sourceNorth)
    {
        this.sourceNorth = sourceNorth;
    }

    public VSource getSourceSouth()
    {
        return sourceSouth;
    }

    public void setSourceSouth(VSource sourceSouth)
    {
        this.sourceSouth = sourceSouth;
    }

    public VSource getSourceWest()
    {
        return sourceWest;
    }

    public void setSourceWest(VSource sourceWest)
    {
        this.sourceWest = sourceWest;
    }

    public VSource getSourceEast()
    {
        return sourceEast;
    }

    public void setSourceEast(VSource sourceEast)
    {
        this.sourceEast = sourceEast;
    }

    public void setDefault()
    {
        //default settings
        this.probAB = 0.5;
        this.probAC = 0.25;
        this.probAD = 0.25;
        this.flowA = 1;
        
        this.probBA = 0.25;
        this.probBC = 0.5;
        this.probBD = 0.25;
        this.flowB = 1;
        
        this.probCA = 0.25;
        this.probCB = 0.25;
        this.probCD = 0.5;
        this.flowC = 1;
        
        this.probDA = 0.25;
        this.probDB = 0.25;
        this.probDC = 0.5;
        this.flowD = 1;
    }
}
