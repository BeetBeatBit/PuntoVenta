
//Hola esto es una prueba


package clases;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.*;
public class conectar {
    private static Connection CN;
    private static final String DRIVER= "com.mysql.jdbc.Driver";
    private static final String USER= "root";
    private static final String PASSWORD= "";
    private static final String URL= "jdbc:mysql://localhost:3306/puntoventa";
    
public conectar(){
    CN=null;
    try{
        Class.forName(DRIVER);
        CN= DriverManager.getConnection(URL, USER, PASSWORD);
    }
    catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage(),"Conexion Denegada", JOptionPane.ERROR_MESSAGE);
    }
}
public Connection getConnection(){
    return CN;
}
public void close(){
    try{
        CN.close();
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage(), "Conexion Interrumpida", JOptionPane.ERROR_MESSAGE);
    }
}
}
