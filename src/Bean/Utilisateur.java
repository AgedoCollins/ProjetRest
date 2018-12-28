package Bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "utilisateur")
@XmlType(propOrder = { "nom", "prenom", "dateNaissance", "telephone", "email", "password" })
public class Utilisateur {

	protected Integer id;
	protected String nom;
	protected String prenom;
	protected String dateNaissance;
	protected String telephone;
	protected String email;
	protected String password;

	public Utilisateur() {

	}

	public Utilisateur(Integer id, String nom, String prenom, String dateNaissance, String telephone, String email,
			String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}

	public Utilisateur(String nom, String prenom, String dateNaissance, String telephone, String email,
			String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}

	@XmlAttribute(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public String toJson() {
		String retour = "";
		retour += "{";

		retour += "\"id\":";
		retour += this.getId();
		retour += ",";
		retour += "\"nom\":";
		retour += "\"" + this.getNom() + "\"";
		retour += ",";
		retour += "\"prenom\":";
		retour += "\"" + this.getPrenom() + "\"";
		retour += ",";
		retour += "\"dateNaissance\":";
		retour += "\"" + this.getDateNaissance() + "\"";
		retour += ",";
		retour += "\"telephone\":";
		retour += "\"" + this.getTelephone() + "\"";
		retour += ",";
		retour += "\"email\":";
		retour += "\"" + this.getEmail() + "\"";
		retour += ",";
		retour += "\"password\":";
		retour += "\"" + this.getPassword() + "\"";
		retour += "}";

		return retour;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", telephone=" + telephone + ", email=" + email + ", password=" + password + "]";
	}

}
