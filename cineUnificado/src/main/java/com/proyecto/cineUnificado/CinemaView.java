package com.proyecto.cineUnificado;


import com.vaadin.cdi.CDIUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@CDIUI(value=CinemaView.NAME)
public class CinemaView extends CustomComponent implements View{

	private static final long serialVersionUID = 1L;
	public final static String NAME = "pelicula";
	
	public CinemaView() {
		
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		
		Label name = new Label();
        name.setCaption("Cartelera Cinepolis en Bogotá");
        name.addStyleName("mycaption");
        
        ThemeResource resource = new ThemeResource("images/cinepolis2.png");
        Image logoEmpresa = new Image("", resource);
        
        HorizontalLayout horizontal = new HorizontalLayout();
        horizontal.setSizeFull();
        horizontal.addComponent(logoEmpresa);
        horizontal.setComponentAlignment(logoEmpresa, Alignment.TOP_LEFT);
        horizontal.addComponent(name); 
		
		Panel panel = new Panel("Cinepolis");
        panel.setSizeUndefined();
        
        VerticalLayout verticalCinema = new VerticalLayout();        
        
        ComboBox combobox = new ComboBox("Selecciona un cinema");
        combobox.setInvalidAllowed(false);
        combobox.setNullSelectionAllowed(false);
        combobox.addItems("Calima", "Hayuelos", "Multiplaza");
        
        verticalCinema.addComponent(combobox);
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        
        Button buttonCinepo = new Button();
        buttonCinepo.setIcon(new ThemeResource("images/cinepolis2.png"));
        buttonCinepo.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        buttonCinepo.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        buttonCinepo.setHeight("160px");
        buttonCinepo.setWidth("160px");
        buttonCinepo.addClickListener( e -> {
        	getUI().getNavigator().navigateTo(CinemaView.NAME);
        });
        
        Button buttonCineCol = new Button();
//        buttonCineCol.setIcon(new ThemeResource("images/cineColombia.jpg"));
        buttonCineCol.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        buttonCineCol.addStyleName(ValoTheme.BUTTON_BORDERLESS);        
        buttonCineCol.setHeight("160px");
        buttonCineCol.setWidth("160px");
        buttonCineCol.addClickListener( e -> {
            layout.addComponent(new Label("Se selecciono Cinecolombia "));
        });
        
        Button buttonCineMark = new Button();
//        buttonCineMark.setIcon(new ThemeResource("images/cinemark.png"));
        buttonCineMark.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        buttonCineMark.addStyleName(ValoTheme.BUTTON_BORDERLESS);     
        buttonCineMark.setHeight("71px");
        buttonCineMark.setWidth("160px");
        buttonCineMark.addClickListener( e -> {
            layout.addComponent(new Label("Se selecciono CineMark "));
        });
        
        Button buttonProcinal = new Button();
//        buttonProcinal.setIcon(new ThemeResource("images/Procinal.png"));
        buttonProcinal.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        buttonProcinal.addStyleName(ValoTheme.BUTTON_BORDERLESS);   
        buttonProcinal.setHeight("80px");
        buttonProcinal.setWidth("160px");
        buttonProcinal.addClickListener( e -> {
            layout.addComponent(new Label("Se selecciono Procinal "));
        });
        
        
        horizontalLayout.addComponent(buttonCinepo);
        horizontalLayout.setComponentAlignment(buttonCinepo, Alignment.MIDDLE_CENTER);
        horizontalLayout.addComponent(buttonCineCol);
        horizontalLayout.setComponentAlignment(buttonCineCol, Alignment.MIDDLE_CENTER);
        horizontalLayout.addComponent(buttonCineMark);
        horizontalLayout.setComponentAlignment(buttonCineMark, Alignment.MIDDLE_CENTER);
        horizontalLayout.addComponent(buttonProcinal);
        horizontalLayout.setComponentAlignment(buttonProcinal, Alignment.MIDDLE_CENTER);
        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);
        
        panel.setContent(horizontalLayout);
        
        HorizontalLayout horiPeliculas = new HorizontalLayout();
        horiPeliculas.addComponent(verticalCinema);
        horiPeliculas.setMargin(true);
        horiPeliculas.setSpacing(true);
        horiPeliculas.addComponent(panel);
        
        layout.addComponent(horizontal);
        layout.setComponentAlignment(horizontal, Alignment.MIDDLE_CENTER);
        layout.addComponent(horiPeliculas);
        layout.setComponentAlignment(horiPeliculas, Alignment.MIDDLE_LEFT);
        layout.setMargin(true);
        layout.setSpacing(true);
				
		setCompositionRoot(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Estas en cine");
		
	}

}
