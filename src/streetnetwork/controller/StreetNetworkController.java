package streetnetwork.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import lpsolve.LpSolve;
import lpsolve.LpSolveException;
import streetnetwork.solver.Intersection;
import streetnetwork.solver.LpBuilder;
import streetnetwork.solver.Source;
import streetnetwork.solver.Street;
import streetnetwork.viewmodels.VIntersection;
import streetnetwork.viewmodels.VSource;
import streetnetwork.viewmodels.VSourceDirection;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class StreetNetworkController
{
    private static VIntersection[][] vintersections;
    private static int rows;
    private static int columns;
    private static StreetNetworkController INSTANCE;
    public static String LPproblem;

    public static StreetNetworkController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new StreetNetworkController();
            LPproblem = null;
        }
        return INSTANCE;
    }

    public static void initialize(int srows, int scolumns)
    {
        rows = srows;
        columns = scolumns;
        vintersections = new VIntersection[srows][scolumns];
        int number = 0;
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                vintersections[row][column] = new VIntersection(number++, row, column);
                vintersections[row][column].setDefault();
            }
        }
    }

    public Triplet generateLP()
    {
        Intersection[][] intersections = new Intersection[rows][columns];
        List<Street> streets = new ArrayList<Street>();
        List<Source> sources = new ArrayList<Source>();

        //init intersections
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                if (vintersections[row][column].isActive())
                {
                    intersections[row][column] = new Intersection(
                            vintersections[row][column].getProbAD(), vintersections[row][column].getProbAC(), vintersections[row][column].getProbAB(),
                            vintersections[row][column].getProbBC(), vintersections[row][column].getProbBD(), vintersections[row][column].getProbBA(),
                            vintersections[row][column].getProbCA(), vintersections[row][column].getProbCB(), vintersections[row][column].getProbCD(),
                            vintersections[row][column].getProbDB(), vintersections[row][column].getProbDA(), vintersections[row][column].getProbDC());
                    //add sources
                    if (vintersections[row][column].getSourceNorth() != null)
                    {
                        sources.add(new Source(intersections[row][column].A, vintersections[row][column].getSourceNorth().getRate()));
                    }
                    if (vintersections[row][column].getSourceEast() != null)
                    {
                        sources.add(new Source(intersections[row][column].C, vintersections[row][column].getSourceEast().getRate()));
                    }
                    if (vintersections[row][column].getSourceSouth() != null)
                    {
                        sources.add(new Source(intersections[row][column].B, vintersections[row][column].getSourceSouth().getRate()));
                    }
                    if (vintersections[row][column].getSourceWest() != null)
                    {
                        sources.add(new Source(intersections[row][column].D, vintersections[row][column].getSourceWest().getRate()));
                    }
                }
            }
        }

        //add bidirectional streets
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                if (vintersections[row][column].isActive())
                {
                    //check for neighbors
                    //only down and right
                    if (row == 0 && column == 0)
                    {

                        if (intersections[row + 1][column] != null
                                && intersections[row][column + 1] != null)
                        {
                            //down
                            streets.add(new Street(intersections[row][column].B, intersections[row + 1][column].A, vintersections[row][column].getFlowB()));
                            streets.add(new Street(intersections[row + 1][column].A, intersections[row][column].B, vintersections[row + 1][column].getFlowA()));
                            //right
                            streets.add(new Street(intersections[row][column].D, intersections[row][column + 1].C, vintersections[row][column].getFlowD()));
                            streets.add(new Street(intersections[row][column + 1].C, intersections[row][column].D, vintersections[row][column + 1].getFlowC()));

                        }
                    }
                    // only up and left
                    if (row == rows - 1 && column == columns - 1)
                    {
                        if (intersections[row - 1][column] != null
                                && intersections[row][column - 1] != null)
                        {
                            streets.add(new Street(intersections[row][column].A, intersections[row - 1][column].B, vintersections[row][column].getFlowA()));
                            streets.add(new Street(intersections[row - 1][column].B, intersections[row][column].A, vintersections[row - 1][column].getFlowB()));

                            streets.add(new Street(intersections[row][column].C, intersections[row][column - 1].D, vintersections[row][column].getFlowC()));
                            streets.add(new Street(intersections[row][column - 1].D, intersections[row][column].C, vintersections[row][column - 1].getFlowD()));
                        }
                    }
                    //all directions
                    if (row < rows - 1 && row > 0 && column < column - 1 && column > 0)
                    {
                        if (intersections[row + 1][column] != null
                                && intersections[row][column + 1] != null
                                && intersections[row - 1][column] != null
                                && intersections[row][column - 1] != null)
                        {
                            //down
                            streets.add(new Street(intersections[row][column].B, intersections[row + 1][column].A, vintersections[row][column].getFlowB()));
                            streets.add(new Street(intersections[row + 1][column].A, intersections[row][column].B, vintersections[row + 1][column].getFlowA()));
                            //right
                            streets.add(new Street(intersections[row][column].D, intersections[row][column + 1].C, vintersections[row][column].getFlowD()));
                            streets.add(new Street(intersections[row][column + 1].C, intersections[row][column].D, vintersections[row][column + 1].getFlowC()));
                            //up
                            streets.add(new Street(intersections[row][column].A, intersections[row - 1][column].B, vintersections[row][column].getFlowA()));
                            streets.add(new Street(intersections[row - 1][column].B, intersections[row][column].A, vintersections[row - 1][column].getFlowB()));
                            //left
                            streets.add(new Street(intersections[row][column].C, intersections[row][column - 1].D, vintersections[row][column].getFlowC()));
                            streets.add(new Street(intersections[row][column - 1].D, intersections[row][column].C, vintersections[row][column - 1].getFlowD()));
                        }
                    }
                }
            }
        }
        String lpString = new LpBuilder().createLp(rows, columns, intersections, streets, sources);
        LPproblem = lpString;
        
        return new Triplet(intersections, streets, sources);
        
    }
    
    public String solveLP() throws LpSolveException, FileNotFoundException, UnsupportedEncodingException, IOException
    {
        Triplet triplet = generateLP();
        String filename = "model.lp";
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.print(LPproblem);
        writer.close();

        StringBuilder builder = new StringBuilder();

        //Get operating system
        String OS = System.getProperty("os.name");
        
        if (OS.equals("Mac OS X"))
        {
            //builder.append(lpString);
            Runtime rt = Runtime.getRuntime();
            String path = StreetNetworkController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            //lp_solve installed with http://brew.sh/
            Process exec = rt.exec("/usr/local/bin/lp_solve " + "model.lp");
            InputStreamReader reader = new InputStreamReader(exec.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            while ((line = br.readLine()) != null)
            {
                if (line.contains("Value of objective function"))
                {
                    builder.append(line).append("\n\r");
                }
                else
                {
                    for (Source source : triplet.getSources())
                    {
                        if (line.contains(source.getName()))
                        {
                            builder.append(line).append("\n\r");
                        }
                    }
                }
            }
        }
        else if( OS.contains("nix") || OS.contains("nux") || OS.contains("aix"))
        {
            Runtime rt = Runtime.getRuntime();
            String path = StreetNetworkController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            //installed with "apt-get install lp-solve" on ubuntu
            Process exec = rt.exec("/usr/bin/lp_solve " + "model.lp");
            InputStreamReader reader = new InputStreamReader(exec.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            while ((line = br.readLine()) != null)
            {
                if (line.contains("Value of objective function"))
                {
                    builder.append(line).append("\n\r");
                }
                else
                {
                    for (Source source : triplet.getSources())
                    {
                        if (line.contains(source.getName()))
                        {
                            builder.append(line).append("\n\r");
                        }
                    }
                }
            }
        }
        //on windows
        else
        {
            LpSolve lpProblem = LpSolve.readLp(filename, LpSolve.NORMAL, "intersection model");
            lpProblem.setUseNames(true, true);
            lpProblem.solve();

            builder.append("Value of objective function ");
            builder.append(lpProblem.getObjective());
            builder.append("\n\n");
            double[] var = lpProblem.getPtrVariables();
            //get the Is where source is true
            for (Source source : triplet.getSources())
            {
                int index = lpProblem.getNameindex(source.getName(), false);
                builder.append("Value of ").append(source.getName());
                builder.append(" ");
                builder.append(var[index - 1]).append("\n\r");
            }
        }
        return builder.toString();
    }

    public void forAll(int row, int column)
    {
        for (int irow = 0; irow < rows; irow++)
        {
            for (int icolumn = 0; icolumn < columns; icolumn++)
            {
                addFlowA(irow, icolumn, vintersections[row][column].getFlowA());
                addFlowB(irow, icolumn, vintersections[row][column].getFlowB());
                addFlowC(irow, icolumn, vintersections[row][column].getFlowC());
                addFlowD(irow, icolumn, vintersections[row][column].getFlowD());

                //A
                addProbabilityAB(irow, icolumn, vintersections[row][column].getProbAB());
                addProbabilityAC(irow, icolumn, vintersections[row][column].getProbAB());
                addProbabilityAD(irow, icolumn, vintersections[row][column].getProbAB());

                //B
                addProbabilityBA(irow, icolumn, vintersections[row][column].getProbAB());
                addProbabilityBC(irow, icolumn, vintersections[row][column].getProbAB());
                addProbabilityBD(irow, icolumn, vintersections[row][column].getProbAB());

                //C
                addProbabilityCA(irow, icolumn, vintersections[row][column].getProbAB());
                addProbabilityCB(irow, icolumn, vintersections[row][column].getProbAB());
                addProbabilityCD(irow, icolumn, vintersections[row][column].getProbAB());

                //D
                addProbabilityDA(irow, icolumn, vintersections[row][column].getProbAB());
                addProbabilityDB(irow, icolumn, vintersections[row][column].getProbAB());
                addProbabilityDC(irow, icolumn, vintersections[row][column].getProbAB());

                if (vintersections[row][column].getSourceNorth() != null)
                {
                    addSource(irow, icolumn, VSourceDirection.North, vintersections[row][column].getSourceNorth().getRate());
                }

                if (vintersections[row][column].getSourceEast() != null)
                {
                    addSource(irow, icolumn, VSourceDirection.East, vintersections[row][column].getSourceEast().getRate());
                }

                if (vintersections[row][column].getSourceSouth() != null)
                {
                    addSource(irow, icolumn, VSourceDirection.South, vintersections[row][column].getSourceSouth().getRate());
                }

                if (vintersections[row][column].getSourceWest() != null)
                {
                    addSource(irow, icolumn, VSourceDirection.West, vintersections[row][column].getSourceWest().getRate());
                }
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

    public void addIntersection(int id, int row, int column)
    {
        vintersections[row][column] = new VIntersection(id, row, column);
    }
    
    //A
    public void addProbabilityAB(int row, int column, double prob)
    {
        vintersections[row][column].setProbAB(prob);
    }

    public void addProbabilityAC(int row, int column, double prob)
    {

        vintersections[row][column].setProbAC(prob);
    }

    public void addProbabilityAD(int row, int column, double prob)
    {
        vintersections[row][column].setProbAD(prob);
    }

    //B
    public void addProbabilityBA(int row, int column, double prob)
    {
        vintersections[row][column].setProbBA(prob);
    }

    public void addProbabilityBC(int row, int column, double prob)
    {
        vintersections[row][column].setProbBC(prob);
    }

    public void addProbabilityBD(int row, int column, double prob)
    {
        vintersections[row][column].setProbBD(prob);
    }

    //C
    public void addProbabilityCA(int row, int column, double prob)
    {
        vintersections[row][column].setProbCA(prob);
    }

    public void addProbabilityCB(int row, int column, double prob)
    {
        vintersections[row][column].setProbCB(prob);
    }

    public void addProbabilityCD(int row, int column, double prob)
    {
        vintersections[row][column].setProbCD(prob);
    }

    //D
    public void addProbabilityDA(int row, int column, double prob)
    {
        vintersections[row][column].setProbDA(prob);
    }

    public void addProbabilityDB(int row, int column, double prob)
    {
        vintersections[row][column].setProbDB(prob);
    }

    public void addProbabilityDC(int row, int column, double prob)
    {
        vintersections[row][column].setProbDC(prob);
    }

    public void addFlowA(int row, int column, double flow)
    {
        vintersections[row][column].setFlowA(flow);
    }

    public void addFlowB(int row, int column, double flow)
    {
        vintersections[row][column].setFlowB(flow);
    }

    public void addFlowC(int row, int column, double flow)
    {
        vintersections[row][column].setFlowC(flow);
    }

    public void addFlowD(int row, int column, double flow)
    {
        vintersections[row][column].setFlowD(flow);
    }

    public void addSource(int row, int column, VSourceDirection direction, double rate)
    {
        VIntersection junction = vintersections[row][column];
        switch (direction)
        {
            case North:
                junction.setSourceNorth(new VSource(rate));
                break;
            case East:
                junction.setSourceEast(new VSource(rate));
                break;
            case South:
                junction.setSourceSouth(new VSource(rate));
                break;
            case West:
                junction.setSourceWest(new VSource(rate));
                break;
        }
    }

    public VIntersection getIntersection(int row, int column)
    {
        return vintersections[row][column];
    }

    public void saveLP(String filepath) throws SaveLPException
    {
        try
        {
            Serializer.getInstance().writeToFile(filepath, vintersections, rows, columns);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(StreetNetworkController.class.getName()).log(Level.SEVERE, null, ex);
            throw new SaveLPException(ex);
        } catch (JAXBException ex)
        {
            Logger.getLogger(StreetNetworkController.class.getName()).log(Level.SEVERE, null, ex);
            throw new SaveLPException(ex);
        }
    }
    
    public void loadLP(String filepath) throws LoadLPException
    {
        try
        {
            vintersections = Serializer.getInstance().readFromFile(filepath);
            rows = vintersections.length;
            columns = vintersections[0].length;
            //generateLP(); 
        } catch (JAXBException ex)
        {
            Logger.getLogger(StreetNetworkController.class.getName()).log(Level.SEVERE, null, ex);
            throw new LoadLPException(ex);
        }
    }
}
