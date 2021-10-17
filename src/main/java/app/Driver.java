package app;

import connection.ConnectDb;
import constants.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class Driver {

  Connection c;

  public Driver(){
    c = ConnectDb.getInstance().getDbConnection();
    if( c == null){
      System.out.println("Unable to connect to Database!!");
      System.exit(1);
    }
  }

  public void setUpTables(){
    try{
      Statement stmt = c.createStatement();
      stmt.execute(Constants.DROP_BUS_STATUS);
      stmt.execute(Constants.DROP_ROUTE);
      stmt.execute(Constants.DROP_RESERVATION);
      stmt.execute(Constants.DROP_PASSENGER);
      stmt.execute(Constants.DROP_BUS);
      stmt.execute(Constants.CREATE_BUS_TABLE);
      stmt.execute(Constants.CREATE_BUS_STATUS_TABLE);
      stmt.execute(Constants.CREATE_ROUTE_TABLE);
      stmt.execute(Constants.CREATE_RESERVATION_TABLE);
      stmt.execute(Constants.CREATE_PASSENGER_TABLE);
    } catch (Exception e){
      e.printStackTrace();
      System.exit(1);
    }
  }

}
