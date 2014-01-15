package domain;

public class Unterricht {
	private Integer l_id;
	private String k_id;
	private String tagstunde;
	
	public Unterricht(Integer l_id, String k_id, String tagstunde) {
		setL_id(l_id);
		setK_id(k_id);
		setTagstunde(tagstunde);
	}
	
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	public String getK_id() {
		return k_id;
	}
	public void setK_id(String k_id) {
		this.k_id = k_id;
	}
	public String getTagstunde() {
		return tagstunde;
	}
	public void setTagstunde(String tagstunde) {
		this.tagstunde = tagstunde;
	}
	
	
	
	
}
