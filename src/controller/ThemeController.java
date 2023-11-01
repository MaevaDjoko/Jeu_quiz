/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.SpringLayout.WIDTH;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Maeva
 */
public class ThemeController {
    
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
    public void ajouterTheme(JTextField nomthemeT, JTextField numthemeT) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            String sql ="insert into theme(numero,nom) values(?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, numthemeT.getText());
            pst.setString(2, nomthemeT.getText());

            pst.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Enregistrement reussie");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ici"+e.getMessage());
        }
    
        /*try {
            int value;
            String nomT=nomthemeT.getText();
            String numT=numthemeT.getText();
            String date=LocalDate.now().getMonth().toString()+" "+LocalDate.now().getYear();
            Class.forName("com.mysql.jdbc.Driver");
            if(isNumeric(numT)){
                //mnt=Integer.parseInt(numT);
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
                String sql="insert into theme(numero,nom,dateenreg) values("+numT+",'"+nomT+"','"+date+");";
                PreparedStatement stat=con.prepareStatement(sql);
                value=stat.executeUpdate();
                
                if(value>0){
                    JOptionPane.showMessageDialog(Jpanel1, "Question Enregistre");
                }else{
                    JOptionPane.showMessageDialog(Jpanel1, "Question pas Enregistre");
                }
            }else{
                JOptionPane.showMessageDialog(Jpanel1, "Le numero de la question doit etre un chiffre");
            }
        } catch (Exception ex) {
           ex.getMessage();
        }*/
    }

     public void actualiseTh(JTable tabletheme) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            String sql = "select * from theme";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel)tabletheme.getModel();
            Model.setRowCount(0);
            while(rs.next()) {
                
                String num = String.valueOf(rs.getInt("numero"));
                String nom = String.valueOf(rs.getString("nom"));
                
                String tableth[] = {num,nom};
                DefaultTableModel tableModel = (DefaultTableModel)tabletheme.getModel();
                tableModel.addRow(tableth);
                
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ici"+e.getMessage());
        }
    }
    /*private boolean isNumeric(String numT) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
     
     public  void cbthemeJ (JComboBox themeJoueur) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            String sql = "select * from theme";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                String nom = rs.getString("nom").toString();
                themeJoueur.addItem(nom);
            }
            con.close();
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ici"+e.getMessage());
         }
     }
     
     public void selectTheme(JTextField jnomtheme, JTextField jnumtheme, JTable tabletheme) {
         try {
            int i = tabletheme.getSelectedRow();
            TableModel m = tabletheme.getModel();
            jnomtheme.setText(m.getValueAt(i, 0).toString());
            jnumtheme.setText(m.getValueAt(i, 1).toString());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
     }
     
     public void modifTheme(JTextField jnumtheme, JTextField jnomtheme) {
         
         String num = jnumtheme.getText();
         String nom = jnomtheme.getText();
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update theme set nom='"+nom+"' where numero='"+num+"'");
            JOptionPane.showMessageDialog(null, "Modification reussie");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
     }
     
      public void supp(JTextField jnumtheme) {
         String num = jnumtheme.getText();
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            Statement st = con.createStatement();
            st.executeUpdate("delete from theme where numero='"+num+"'");
            JOptionPane.showMessageDialog(null, "Suppression reussie");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
      }
     
}
