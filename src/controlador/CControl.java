
package controlador;
import java.sql.Connection;
import java.util.ArrayList;
import vista.*;
import modelo.*;

public class CControl {
    
    CConexion con=new CConexion();
    Connection conecta;
    CConsultas consulta=new CConsultas();
    
    public CControl(){
        
    }
    
    
    public ArrayList<CContacto> consultar(){
       ArrayList<CContacto> lista = new ArrayList<>(); 
       conecta=con.conectar(); 
       if(conecta!=null){ 
         lista=consulta.consultar(conecta);
         con.desconectar(conecta);
         return lista;
       }else{
           return null;       
       } 
    }
    
    
}
