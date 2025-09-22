
package controlador;
import java.sql.Connection;
import vista.*;
import modelo.*;

public class CControl {
    
    CConexion con=new CConexion();
    Connection conecta;
    CConsultas consulta;
    String query;
    
    public CControl(){
        
    }
    
    
    public void consultar(){
       query="SELECT * FROM datos;"; 
       conecta=con.conectar(); 
       if(conecta!=null){ 
          consulta.consultar(query, conecta);
           
       }
    }
    
    
}
