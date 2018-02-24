/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntodeventa;

/**
 *
 * @author neftali
 */
public class PuntoDeVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login login=new Login();
        login.setSize(300,400);
        login.setVisible(true);
        login.setResizable(false);
        login.setLocationRelativeTo (null);
    }
    
}
