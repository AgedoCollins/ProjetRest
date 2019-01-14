package REST_Classes;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Bean.Article;
import Bean.Client;
import Bean.Commande;
import DAO.DAOArticle;
import DAO.DAOCommande;
import DAO.DAOFactory;

@Path("commandes")
public class REST_Commande {
	private DAOFactory daoFactory = new DAOFactory();
	private DAOCommande daoCommande = (DAOCommande) daoFactory.getDaoCommande();

	@GET
	@Path("lastId")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandeForLastId() {
		daoFactory = new DAOFactory();
		DAOCommande daoCommande = (DAOCommande) daoFactory.getDaoCommande();
		List<Commande> listCommandes = daoCommande.findAllForLastId();
		if (listCommandes.size() > 0)
			return Response.status(Status.OK).entity(listCommandes).build();
		else
			return Response.status(Status.OK).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandes(@QueryParam("id") String id) {
		List<Commande> listCommandes = daoCommande.findCommandeByClient(Integer.parseInt(id));
		if (listCommandes.size() > 0)
			return Response.status(Status.OK).entity(listCommandes).build();
		else
			return Response.status(Status.OK).build();
	}
	
	@POST
	@Path("ajoutercommande")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostCom(@FormParam("dateCommande") String dateCommande, @FormParam("id_utilisateur") int id) {
		daoFactory = new DAOFactory();
		Commande commande = new Commande();
		commande.setDateCommande(dateCommande);
		Client client = new Client();
		client.setId(id);
		return Response.status(Status.OK).entity(daoCommande.create(commande, client)).build();
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostLigneCom(@FormParam("id_commande") int id_commande, @FormParam("id_article") int id_article,
			@FormParam("quantite") int quantite) {
		daoFactory = new DAOFactory();
		Commande commande = new Commande();
		commande.setId(id_commande);
		Article article = new Article();
		article.setId(id_article);
		return Response.status(Status.OK).entity(daoCommande.createLigneCommande(commande, article, quantite)).build();
	}

	@PUT
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateCommande(@FormParam("id_article") int id_article, @FormParam("id_commande") int id_commande) {
		Article art = new Article();
		art.setId(id_article);
		art.setId_commande(id_commande);
		if (daoCommande.updateTraite(art))
			return Response.status(Status.OK).entity("ok").build();
		else
			return Response.status(Status.OK).entity("ko").build();
	}
}
