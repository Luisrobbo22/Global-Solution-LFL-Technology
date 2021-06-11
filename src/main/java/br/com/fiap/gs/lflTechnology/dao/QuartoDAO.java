package br.com.fiap.gs.lflTechnology.dao;

import br.com.fiap.gs.lflTechnology.model.Quarto;

import java.util.List;

public interface QuartoDAO extends GenericDAO<Quarto, Integer> {


    public List<Quarto> buscarTodosOsQuartosEOrdernarPorMenorPreco();
}
