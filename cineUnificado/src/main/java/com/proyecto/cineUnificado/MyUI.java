package com.proyecto.cineUnificado;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import com.proyecto.cineUnificado.persistencia.ConexionBD;
import com.proyecto.cineUnificado.persistencia.EmpresasDAO;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.cdi.URLMapping;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@CDIUI("")
@Push
@Theme("mytheme")
public class MyUI extends UI {

	private static final long serialVersionUID = 1L;

	@Inject
    CDIViewProvider viewProvider;
	

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	Navigator navigator = new Navigator(this, this);
    	navigator.addView(CinemaView.NAME, new CinemaView());
    	
    	
    	navigator.addProvider(viewProvider);
    	navigator.navigateTo(EmpresaView.NAME);    	
    	
    	   	
    }

  
}
