package streetnetwork.viewmodels;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class Street implements IStreetNetworkItem
{
    private double flow;
    private Junction origin;
    private Junction destination;

    public Junction getOrigin()
    {
        return origin;
    }

    public void setOrigin(Junction origin)
    {
        this.origin = origin;
    }

    public Junction getDestination()
    {
        return destination;
    }

    public void setDestination(Junction destination)
    {
        this.destination = destination;
    }

    public double getFlow()
    {
        return flow;
    }

    public void setFlow(double flow)
    {
        this.flow = flow;
    }
}
