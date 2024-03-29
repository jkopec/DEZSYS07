package at.ernhofer.kopec.dezsys07;

import org.springframework.data.annotation.Id;

public class Data {

	@Id private String id;

	private String suchbegriff;
	private String beschreibung;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}

	public String getSuchbegriff() {
		return suchbegriff;
	}

	public void setSuchbegriff(String suchbegriff) {
		this.suchbegriff = suchbegriff;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
}
