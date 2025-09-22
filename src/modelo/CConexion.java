
package modelo;

//descargar librerías de https://www.mysql.com/products/connector/
import java.sql.Connection;
import java.sql.DriverManager;


public class CConexion {
   String usuario="root";
   String contrasena="root";
   String url="jdbc:mysql://localhost:3306/agenda";
   
   
   public Connection conectar(){
       Connection con=null;
       try{         
          con= DriverManager.getConnection(url,usuario,contrasena);
          System.out.println("conexion correcta");
       }catch (Exception e){
          System.out.println(e.toString());
       }
       return con; 
       
   }
}
