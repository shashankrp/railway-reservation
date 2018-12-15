package Railway;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Admin_Auth extends javax.swing.JFrame {
Connection connect = null;
ResultSet rst=null;
PreparedStatement pst=null;
    public Admin_Auth() {
        initComponents();
        connect = (Connection) Railway.connDB();
    }
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {

    
               Statement s=connect.createStatement();
               String sql = "insert into trains values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"','"+jTextField7.getText()+"','"+jTextField8.getText()+"','"+jTextField9.getText()+"','"+jTextField10.getText()+"','"+jTextField11.getText()+"','"+jTextField12.getText()+"')"; 
               s.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Success !");
                jTextField1.setText(" ");
                jTextField2.setText(" ");
                jTextField3.setText(" ");
                jTextField4.setText(" ");
                jTextField5.setText(" ");
                jTextField6.setText(" ");
                jTextField7.setText(" ");
                jTextField8.setText(" ");
                jTextField9.setText(" ");
                jTextField10.setText(" ");
                jTextField11.setText(" ");
                jTextField12.setText(" ");
                  } 
              catch (HeadlessException | SQLException e) {
                      System.out.println("errorrr");
              }      
    }                                        
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
        new login().setVisible(true);
    }                                        
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
        new remove().setVisible(true);
    }                                        
private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
        new seat_u().setVisible(true);
    }
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            try
        {
        String sql="select * from railway.booking";
      
        Statement s=connect.createStatement();
        
        rst=s.executeQuery(sql);
        
        jTable1.setModel(DbUtils.resultSetToTableModel(rst));
        
        if(rst.next() == false)
        {
                JOptionPane.showMessageDialog(null," Success");
     
         jTextField1.setText(" ");
         
      
      jTextField1.requestFocusInWindow();
}else{
        JOptionPane.showMessageDialog(null," No such value is found");
        }
        }
      catch(Exception ee)
      {
    }                                   

    }                                        
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Auth().setVisible(true);
            }
        });
    }
