package Railway;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Details extends javax.swing.JFrame {
Connection connect = null;
ResultSet rst=null;
PreparedStatement pst=null;
public Details() {
        initComponents();
        connect = (Connection) Railway.connDB();
         try
        {
        String sql="select * from railway.Details";
      
        Statement s=connect.createStatement();
        
        rst=s.executeQuery(sql);
        
        if(rst.next() == false)
        {
                JOptionPane.showMessageDialog(null," No Such Records Invalid Pid");
     
         jTextField2.setText("");
      
      jTextField2.requestFocusInWindow();
}
        else
        {
            jTextField1.setText(rst.getString(1));
            jTextField2.setText(rst.getString(2));
            jTextField3.setText(rst.getString(3));
            
        }
        
      }
      catch(Exception ee)
      {
          
      }
    }
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
        new welcome().setVisible(true);
    }                                        
public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Details().setVisible(true);
            }
        });
    }
