package dao;

import factory.FactoryConnector;
import model.Usuarios;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {

	public String getUsuario(String nombre) throws SQLException {
        String password = "";
        FactoryConnector factory = new FactoryConnector();
        final Connection con = factory.recuperaConexion();
        try(con) {
            final PreparedStatement statement = con.prepareStatement("SELECT password FROM usuarios WHERE nombre = ?");
            try(statement) {
                statement.setString(1, nombre); 
                statement.execute(); 
                System.out.println("desde usuarios: "+ nombre);
             
             final ResultSet resultSet = statement.getResultSet();
                
                try(resultSet) {
                    while (resultSet.next()) {
                    	password = resultSet.getString("password");
//                    	System.out.println("USUARIO: password: "+password);               
                    }
                }
            }
            return password;
        }
    }
}
