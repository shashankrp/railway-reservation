package Railway;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Railway 
{
     Connection conn;
    public static Connection connDB()
        {
         try {
               Class.forName("com.mysql.jdbc.Driver");
               Connection conn;
             conn = DriverManager.getConnection("jdbc:mysql://localhost/railway","root","password");
               return conn;
             } 
         catch (ClassNotFoundException | SQLException e)
            {
               JOptionPane.showMessageDialog(null, e);
            }
         return null;
        }

    public Railway() {
        this.conn = null;
    }

public static void main(String args[]) {
java.awt.EventQueue.invokeLater(() -> {
            new Railway().setVisible(true);
        });
    }
private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private Container getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private void pack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
