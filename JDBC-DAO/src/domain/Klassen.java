package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Klassen {
	private String id;
	private final List<Unterricht> unterrichtsliste = new ArrayList<>();
	
	public Klassen(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id){
		if(id!=null)
			this.id= id;
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
		return "Klassen-ID = " + id;
	}
}
