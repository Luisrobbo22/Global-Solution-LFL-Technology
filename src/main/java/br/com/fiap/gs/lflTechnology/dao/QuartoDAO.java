package br.com.fiap.gs.lflTechnology.dao;

import br.com.fiap.gs.lflTechnology.model.Quarto;

import java.math.BigDecimal;
import java.util.List;

public interface QuartoDAO extends GenericDAO<Quarto, Integer> {


    public List<Quarto> buscarTodosOsQuartosEOrdernarPorMenorPreco();

    public List<Quarto> buscarTodosQuartosEOrdenarPorMaiorPreco();

    public List<Quarto> buscarQuartosPorValorMaximo(BigDecimal valor);
}
