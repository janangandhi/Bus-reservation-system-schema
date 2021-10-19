package app;

import connection.ConnectDb;
import constants.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

  Connection c;

  public Driver() {
    c = ConnectDb.getInstance().getDbConnection();
    if (c == null) {
      System.out.println("Unable to connect to Database!!");
      System.exit(1);
    }
  }

  public void setUpTables() {
    try {
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
      stmt.close();
    } catch (Exception e) {
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
      stmt.executeUpdate("INSERT INTO BUS (BUS_ID,NAME,SOURCE,DESTINATION) VALUES (1007,'Bus7','San Francisco','Berkeley')");
      stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1001,TIMESTAMP'2021-10-16 00:00:00.0',100,0,10)");
      stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1002,TIMESTAMP'2021-10-16 00:00:00.0',27,13,0)");
      stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1003,TIMESTAMP'2021-10-15 00:00:00.0',35,5,0)");
      stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1004,TIMESTAMP'2021-10-14 00:00:00.0',40,0,29)");
      stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1005,TIMESTAMP'2021-10-17 00:00:00.0',40,0,0)");
      stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES  (1006,TIMESTAMP'2021-10-15 00:00:00.0',19,21,0)");
      stmt.executeUpdate("INSERT INTO BUS_STATUS (BUS_ID,BUS_DATE,BOOKED_SEATS,AVAILABLE_SEATS,WAIT_LISTED_SEATS) VALUES (1007,TIMESTAMP'2021-10-18 00:00:00.0',39,1,0)");
      stmt.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }


  public void printAllTables() {
    try {
      ResultSet resultSet;
      Statement stmt = c.createStatement();
      System.out.println("****************************************************");
      System.out.println("Select * from Bus");
      resultSet = stmt.executeQuery("select * from Bus");
      printBusData(resultSet);
      System.out.println("****************************************************");

      System.out.println("****************************************************");
      System.out.println("Select * from passenger");
      resultSet = stmt.executeQuery("select * from passenger");
      printPassengerData(resultSet);
      System.out.println("****************************************************");
      System.out.println("****************************************************");
      System.out.println("Select * from route");
      resultSet = stmt.executeQuery("select * from route");
      printRouteData(resultSet);
      System.out.println("****************************************************");
      System.out.println("****************************************************");
      System.out.println("Select * from reservation");
      resultSet = stmt.executeQuery("select * from reservation");
      printReservationData(resultSet);
      System.out.println("****************************************************");
      System.out.println("****************************************************");
      System.out.println("Select * from bus_status");
      resultSet = stmt.executeQuery("select * from bus_status");
      printBusStatusData(resultSet);
      System.out.println("*****************************************************");
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  private void printBusData(ResultSet resultSet) throws SQLException {
    while (resultSet.next()) {
      System.out.println("BusId: " + resultSet.getInt("bus_id") + " Bus Name: " + resultSet.getString("name")
              + " Source: " + resultSet.getString("source") + "Destination: " + resultSet.getString("destination"));
    }
  }

  private void printPassengerData(ResultSet resultSet) throws SQLException {
    while (resultSet.next()) {
      System.out.println("Passenger Id: " + resultSet.getInt("passenger_id") + " Bus Id: " + resultSet.getInt("bus_id")
              + " reservation id: " + resultSet.getInt("reservation_id") + " Name: " + resultSet.getString("name")
              + " Age : " + resultSet.getInt("Age") + " Email: " + resultSet.getInt("Email"));
    }
  }

  private void printRouteData(ResultSet resultSet) throws SQLException {
    while (resultSet.next()) {
      System.out.println("Route Id: " + resultSet.getInt("route_id") + " Bus Id: " + resultSet.getInt("bus_id") + " Arrival time: "
              + resultSet.getString("Arrival_Time") + " Route marker: " + resultSet.getString("route_marker"));
    }
  }

  private void printReservationData(ResultSet resultSet) throws SQLException {
    while (resultSet.next()) {
      System.out.println("Reservation Id: " + resultSet.getInt("reservation_id") + " Cost: " + resultSet.getInt("cost")
              + " Status: " + resultSet.getString("status") + " Departure date: " + resultSet.getDate("departure_date"));
    }
  }

  private void printBusStatusData(ResultSet resultSet) throws SQLException {
    while (resultSet.next()) {
      System.out.println("Bus Id: " + resultSet.getInt("bus_id") + " Available count: " + resultSet.getInt("AVAILABLE_SEATS")
              + " Booked count: " + resultSet.getInt("BOOKED_SEATS") + " Waiting_Count " + resultSet.getInt("WAIT_LISTED_SEATS")
              + " Bus Date: " + resultSet.getDate("BUS_DATE"));
    }
  }

}
