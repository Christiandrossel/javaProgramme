import java.sql.*;
import java.lang.*;

public class JDBC{
	
	public JDBC(){
		Connection con;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			String URL = "jdbc:oracle:thin:@<IPADRESSE>/dbws07";
			con = DriverManager.getConnection(URL, "USER", "password");
			String Query="SELECT TeilName FROM Bauteil";
			ResultSet rset=stmnt.executeQuery(Query);
			while(rset.net())
				System.out.println(rset.getString(1));
			stmnt.close();
		}catch(Exception e){System.out.println(e); e.printStackTrace();}