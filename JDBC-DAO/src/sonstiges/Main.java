
package sonstiges;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import DAOs.*;
import domain.*;

public class Main {

	public static void main(String[] args) {
		KlassenDAOImpl    k = new KlassenDAOImpl();
		LehrerDAOImpl     l = new LehrerDAOImpl();
		UnterrichtDAOImpl u = new UnterrichtDAOImpl();
		
		
		//Testdatensätze
		Lehrer l1 = new Lehrer(1, "John", "Johnas");
		Lehrer l2 = new Lehrer(2, "Max", "Min");
		Lehrer l3 = new Lehrer(2, "Jason", "Statham");

		
		Klassen k1 = new Klassen ("1BFIT");
		Klassen k2 = new Klassen ("3ASHT");
		
		Unterricht u1 = new Unterricht(l1.getId(), k1.getId(),"UO1");
		Unterricht u2 = new Unterricht(l1.getId(), k1.getId(),"UO2");
		Unterricht u3 = new Unterricht(l2.getId(), k1.getId(),"UO4");

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcuebung?user=root&password=");
			Statement stmt = con.createStatement();
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM klassen;");
		
			System.out.println("---Nach Insert von den 2 Klassen---");
			rs = stmt.executeQuery("SELECT * FROM klassen;");
			k.insert(con, k1);
			k.insert(con, k2);
			showRS(rs,1);
			
			l.insert(con, l1);
			l.insert(con, l2);
			l.insert(con, l3);
			System.out.println("---Nach Insert von den 3 Lehrern---");
			rs = stmt.executeQuery("SELECT * FROM lehrer;");
			showRS(rs,3);
			
			u.insert(con, u1);
			u.insert(con, u2);
			u.insert(con, u3);
			System.out.println("---Nach Insert von den 3 Unterricht---");
			rs = stmt.executeQuery("SELECT * FROM unterricht;");
			showRS(rs,3);
			
			System.out.println("---Nach Update von Klasse 1---");
			rs = stmt.executeQuery("Update klassen set id = '1BFIT' where id = '1BFIT';");
			showRS(rs,1);
			
			System.out.println("---Nach Update von Lehrer 2---");
			rs = stmt.executeQuery("Update lehrer set Vorname = 'John' where id = 'Johnas';");
			showRS(rs,3);
			
			System.out.println("---Nach Update von Unterricht 2---");
			rs = stmt.executeQuery("Update Unterricht set tagstunde = 'DI1' where tagstunde = 'UO2';");
			showRS(rs,3);
			
			System.out.println("---Nach Delete von Unterricht 2---");
			rs = stmt.executeQuery("delete from Unterricht where tagstunde = 'DI1'");
			showRS(rs,3);
			
			System.out.println("---Truncate von unterricht---");
			rs = stmt.executeQuery("truncate unterricht");
			try{
				rs.first();
			}catch(SQLException ex){
				System.out.println("Im Catch-Block nach rs.first() -> tabelle leer");
			}
			
			System.out.println("---löschen aller Klassen---");
			rs = stmt.executeQuery("delete from klassen where 1 = 1");
			try{
				rs.first();
			}catch(SQLException ex){
				System.out.println("Im Catch-Block nach rs.first() -> tabelle leer");
			}
			
			System.out.println("---löschen aller lehrer---");
			rs = stmt.executeQuery("delete from lehrer where 1 = 1");
			try{
				rs.first();
			}catch(SQLException ex){
				System.out.println("Im Catch-Block nach rs.first() -> tabelle leer");
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e){
			System.out.println("Connection funktioniert nicht");
		} catch (Exception e){
			System.err.println("Fehler bei 'Class.forName(\"com.mysql.jdbc.Driver\").newInstance();'");
		}
		
		
	}
	
	private static void showRS(ResultSet rs, int num)
	{
		//verbessertes ShowRS
		try {
			while ( rs.next() ) {
				ResultSetMetaData rsmd = rs.getMetaData();
				
				for(int i = 1; i<=num; ++i)
					System.out.print(rsmd.getColumnName(i) + ":" + rs.getString(i) + " ;");
				System.out.println("");
			}
		} catch (SQLException e) {
			//Wahrscheinlich war der angegebene int-Parameter groesser als die Spaltenanzahl
			System.out.println("FEHLER");
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
