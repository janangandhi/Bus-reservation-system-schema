import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConn {
	
	private Connection getConn() throws ClassNotFoundException, SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclcdb","mydb", "mydb");
		
	}
	
	public void addStudent(String fname, String lname, Date dob, int major, String graduation) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO STUDENTS(FIRST_NAME, LAST_NAME, DOB, MAJOR, GRADUATED) "
				+ "VALUES (?, ?, ?, ?, ?)";
		Connection c = getConn();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setDate(3, dob);
		ps.setInt(4, major);
		ps.setString(5, graduation);
		ps.execute();
		ps.close();
		c.close();
	}
	
	public void updateStudent(int student_id, String fname, String lname, Date dob, Integer major, String graduation) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE STUDENTS SET FIRST_NAME = " + fname;
		if(lname != null) sql += ", LAST_NAME = " + lname;
		if(dob != null) sql += ", DOB = " + dob;
		if(major != null) sql += ", MAJOR = " + major;
		if(graduation != null) sql += ", GRADUATED = " + graduation;
		sql += "WHERE ID = " + student_id;
		
		Connection c = getConn();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, student_id);
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	
	public void deleteStudent(int student_id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM STUDENTS WHERE ID = ? ";
		Connection c = getConn();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, student_id);
		ps.executeUpdate();
		ps.close();
		c.close();
	}
	

}
