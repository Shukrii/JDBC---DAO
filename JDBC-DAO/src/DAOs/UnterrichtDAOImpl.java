package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Lehrer;
import domain.Unterricht;

public class UnterrichtDAOImpl implements UnterrichtDAO{

	@Override
	public int insert(Connection con, Unterricht u) {
		final String sql = "INSERT INTO unterricht(l_id, k_id, tagstunde) VALUES (?, ?, ?)";

		try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, u.getL_id());
			ps.setString(2, u.getK_id());
			ps.setString(3, u.getTagstunde());
			
			return ps.executeUpdate();			
		}catch (SQLException ex) {
			System.err.println("Fehler bei Unterricht.Insert");
		}
		
		return 0;
	}

	@Override
	public int update(Connection con, Unterricht u) {
		final String sql =	"UPDATE unterricht SET l_id = ?, k_id = ?, tagstunde = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, u.getL_id());
			ps.setString(2, u.getK_id());
			ps.setString(3, u.getTagstunde());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Fehler bei Unterricht.Update");
			
		}

		return 0;
	}

	@Override
	public List<Unterricht> findAllUnterricht(Connection con) {
		final String sql = "SELECT * FROM unterricht";
		List<Unterricht> unterricht = new ArrayList();
		
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					unterricht.add(new Unterricht(rs.getInt("l_id"), rs.getString("k_id"), rs.getString("nachname")));
				}
			} catch (SQLException ex) {
				System.err.println("Fehler bei Unterricht.findAllUnterricht");
			}
		} catch (SQLException ex) {
			System.err.println("Fehler bei Unterricht.findAllUnterricht");
		}
		return unterricht;
	}

	@Override
	public int delete(Connection con, Unterricht u) {
		final String sql = "delete FROM unterricht where l_id=? and k_id=? and tagstunde=?";
		
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, u.getL_id());
			ps.setString(2, u.getK_id());
			ps.setString(3,"'" + u.getTagstunde() + "'");

			return ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Fehler bei Unterricht.delete");
			
		}
		
		return 0;
	}

}
