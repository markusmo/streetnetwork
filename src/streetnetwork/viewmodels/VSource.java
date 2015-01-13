package streetnetwork.viewmodels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@XmlRootElement(name="source")
@XmlAccessorType(XmlAccessType.FIELD)
public class VSource
{
    @XmlAttribute
    private double rate;

    public VSource(){};
    
    public VSource(double rate)
    {
        this.rate = rate;
    }
    
    public double getRate()
    {
        return rate;
    }

    public void setRate(double rate)
    {
        this.rate = rate;
    }

    @Override
    public String toString()
    {
        return "VSource{" + "rate=" + rate + '}';
    }
}
