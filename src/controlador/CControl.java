
package controlador;
import java.sql.Connection;
import vista.*;
import modelo.*;

public class CControl {
    
    CConexion con=new CConexion();
    Connection conecta;
    CConsultas consulta=new CConsultas();
    
    public CControl(){
        
    }
    
    
    public void consultar(){ 
       conecta=con.conectar(); 
       if(conecta!=null){ 
         consulta.consultar(conecta);
           
       }
       con.desconetar(conecta);
    }
    
    
}
