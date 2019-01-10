package Bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "commande")
@XmlType(propOrder = { "id", "dateCommande", "etat" })
public class Commande {
	private int id;
	private String dateCommande;
	private String etat;

	public Commande() {

	}

	public Commande(int id, String dateCommande, String etat) {
		this.id = id;
		this.dateCommande = dateCommande;
	}

	public Commande(String dateCommande, String etat) {
		this.dateCommande = dateCommande;
	}

	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlAttribute(name = "dateCommande")
	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	@XmlAttribute(name = "etat")
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
