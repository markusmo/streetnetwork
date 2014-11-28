package streetnetwork.viewmodels;
/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class Source extends Street
{
    private double rate;

    public double getRate()
    {
        return rate;
    }

    public void setRate(double rate)
    {
        this.rate = rate;
    }
    
    @Override
    public void setFlow(double flow)
    {}

    @Override
    public double getFlow()
    {
        return -1.0f;
    }
}
