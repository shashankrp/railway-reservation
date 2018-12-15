package Railway;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class login extends javax.swing.JFrame {
Connection connect = null;
ResultSet rst=null,rs=null;
PreparedStatement pst=null;
    public login() {
        initComponents();
        connect = (Connection) Railway.connDB();
    }
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
                 
                 String sql="select * from registration where user='"+jTextField1.getText()+"' and password='"+jPasswordField1.getText()+"'";
                 
                 Statement s=connect.createStatement();
                 rst=s.executeQuery(sql);
            
                 if(rst.next() == false)
                 {
                   String qry="select * from railway.admin where user='"+jTextField1.getText()+"' and password='"+jPasswordField1.getText()+"'";
                      rs=s.executeQuery(qry);
                 if(rs.next()==false)
                 {
                      JOptionPane.showMessageDialog(null," User or password error ");
                 }else {
                    
                     this.setVisible(false);
                     Admin_Auth home1=new Admin_Auth();
                     home1.setVisible(true);
                 }
         jTextField1.setText("");
         jPasswordField1.setText("");
      
      jTextField1.requestFocusInWindow();
      jPasswordField1.requestFocusInWindow();
}
                 else 
        {
             JOptionPane.showMessageDialog(null," Login Succssfully... ");
            this.setVisible(false);
                     reservation home= new reservation();
                     home.setVisible(true);
        } 
                
        
      }
               
catch(Exception e) 
{
    System.out.println(e.getMessage());
}   
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          this.setVisible(false);
        new registration().setVisible(true);
}
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         this.setVisible(false);
        new welcome().setVisible(true);
    }   
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
        new RESET().setVisible(true);
    }  
public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new login().setVisible(true);
}
        });
    }
