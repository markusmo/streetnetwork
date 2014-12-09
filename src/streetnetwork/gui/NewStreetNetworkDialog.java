/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streetnetwork.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class NewStreetNetworkDialog extends javax.swing.JDialog
{
    private NewStreetNetworkObserver observer;
    /**
     * Creates new form NewStreetNetworkDialog
     * @param parent
     * @param observer
     * @param modal
     */
    public NewStreetNetworkDialog(java.awt.Frame parent, NewStreetNetworkObserver observer, boolean modal)
    {
        super(parent, modal);
        this.observer = observer;
        initComponents();
        this.setTitle("New street network dimensions");
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

        dimensionXTextField = new JTextField();
        X = new JLabel();
        dimensionYTextField = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        generateButton = new JButton();
        closeButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        X.setText("X");

        jLabel1.setLabelFor(dimensionXTextField);
        jLabel1.setText("Dimension x");
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);

        jLabel2.setLabelFor(dimensionYTextField);
        jLabel2.setText("Dimension y");

        jLabel3.setFont(new Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Enter the dimensions you want to have");

        generateButton.setText("generate");
        generateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                generateButtonActionPerformed(evt);
            }
        });

        closeButton.setText("close");
        closeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                closeButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(X, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(dimensionXTextField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dimensionYTextField, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(generateButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(closeButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dimensionXTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(X)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dimensionYTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(generateButton)
                    .addComponent(closeButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(ActionEvent evt)//GEN-FIRST:event_generateButtonActionPerformed
    {//GEN-HEADEREND:event_generateButtonActionPerformed
        int x = 0;
        int y = 0;
        try
        {
            x = Integer.parseInt(dimensionXTextField.getText().trim());
        }catch(NumberFormatException ex)
        {
            JOptionPane.showConfirmDialog(this, "Please enter a x value", "Missing value", JOptionPane.ERROR_MESSAGE);
        }
        try
        {
            y = Integer.parseInt(dimensionYTextField.getText().trim());
        }catch(NumberFormatException ex)
        {
            JOptionPane.showConfirmDialog(this, "Please enter a y value", "Missing value", JOptionPane.ERROR_MESSAGE);
        }
        if(x != 0 && y != 0)
        {
            this.observer.didEnterDimensions(x, y);
            this.dispose();
        }
    }//GEN-LAST:event_generateButtonActionPerformed

    private void closeButtonActionPerformed(ActionEvent evt)//GEN-FIRST:event_closeButtonActionPerformed
    {//GEN-HEADEREND:event_closeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel X;
    private JButton closeButton;
    private JTextField dimensionXTextField;
    private JTextField dimensionYTextField;
    private JButton generateButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
