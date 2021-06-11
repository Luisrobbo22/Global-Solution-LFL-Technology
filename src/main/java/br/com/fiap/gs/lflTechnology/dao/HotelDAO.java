package br.com.fiap.gs.lflTechnology.dao;

import br.com.fiap.gs.lflTechnology.model.Hotel;

import java.util.List;

public interface HotelDAO extends GenericDAO<Hotel, Integer> {

    public List<Hotel> buscarHotelPorCidadeEEstado(String cidade, String estado);

    public List<Hotel> getAll();

    public Hotel findById(Integer id);

    List<Hotel> buscarHoteisPorAvaliacoes(int estrelas);
}
