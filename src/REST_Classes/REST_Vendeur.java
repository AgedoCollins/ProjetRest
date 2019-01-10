package REST_Classes;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Bean.Vendeur;
import DAO.DAOVendeur;

import DAO.DAOFactory;

@Path("vendeurs")
public class REST_Vendeur {
	private DAOFactory daoFactory= null;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVendeur(@QueryParam("email") String email,@QueryParam("password") String password) {
		daoFactory= new DAOFactory();
		DAOVendeur daoVendeur = (DAOVendeur) daoFactory.getDaoVendeur();
		Vendeur vendeur = daoVendeur.login(email, password);
		if(vendeur!=null)
			return Response.status(Status.OK).entity(vendeur).build();
		else
			return Response.status(Status.OK).build();
			
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllVendeur() {
		daoFactory= new DAOFactory();
		DAOVendeur daoVendeur = (DAOVendeur) daoFactory.getDaoVendeur();
		List<Vendeur> listVendeurs = daoVendeur.findAll();	
		if(listVendeurs.size()>0)
			return Response.status(Status.OK).entity(listVendeurs).build();
		else
			return Response.status(Status.OK).build();		
			
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createVendeur(@FormParam("nom") String nom,
								 @FormParam("prenom") String prenom,
								 @FormParam("dateNaissance") String dateNaissance,
								 @FormParam("telephone") String telephone,
								 @FormParam("email") String email,
								 @FormParam("password") String password){
		daoFactory = new DAOFactory();
		Vendeur vendeur = new Vendeur();
		vendeur.setNom(nom);
		vendeur.setPrenom(prenom);
		vendeur.setDateNaissance(dateNaissance);
		vendeur.setTelephone(telephone);
		vendeur.setEmail(email);
		vendeur.setPassword(password);
		DAOVendeur daoVendeur = (DAOVendeur) daoFactory.getDaoVendeur();
		return Response.status(Status.OK).entity(daoVendeur.create(vendeur)).build();
	}
}

