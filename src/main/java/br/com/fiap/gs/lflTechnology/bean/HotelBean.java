package br.com.fiap.gs.lflTechnology.bean;

import br.com.fiap.gs.lflTechnology.dao.HotelDAO;
import br.com.fiap.gs.lflTechnology.dao.impl.HotelDaoImpl;
import br.com.fiap.gs.lflTechnology.exception.CommitException;
import br.com.fiap.gs.lflTechnology.model.Hotel;
import br.com.fiap.gs.lflTechnology.singleton.EntityManagerFactorySingleton;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named
@RequestScoped
public class HotelBean {

    private Hotel hotel = new Hotel();
    private final FacesContext context = FacesContext.getCurrentInstance();
    private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
    private HotelDAO dao = new HotelDaoImpl(em);

    public void save() {
        em.getTransaction().begin();
        dao.create(hotel);
        em.getTransaction().commit();
        em.close();

        context.addMessage(null, new FacesMessage("Hotel cadastrado com sucesso"));
    }

    public List<Hotel> getHoteis() {
        List<Hotel> hoteis = new HotelDaoImpl(em).getAll();

        if (hoteis.isEmpty() || hoteis == null) {
            context.addMessage(null, new FacesMessage("Não há hoteis cadastrado!"));
        }

        return new HotelDaoImpl(em).getAll();
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
