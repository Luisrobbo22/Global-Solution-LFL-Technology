package br.com.fiap.gs.lflTechnology.view;

import br.com.fiap.gs.lflTechnology.dao.*;
import br.com.fiap.gs.lflTechnology.dao.impl.*;
import br.com.fiap.gs.lflTechnology.exception.CommitException;
import br.com.fiap.gs.lflTechnology.model.*;
import br.com.fiap.gs.lflTechnology.model.enums.TipoPagamento;
import br.com.fiap.gs.lflTechnology.singleton.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CadastroTeste2 {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        /**
         * Instanciando os DAOs
         */
        HotelDAO hotelDAO = new HotelDaoImpl(em);
        EnderecoDAO enderecoDAO = new EnderecoDaoImpl(em);
        CondicaoPagamentoDAO condicaoPagamentoDAO = new CondicaoPagamentoDaoImpl(em);
        QuartoDAO quartoDAO = new QuartoDaoImpl(em);
        PrecoDAO precoDAO = new PrecoDaoImpl(em);
        UsuarioDAO usuarioDAO = new UsuarioDaoImpl(em);

        /**
         * Instanciando as Entidades
         */

        Hotel hotel = new Hotel("Nomaa Hotel",
                "Hotel top de Curitiba", "(41)30879595)",
                "nomaahotel@email.com",4, null);

        Endereco endereco = new Endereco("Rua Gutemberg", "Curitiba",
                "PR", "80420030", "Brasil", null);

        Quarto quarto = new Quarto("Suite Master", "Suite top master com hidromassagem", 38, "Deluxe",
                15, hotel, null);

        CondicaoPagamento condicaoPagamento = new CondicaoPagamento("Pagamento da Reserva do Hotel Nomaa", 1, TipoPagamento.CARTAO_DEBITO);
        List<CondicaoPagamento> condicaoPagamentoList = new ArrayList<>();
        condicaoPagamentoList.add(condicaoPagamento);

        Preco preco = new Preco(new BigDecimal(149.90), Calendar.getInstance(), quarto, condicaoPagamentoList);

        hotel.addQuartos(quarto);
        hotel.setEndereco(endereco);
        quarto.setPreco(preco);
        quarto.setHotel(hotel);

        Usuario usuario = new Usuario("Ricardo Santos", "ricardo@email.com", "Ricardo1234", new Date());

        try {
            quartoDAO.create(quarto);
            usuarioDAO.create(usuario);
            quartoDAO.commit();
            usuarioDAO.commit();
            System.out.println("Quarto cadastrado com sucesso");
            System.out.println("Usuário cadastrado com sucesso");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        em.close();
        EntityManagerFactorySingleton.getInstance().close();

    }
}
