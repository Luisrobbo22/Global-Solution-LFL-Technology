package br.com.fiap.gs.lflTechnology.view;

import br.com.fiap.gs.lflTechnology.dao.*;
import br.com.fiap.gs.lflTechnology.dao.impl.*;
import br.com.fiap.gs.lflTechnology.model.Hotel;
import br.com.fiap.gs.lflTechnology.model.Quarto;
import br.com.fiap.gs.lflTechnology.singleton.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import java.util.List;

public class PesquisaTeste {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        /**
         * Implementando todos os DAOs
         */
        HotelDAO hotelDAO = new HotelDaoImpl(em);
        UsuarioDAO usuarioDAO = new UsuarioDaoImpl(em);
        QuartoDAO quartoDAO = new QuartoDaoImpl(em);
        PrecoDAO precoDAO = new PrecoDaoImpl(em);
        EnderecoDAO enderecoDAO = new EnderecoDaoImpl(em);


        // Listar hoteis por cidade e estado
        List<Hotel> hoteis = hotelDAO.buscarHotelPorCidadeEEstado("Rio de Janeiro", "RJ");
        System.out.println("Listando todos os Hoteis por cidade e estado");
        for (Hotel h : hoteis) {
            System.out.println("Nome hotel: " + "" + h.getNome() +
                    "\nNome da cidade do hotel: " + h.getEndereco().getCidade() +
                    "\nNome estado do hotel: " + h.getEndereco().getEstado());
            System.out.println("---------------------------------------");
        }

        // Buscar todos os quartos e ordenar pelo menor preço
        List<Quarto> quartos = quartoDAO.buscarTodosOsQuartosEOrdernarPorMenorPreco();
        System.out.println("Buscando todos os quartos e ordenando pelo menor preço");
        for (Quarto q : quartos) {
            System.out.println("Nome do quarto: " + q.getNome() +
                    "\nValor do quarto: " + q.getPreco().getPrecoDiaria());
            System.out.println("---------------------------------------");
        }

        // Listar todos os Hoteis
        hoteis = hotelDAO.getAll();
        System.out.println("Listando todos os hoteis");
        for (Hotel h : hoteis) {
            System.out.println("Nome hotel: " + "" + h.getNome());
        }


    }
}
