package streetnetwork.viewmodels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@XmlRootElement(name = "intersection")
@XmlAccessorType (XmlAccessType.FIELD)
public class VIntersection
{
    public VIntersection(){}
    
    private int id;
    private int x;
    private int y;
    //A
    private double probAB;
    private double probAC;
    private double probAD;
    private double flowA;
    //B
    private double probBA;
    private double probBC;
    private double probBD;
    private double flowB;
    //C
    private double probCA;
    private double probCB;
    private double probCD;
    private double flowC;
    //D
    private double probDA;
    private double probDB;
    private double probDC;
    private double flowD;
    
    private VSource sourceNorth;
    private VSource sourceSouth;
    private VSource sourceWest;
    private VSource sourceEast;

    private boolean active;

    public VIntersection(int id, int x, int y)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.setDefault();
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    
    public int getId()
    {
        return id;
    }

    public double getFlowA()
    {
        return flowA;
    }

    public void setFlowA(double flowA)
    {
        this.flowA = flowA;
    }

    public double getFlowB()
    {
        return flowB;
    }

    public void setFlowB(double flowB)
    {
        this.flowB = flowB;
    }

    public double getFlowC()
    {
        return flowC;
    }

    public void setFlowC(double flowC)
    {
        this.flowC = flowC;
    }

    public double getFlowD()
    {
        return flowD;
    }

    public void setFlowD(double flowD)
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
        this.flowA = 0.3;
        
        this.probBA = 0.25;
        this.probBC = 0.5;
        this.probBD = 0.25;
        this.flowB = 0.3;
        
        this.probCA = 0.25;
        this.probCB = 0.25;
        this.probCD = 0.5;
        this.flowC = 0.3;
        
        this.probDA = 0.25;
        this.probDB = 0.25;
        this.probDC = 0.5;
        this.flowD = 0.3;
    }

    @Override
    public String toString()
    {
        String retstr = "x=" + x
                + "y=" + y
                + "id=" + id
                + ", probAB=" + probAB 
                + ", probAC=" + probAC 
                + ", probAD=" + probAD 
                + ", flowA=" + flowA 
                + ", probBA=" + probBA 
                + ", probBC=" + probBC 
                + ", probBD=" + probBD 
                + ", flowB=" + flowB 
                + ", probCA=" + probCA 
                + ", probCB=" + probCB 
                + ", probCD=" + probCD 
                + ", flowC=" + flowC 
                + ", probDA=" + probDA 
                + ", probDB=" + probDB 
                + ", probDC=" + probDC 
                + ", flowD=" + flowD
                + ", active=" + active;
        if(sourceNorth != null)
                retstr += ", sourceNorth=" + sourceNorth.toString();
        if(sourceSouth != null)
                retstr += ", sourceSouth=" + sourceSouth.toString();
        if(sourceWest != null)
                retstr += ", sourceWest=" + sourceWest.toString();
        if(sourceEast != null)
                retstr += "sourceEast=" + sourceEast.toString();
        
        return retstr + "\n\r";
    }
}
