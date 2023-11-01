/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Pr NOUBISSIE Samuel
 */
public class Question extends javax.swing.JFrame {

    public String questionId="1";
    public String answer;
    public int min = 0;
    public int sec = 0;
    public int marks=0;
    
    public void answerCheck() {
        String repo="";
        if(jrep1.isSelected()) {
            repo=jrep1.getText();
        } else if (jrep2.isSelected()) {
            repo=jrep2.getText();
        } else if (jrep3.isSelected()) {
            repo=jrep3.getText();
        } else if (jrep4.isSelected()) {
            repo=jrep4.getText();
        }
        
        if(repo.equals(answer)) {
            marks =marks+1;
            String marks1=String.valueOf(marks);
            jscore.setText(marks1);
        }
        
        int questionId1=Integer.parseInt(questionId);
        questionId1=questionId1+1;
        questionId=String.valueOf(questionId1);
        
        jrep1.setSelected(false);
        jrep2.setSelected(false);
        jrep3.setSelected(false);
        jrep4.setSelected(false);

    }
    
    public void question() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            Statement st = con.createStatement();
            
            ResultSet rsl = st.executeQuery("select * from question where numQuestion='"+questionId+"'");
            while (rsl.next()) {
                numquest.setText(rsl.getString("numQuestion"));
                jtheme.setText(rsl.getString("theme"));
                jquestion.setText(rsl.getString("libelle"));
                jrep1.setText(rsl.getString("rep1"));
                jrep2.setText(rsl.getString("rep2"));
                jrep3.setText(rsl.getString("rep3"));
                jrep4.setText(rsl.getString("rep4"));
                answer = rsl.getString("reponse");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void submit() {
        String numero = jid.getText();
        answerCheck();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update joueur set score='"+marks+"' where id='"+numero+"'");
            String marks1=String.valueOf(marks);
            JOptionPane.showMessageDialog(null, "Votre score: "+marks1+" points");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    /**
     * Creates new form Question
     */
    public Question() {
        initComponents();
    }

    Timer time;
    public Question(int id, String th) {
        initComponents();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from joueur where id='"+id+"'");
            
            while (rs.next()) {
                jid.setText(rs.getString("id"));
            }
            ResultSet rsl = st.executeQuery("select * from question where numQuestion='"+questionId+"'");
            while (rsl.next()) {
                numquest.setText(rsl.getString("numQuestion"));
                jtheme.setText(rsl.getString("theme"));
                jquestion.setText(rsl.getString("libelle"));
                jrep1.setText(rsl.getString("rep1"));
                jrep2.setText(rsl.getString("rep2"));
                jrep3.setText(rsl.getString("rep3"));
                jrep4.setText(rsl.getString("rep4"));
                answer = rsl.getString("reponse");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        setLocationRelativeTo(this);
        time = new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtime2.setText(String.valueOf(sec));
                jtime1.setText(String.valueOf(min));
                
                if(sec==15) {
                    sec=0;
                   answerCheck();
                   question();
                  //  min++;
//                    if(min==5){
//                        time.stop();
//                        answerCheck();
//                        submit();
//                    }
                }
                sec++;
            }
        });
        time.start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jquestion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jrep1 = new javax.swing.JRadioButton();
        jrep2 = new javax.swing.JRadioButton();
        jrep3 = new javax.swing.JRadioButton();
        jrep4 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jtheme = new javax.swing.JLabel();
        jscore = new javax.swing.JLabel();
        numquest = new javax.swing.JLabel();
        jid = new javax.swing.JLabel();
        jtime1 = new javax.swing.JLabel();
        jtime2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 51), null, null));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_signal_60px.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 0, 51), null, null));

        jquestion.setBackground(new java.awt.Color(0, 204, 153));
        jquestion.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jquestion.setForeground(new java.awt.Color(0, 0, 0));
        jquestion.setText("Question?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jquestion, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), null));

        jrep1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jrep1.setForeground(new java.awt.Color(255, 255, 102));
        jrep1.setText("jRadioButton1");
        jrep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrep1ActionPerformed(evt);
            }
        });

        jrep2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jrep2.setForeground(new java.awt.Color(255, 255, 102));
        jrep2.setText("jRadioButton2");
        jrep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrep2ActionPerformed(evt);
            }
        });

        jrep3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jrep3.setForeground(new java.awt.Color(255, 255, 102));
        jrep3.setText("jRadioButton3");
        jrep3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrep3ActionPerformed(evt);
            }
        });

        jrep4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jrep4.setForeground(new java.awt.Color(255, 255, 102));
        jrep4.setText("jRadioButton4");
        jrep4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrep4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrep1)
                    .addComponent(jrep3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrep2)
                    .addComponent(jrep4))
                .addGap(114, 114, 114))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrep1)
                    .addComponent(jrep2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrep3)
                    .addComponent(jrep4))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton3.setText("Suivant");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton4.setText("Soumettre");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_bang_50px_1.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_question_mark_127px_3.png"))); // NOI18N

        jButton10.setBackground(new java.awt.Color(255, 204, 0));
        jButton10.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_exit_sign_50px.png"))); // NOI18N
        jButton10.setText("ABANDONNER");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jtheme.setBackground(new java.awt.Color(0, 51, 102));
        jtheme.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jtheme.setForeground(new java.awt.Color(255, 255, 102));
        jtheme.setText("Theme");

        jscore.setBackground(new java.awt.Color(0, 51, 102));
        jscore.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 0, 24)); // NOI18N
        jscore.setForeground(new java.awt.Color(255, 255, 255));
        jscore.setText("00");

        numquest.setBackground(new java.awt.Color(0, 51, 102));
        numquest.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 0, 24)); // NOI18N
        numquest.setForeground(new java.awt.Color(255, 255, 255));
        numquest.setText("00");

        jid.setBackground(new java.awt.Color(0, 51, 102));
        jid.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 0, 24)); // NOI18N
        jid.setForeground(new java.awt.Color(255, 255, 255));
        jid.setText("00");

        jtime1.setBackground(new java.awt.Color(0, 51, 102));
        jtime1.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 0, 24)); // NOI18N
        jtime1.setForeground(new java.awt.Color(204, 0, 0));
        jtime1.setText("00");

        jtime2.setBackground(new java.awt.Color(0, 51, 102));
        jtime2.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 0, 24)); // NOI18N
        jtime2.setForeground(new java.awt.Color(204, 0, 0));
        jtime2.setText("00");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Score");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Question");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Id joueur");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Theme");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Time");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(406, 406, 406))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jid)
                                        .addGap(183, 183, 183)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(numquest)
                                                .addGap(222, 222, 222))
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(32, 32, 32)
                                        .addComponent(jtheme)))
                                .addGap(12, 12, 12))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jscore, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jtime1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtime2)
                                    .addGap(47, 47, 47))
                                .addComponent(jLabel1))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(134, 134, 134)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtheme, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtime2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jscore, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(numquest, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6))
                                .addGap(129, 129, 129)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        answerCheck();
        question();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
     Menue M =new Menue();
     M.show();
     dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jrep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrep1ActionPerformed
        // TODO add your handling code here:
        if(jrep1.isSelected()) {
            jrep2.setSelected(false);
            jrep3.setSelected(false);
            jrep4.setSelected(false);
            sec=0;
        }
    }//GEN-LAST:event_jrep1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment valider le formulaire?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0) {
            answerCheck();
            submit();
            Menue m = new Menue();
            m.show();
            dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jrep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrep2ActionPerformed
        // TODO add your handling code here:
        if(jrep2.isSelected()) {
            jrep1.setSelected(false);
            jrep3.setSelected(false);
            jrep4.setSelected(false);
            sec =0;
        }
    }//GEN-LAST:event_jrep2ActionPerformed

    private void jrep3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrep3ActionPerformed
        // TODO add your handling code here:
        if(jrep3.isSelected()) {
            jrep2.setSelected(false);
            jrep1.setSelected(false);
            jrep4.setSelected(false);
             sec =0;
        }
    }//GEN-LAST:event_jrep3ActionPerformed

    private void jrep4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrep4ActionPerformed
        // TODO add your handling code here:
        if(jrep4.isSelected()) {
            jrep2.setSelected(false);
            jrep3.setSelected(false);
            jrep1.setSelected(false);
             sec =0;
        }
    }//GEN-LAST:event_jrep4ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Question().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jid;
    private javax.swing.JLabel jquestion;
    private javax.swing.JRadioButton jrep1;
    private javax.swing.JRadioButton jrep2;
    private javax.swing.JRadioButton jrep3;
    private javax.swing.JRadioButton jrep4;
    private javax.swing.JLabel jscore;
    private javax.swing.JLabel jtheme;
    private javax.swing.JLabel jtime1;
    private javax.swing.JLabel jtime2;
    private javax.swing.JLabel numquest;
    // End of variables declaration//GEN-END:variables
}
