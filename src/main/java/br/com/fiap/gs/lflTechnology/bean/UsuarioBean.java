package br.com.fiap.gs.lflTechnology.bean;

import br.com.fiap.gs.lflTechnology.dao.UsuarioDAO;
import br.com.fiap.gs.lflTechnology.dao.impl.UsuarioDaoImpl;
import br.com.fiap.gs.lflTechnology.exception.CommitException;
import br.com.fiap.gs.lflTechnology.model.Usuario;
import br.com.fiap.gs.lflTechnology.singleton.EntityManagerFactorySingleton;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

@Named
@RequestScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    private final FacesContext context = FacesContext.getCurrentInstance();
    private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
    private UsuarioDAO dao = new UsuarioDaoImpl(em);

    public String login() {
        boolean exist = dao.exist(usuario);
        if (exist) {
            Object usuario = context.getExternalContext().getSessionMap().put("usuario", this.usuario);
            return "index?faces-redirect=true";
        }
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.addMessage(null, new FacesMessage(SEVERITY_ERROR, "Login inválido", "Login inválido"));
        return "user?faces-redirect=true";
    }

    public String logout() {
        context.getExternalContext().getSessionMap().remove("usuario");
        return "login?faces-redirect=true";

    }

    public void cadastrar() {
        try {
            context.getExternalContext().redirect("user.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void save() {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        System.out.println("salvando usuario....");
        context.addMessage(null, new FacesMessage("Usuário cadastrado com sucesso"));
    }

    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new UsuarioDaoImpl(em).getAll();

        if (usuarios.isEmpty() || usuario == null) {
            context.addMessage(null, new FacesMessage("Não há usuário cadastrado!"));
        }

        return new UsuarioDaoImpl(em).getAll();
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
