package domain;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Lehrer {
	private Integer id;
	private String vorname;
	private String nachname;
	
	private final List<Unterricht> unterrichtsliste = new ArrayList<>();
	
	public Lehrer(int id, String vorname, String nachname){
	
		setId(id);
		setVorname(vorname);
		setNachname(nachname);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		if(vorname != null)
			this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		if(nachname != null)
			this.nachname = nachname;
	}

	public List<Unterricht> getUnterrichtsliste() {
		return Collections.unmodifiableList(unterrichtsliste);
	}
	
	public void addUnterricht(Unterricht u) {
		if (u == null) {
			throw new IllegalArgumentException("Null!");
		}
		unterrichtsliste.add(u);
	}
	
	
	public String toString(){
		return "SchuelerNr: " + id + "; " + nachname + " " + vorname + ";";
	}
}
