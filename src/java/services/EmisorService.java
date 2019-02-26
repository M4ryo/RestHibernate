/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import entities.Emisor;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.EmisorModel;

/**
 * REST Web Service
 *
 * @author Desarrollo
 */
@Path("emisor")
public class EmisorService {

    Gson json = new Gson();
    EmisorModel rs = new EmisorModel();
    Emisor emisor = new Emisor();

    @Context
    private UriInfo context;

    public EmisorService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "{id:1}";
    }

    @GET
    @Path("getEmisores")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmisores() {
        List<Emisor> lst = new ArrayList();
        lst = rs.dbAction("", null, 0);
        return json.toJson(lst);
    }

    @GET
    @Path("getEmisorById")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmisorById(@QueryParam("idEmisor") int idEmisor) {
        List<Emisor> lst = new ArrayList();
        lst = rs.dbAction("get", null, idEmisor);
        return json.toJson(lst);
    }

    @POST
    @Path("insertEmisor")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertEmisor(@QueryParam("emisor") String emisor) {
        rs.dbAction("add", json.fromJson(emisor, Emisor.class), 0);
    }

    @DELETE
    @Path("deleteEmisor")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteEmisor(@QueryParam("emisor") String emisor) {
        rs.dbAction("delete", json.fromJson(emisor, Emisor.class), 0);
    }

    @PUT
    @Path("updateEmisor")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmisor(@QueryParam("emisor") String emisor) {
        rs.dbAction("update", json.fromJson(emisor, Emisor.class), 0);
    }
}
