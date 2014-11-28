package streetnetwork.controller;

import java.util.ArrayList;
import streetnetwork.viewmodels.Junction;
import streetnetwork.viewmodels.Street;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class StreetNetworkController 
{
    public Junction[][] generateJunctions(int row, int column)
    {
        Junction [][] junctions = new Junction[row][column];
        ArrayList<Street> streets = new ArrayList<Street>();
        
        int count = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                 junctions[i][j] = new Junction(count);
                 count++;
            }
        }
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                if(i == 0 && j == 0)
                {
                    streets.add(connectJunctions(junctions[i][j], junctions[i+1][j]));
                    streets.add(connectJunctions(junctions[i][j], junctions[i][j+1]));
                }
                
                if(i == 0 && j > 1)
                {
                    streets.add(connectJunctions(junctions[i][j], junctions[i+1][j]));
                    streets.add(connectJunctions(junctions[i][j], junctions[i][j+1]));
                    streets.add(connectJunctions(junctions[i][j], junctions[i][j-1]));
                }
                
                if(i > 1 && j == 0)
                {
                    streets.add(connectJunctions(junctions[i][j], junctions[i+1][j]));
                    streets.add(connectJunctions(junctions[i][j], junctions[i][j+1]));
                    streets.add(connectJunctions(junctions[i][j], junctions[i-1][j]));
                }
                
                if(i > 1 && j > 1)
                {
                    streets.add(connectJunctions(junctions[i][j], junctions[i+1][j]));
                    streets.add(connectJunctions(junctions[i][j], junctions[i][j+1]));
                    streets.add(connectJunctions(junctions[i][j], junctions[i-1][j]));
                    streets.add(connectJunctions(junctions[i][j], junctions[i][j-1]));
                }
            }
        }
        
        return junctions;
    }
    
    private Street connectJunctions(Junction origin, Junction destination)
    {
        Street street = new Street();
        street.setOrigin(origin);
        street.setDestination(destination);
        return street;
    }
}
