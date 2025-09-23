
package modelo;
import java.sql.*;

public class CConsultas {
    
    //de la librería sql usamos como atributo un objeto de tipo conexión, que es necesario para ejecutar las consultas
    Connection con;
    String query;
    
     public CConsultas(){
         
     }
     
      //para ejecutar consulta recibimos por parámetro una conexión activa, y una query
     public void consultar(String query, Connection con){ 
      this.con=con;   
      this.query = query; 
      try{ 
          //preparo la consulta
          PreparedStatement preparar=con.prepareStatement(query);
          //ejecuto la consulta luego de prepararla
          ResultSet resultado = preparar.executeQuery();
          //la metadata sirve para ver el nombre de las colomnas, el tipo de dato y cuantas colomnas tiene la consulta
          ResultSetMetaData metaData = resultado.getMetaData();
          //traigo el número de columnas
          int numeroColumnas = metaData.getColumnCount();
          for (int i = 1; i <= numeroColumnas; i++) {
                //imprimo el nombre de las columnas
                System.out.print(metaData.getColumnName(i) + "\t");
          }
          System.out.println();
          //imprimo las filas
          while(resultado.next()){           
            for (int i = 1; i <= numeroColumnas; i++) {
                    System.out.print(resultado.getString(i) + "\t");
                }
                System.out.println();
          }
          System.out.println("Consulta correcta");
       }catch (SQLException ex){
          System.out.println("Error en el sql");
          
       }
   } 
}
