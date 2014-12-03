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
    
    public static void initialize(int srows, int scolumns)
    {
        junctions = new Junction[srows][scolumns];
        rows = srows;
        columns = scolumns;
    }
    
    public void addJunctions(int number)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column] = new Junction(number);
    }
    
    //A
    public void addProbabilityAB(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbAB(prob);
    }
    
    public void addProbabilityAC(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbAC(prob);
    }
    
    public void addProbabilityAD(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbAD(prob);
    }
    
    //B
    public void addProbabilityBA(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbBA(prob);
    }
    
    public void addProbabilityBC(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbBC(prob);
    }
    
    public void addProbabilityBD(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbBD(prob);
    }
    
    //C
    public void addProbabilityCA(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbCA(prob);
    }
    
    public void addProbabilityCB(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbCB(prob);
    }
    
    public void addProbabilityCD(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbCD(prob);
    }
    
    //D
    public void addProbabilityDA(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbDA(prob);
    }
    
    public void addProbabilityDB(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbDB(prob);
    }
    
    public void addProbabilityDC(int number, double prob)
    {
        int row = number / rows;
        int column = number % columns;
        junctions[row][column].setProbDC(prob);
    }
    
    public void addSource(int number, SourceDirection direction, double rate)
    {
        int row = number / rows;
        int column = number % columns;
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
}
            
