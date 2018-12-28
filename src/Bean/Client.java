package Bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "client")
@XmlType(propOrder = { "nom", "prenom", "dateNaissance", "telephone", "email", "password" })
public class Client extends Utilisateur{

	public Client() {
		
	}
	
	public Client(Integer id, String nom, String prenom, String dateNaissance, String telephone, String email, String password) {
		super(id, nom, prenom, dateNaissance, telephone,  email, password);
	}
	
	public Client(String nom, String prenom, String dateNaissance, String telephone, String email, String password) {
		super(nom, prenom, dateNaissance, telephone,  email, password);
	}
}
