package streetnetwork.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import streetnetwork.viewmodels.Source;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class StreetLabel extends JLabel
{
    public enum StreetType
    {
        vertical, horizontal
    };
    private Source source;
    private StreetType type;
    private boolean active;
    
    public StreetLabel(StreetType type)
    {
        this.type = type;
        String pathToImage = null;
        switch(this.type)
        {
            case vertical:
                pathToImage = "streetnetwork/images/street_vertical.png";
                break;
            case horizontal:
                pathToImage = "streetnetwork/images/street_horizontal.png";
                break;
        }
        this.setIcon(new ImageIcon(pathToImage));
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public boolean isSource()
    {
        return source != null;
    }
    
    public Source getSource()
    {
        if (this.isSource())
        {
            return this.source;
        }
        return null;
    }

    public StreetType getType()
    {
        return type;
    }
}
