package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Klassen;
import domain.Unterricht;

public class KlassenDAOImpl implements KlassenDAO{

	@Override
	public int insert(Connection con, Klassen u) {
		final String sql = "INSERT INTO klassen VALUES (?)";

		try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, u.getId());
			
			return ps.executeUpdate();			
		}catch (SQLException ex) {
			System.out.println("Datensatz bereits vorhanden");
		}
		
		return 0;
	}

	@Override
	public int update(Connection con, Klassen u) {
		final String sql =	"UPDATE klassen SET l_id = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, u.getId());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Fehler bei Klassen.Update");
			
		}

		return 0;
	}

	@Override
	public int delete(Connection con, Klassen u) {
		final String sql = "delete FROM klassen where id=?";
		
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, u.getId());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Fehler bei Klassen.delete ... Vielleicht musst du zuerst alle FKs, die auf diese Tabelle referenziert entfernen.");
			
		}
		
		return 0;
	}

	@Override
	public List<Klassen> findAllKlassen(Connection con) {
		final String sql = "SELECT * FROM unterricht";
		List<Klassen> klassen = new ArrayList();
		
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					klassen.add(new Klassen(rs.getString("Id")));
				}
			} catch (SQLException ex) {
				System.err.println("Fehler bei Klassen.findAllKlassen"); //Vielleicht später implementieren, dass die FKs in Unterricht gelöscht werden?
			}
		} catch (SQLException ex) {
			System.err.println("Fehler bei Klassen.findAllKlassen");
		}
		return klassen;
	}

}
