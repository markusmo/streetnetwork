package streetnetwork.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import streetnetwork.viewmodels.Junction;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class JunctionLabel extends JLabel
{
    private Junction junction;
    private boolean active;
    
    public JunctionLabel()
    {
        this.setIcon(new ImageIcon("streetnetwork/images/junction.png"));
    }

    public Junction getJunction()
    {
        return junction;
    }

    public void setJunction(Junction junction)
    {
        this.junction = junction;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    
}
