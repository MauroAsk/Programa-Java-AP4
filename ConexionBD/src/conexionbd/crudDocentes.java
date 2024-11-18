
package conexionbd;
import java.sql.*;

public class crudDocentes {
    
    
    public void insertarDato(int dni,String nombre,String apellido,String direccion,int telefono,String email,String cargo,int legajo){
        String query="insert into docentes (dni, nombre, apellido, direccion, telefono, email, cargo, legajo) values(?,?,?,?,?,?,?,?)";
        try {
            Connection con=dbConnection.conectar();
            PreparedStatement ps=con.prepareStatement (query);
            ps.setInt(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion);
            ps.setInt(5, telefono);
            ps.setString(6, email);
            ps.setString(7, cargo);
            ps.setInt(8, legajo);
            
            ps.executeUpdate();
            System.out.println("Dato insertado exitosamente");
            
        }   
        catch(SQLException ex){
            System.out.println("Error al insertar dato");
            ex.printStackTrace();        
        }
    }

    public void leerDatos(){
        String query="select * from docentes";
            try{
               Connection con=dbConnection.conectar();
               PreparedStatement ps=con.prepareStatement (query);
            
            ResultSet rs=ps.executeQuery();
             
            while(rs.next()){
                int dni=rs.getInt("dni");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String direccion=rs.getString("direccion");
                int telefono=rs.getInt("telefono");
                String email=rs.getString("email");
                String cargo=rs.getString("cargo");
                int legajo=rs.getInt("legajo");
                
                System.out.println("dni: "+dni + "nombre: "+nombre + "apellido: "+apellido + "direccion: "+direccion + "telefono: "+telefono + "email: "+email + "cargo: "+cargo + "legajo: "+legajo);
                
           }
        }
           catch(SQLException ex){
            System.out.println("Error");
            ex.printStackTrace();   
           }
    }
    public void eliminarRegistro(int dni){
        String query="delete from docentes where dni=?";
        try {
            Connection con=dbConnection.conectar();
            PreparedStatement ps=con.prepareStatement (query);
            ps.setInt(1, dni);
            ps.executeUpdate();
            System.out.println("Registro eliminado con exito");
        }
            catch(SQLException ex){
            System.out.println("Error al eliminar registro");
            ex.printStackTrace();
        }       
    }
}
    
       
   

