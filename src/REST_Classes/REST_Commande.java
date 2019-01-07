package REST_Classes;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Bean.Article;
import Bean.Commande;
import DAO.DAOArticle;
import DAO.DAOCommande;
import DAO.DAOFactory;

@Path("commandes")
public class REST_Commande {
	private DAOFactory daoFactory= new DAOFactory();
	private DAOCommande daoCommande = (DAOCommande) daoFactory.getDaoCommande();
	
	/*@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommande(@PathParam("id") String id) {
		Commande commande = new Commande();
		commande.setId(Integer.parseInt(id));
		Commande comm = daoCommande.find(commande);
		if(comm!=null)
			return Response.status(Status.OK).entity(comm).build();
		else
			return Response.status(Status.OK).build();
			
	}*/
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommande() {
		daoFactory= new DAOFactory();
		DAOCommande daoCommande = (DAOCommande) daoFactory.getDaoCommande();
		List<Commande> listCommandes = daoCommande.findAll();
		if(listCommandes.size()>0)
			return Response.status(Status.OK).entity(listCommandes).build();
		else
			return Response.status(Status.OK).build();		
			
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommandes(@QueryParam("id") String id) {
		List<Commande> listCommandes = daoCommande.findCommandeByClient(Integer.parseInt(id));
		if(listCommandes.size()>0)
			return Response.status(Status.OK).entity(listCommandes).build();
		else
			return Response.status(Status.OK).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticleByCommande(@PathParam("id") int id) {
		daoFactory= new DAOFactory();
		DAOArticle daoArticle = (DAOArticle) daoFactory.getDaoArticle();
		List<Article> listArticles = daoArticle.findByIdCommande(id);	
		if(listArticles.size()>0)
			return Response.status(Status.OK).entity(listArticles).build();
		else
			return Response.status(Status.OK).entity(null).build();		
			
	}
	
	/*@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostArt(
			@FormParam("datecommande") String dateCommande,
			 @FormParam("idClient") int idClient,
			 @FormParam("idArticle") int idArticle,
			 @FormParam("quantite") int quantite,
			 @FormParam("traite") int traite) {
		fact= new DaoFactory();
		Commande commande = new Commande();
		commande.setDate(dateCommande);
		commande.setQuantite(quantite);
		commande.setTraite(traite);
		Article article = new Article();
		article.setId(idArticle);
		commande.setArticle(article);
		Client client = new Client();
		client.setId(idClient);
		commande.setClient(client);
		return Response.status(Status.OK).entity(dao_com.create(commande)).build();	
	}*/
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes("application/x-www-form-urlencoded")
	public Response updateCommande(
				@FormParam("id_commande") int id_commande,
				@FormParam("etat") String etat) {
		Commande com = new Commande();
		com.setId(id_commande);
		com.setEtat(etat);
		if(daoCommande.updateTraite(com))
			return Response.status(Status.OK).entity("ok").build();	
		else
			return Response.status(Status.OK).entity("ko").build();	
	}
	
	
}
