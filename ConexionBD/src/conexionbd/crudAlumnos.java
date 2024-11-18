
package conexionbd;
import java.sql.*;

public class crudAlumnos {
    
    
    public void insertarDato(int dni,String nombre,String apellido,String direccion,int telefono,String email,String curso,int matricula){
        String query="insert into alumnos (dni, nombre, apellido, direccion, telefono, email, curso, matricula) values(?,?,?,?,?,?,?,?)";
        try {
            Connection con=dbConnection.conectar();
            PreparedStatement ps=con.prepareStatement (query);
            ps.setInt(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion);
            ps.setInt(5, telefono);
            ps.setString(6, email);
            ps.setString(7, curso);
            ps.setInt(8, matricula);
            
            ps.executeUpdate();
            System.out.println("Dato insertado exitosamente");
            
        }   
        catch(SQLException ex){
            System.out.println("Error al insertar dato");
            ex.printStackTrace();        
        }
    }

    public void leerDatos(){
        String query="select * from alumnos";
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
                String curso=rs.getString("curso");
                int matricula=rs.getInt("matricula");
                
                System.out.println("dni: "+dni + "nombre: "+nombre + "apellido: "+apellido + "direccion: "+direccion + "telefono: "+telefono + "email: "+email + "curso: "+curso + "matricula: "+matricula);
                
           }
        }
           catch(SQLException ex){
            System.out.println("Error");
            ex.printStackTrace();   
           }
    }
    public void eliminarRegistro(int dni){
        String query="delete from alumnos where dni=?";
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
    
       
   

