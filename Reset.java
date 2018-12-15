package Railway;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class RESET extends javax.swing.JFrame {
Connection connect = null;
ResultSet rst=null;
PreparedStatement pst=null;
    /**
     * Creates new form RESET
     */
    public RESET() {
        initComponents();
        connect = (Connection) Railway.connDB();
    }
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         try
      {
       
          String sql="update registration set Password='"+jPasswordField1.getText()+"' where user='"+jTextField1.getText()+"'";
      
        Statement s=connect.createStatement();
        
       s.executeUpdate(sql);
        
                JOptionPane.showMessageDialog(null," user Records UPdated Succssfully... ");
        
      jTextField1.setText("");
      jPasswordField1.setText("");
      
      jPasswordField1.requestFocusInWindow();
      
                
      }
        
      
      catch(Exception ee)
      {
                JOptionPane.showMessageDialog(null," Erro="+ee);
          
      }
    }                                        
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         this.setVisible(false);
        new login().setVisible(true);
    }                                        
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RESET().setVisible(true);
            }
        });
    }
