/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streetnetwork.gui;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import lpsolve.LpSolveException;
import streetnetwork.controller.LoadLPException;
import streetnetwork.controller.SaveLPException;
import streetnetwork.controller.StreetNetworkController;
import streetnetwork.viewmodels.VIntersection;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class StreetViewGUI extends javax.swing.JFrame implements NewStreetNetworkObserver
{
    /**
     * Creates new form StreetViewGUI
     */
    public StreetViewGUI()
    {
        initComponents();
        URL iconurlResource = this.getClass().getResource("images/icons/Arrow-Junction-icon.png");
        ImageIcon icon = new ImageIcon(iconurlResource);
        this.setIconImage(icon.getImage());
        this.scrollPane.setPreferredSize(this.getPreferredSize());
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        scrollPane = new JScrollPane();
        dropPanel = new StreetNetworkPanel();
        menuBar = new JMenuBar();
        jMenu1 = new JMenu();
        newStreetNetworkMenuItem = new JMenuItem();
        resetStreetNetworkMenuItem = new JMenuItem();
        saveStreetNetwork = new JMenuItem();
        loadLPMenuItem = new JMenuItem();
        exitMenuItem = new JMenuItem();
        jMenu2 = new JMenu();
        solveLP = new JMenuItem();
        showMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);

        GroupLayout dropPanelLayout = new GroupLayout(dropPanel);
        dropPanel.setLayout(dropPanelLayout);
        dropPanelLayout.setHorizontalGroup(dropPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        dropPanelLayout.setVerticalGroup(dropPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(dropPanel);

        jMenu1.setText("Street network");

        newStreetNetworkMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        newStreetNetworkMenuItem.setText("new street network");
        newStreetNetworkMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                newStreetNetworkMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(newStreetNetworkMenuItem);

        resetStreetNetworkMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        resetStreetNetworkMenuItem.setText("reset street network");
        resetStreetNetworkMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                resetStreetNetworkMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(resetStreetNetworkMenuItem);

        saveStreetNetwork.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        saveStreetNetwork.setText("save street network");
        saveStreetNetwork.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                saveStreetNetworkActionPerformed(evt);
            }
        });
        jMenu1.add(saveStreetNetwork);

        loadLPMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        loadLPMenuItem.setText("open street network");
        loadLPMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                loadLPMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadLPMenuItem);

        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        exitMenuItem.setText("exit");
        exitMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        menuBar.add(jMenu1);

        jMenu2.setText("Solver");

        solveLP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        solveLP.setText("solve LP");
        solveLP.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                solveLPActionPerformed(evt);
            }
        });
        jMenu2.add(solveLP);

        showMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
        showMenuItem.setText("show LP details");
        showMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                showMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(showMenuItem);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_showMenuItemActionPerformed
    {//GEN-HEADEREND:event_showMenuItemActionPerformed
        if (StreetNetworkController.getInstance().LPproblem != null)
        {
            ShowLPDialog dialog = new ShowLPDialog(this, StreetNetworkController.getInstance().LPproblem, true);
            dialog.setVisible(true);
        }        
    }//GEN-LAST:event_showMenuItemActionPerformed

    private void solveLPActionPerformed(ActionEvent evt)//GEN-FIRST:event_solveLPActionPerformed
    {//GEN-HEADEREND:event_solveLPActionPerformed
        try
        {
            String solution = StreetNetworkController.getInstance().solveLP();
            SolutionDialog sd = new SolutionDialog(this, true , solution);
            sd.setVisible(true);
        }
        catch (LpSolveException ex)
        {
            Logger.getLogger(StreetViewGUI.class.getName()).log(Level.SEVERE, null, ex);
            SolutionDialog sd = new SolutionDialog(this, true , ex.toString());
            sd.setVisible(true);
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(StreetViewGUI.class.getName()).log(Level.SEVERE, null, ex);
            SolutionDialog sd = new SolutionDialog(this, true , ex.toString());
            sd.setVisible(true);
        }
        catch (UnsupportedEncodingException ex)
        {
            Logger.getLogger(StreetViewGUI.class.getName()).log(Level.SEVERE, null, ex);
            SolutionDialog sd = new SolutionDialog(this, true , ex.toString());
            sd.setVisible(true);
        }
        catch (IOException ex)
        {
            Logger.getLogger(StreetViewGUI.class.getName()).log(Level.SEVERE, null, ex);
            SolutionDialog sd = new SolutionDialog(this, true , ex.toString());
            sd.setVisible(true);
        }
    }//GEN-LAST:event_solveLPActionPerformed

    private void newStreetNetworkMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_newStreetNetworkMenuItemActionPerformed
    {//GEN-HEADEREND:event_newStreetNetworkMenuItemActionPerformed
       NewStreetNetworkDialog dialog = new NewStreetNetworkDialog(new javax.swing.JFrame(),this, true);
       dialog.setVisible(true);
    }//GEN-LAST:event_newStreetNetworkMenuItemActionPerformed

    private void resetStreetNetworkMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_resetStreetNetworkMenuItemActionPerformed
    {//GEN-HEADEREND:event_resetStreetNetworkMenuItemActionPerformed
        resetGUI();
    }//GEN-LAST:event_resetStreetNetworkMenuItemActionPerformed

    private void resetGUI()
    {
        StreetNetworkController.getInstance().LPproblem = null;
        this.dropPanel.removeAll();
        this.repaint();
        this.revalidate();
    }

    private void exitMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_exitMenuItemActionPerformed
    {//GEN-HEADEREND:event_exitMenuItemActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void saveStreetNetworkActionPerformed(ActionEvent evt)//GEN-FIRST:event_saveStreetNetworkActionPerformed
    {//GEN-HEADEREND:event_saveStreetNetworkActionPerformed
        JFileChooser fch = new JFileChooser();
        int retval = fch.showSaveDialog(this);
        if(retval == JFileChooser.APPROVE_OPTION)
        {
            File selected = fch.getSelectedFile();
            try
            {
                StreetNetworkController.getInstance().saveLP(selected.getAbsolutePath());
            } catch (SaveLPException ex)
            {
                SolutionDialog dialog = new SolutionDialog(this, rootPaneCheckingEnabled, ex.getLocalizedMessage());
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_saveStreetNetworkActionPerformed

    private void loadLPMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_loadLPMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadLPMenuItemActionPerformed
        JFileChooser fch = new JFileChooser();
        int retval = fch.showOpenDialog(this);
        if(retval == JFileChooser.APPROVE_OPTION)
        {
            File selected = fch.getSelectedFile();
            try
            {
                StreetNetworkController.getInstance().loadLP(selected.getAbsolutePath());
            } catch (LoadLPException ex)
            {
                SolutionDialog dialog = new SolutionDialog(this, rootPaneCheckingEnabled, ex.getLocalizedMessage());
                dialog.setVisible(true);
            }
        }
        loadStreetNetwork();
    }//GEN-LAST:event_loadLPMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(StreetViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(StreetViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(StreetViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(StreetViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new StreetViewGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private StreetNetworkPanel dropPanel;
    private JMenuItem exitMenuItem;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuItem loadLPMenuItem;
    private JMenuBar menuBar;
    private JMenuItem newStreetNetworkMenuItem;
    private JMenuItem resetStreetNetworkMenuItem;
    private JMenuItem saveStreetNetwork;
    private JScrollPane scrollPane;
    private JMenuItem showMenuItem;
    private JMenuItem solveLP;
    // End of variables declaration//GEN-END:variables

    @Override
    public void didEnterDimensions(int rows, int columns)
    {
        StreetNetworkController.getInstance().initialize(rows, columns);
        paintStreetNetwork(rows, columns);
    }

    private void loadStreetNetwork()
    {
        this.resetGUI();
        this.paintStreetNetwork(StreetNetworkController.getInstance().getRows(), StreetNetworkController.getInstance().getColumns());
    }
    
    private void paintStreetNetwork(int rows, int columns)
    {
        this.dropPanel.setLayout(new GridBagLayout());
        this.scrollPane.add(this.dropPanel);
        this.scrollPane.setViewportView(this.dropPanel);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                gbc.gridx = column;
                gbc.gridy = row;
                VIntersection junction = StreetNetworkController.getInstance().getIntersection(row, column);
                IntersectionLabel intersectionLabel = new IntersectionLabel(junction.getId(), row, column);
                intersectionLabel.setIntersection(junction);
                intersectionLabel.switchImages();
                this.dropPanel.add(intersectionLabel,gbc);
            }
        }
        
        this.dropPanel.setVisible(true);
        this.repaint();
        this.revalidate();
    }
}
