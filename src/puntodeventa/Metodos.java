/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntodeventa;
import clases.conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Metodos {
    private final String SQL_INSERT="INSERT INTO registro(usuario, contraseña)values(?, ?)";
    private final String SQL_INSERT_ADMIN = "INSERT INTO registrousers (usuario, contraseña) values (?, ?)";
    private final String SQL_INSERT_PRODUCTOS = "INSERT INTO productos (nombre, costo, cantidad, descripcion, codigo_producto) values (?, ?, ?, ?, ?)";
    private final String SQL_SELECT="SELECT contraseña FROM registro WHERE usuario= ?";
    private final String SQL_SELECT_ADMIN = "SELECT contraseña FROM registrousers WHERE usuario=?";
    private final String SQL_SELECT_PRODUCTOS = "SELECT id_producto FROM prodcutos";
    private final String SQL_UPDATE = "UPDATE registro SET usuario= ?, contraseña= ?";
    private final String SQL_UPDATE_PASS = "UPDATE registrousers SET contraseña = ?";
    private final String SQL_UPDATE_PRODUCTS = "UPDATE productos SET nombre = ?, costo = ?, cantidad = ?, descripcion = ?, codigo_producto = ?";
    private ResultSet RS;
    private PreparedStatement PS;
    private final conectar CONEC;
    
    public Metodos(){
        PS=null;
        CONEC=new conectar();
    }
    
    public int insertProductos(String nombre, String costo, String cantidad, String descripcion, String codigo_producto){
        try{
            PS=CONEC.getConnection().prepareStatement(SQL_INSERT_PRODUCTOS);
            PS.setString(1, nombre);
            PS.setString(2, costo);
            PS.setString(3, cantidad);
            PS.setString(4, descripcion);
            PS.setString(5, codigo_producto);
            
            int res=PS.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null,"Registro Exitoso","Exito",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        finally{
            PS=null;
        }
        return 0;
    }
    
    public int inserDatos(String usuario, String contraseña){
        try{
            PS=CONEC.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, usuario);
            PS.setString(2, contraseña);
            
            int res=PS.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null,"Registro Exitoso","Exito",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        finally{
            PS=null;
        }
        return 0;
    }
    
        public int inserDatosAdmin (String usuario, String contraseña){
        try{
            PS=CONEC.getConnection().prepareStatement(SQL_INSERT_ADMIN);
            PS.setString(1, usuario);
            PS.setString(2, contraseña);
            
            int res=PS.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null,"Registro Exitoso","Exito",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        finally{
            PS=null;
        }
        return 0;
    }
   
    public int upDatos(String usuario, String contraseña, int n_registro){
        try{
           PS=CONEC.getConnection().prepareStatement(SQL_UPDATE);
           PS.setString(1, usuario);
           PS.setString(2, contraseña);
           PS.setInt(3, n_registro);
           
           int res=PS.executeUpdate();
           if(res>0){
               JOptionPane.showMessageDialog(null, "Modificacion Cargada Con Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    public int upDatosPass (String password){
        try{
           PS=CONEC.getConnection().prepareStatement(SQL_UPDATE_PASS);
           PS.setString(1, password);
           
           int res=PS.executeUpdate();
           if(res>0){
               JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
     public int updateProductos (String nombre, String costo, String cantidad, String descripcion, String codigo_producto){
        try{
           PS=CONEC.getConnection().prepareStatement(SQL_UPDATE_PRODUCTS);
           PS.setString(1, nombre);
           PS.setString(2, costo);
           PS.setString(3, cantidad);
           PS.setString(4, descripcion);
           PS.setString(5, codigo_producto);
           
           int res=PS.executeUpdate();
           if(res>0){
               JOptionPane.showMessageDialog(null, "Modificacion Cargada Con Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    public int SelectDatos(String usuario,String contra){
        String Con = "";
        int control = 0;
        try{
            PS = CONEC.getConnection().prepareStatement(SQL_SELECT);
            PS.setString(1, usuario);
            RS = PS.executeQuery();
            if(RS.next()){
               Con = RS.getString(1);
            }
            
            if(Con.equals(contra)){
                JOptionPane.showMessageDialog(null, "Excelente","Exito", JOptionPane.INFORMATION_MESSAGE);
               control = 1; 
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
        if(control ==1){
            return 1;
        }else{
           return 0;
        }
    }
    
     public int SelectProductosID (String id_producto){
        String Con = "";
        int control = 0;
        try{
            PS = CONEC.getConnection().prepareStatement(SQL_SELECT_PRODUCTOS);
            PS.setString(1, id_producto);
            RS = PS.executeQuery();
            if(RS.next()){
               Con = RS.getString(1);
            }
            
            if(Con.equals(id_producto)){
                JOptionPane.showMessageDialog(null, "Excelente","Exito", JOptionPane.INFORMATION_MESSAGE);
               control = 1; 
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(control ==1){
            return 1;
        } else{
           return 0;
        }
    }
    
    public int SelectDatosAdmin (String usuario,String contra){
        String Con = "";
        int control = 0;
        try{
            PS = CONEC.getConnection().prepareStatement(SQL_SELECT_ADMIN);
            PS.setString(1, usuario);
            RS = PS.executeQuery();
            if(RS.next()){
               Con = RS.getString(1);
            }
            
            if(Con.equals(contra)){
                JOptionPane.showMessageDialog(null, "Excelente","Exito", JOptionPane.INFORMATION_MESSAGE);
               control = 1; 
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
        if(control ==1){
            return 1;
        }else{
           return 0;
        }
    }
        
}
