package DAOs;

import java.sql.Connection;
import java.util.List;

import domain.Klassen;
import domain.Lehrer;
import domain.Unterricht;

public abstract interface LehrerDAO {

	public abstract int insert(Connection con, Lehrer l);

	public abstract int update(Connection con, Lehrer l);
	
	public abstract int delete(Connection con, Lehrer l);

	public abstract List<Lehrer>findAllLehrerWithUnterricht(Connection con);

	public abstract List<Lehrer> findAllUnterricht(Connection con);
	
}
