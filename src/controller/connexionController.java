/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import connexion.connexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.Admin;

/**
 *
 * @author Maeva
 */
public class connexionController {

    public void connecter(JTextField userT, JPasswordField passwordT, JPanel jpanel2) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
        
            String username = userT.getText();
            String password = passwordT.getText();
            
            Statement stm = con.createStatement();
            
            String sql = "select * from admin where username='"+username+"' and mdp='"+password+"'";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                Admin a = new Admin();
                a.show();
                //dispose();
            } else {
                JOptionPane.showMessageDialog(jpanel2, "username or password wrong...");
                userT.setText("");
                passwordT.setText("");
            }
            con.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void list(JTable table) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            String sql = "select * from joueur";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel)table.getModel();
            Model.setRowCount(0);
            while(rs.next()) {
                
                String num = String.valueOf(rs.getInt("id"));
                String nom = String.valueOf(rs.getString("pseudo"));
                String theme = String.valueOf(rs.getString("choixtheme"));
                String sc = String.valueOf(rs.getInt("score"));
                
                String tableth[] = {num,nom,theme,sc};
                DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
                tableModel.addRow(tableth);
                
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ici"+e.getMessage());
        }
    }
    
}
