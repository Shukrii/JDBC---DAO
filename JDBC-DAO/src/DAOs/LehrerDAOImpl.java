package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Lehrer;
import domain.Unterricht;

public class LehrerDAOImpl implements LehrerDAO{

	@Override
	public int insert(Connection con, Lehrer l) {
		final String sql = "INSERT INTO lehrer(ID, vorname, nachname) VALUES (?, ?, ?)";
		
		
		try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, l.getId());
			ps.setString(2, l.getVorname());
			ps.setString(3, l.getNachname());
			
			return ps.executeUpdate();
			
		}catch (SQLException ex) {
			System.out.println("Datensatz bereits vorhanden");
		}
		
		return 0;
	}

	@Override
	public int update(Connection con, Lehrer l) {
		final String sql =	"UPDATE lehrer SET id = ?, vorname = ?, nachname = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, l.getId());
			ps.setString(2, l.getVorname());
			ps.setString(3, l.getNachname());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Fehler bei Lehrer.Update");
			
		}

		return 0;
	}
	
	@Override
	public List<Lehrer> findAllLehrerWithUnterricht(Connection con) {
		final String sql = "select * from lehrer, unterricht where lehrer.id = unterricht.l_id";
		Map<Integer, Lehrer> lehrer = new HashMap<Integer, Lehrer>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Integer id = rs.getInt("id");
					String vorname = rs.getString("vorname");
					String nachname = rs.getString("nachname");
					Lehrer l = lehrer.get(id);
					if(l == null){
						if(vorname == null || nachname == null)
							System.out.println("Ein Feld von der Tabelle Lehrer ist null, kein Lehrer wird erstellt");
						else
							lehrer.put(id, new Lehrer(id,vorname,nachname));
					}
					l.addUnterricht(new Unterricht(rs.getInt("l_id"),rs.getString("k_id"),rs.getString("tagstunde")));
				}
			} catch (SQLException ex) {
				System.err.println("Fehler bei Lehrer.findAllLehrerWithUnterricht");
			}
		} catch (SQLException ex) {
			System.err.println("Fehler bei Lehrer.findAllLehrerWithUnterricht");
		}
		return new ArrayList<Lehrer>(lehrer.values());
	}

	@Override
	public List<Lehrer> findAllUnterricht(Connection con) {
			
		final String sql = "SELECT * FROM lehrer";
		List<Lehrer> lehrer = new ArrayList();
		
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					lehrer.add(new Lehrer(rs.getInt("id"), rs.getString("vorname"), rs.getString("nachname")));
				}
			} catch (SQLException ex) {
				System.err.println("Fehler bei Lehrer.findAllLehrer");
			}
		} catch (SQLException ex) {
			System.err.println("Fehler bei Lehrer.findAllLehrer");
		}
		return lehrer;
	}

	@Override
	public int delete(Connection con, Lehrer l) {
		final String sql = "delete FROM lehrer where id=? and vorname='?' and nachname='?'";
		
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, l.getId());
			ps.setString(2, l.getVorname());
			ps.setString(3, l.getNachname());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Fehler bei Lehrer.delete"); //Vielleicht später implementieren, dass die FKs in Unterricht gelöscht werden?
			
		}
		
		return 0;
	}

}
