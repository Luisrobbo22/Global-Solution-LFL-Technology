package br.com.fiap.gs.lflTechnology.controller;

import br.com.fiap.gs.lflTechnology.dao.HotelDAO;
import br.com.fiap.gs.lflTechnology.dao.impl.HotelDaoImpl;
import br.com.fiap.gs.lflTechnology.exception.CommitException;
import br.com.fiap.gs.lflTechnology.exception.EntityNotFoundException;
import br.com.fiap.gs.lflTechnology.model.Hotel;
import br.com.fiap.gs.lflTechnology.singleton.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("hotel")
public class HotelController {

    private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
    private HotelDAO hotelDAO = new HotelDaoImpl(em);


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {
        em.getTransaction().begin();

        List<Hotel> hoteis = hotelDAO.getAll();
        em.close();
        return Response.status(Response.Status.OK).entity(hoteis).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Hotel hotel) {
        if (hotel == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        try {
            em.getTransaction().begin();
            em.persist(hotel);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        em.close();
        return Response.status(Response.Status.CREATED).entity(hotel).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Integer id) {
        Hotel hotel = null;
        em.getTransaction().begin();
        try {
            hotel = em.find(Hotel.class, id);
            if (hotel == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.close();
        return Response.status(Response.Status.OK).entity(hotel).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") Integer id, Hotel hotel) {
        em.getTransaction().begin();
        try {
            hotel = em.find(Hotel.class, id);
            if (hotel == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        hotel.setId(id);
        em.merge(hotel);
        em.close();
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        Hotel hotel = null;
        em.getTransaction().begin();

        //hotel = em.find(Hotel.class, id);
        hotel = hotelDAO.findById(id);
        if (hotel == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        em.remove(hotel);
        em.getTransaction().commit();
//        try {
//            hotelDAO.delete(id);
//            hotelDAO.commit();
//        } catch (EntityNotFoundException | CommitException e) {
//            e.printStackTrace();
//        }
        em.close();
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
