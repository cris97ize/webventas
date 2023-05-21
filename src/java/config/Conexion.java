
package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String user ="root";
    String pass = "231920";
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user,pass); 
            System.out.println("Conexion exitosa ");
        }catch(Exception e){    
            System.out.println("No se pudo establecer conexion: "+e.getMessage());
        }
        return con;
    }
}
