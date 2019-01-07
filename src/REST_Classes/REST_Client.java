package REST_Classes;

import java.sql.Date;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Bean.Client;
import DAO.DAOClient;
import DAO.DAOFactory;
import DAO.DAOUtilisateur;

@Path("clients")
public class REST_Client {
	private DAOFactory daoFactory= null;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClient(@QueryParam("email") String email,@QueryParam("password") String password) {
		daoFactory= new DAOFactory();
		DAOClient daoClient = (DAOClient) daoFactory.getDaoClient();
		Client client = daoClient.login(email, password);
		if(client!=null)
			return Response.status(Status.OK).entity(client).build();
		else
			return Response.status(Status.OK).build();
			
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createClient(@FormParam("nom") String nom,
								 @FormParam("prenom") String prenom,
								 @FormParam("dateNaissance") String dateNaissance,
								 @FormParam("telephone") String telephone,
								 @FormParam("email") String email,
								 @FormParam("password") String password){
		daoFactory = new DAOFactory();
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setDateNaissance(dateNaissance);
		client.setTelephone(telephone);
		client.setEmail(email);
		client.setPassword(password);
		DAOClient dao_client = (DAOClient) daoFactory.getDaoClient();
		return Response.status(Status.OK).entity(dao_client.create(client)).build();
	}
	
	@Path("Update")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response UpdateClient(
			@FormParam("nom") String nom,
			 @FormParam("prenom") String prenom,
			 @FormParam("dateNaissance") String dateNaissance,
			 @FormParam("telephone") String telephone,
			 @FormParam("email") String email,
			 @FormParam("password") String password,
			 @FormParam("id")int id) throws SQLException{
		
		daoFactory= new DAOFactory();
		DAOClient daoClient = (DAOClient) daoFactory.getDaoClient();
		Client cli = new Client();
		cli.setNom(nom);
		cli.setPrenom(prenom);
		cli.setDateNaissance(dateNaissance);
		cli.setEmail(email);
		cli.setPassword(password);
		cli.setTelephone(telephone);
		cli.setId(id);
		boolean res = daoClient.update(cli);
		if(res) {
			return Response.status(Status.OK).build();
		}
		
		else {
			
		}
			return Response.status(Status.OK).entity("-1").build();
			
	}
	
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteClient() {
		
		return Response.status(Status.OK).entity("mmmmmmmmmmmmmmm").build();
	}
	
	
	
	
}

