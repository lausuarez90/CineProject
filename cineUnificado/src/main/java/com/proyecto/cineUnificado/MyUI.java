package com.proyecto.cineUnificado;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();        
        
        final Label name = new Label();
        name.setCaption("Tus cines");

        Button buttonCinepo = new Button();
        buttonCinepo.setIcon(new ThemeResource("images/cinepolis2.png"));
        buttonCinepo.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        buttonCinepo.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        buttonCinepo.setHeight("160px");
        buttonCinepo.setWidth("160px");
        buttonCinepo.addClickListener( e -> {
            layout.addComponent(new Label("Se selecciono Cinepolis "));
        });
        
        Button buttonCineCol = new Button();
        buttonCineCol.setIcon(new ThemeResource("images/cineColombia.jpg"));
        buttonCineCol.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        buttonCineCol.addStyleName(ValoTheme.BUTTON_BORDERLESS);        
        buttonCineCol.setHeight("160px");
        buttonCineCol.setWidth("160px");
        buttonCineCol.addClickListener( e -> {
            layout.addComponent(new Label("Se selecciono Cinecolombia "));
        });
        
        Button buttonCineMark = new Button();
        buttonCineMark.setIcon(new ThemeResource("images/cinemark.png"));
        buttonCineMark.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        buttonCineMark.addStyleName(ValoTheme.BUTTON_BORDERLESS);     
        buttonCineMark.setHeight("71px");
        buttonCineMark.setWidth("160px");
        buttonCineMark.addClickListener( e -> {
            layout.addComponent(new Label("Se selecciono CineMark "));
        });
        
        Button buttonProcinal = new Button();
        buttonProcinal.setIcon(new ThemeResource("images/Procinal.png"));
        buttonProcinal.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        buttonProcinal.addStyleName(ValoTheme.BUTTON_BORDERLESS);   
        buttonProcinal.setHeight("80px");
        buttonProcinal.setWidth("160px");
        buttonProcinal.addClickListener( e -> {
            layout.addComponent(new Label("Se selecciono Procinal "));
        });
        
       
        horizontalLayout.addComponent(buttonCinepo);
        horizontalLayout.addComponent(buttonCineCol);
        horizontalLayout.addComponent(buttonCineMark);
        horizontalLayout.addComponent(buttonProcinal);
        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);
        
        HorizontalLayout horizontal = new HorizontalLayout();
        horizontal.addComponent(name);        
        
        layout.addComponent(horizontal);
        layout.setComponentAlignment(horizontal, Alignment.MIDDLE_CENTER);
        layout.addComponent(horizontalLayout);
        layout.setComponentAlignment(horizontalLayout, Alignment.TOP_CENTER);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
