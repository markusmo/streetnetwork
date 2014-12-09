package streetnetwork.controller;

import streetnetwork.viewmodels.Junction;
import streetnetwork.viewmodels.Source;
import streetnetwork.viewmodels.SourceDirection;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class StreetNetworkController 
{
    private static Junction[][] junctions;
    private static int rows;
    private static int columns;
    private static StreetNetworkController INSTANCE;
    
    public static StreetNetworkController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new StreetNetworkController();
        }
        return INSTANCE;
    }
    
    public static void initialize(int rows, int columns)
    {
        junctions = new Junction[rows][columns];
        int number = 0;
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                junctions[row][column] = new Junction(number++);
                junctions[row][column].setDefault();
            }
        }
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return columns;
    }
    
    public void addJunctions(int id, int row, int column)
    {
        junctions[row][column] = new Junction(id);
    }
    
    //A
    public void addProbabilityAB(int row, int column, double prob)
    {
        junctions[row][column].setProbAB(prob);
    }
    
    public void addProbabilityAC(int row, int column, double prob)
    {
        
        
        junctions[row][column].setProbAC(prob);
    }
    
    public void addProbabilityAD(int row, int column, double prob)
    {
        junctions[row][column].setProbAD(prob);
    }
    
    //B
    public void addProbabilityBA(int row, int column, double prob)
    {
        junctions[row][column].setProbBA(prob);
    }
    
    public void addProbabilityBC(int row, int column, double prob)
    {
        junctions[row][column].setProbBC(prob);
    }
    
    public void addProbabilityBD(int row, int column, double prob)
    {
        junctions[row][column].setProbBD(prob);
    }
    
    //C
    public void addProbabilityCA(int row, int column, double prob)
    {
        junctions[row][column].setProbCA(prob);
    }
    
    public void addProbabilityCB(int row, int column, double prob)
    {
        junctions[row][column].setProbCB(prob);
    }
    
    public void addProbabilityCD(int row, int column, double prob)
    {
        junctions[row][column].setProbCD(prob);
    }
    
    //D
    public void addProbabilityDA(int row, int column, double prob)
    {
        junctions[row][column].setProbDA(prob);
    }
    
    public void addProbabilityDB(int row, int column, double prob)
    {
        junctions[row][column].setProbDB(prob);
    }
    
    public void addProbabilityDC(int row, int column, double prob)
    {
        junctions[row][column].setProbDC(prob);
    }
    
    public void addFlowA(int row, int column, int flow)
    {
        junctions[row][column].setFlowA(flow);
    }
    
    public void addFlowB(int row, int column, int flow)
    {
        junctions[row][column].setFlowB(flow);
    }
    
    public void addFlowC(int row, int column, int flow)
    {
        junctions[row][column].setFlowC(flow);
    }
    
    public void addFlowD(int row, int column, int flow)
    {
        junctions[row][column].setFlowD(flow);
    }
    
    public void addSource(int row, int column, SourceDirection direction, double rate)
    {
        Junction junction = junctions[row][column];
        switch(direction)
        {
            case North:
                junction.setSourceNorth(new Source(rate));
                break;
            case East:
                junction.setSourceEast(new Source(rate));
                break;
            case South:
                junction.setSourceSouth(new Source(rate));
                break;
            case West:
                junction.setSourceWest(new Source(rate));
                break;
        }
    }
    
    public Junction getJunction(int row, int column)
    {
        return junctions[row][column];
    }
}
            
