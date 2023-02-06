package dao;

import factory.FactoryConnector;
import model.Huespedes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class HuespedesDAO {
	
    private Connection con;

	public HuespedesDAO(Connection con) {
        this.con = con;
	}

	public void guardarHuesped(String nombre, String apellido, String fechaNacimiento, String nacionalidad,
			String telefono, Integer reservas_id, int usuarios_id) throws SQLException {

        FactoryConnector factory = new FactoryConnector();

        final Connection con = factory.recuperaConexion();
        try (con) {
            final PreparedStatement statement = con.prepareStatement(
            "INSERT INTO huespedes"
            + "(nombre,apellido,fechaNacimiento,nacionalidad,telefono,reservas_id,usuarios_id)"
            + "values (?,?,?,?,?,?,?);"
            );

            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, fechaNacimiento);
            statement.setString(4, nacionalidad);
            statement.setString(5, telefono); 
            statement.setInt(6, reservas_id);
            statement.setInt(7, usuarios_id);

            try (statement) {
            statement.execute();
//            System.out.println("desde huespedesDAO - INICIA guardarHuesped");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ROLLBACK de la transaccion "+e);
            con.rollback();
        }
    }
}   

//modificar Huesped//
	
public int modificar(String nombre, String apellido,String fechaNacimiento,String nacionalidad,String telefono,int reservas_id,int id) throws SQLException {
        FactoryConnector factory = new FactoryConnector();
        final Connection con = factory.recuperaConexion();
      
        try(con) {
            final PreparedStatement statement = con
            		.prepareStatement("UPDATE huespedes SET "
                        + " nombre = ?,"
                        + " apellido = ?,"
                        + " fechaNacimiento = ?,"
                        + " nacionalidad = ?,"
                        + " telefono = ?,"
                        + " reservas_id = ?"
                        + " WHERE id = ?"
                        );
            
            try(statement) {
            	
            	statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, fechaNacimiento);
                statement.setString(4, nacionalidad);
                statement.setString(5,telefono);
                statement.setInt(6,reservas_id);
                statement.setInt(7,id);
                statement.execute();
       
                int updateCount = statement.getUpdateCount();
//                System.out.println("Desde huesdepesDAO huesped modificada - id: "+id);
//                System.out.println(nombre+" "+apellido+ " "+id);
                return updateCount;
            }
        } 
    }    

public int eliminarXId(Integer id) throws SQLException {
        FactoryConnector factory = new FactoryConnector();
        final Connection con = factory.recuperaConexion();
        
        try(con) {
            final PreparedStatement statement = con
                .prepareStatement("DELETE FROM Huespedes WHERE ID = ?");
            try(statement) {
               
                statement.setInt(1, id);
                statement.execute();
        
                int updateCount = statement.getUpdateCount();
            return updateCount;
            }
        }
    }

public int eliminarXReserva(Integer id) throws SQLException {
        FactoryConnector factory = new FactoryConnector();
        final Connection con = factory.recuperaConexion();
        
        try(con) {
            final PreparedStatement statement = con
                .prepareStatement("DELETE FROM Huespedes WHERE reservas_id = ?");
            try(statement) {
                
                statement.setInt(1, id);
                statement.execute();
        
                int updateCount = statement.getUpdateCount();
            return updateCount;
            }
        }
    } 

public List<Huespedes> listar() {
    List<Huespedes> resultado = new ArrayList<>();
    FactoryConnector factory = new FactoryConnector();
    final Connection con = factory.recuperaConexion();

    try(con) {
        final PreparedStatement statement = con.prepareStatement("SELECT id,nombre, apellido, fechaNacimiento, nacionalidad,telefono,reservas_id FROM huespedes");
        
        try (statement) {
            statement.execute(); 

            final ResultSet resultSet = statement.getResultSet();

            try (resultSet) {
                while (resultSet.next()) {
                    resultado.add(new Huespedes(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido"),
                            resultSet.getString("fechaNacimiento"),
                            resultSet.getString("nacionalidad"),
                            resultSet.getString("telefono"),
                            resultSet.getInt("reservas_id")
                            ));
                }
            } 
        }    
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return resultado;
}
}
