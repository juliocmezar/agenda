
package modelo;
import java.sql.*;
import java.util.ArrayList;

public class CConsultas {
    
    //de la librería sql usamos como atributo un objeto de tipo conexión, que es necesario para ejecutar las consultas
    Connection con;
    String query;
    
     public CConsultas(){
         
     }
     
     //para ejecutar el método recibimos por parámetro una conexión activa
     public boolean ingresar(Connection con, String nombres, String apellidos, String direccion, String telefono, String email){
         this.con=con;
         query="INSERT INTO datos(id,nombres,apellidos,telefono,direccion,email) VALUES (null,'Natalia','Casas','4564','cra 30','natalia@gmail.com');";
         try{ 
          //preparo la consulta
          PreparedStatement preparar=con.prepareStatement(query);
          //ejecuto la consulta luego de prepararla
          preparar.executeUpdate();
          return true;
         }catch (SQLException ex){
          System.out.println("Error en el sql");
          return false;
       }
     }
     
      //para ejecutar el método recibimos por parámetro una conexión activa
     public ArrayList<CContacto> consultar(Connection con){ 
      this.con=con;   
      query = "SELECT * FROM datos"; 
      ArrayList<CContacto> lista = new ArrayList<>();
      try{ 
          //preparo la consulta
          PreparedStatement preparar=con.prepareStatement(query);
          //ejecuto la consulta luego de prepararla
          ResultSet resultado = preparar.executeQuery();
                    
          /* //Este código me sirve para ver la salida en consola, para probar si la consulta está bien hecha
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

          */ //fin del código para probar consulta
          
          //recorro cada fila, se intancia un objeto de la clase CContacto y se guarda en la lista
          while(resultado.next()){
            CContacto c=new CContacto( 
              resultado.getInt("id"),
              resultado.getString("nombres"),
              resultado.getString("apellidos"),
              resultado.getString("direccion"),      
              resultado.getString("telefono"),
              resultado.getString("email")
            ); 
            lista.add(c);
          } 
          System.out.println("Consulta correcta");
          return lista;
          
       }catch (SQLException ex){
          System.out.println("Error en el sql");
          return null;
       }
   } 
}
