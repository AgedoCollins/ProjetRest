package Bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "commande")
@XmlType(propOrder = { "id", "dateCommande", "etat"/*, "total", "dateLivraison" */})
public class Commande {
	private int id;
	private String dateCommande;
	private String etat;
	//private double total;
//	private Date dateLivraison;

	public Commande() {

	}

	public Commande(int id, String dateCommande, String etat/*, double total, Date dateLivraison*/) {
		this.id = id;
		this.dateCommande = dateCommande;
		this.etat = etat;
		//this.total = total;
		//this.dateLivraison = dateLivraison;
	}

	public Commande(String dateCommande, String etat/*, double total, Date dateLivraison*/) {
		this.dateCommande = dateCommande;
		this.etat = etat;
		//this.total = total;
		//this.dateLivraison = dateLivraison;
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

	/*@XmlAttribute(name = "total")
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@XmlAttribute(name = "dateLivraison")
	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}*/

}
