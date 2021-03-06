/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;

import java.io.File;
import java.util.ArrayList;
import java.awt.Desktop;
import javax.swing.JOptionPane;


/**
 *
 * @author melaniehendricks
 */
public class network_GUI extends javax.swing.JFrame {

    /**
     * Creates new form network_GUI
     */
    public network_GUI() {
        actArray = new ArrayList<Activity>();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        manualEntry = new javax.swing.JLabel();
        activityLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        predecessorLabel = new javax.swing.JLabel();
        act1Text = new javax.swing.JTextField();
        dur1Text = new javax.swing.JTextField();
        pred1Text = new javax.swing.JTextField();
        add1Btn = new javax.swing.JButton();
        errorsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        errorTextArea = new javax.swing.JTextArea();
        processBtn = new javax.swing.JButton();
        restartBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        about = new javax.swing.JMenu();
        project = new javax.swing.JMenuItem();
        members = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        tips = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Network Analysis Program");

        manualEntry.setText("Manual Entry:");

        activityLabel.setText("Activity");

        durationLabel.setText("Duration");

        predecessorLabel.setText("Predecessor");

        add1Btn.setText("Add");
        add1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1BtnActionPerformed(evt);
            }
        });

        errorsLabel.setText("Errors:");

        errorTextArea.setColumns(20);
        errorTextArea.setRows(5);
        jScrollPane1.setViewportView(errorTextArea);

        processBtn.setText("Process");
        processBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processBtnActionPerformed(evt);
            }
        });

        restartBtn.setText("Restart");
        restartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartBtnActionPerformed(evt);
            }
        });

        file.setText("File");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        file.add(exit);

        jMenuBar1.add(file);

        about.setText("About");

        project.setText("Project");
        project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectActionPerformed(evt);
            }
        });
        about.add(project);

        members.setText("Team");
        members.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersActionPerformed(evt);
            }
        });
        about.add(members);

        jMenuBar1.add(about);

        help.setText("Help");

        tips.setText("Tips for User");
        tips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipsActionPerformed(evt);
            }
        });
        help.add(tips);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(activityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(act1Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(processBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dur1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(durationLabel)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pred1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(predecessorLabel))
                        .addGap(38, 38, 38)
                        .addComponent(add1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(errorsLabel)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(manualEntry)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(restartBtn)))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {act1Text, dur1Text, pred1Text});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(manualEntry)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activityLabel)
                    .addComponent(durationLabel)
                    .addComponent(predecessorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dur1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pred1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(act1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(processBtn)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorsLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(restartBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_exitActionPerformed

    private void add1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1BtnActionPerformed
        String activityName = act1Text.getText().trim();
    	String durationString = dur1Text.getText().trim();
    	String predecessors = pred1Text.getText().trim();
    	
    	int duration = Integer.parseInt(durationString);
    	if(duration < 0 || durationString.contains(".")){
    		errorTextArea.setText("Error 9: The duration was invalid. The activity was not created.");
    	}
    	else
    		actArray.add(new Activity(activityName, duration, predecessors));
    	act1Text.setText("");
    	dur1Text.setText("");
    	pred1Text.setText("");
        errorTextArea.setText("");
    }//GEN-LAST:event_add1BtnActionPerformed

    private void processBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processBtnActionPerformed
        Activity[] array = new Activity[actArray.size()];
        array = actArray.toArray(array);
    	NewGraph network = new NewGraph(array);

    	if(network.errorList[0] == 1)
    		errorTextArea.setText(errorTextArea.getText() + "\n" + "Error 3: A node is unconnected.");
    	if(network.errorList[1] == 1)
    		errorTextArea.setText(errorTextArea.getText() + "\n" + "Error 7: The network contains a loop.");
    	String allPaths = "";
        if(network.errorList[0] != 1 && network.errorList[1] != 1){
    		network.InsertionSort(network.paths);
    		allPaths = "";
    		for(int x = network.paths.size() - 1; x > -1; x--){
                        Activity[] arr = new Activity[network.paths.get(x).size()];
                        arr = network.paths.get(x).toArray(arr);
    			allPaths += network.printPath(arr);
    			allPaths += "\n";
    		}
            this.dispose();
            process_GUI second = new process_GUI(allPaths);
            second.setVisible(true);
        }
    }//GEN-LAST:event_processBtnActionPerformed

    private void restartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartBtnActionPerformed
        act1Text.setText("");
        dur1Text.setText("");
        pred1Text.setText("");
        errorTextArea.setText("");
        actArray = new ArrayList<Activity>();
    }//GEN-LAST:event_restartBtnActionPerformed

    private void tipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipsActionPerformed
        
        help_GUI tips = new help_GUI();
        tips.setVisible(true);
        
        
    }//GEN-LAST:event_tipsActionPerformed

    private void membersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersActionPerformed
        
        team_GUI team = new team_GUI();
        team.setVisible(true);
        
        
    }//GEN-LAST:event_membersActionPerformed

    private void projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectActionPerformed
        project_GUI project = new project_GUI();
        project.setVisible(true);
    }//GEN-LAST:event_projectActionPerformed


    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(network_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(network_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(network_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(network_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new network_GUI().setVisible(true);
            }
        });
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu about;
    private javax.swing.JTextField act1Text;
    private javax.swing.JLabel activityLabel;
    private javax.swing.JButton add1Btn;
    private javax.swing.JTextField dur1Text;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextArea errorTextArea;
    private javax.swing.JLabel errorsLabel;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu file;
    private javax.swing.JMenu help;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manualEntry;
    private javax.swing.JMenuItem members;
    private javax.swing.JTextField pred1Text;
    private javax.swing.JLabel predecessorLabel;
    private javax.swing.JButton processBtn;
    private javax.swing.JMenuItem project;
    private javax.swing.JButton restartBtn;
    private javax.swing.JMenuItem tips;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Activity> actArray;
}
