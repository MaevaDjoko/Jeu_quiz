/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import view.Question;

/**
 *
 * @author Maeva
 */
public class ModeSoloController {
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    
    public void commencer(JTextField id, JTextField pseudojoueur, JComboBox themejoueur, JTextField jscore){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            String sql ="insert into joueur(id,pseudo,choixtheme,score) values(?,?,?,?)";
            st = con.prepareStatement(sql);
            
            st.setString(1, id.getText());
            st.setString(2, pseudojoueur.getText());
            st.setString(3, (String) themejoueur.getSelectedItem());
            st.setString(4, jscore.getText());
            //st.setString(4, );
            st.execute();
            con.close();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /*public void jouer(JLabel jquestion, JComboBox themejoueur) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            
            String th = (String) themejoueur.getSelectedItem();
            //String lib = libel.getText();
            
            Statement stm = con.createStatement();
            String sql = "select * from question where theme='"+th+"'";
            rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                String libelle = String.valueOf(rs.getString("libelle"));
                
                String tableth[] = {libelle};
                add(jquestion);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeSoloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    private void add(JLabel jquestion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
