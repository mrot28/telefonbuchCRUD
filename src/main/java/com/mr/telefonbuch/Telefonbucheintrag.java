package com.mr.telefonbuch;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telefonbucheintrag {
	private @Id @GeneratedValue Long id;
	private String telefonNr;
	private String name;
	private String adresse;
	
	Telefonbucheintrag() {}
	
	public Telefonbucheintrag(String telefonNr, String name, String adresse) {
		this.telefonNr = telefonNr;
		this.name = name;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, id, name, telefonNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefonbucheintrag other = (Telefonbucheintrag) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(telefonNr, other.telefonNr);
	}

	@Override
	public String toString() {
		return "Telefonbucheintrag [id=" + id + ", telefonNr=" + telefonNr + ", name=" + name + ", adresse=" + adresse
				+ "]";
	}
	

}
