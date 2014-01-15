
package at.spengergasse.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;


public class Haupt {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

			//conn = DriverManager.getConnection("jdbc:derby:firstdb;create=true");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbcuebung?user=root&password=");
			//createSampleTables(conn);
			
			

			Statement stmt = conn.createStatement();
			
			//Hier sind die normalen Statements
			
			System.out.println("---Start---");
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM klasse;");

			showRS(rs,1);
			
			System.out.println("---Insert von 5a---");
			
			stmt.executeUpdate("insert into klasse values('5a')");
			
			rs = stmt.executeQuery("SELECT * FROM klasse;");

			showRS(rs,1);

			stmt.executeUpdate("delete from klasse where id = '5a';");
			
			System.out.println("---jetzt nach delete von 5a---");
			
			rs = stmt.executeQuery("SELECT * FROM klasse;");

			showRS(rs,1);
			stmt.close();
			//preparedtatements hier
			
			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from schueler;");
			
			rs = pstmt.executeQuery();
			
			
			System.out.println("---schueler mit preparedstatement selectet---");
			showRS(rs,4);
			
			pstmt.close();
			
			rs.close();
			

		} catch (Exception e) {
			// For the sake of this tutorial, let's keep exception handling simple
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

	private static void showRS(ResultSet rs, int num)
	{
		
		try {
			while ( rs.next() ) {
				//System.out.printl( "%s, %s, %s %n", rs.getString(1));
				for(int i = 1; i<=num; ++i)
					System.out.print(rs.getString(i) + " ");
				System.out.println("");
			}
		} catch (SQLException e) {
			//Wahrscheinlich war der angegebene int-Parameter groesser als die Spaltenanzahl
			System.out.println("FEHLER");
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	/*private static void createSampleTables(Connection con) {
		try (Statement stmt = con.createStatement()){
			//stmt.execute("set schema 'SAMP'");

			try {
				stmt.executeUpdate("DROP TABLE app.posts");
			} catch (SQLException e) {
				; // do nothing
			}

			// Create empty tables.
			stmt.execute("CREATE TABLE app.posts ("
					+ "post_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "postname VARCHAR(50),"
					+ "comments VARCHAR(512) NOT NULL"
					+ ")"
					);

			stmt.executeUpdate("INSERT INTO app.posts(postname, comments) VALUES('Fred Jones', 'Derby is cool, and the Eclipse plugin makes using it a snap!')");
			stmt.executeUpdate("INSERT INTO app.posts(postname, comments) VALUES('Wilma Harris', 'Tomcat lets me register DataSources using a file in my web project? That''s great stuff!')");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	
}
