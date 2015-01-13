package streetnetwork.controller;

import java.util.List;
import streetnetwork.solver.Intersection;
import streetnetwork.solver.Source;
import streetnetwork.solver.Street;

/**
 *
 * @author mohi
 */
public class Triplet
{
     private Intersection[][] intersections;
     private List<Street> streets;
     private List<Source> sources;

    public Triplet(Intersection[][] intersections, List<Street> streets, List<Source> sources)
    {
        this.intersections = intersections;
        this.streets = streets;
        this.sources = sources;
    }

    public Intersection[][] getIntersections()
    {
        return intersections;
    }

    public List<Street> getStreets()
    {
        return streets;
    }

    public List<Source> getSources()
    {
        return sources;
    }
     
    
}
