package webservices;

import entities.Module;


import metiers.ModuleBusiness;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ux")
public class ModuleApiRest {
    static ModuleBusiness helper = new ModuleBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules(){
        return Response.status(200)
                .entity(helper.getAllModules())
                .build();

    }
    @Path("/listParMatricle/{matricule}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByMatricule(@PathParam("matricule") String matricule){
        return Response.status(200)
                .entity(helper.getModuleByMatricule(matricule))
                .build();

    }
    @Path("/listParType/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModulesByType(@PathParam("type") Module.TypeModule type){
        return Response.status(200)
                .entity(helper.getModulesByType(type))
                .build();

    }
    @Path("/modify/{matricule}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateModule(
            @PathParam("matricule") String matricule,
            Module updatedModule) {
        if (helper.updateModule(matricule, updatedModule)) {
            return Response.status(200)
                    .entity("Successfully modified")
                    .build();
        } else {
            return Response.status(404)
                    .entity("Module not found")
                    .build();
        }
    }
    @Path("/delete/{matricule}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteModule(@PathParam("matricule") String matricule){
        if(helper.deleteModule(matricule)){
            return Response.status(201)
                    .entity("Successfully delete")
                    .build();
        }
        else {
            return Response.status(400).entity("Erreur").build();
        }
    }
    @Path("/add")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response addModule(Module module){
        if(helper.addModule(module)){
            return Response.status(200)
                    .entity("Successfully added")
                    .build();
        }
        else {
            return Response.status(400).entity("Erreur").build();
        }
    }

}
