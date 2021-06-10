package br.com.fiap.gs.lflTechnology.utils;

import br.com.fiap.gs.lflTechnology.model.Usuario;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthorizarionListner implements PhaseListener {
    @Override
    public void afterPhase(PhaseEvent event) {
        // se não está logado, vai para login
        FacesContext context = FacesContext.getCurrentInstance();

        Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

        final String page = context.getViewRoot().getViewId();
        System.out.println(page);

        if (page.equals("/login.xhtml") || page.equals("/user.xhtml")) return;

        if (usuario == null) {
            NavigationHandler navigation = context.getApplication().getNavigationHandler();
            navigation.handleNavigation(context, "", "login?faces-redirect=true");
            return;
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}

