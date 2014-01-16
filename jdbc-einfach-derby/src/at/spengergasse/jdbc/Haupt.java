package at.spengergasse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;

public class Haupt 
{
        public static void main(String[] args)
        {
                Connection conn = null;
                try 
                {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbcuebung?user=root&password=");
                        Statement stmt = conn.createStatement();

                        System.out.println("-- Start --");
                        
                        ResultSet rs = stmt.executeQuery("SELECT * FROM flugzeugtyp;");

                        showRS(rs,1);
                        
                        System.out.println("-- INSERT zum Flugzeugtyp Kleinflugzeug --");
                        
                        stmt.executeUpdate("insert into flugzeugtyp values('Kleinflugzeug')");
                        
                        rs = stmt.executeQuery("SELECT * FROM flugzeugtyp;");

                        showRS(rs,1);

                        stmt.executeUpdate("delete from flugzeugtyp where bezeichnung = 'Kleinflugzeug';");
                        
                        System.out.println("-- Löschung vom Flugzeugtyp Kleinflugzeug durchgeführt --");
                        
                        rs = stmt.executeQuery("SELECT * FROM flugzeugtyp;");

                        showRS(rs,1);
                        stmt.close();                        
                        
                        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from flugzeug;");
                        
                        rs = pstmt.executeQuery();

                        System.out.println("-- Flugzeuge mit PreparedStatement ausgegeben --");
                        showRS(rs,4);
                        
                        pstmt.close();
                        
                        rs.close();
                } 
                catch (Exception e) 
                {
                        e.printStackTrace();
                } 
                finally 
                {
                        if (conn != null) 
                        {
                                try 
                                {
                                        conn.close();
                                } 
                                catch (SQLException ignore) 
                                {
                                }
                        }
                }
        }
        
        private static void showRS(ResultSet rs, int num)
        {
                try 
                {
                        while ( rs.next() ) 
                        {
                                //System.out.printl( "%s, %s, %s %n", rs.getString(1));
                                for(int i = 1; i<=num; ++i)
                                {
                                        System.out.print(rs.getString(i) + " ");
                                }
                                System.out.println("");
                        }
                } 
                catch (SQLException e) 
                {
                        System.out.println("Fehler!!");
                } 
                catch (Exception e)
                {
                        System.out.println(e.getMessage());
                }
        }
}
