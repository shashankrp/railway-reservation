package Railway;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class SearchTrain extends javax.swing.JFrame {
Connection connect = null;
ResultSet rst=null;
PreparedStatement pst=null;
    public SearchTrain() {
        initComponents();
        connect = (Connection) Railway.connDB();
    }
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try
        {
        String sql="select * from railway.trains where To_A='"+jTextField2.getText()+"' and Date='"+jTextField12.getText()+"'";
      
        Statement s=connect.createStatement();
        
        rst=s.executeQuery(sql);
        
        if(rst.next() == false)
        {
                JOptionPane.showMessageDialog(null," No Such Records Invalid Pid");
     
         jTextField2.setText("");
         jTextField12.setText("");
         
      
      jTextField2.requestFocusInWindow();
      jTextField12.requestFocusInWindow();
}
        else
        {
            jTextField1.setText(rst.getString(3));
            jTextField3.setText(rst.getString(1));
            jTextField4.setText(rst.getString(2));
            jTextField5.setText(rst.getString(5));
            jTextField6.setText(rst.getString(6));
            jTextField7.setText(rst.getString(7));
            jTextField8.setText(rst.getString(8));
            jTextField9.setText(rst.getString(9));
            jTextField10.setText(rst.getString(10));
            jTextField11.setText(rst.getString(11));
             }
        
      }
      catch(Exception ee)
      {
          
      }
                
    }                                        
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
        new SearchTrain().setVisible(true);
    }                                        
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
        new reservation().setVisible(true);
    }                                        
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
        new Train().setVisible(true);
    }                                        
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchTrain().setVisible(true);
            }
        });
    }
