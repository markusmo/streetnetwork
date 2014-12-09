package streetnetwork.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import streetnetwork.viewmodels.Junction;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class JunctionLabel extends JLabel implements MouseListener
{
    private Junction junction;
    private boolean active;
    private int number;
    private int row;
    private int column;
    
    public JunctionLabel(int number)
    {
        URL resource = this.getClass().getResource("images/junction_inactive.png");
        this.setIcon(new ImageIcon(resource));
        this.active = false;
        this.addMouseListener(this);
        this.number = number;
        this.setIconTextGap(-230);
        this.setText(""+number);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setBorder(LineBorder.createBlackLineBorder());
    }

    public Junction getJunction()
    {
        return junction;
    }

    public void setJunction(Junction junction)
    {
        this.junction = junction;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(!this.active)
        {
            URL resource = this.getClass().getResource("images/junction.png");
            this.setIcon(new ImageIcon(resource));
            this.repaint();
            this.revalidate();
            this.active = !this.active;
            
            JunctionSettingsDialog dialog = new JunctionSettingsDialog(null, true, number);
            dialog.setVisible(true);
        }
        else
        {
            URL resource = this.getClass().getResource("images/junction_inactive.png");
            this.setIcon(new ImageIcon(resource));
            this.repaint();
            this.revalidate();
            this.active = !this.active;
            this.junction.setDefault();
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
}
