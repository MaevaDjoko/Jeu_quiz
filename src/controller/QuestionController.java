/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Maeva
 */
public class QuestionController {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
    
    public void ajouterQuestion(JTextField jnum, JComboBox jcbquest, JTextArea jlibelle, JTextField jrep1, JTextField jrep2, JTextField jrep3, JTextField jrep4, JTextField jrep) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            String sql ="insert into question(numQuestion,theme,libelle,rep1,rep2,rep3,rep4,reponse) values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, jnum.getText());
            pst.setString(2, (String) jcbquest.getSelectedItem());
            pst.setString(3, jlibelle.getText());
            pst.setString(4, jrep1.getText());
            pst.setString(5, jrep2.getText());
            pst.setString(6, jrep3.getText());
            pst.setString(7, jrep4.getText());
            pst.setString(8, jrep.getText());

            pst.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Enregistrement reussie");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ici"+e.getMessage());
        }
    }
        
        public  void cbquestion (JComboBox jcbquest) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            String sql = "select * from theme";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                String nom = rs.getString("nom").toString();
                jcbquest.addItem(nom);
            }
            con.close();
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ici"+e.getMessage());
         }
        }
        
        
        public void actualq(JTable tablequestion) {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            String sql = "select * from question";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            //tabletheme.setModel(DbUtils.resultSetToTableModel(rs));
            
            DefaultTableModel Model = (DefaultTableModel)tablequestion.getModel();
            Model.setRowCount(0);
            while(rs.next()) {
                
                String num = String.valueOf(rs.getInt("numQuestion"));
                String theme = String.valueOf(rs.getString("theme"));
                String libelle = String.valueOf(rs.getString("libelle"));
                String rep1 = String.valueOf(rs.getString("rep1"));
                String rep2 = String.valueOf(rs.getString("rep2"));
                String rep3 = String.valueOf(rs.getString("rep3"));
                String rep4 = String.valueOf(rs.getString("rep4"));
                String rep = String.valueOf(rs.getString("reponse"));
                
                String tableth[] = {num,theme,libelle,rep1,rep2,rep3,rep4,rep};
                DefaultTableModel tableModel = (DefaultTableModel)tablequestion.getModel();
                tableModel.addRow(tableth);
                
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ici"+e.getMessage());
        }
    }
        public void select(JTextField num, JComboBox theme, JTextField libelle, JTextField rep1, JTextField rep2, JTextField rep3, JTextField rep4, JTextField rep, JTable tablequestion) {
            try {
            int i = tablequestion.getSelectedRow();
            TableModel m = tablequestion.getModel();
            num.setText(m.getValueAt(i, 0).toString());
            theme.setSelectedItem(m.getValueAt(i, 1).toString());
            libelle.setText(m.getValueAt(i, 2).toString());
            rep1.setText(m.getValueAt(i, 3).toString());
            rep2.setText(m.getValueAt(i, 4).toString());
            rep3.setText(m.getValueAt(i, 5).toString());
            rep4.setText(m.getValueAt(i, 6).toString());
            rep.setText(m.getValueAt(i, 7).toString());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        }
        
        
        public void modifQuest(JTextField numero, JComboBox theme, JTextField libelle, JTextField rep1, JTextField rep2,JTextField rep3,JTextField rep4,JTextField rep) {
         
         String num = numero.getText();
         String th = (String) theme.getSelectedItem();
         String lib = libelle.getText();
         String repo1 = rep1.getText();
         String repo2 = rep2.getText();
         String repo3 = rep3.getText();
         String repo4 = rep4.getText();
         String repo = rep.getText();
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update question set theme='"+th+"', libelle='"+lib+"', rep1='"+repo1+"', rep2='"+repo2+"', rep3='"+repo3+"', rep4='"+repo4+"', reponse='"+repo+"' where numQuestion='"+num+"'");
            JOptionPane.showMessageDialog(null, "Modification reussie");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
     }
}
