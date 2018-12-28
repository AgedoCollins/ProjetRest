package Bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "vendeur")
@XmlType(propOrder = { "nom", "prenom", "dateNaissance", "telephone", "email", "password" })
public class Vendeur extends Utilisateur{

	public Vendeur() {
		
	}
	
	public Vendeur(Integer id, String nom, String prenom, String dateNaissance, String telephone, String email, String password) {
		super(id, nom, prenom, dateNaissance, telephone,  email, password);
	}
	
	public Vendeur(String nom, String prenom, String dateNaissance, String telephone, String email, String password) {
		super(nom, prenom, dateNaissance, telephone,  email, password);
	}
}
