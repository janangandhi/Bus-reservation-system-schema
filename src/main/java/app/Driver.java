package app;

import connection.ConnectDb;
import constants.Constants;

import java.sql.*;
import java.util.Scanner;

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
      stmt.executeUpdate("INSERT INTO ROUTE (BUS_ID, ARRIVAL_TIME, ROUTE_MARKER) VALUES (1001, '23:45', '101' )");
      stmt.executeUpdate("INSERT INTO ROUTE (BUS_ID, ARRIVAL_TIME, ROUTE_MARKER) VALUES (1002, '00:25', '580' )");
      stmt.executeUpdate("INSERT INTO ROUTE (BUS_ID, ARRIVAL_TIME, ROUTE_MARKER) VALUES (1003, '13:30', '140' )");
      stmt.executeUpdate("INSERT INTO ROUTE (BUS_ID, ARRIVAL_TIME, ROUTE_MARKER) VALUES (1004, '08:00', '280' )");
      stmt.executeUpdate("INSERT INTO ROUTE (BUS_ID, ARRIVAL_TIME, ROUTE_MARKER) VALUES (1005, '18:00', '880' )");
      stmt.executeUpdate("INSERT INTO ROUTE (BUS_ID, ARRIVAL_TIME, ROUTE_MARKER) VALUES (1006, '12:00', '420' )");
      stmt.executeUpdate("INSERT INTO ROUTE (BUS_ID, ARRIVAL_TIME, ROUTE_MARKER) VALUES (1007, '20:00', '505' )");
      stmt.executeUpdate("INSERT INTO RESERVATION VALUES(10001, 10, 'Booked', TO_DATE('10-01-2021','MM-DD-YYYY'), TO_DATE('2021-11-22','YYYY-MM-DD'))");
      stmt.executeUpdate("INSERT INTO RESERVATION VALUES(10002, 20, 'Booked', TO_DATE('10-02-2021','MM-DD-YYYY'), TO_DATE('2021-11-24','YYYY-MM-DD'))");
      stmt.executeUpdate("INSERT INTO RESERVATION VALUES(10003, 10, 'Waiting', TO_DATE('09-01-2021','MM-DD-YYYY'), TO_DATE('2021-11-22','YYYY-MM-DD'))");
      stmt.executeUpdate("INSERT INTO RESERVATION VALUES(10004, 15, 'Cancelled', TO_DATE('04-10-2021','MM-DD-YYYY'), TO_DATE('2021-11-25','YYYY-MM-DD'))");
      stmt.executeUpdate("INSERT INTO RESERVATION VALUES(10005, 40, 'Waiting', TO_DATE('07-10-2021','MM-DD-YYYY'), TO_DATE('2021-11-26','YYYY-MM-DD'))");
      stmt.executeUpdate("INSERT INTO PASSENGER (PASSENGER_ID,RESERVATION_ID, BUS_ID, NAME, GENDER, AGE, EMAIL) VALUES (1010, 10001, 1001, 'JOHN','M',25,'john@gmail.com' )");
      stmt.executeUpdate("INSERT INTO PASSENGER (PASSENGER_ID,RESERVATION_ID, BUS_ID, NAME, GENDER, AGE, EMAIL) VALUES (1011,10002, 1002, 'PETER','F',25,'peter@gmail.com' )");
      stmt.executeUpdate("INSERT INTO PASSENGER (PASSENGER_ID,RESERVATION_ID, BUS_ID, NAME, GENDER, AGE, EMAIL) VALUES (1012,10003, 1003, 'FRANK','O',25,'frank@gmail.com' )");
      stmt.executeUpdate("INSERT INTO PASSENGER (PASSENGER_ID,RESERVATION_ID, BUS_ID, NAME, GENDER, AGE, EMAIL) VALUES (1013,10004, 1004, 'TOM','F',25,'tom@gmail.com' )");
      stmt.executeUpdate("INSERT INTO PASSENGER (PASSENGER_ID,RESERVATION_ID, BUS_ID, NAME, GENDER, AGE, EMAIL) VALUES (1014,10005, 1005, 'HARRY','O',25,'harry@gmail.com' )");
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


  public void acceptQueries(){
    Scanner sc = new Scanner(System.in);
    while(true){
       String input = sc.nextLine();
       if(input.equalsIgnoreCase("EXIT")){
         break;
       }
       executeAndPrintQuery(input);
    }

  }

  private void executeAndPrintQuery(String query){
    try{
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while(rs.next()){
        for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
          System.out.print("|"+rs.getString(i)+"| ");
        }
        System.out.println();
      }
    } catch (Exception e){
      System.out.println("Error in executing query "+query);
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
              + " Gender: " + resultSet.getString("gender") + " Age : " + resultSet.getInt("Age")
              + " Email: " + resultSet.getString("Email"));
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
