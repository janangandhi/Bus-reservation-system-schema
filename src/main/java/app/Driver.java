package app;

import connection.ConnectDb;
import constants.Constants;

import java.sql.Connection;
import java.sql.SQLException;
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
      stmt.execute(Constants.DROP_PASSENGER);
      stmt.execute(Constants.DROP_BUS_STATUS);
      stmt.execute(Constants.DROP_ROUTE);
      stmt.execute(Constants.DROP_RESERVATION);
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
  
  
  public void insertData() {  
	try {
		Statement stmt = c.createStatement();
		stmt.executeUpdate("INSERT INTO BUS (BUS_ID,NAME,SOURCE,DESTINATION) VALUES (1001,'Bus1','Santa Clara','San Jose')");
		stmt.executeUpdate("INSERT INTO BUS (BUS_ID,NAME,SOURCE,DESTINATION) VALUES (1002,'Bus2','Santa Clara','San Francisco')");
		stmt.executeUpdate("INSERT INTO BUS (BUS_ID,NAME,SOURCE,DESTINATION) VALUES (1003,'Bus3','San Jose','Santa Clara')");
		stmt.executeUpdate("INSERT INTO BUS (BUS_ID,NAME,SOURCE,DESTINATION) VALUES (1004,'Bus4','San Francisco','San Jose')");
		stmt.executeUpdate("INSERT INTO BUS (BUS_ID,NAME,SOURCE,DESTINATION) VALUES (1005,'Bus5','San Jose','Santa Cruz')");
		stmt.executeUpdate("INSERT INTO BUS (BUS_ID,NAME,SOURCE,DESTINATION) VALUES (1006,'Bus6','San Jose','Mountain View')");
		stmt.executeUpdate("INSERT INTO BUS (BUS_ID,NAME,SOURCE,DESTINATION) VALUES (1007,'Bus7','San Francisco','Berkeley')");stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1001,TIMESTAMP'2021-10-16 00:00:00.0',100,0,10)");
		  stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1002,TIMESTAMP'2021-10-16 00:00:00.0',27,13,0)");
		  stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1003,TIMESTAMP'2021-10-15 00:00:00.0',35,5,0)");
		  stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1004,TIMESTAMP'2021-10-14 00:00:00.0',40,0,29)");
		  stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1005,TIMESTAMP'2021-10-17 00:00:00.0',40,0,0)");
		  stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES  (1006,TIMESTAMP'2021-10-15 00:00:00.0',19,21,0)");
		  stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1007,TIMESTAMP'2021-10-18 00:00:00.0',39,1,0)");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  }

}
