package dao;

import factory.FactoryConnector;
import views.Exito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservasDAO {

    //buscar ultimo número de reserva en DDBB//

    public int getNumeroReserva() throws SQLException {
        int resultado = 0;
        FactoryConnector factory = new FactoryConnector();
        final Connection con = factory.recuperaConexion();
        try(con) {
            final PreparedStatement statement = con.prepareStatement("SELECT MAX(id)AS id FROM reservas");
            try(statement) { 
                statement.execute();
                ResultSet result = statement.getResultSet();
             if (result.next()) {
                resultado = result.getInt(1);

                System.out.println("número de reserva en BBDD: "+ resultado);
             }              
            }
         return resultado+1;
        }
    }
    
    	public  Object guardarReserva(int id,String fEntrada,String fSalida, String costo,int fPago,int huespedes_id) throws SQLException {          
       FactoryConnector factory = new FactoryConnector();

        final Connection con = factory.recuperaConexion();
        
        try(con) {
            final PreparedStatement statement = con.prepareStatement("INSERT INTO reservas"
                        + "(id, fechaEntrada, fechaSalida,valor,FormaDePago,huespedes_id)"
                        + " VALUES (?,?,?,?,?,?)"
                        );
            try(statement){
            			statement.setInt(1,id);
                        statement.setString(2,fEntrada);
                        statement.setString(3,fSalida);
                        statement.setFloat(4,Float.valueOf(costo));
                        statement.setInt(5,fPago);
                        statement.setInt(6,huespedes_id);
         
                statement.execute();
                Exito.main(null);
//                statement.close(); 
        }
        
        int updateCount = statement.getUpdateCount();
        return updateCount;
  }
}

    	//Modificar Reservas//

public int modificar(String fechaEntrada, String fechaSalida, float valor,int formaDePago,int id) throws SQLException {
        FactoryConnector factory = new FactoryConnector();
        final Connection con = factory.recuperaConexion();
        
        try(con) {
            final PreparedStatement statement = con
                .prepareStatement("UPDATE reservas SET "
                        + " fechaEntrada = ?, "
                        + " fechaSalida = ?,"
                        + " valor = ?,"
                        + " formaDePago = ?"
                        + " WHERE id = ?"
                        );
          
            try(statement) {
                statement.setString(1, fechaEntrada);
                statement.setString(2, fechaSalida);
                statement.setFloat(3, valor);
                statement.setInt(4, formaDePago);
                statement.setInt(5,id);
                statement.execute();
               
                int updateCount = statement.getUpdateCount();
                System.out.println("Desde ReservaDAO resesrva modificada - id: "+id);
                return updateCount;
  }
 }
}
  
    public int eliminar(Integer id) throws SQLException {
        FactoryConnector factory = new FactoryConnector();
        final Connection con = factory.recuperaConexion();
        
        try(con) {
            final PreparedStatement statement = con
                .prepareStatement("DELETE FROM reservas WHERE id = ?");
            
            try(statement) {
                
                statement.setInt(1, id); 
                
                statement.execute();
                System.out.println("Desde ReservaDAO resesrva eliminada - id: "+id);
                int updateCount = statement.getUpdateCount();
        
                return updateCount;
            }
        }
    }
}
