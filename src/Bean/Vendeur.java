package Bean;

import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "vendeur")
@XmlType(propOrder = { "nom", "prenom", "dateNaissance", "telephone", "email", "password" })
public class Vendeur extends Utilisateur {

	private List<Article> listArticles;

	public Vendeur() {

	}

	public Vendeur(Integer id, String nom, String prenom, String dateNaissance, String telephone, String email,
			String password) {
		super(id, nom, prenom, dateNaissance, telephone, email, password);
	}

	public Vendeur(String nom, String prenom, String dateNaissance, String telephone, String email, String password) {
		super(nom, prenom, dateNaissance, telephone, email, password);
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

}
