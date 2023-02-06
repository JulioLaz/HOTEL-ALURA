package factory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class FactoryConnector {
	
private DataSource dataSource;

public FactoryConnector() {
    var comboPooledDataSource = new ComboPooledDataSource();
    comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotelesaluras?useTimeZone=true&serverTimeZone=UTC");
//    comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/mydb?useTimeZone=true&serverTimeZone=UTC");
    comboPooledDataSource.setUser("root");
    comboPooledDataSource.setPassword("Jumysql1978#");
    comboPooledDataSource.setMaxPoolSize(10);
    
    this.dataSource = comboPooledDataSource;
}

public Connection recuperaConexion() {
    try {
        return this.dataSource.getConnection();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  }
}