package com.proyecto.cineUnificado;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.themes.ValoTheme;

@CDIView(EmpresaView.NAME)
public class EmpresaView extends CustomComponent implements View {
	
	public final static String NAME = "";
	
	public EmpresaView() {
		
		final VerticalLayout layout = new VerticalLayout();
        
        Panel panel = new Panel("Mis Cines");
        panel.setSizeUndefined();
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();        
        
        Label name = new Label();
        name.setCaption("Bienvenidos aqui puedes revisar la cartelera de tus cinemas favoritos!!!");
        name.addStyleName("mycaption");

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
        
        HorizontalLayout horizontal = new HorizontalLayout();
        horizontal.addComponent(name);        
        
        layout.addComponent(horizontal);
        layout.setComponentAlignment(horizontal, Alignment.MIDDLE_CENTER);
        layout.addComponent(panel);
        layout.setComponentAlignment(panel, Alignment.TOP_CENTER);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setCompositionRoot(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
