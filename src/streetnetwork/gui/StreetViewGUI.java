/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streetnetwork.gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import streetnetwork.gui.popups.NewStreetNetworkDialog;
import streetnetwork.gui.popups.NewStreetNetworkObserver;
import streetnetwork.gui.popups.ShowLPDialog;

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
        this.scrollPane.setPreferredSize(this.getPreferredSize());
        this.dropPanel.setPreferredSize(this.scrollPane.getPreferredSize());
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
        dropPanel = new DropPanel();
        menuBar = new JMenuBar();
        jMenu1 = new JMenu();
        newStreetNetworkMenuItem = new JMenuItem();
        resetStreetNetworkMenuItem = new JMenuItem();
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
            .addGap(0, 447, Short.MAX_VALUE)
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

        solveLP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
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
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_showMenuItemActionPerformed
    {//GEN-HEADEREND:event_showMenuItemActionPerformed
        // TODO add your handling code here:
        String lp = "this is a lp";
        ShowLPDialog dialog = new ShowLPDialog(this, lp, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_showMenuItemActionPerformed

    private void solveLPActionPerformed(ActionEvent evt)//GEN-FIRST:event_solveLPActionPerformed
    {//GEN-HEADEREND:event_solveLPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_solveLPActionPerformed

    private void newStreetNetworkMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_newStreetNetworkMenuItemActionPerformed
    {//GEN-HEADEREND:event_newStreetNetworkMenuItemActionPerformed
       NewStreetNetworkDialog dialog = new NewStreetNetworkDialog(new javax.swing.JFrame(),this, true);
       dialog.setVisible(true);
           
    }//GEN-LAST:event_newStreetNetworkMenuItemActionPerformed

    private void resetStreetNetworkMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_resetStreetNetworkMenuItemActionPerformed
    {//GEN-HEADEREND:event_resetStreetNetworkMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetStreetNetworkMenuItemActionPerformed

    private void exitMenuItemActionPerformed(ActionEvent evt)//GEN-FIRST:event_exitMenuItemActionPerformed
    {//GEN-HEADEREND:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

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
    private DropPanel dropPanel;
    private JMenuItem exitMenuItem;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar menuBar;
    private JMenuItem newStreetNetworkMenuItem;
    private JMenuItem resetStreetNetworkMenuItem;
    private JScrollPane scrollPane;
    private JMenuItem showMenuItem;
    private JMenuItem solveLP;
    // End of variables declaration//GEN-END:variables

    @Override
    public void didEnterDimensions(int x, int y)
    {
        System.out.println("invoke");
    }
}
