package webservices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.UniteEnseignement;
import metiers.*;
import metiers.UniteEnseignementBusiness;
@Path("/ue")
public class UniteEnsRestAPI {
    //getListUEs
    static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUe(){
      return Response.status(200)
              .entity(helper.getListeUE())
              .build();

    }
    @Path("/add")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUniteEnseignement(UniteEnseignement ue){
        if(helper.addUniteEnseignement(ue)){
            return Response.status(201)
                    .entity("Successfully added")
                    .build();
        }
        else {
            return Response.status(400).entity("Erreur").build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")
    public Response getUEByCode(@PathParam("code")int code){
        return Response.status(200).entity(helper.getUEByCode(code)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getUEBySemestre(@QueryParam("semestre") int semestre){
        return Response.status(200).entity(helper.getUEBySemestre(semestre)).build();
    }
    @Path("/modify/{code}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateUniteEnseignement( @PathParam("code") int code,
                                             UniteEnseignement ue){
        if (helper.updateUniteEnseignement(code, ue)) {
            return Response.status(200)
                    .entity("Successfully modified")
                    .build();
        }
        else {
            return Response.status(400).entity("Erreur").build();
        }
    }
    @Path("/delete/{code}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUniteEnseignement(@PathParam("code") int code){
        if(helper.deleteUniteEnseignement(code)){
            return Response.status(201)
                    .entity("Successfully delete")
                    .build();
        }
        else {
            return Response.status(400).entity("Erreur").build();
        }
    }

}
