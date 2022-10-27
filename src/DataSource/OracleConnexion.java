package DataSource;

import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public final class OracleConnexion extends OracleDataSource { 
  private static OracleConnexion ods;

  private OracleConnexion() throws SQLException{}

  public static OracleConnexion getDataSource() throws SQLException {

    if (ods == null) {

      ods = new OracleConnexion();

      ods.setDriverType("thin"); 
      ods.setPortNumber(1521); 
      ods.setServerName("iutdoua-ora.univ-lyon1.fr"); 
      ods.setServiceName("orcl.univ-lyon1.fr"); 
      ods.setUser("pxxxxxxxx");
      ods.setPassword("xxxxxx");
    }

    return ods;
  }

  
  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException(); 
  }
}