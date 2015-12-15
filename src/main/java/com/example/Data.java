package com.example;

import org.springframework.data.annotation.Id;

public class Data {

	@Id private String id;

	private String suchbegriff;
	private String beschreibung;

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
