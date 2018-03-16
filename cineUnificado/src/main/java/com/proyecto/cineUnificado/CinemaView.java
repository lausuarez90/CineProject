package com.proyecto.cineUnificado;


import java.sql.SQLException;
import java.util.List;

import com.proyecto.cineUnificado.ImpInterface.ImpInterfaceCine;
import com.proyecto.cineUnificado.Interfaces.InterfaceCine;
import com.proyecto.cineUnificado.modelo.Cinema;
import com.proyecto.cineUnificado.modelo.Peliculas;
import com.proyecto.cineUnificado.persistencia.CinemaDAO;
import com.vaadin.cdi.CDIUI;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
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
	public final static String NAME = "peliculas";
	InterfaceCine interfaceCine;
	Cinema cinemaEncontrado;
	
	public CinemaView() {
		interfaceCine = new ImpInterfaceCine();	
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		String[] empresaSeleccionada = event.getParameters().split("/");
		String id = empresaSeleccionada[0];
		String nombre = empresaSeleccionada[1];
		String nit = empresaSeleccionada[2];
		
		
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		
		HorizontalLayout labelName = new HorizontalLayout();
		Label name = new Label();
        name.setCaption("Cartelera " +  nombre + " en Bogotá");
        name.addStyleName("mycaption");
        labelName.addComponent(name);
        
        ThemeResource resource = null;
        
        if (nombre.equals("Cinepolis")){
    		resource = new ThemeResource("images/cinepolis2.png");    		
    	}else if (nombre.equals("CineColombia")){
    		resource = new ThemeResource("images/cineColombia.jpg");    		
    	}else if (nombre.equals("CineMark")){
    		resource = new ThemeResource("images/cinemark.png");    	
    	}else if (nombre.equals("Procinal")){
    		resource = new ThemeResource("images/Procinal.png");    	
    	}
        
        Image logoEmpresa = new Image("", resource);
        
        VerticalLayout verticalPeli = new VerticalLayout();
        Label labelNombre = new Label(nombre);
        Label labelNit = new Label(nit);
        verticalPeli.addComponent(labelNombre);
        verticalPeli.addComponent(labelNit);
        
        HorizontalLayout horizontal = new HorizontalLayout();
        horizontal.setSizeFull();
        horizontal.addComponent(logoEmpresa);
        horizontal.setComponentAlignment(logoEmpresa, Alignment.TOP_LEFT);
        horizontal.addComponent(verticalPeli);
        horizontal.setComponentAlignment(verticalPeli, Alignment.TOP_RIGHT);
        
        VerticalLayout verticalGeneral = new VerticalLayout();
        verticalGeneral.addComponent(labelName);
        verticalGeneral.setComponentAlignment(labelName, Alignment.MIDDLE_CENTER);
        verticalGeneral.addComponent(horizontal);
        
               
		
		List<Cinema> cinemas = interfaceCine.consultarCinemasPorEmpresa(Integer.valueOf(id));
		BeanItemContainer<Cinema> container = new BeanItemContainer<Cinema>(Cinema.class);
		for (Cinema cinema : cinemas) {
			cinema.setIdEmpresa(Integer.valueOf(id));
			cinema.setNombreEmpresa(nombre);
			cinema.setNit(nit);
			container.addItem(cinema);			
		}
		
		ComboBox combobox = new ComboBox("Selecciona un cinema", container);
        
        combobox.setInvalidAllowed(false);
        combobox.setNullSelectionAllowed(false); 
        
        combobox.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        combobox.setItemCaptionPropertyId("nombre");
        
		
		combobox.setImmediate(true);
		
        HorizontalLayout horizontalCinema = new HorizontalLayout();       
        horizontalCinema.setSizeFull();       
        horizontalCinema.addComponent(combobox);
        horizontalCinema.setComponentAlignment(combobox, Alignment.TOP_LEFT);
        
               
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        
        Panel panel = new Panel(nombre);
        panel.setSizeUndefined();
        
       
        combobox.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				
				Object itemId = event.getProperty().getValue();
		        BeanItem<?> item = (BeanItem<?>) combobox.getItem(itemId);
		        
		        // Get the actual bean and use the data
		        Cinema cinema = (Cinema) item.getBean();

				System.out.println("selecciono " +cinema.getId() + " nombre " + cinema.getNombre());	
				
				cinemaEncontrado = interfaceCine.consultarPeliculasporCinema(cinema);
				
				 List<Peliculas> peliculas = cinemaEncontrado.getCartelera().getPeliculas();
			        
			        if (peliculas != null){
			        	horizontalLayout.removeAllComponents();
			        	
					for (Peliculas pelicula : peliculas) {

						ThemeResource resource = null;
						Button buttonCinepo = new Button();
						if (pelicula.getNombre().equals("3 anuncios por un crimen")){
							resource = new ThemeResource("images/anunciosCrimen.jpg");
						}else if (pelicula.getNombre().equals("Coco")){
							resource = new ThemeResource("images/coco.jpg");
						}else if (pelicula.getNombre().equals("Deseo de matar")){
							resource = new ThemeResource("images/deseoMatar.jpg");
						}else if (pelicula.getNombre().equals("El robo perfecto")){
							resource = new ThemeResource("images/roboPerfecto.jpg");
						}else if (pelicula.getNombre().equals("La forma del agua")){
							resource = new ThemeResource("images/formaAgua.jpg");
						}else if (pelicula.getNombre().equals("El cavernícola")){
							resource = new ThemeResource("images/cavernicola.jpg");
						}else if (pelicula.getNombre().equals("La maldición de la casa Winchester")){
							resource = new ThemeResource("images/maldicionCasa.jpg");
						}else if (pelicula.getNombre().equals("Noche de juegos")){
							resource = new ThemeResource("images/nocheJuegos.jpg");
						}else if (pelicula.getNombre().equals("Pantera Negra")){
							resource = new ThemeResource("images/panteraNegra.jpg");
						}
						
						
						buttonCinepo.setIcon(resource);
						buttonCinepo.setHeight("170px");
						buttonCinepo.setWidth("251px");
						buttonCinepo.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
						buttonCinepo.addStyleName(ValoTheme.BUTTON_BORDERLESS);
						buttonCinepo.addClickListener(e -> {							
							getUI().getNavigator().addView(PeliculaView.NAME, new PeliculaView(pelicula));
							getUI().getNavigator().navigateTo(PeliculaView.NAME);
						});

						horizontalLayout.addComponent(buttonCinepo);
						horizontalLayout.setComponentAlignment(buttonCinepo, Alignment.MIDDLE_CENTER);
						horizontalLayout.setMargin(true);
						horizontalLayout.setSpacing(true);

					}
			        }
								
			}
		});

       
        
//        Button buttonCinepo = new Button();
//        buttonCinepo.setIcon(new ThemeResource("images/cinepolis2.png"));
//        buttonCinepo.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
//        buttonCinepo.addStyleName(ValoTheme.BUTTON_BORDERLESS);
//        buttonCinepo.setHeight("160px");
//        buttonCinepo.setWidth("160px");
//        buttonCinepo.addClickListener( e -> {
//        	getUI().getNavigator().navigateTo(PeliculaView.NAME);
//        });
//        
//        Button buttonCineCol = new Button();
////        buttonCineCol.setIcon(new ThemeResource("images/cineColombia.jpg"));
//        buttonCineCol.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
//        buttonCineCol.addStyleName(ValoTheme.BUTTON_BORDERLESS);        
//        buttonCineCol.setHeight("160px");
//        buttonCineCol.setWidth("160px");
//        buttonCineCol.addClickListener( e -> {
//            layout.addComponent(new Label("Se selecciono Cinecolombia "));
//        });
//        
//        Button buttonCineMark = new Button();
////        buttonCineMark.setIcon(new ThemeResource("images/cinemark.png"));
//        buttonCineMark.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
//        buttonCineMark.addStyleName(ValoTheme.BUTTON_BORDERLESS);     
//        buttonCineMark.setHeight("71px");
//        buttonCineMark.setWidth("160px");
//        buttonCineMark.addClickListener( e -> {
//            layout.addComponent(new Label("Se selecciono CineMark "));
//        });
//        
//        Button buttonProcinal = new Button();
////        buttonProcinal.setIcon(new ThemeResource("images/Procinal.png"));
//        buttonProcinal.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
//        buttonProcinal.addStyleName(ValoTheme.BUTTON_BORDERLESS);   
//        buttonProcinal.setHeight("80px");
//        buttonProcinal.setWidth("160px");
//        buttonProcinal.addClickListener( e -> {
//            layout.addComponent(new Label("Se selecciono Procinal "));
//        });
        
        
//        horizontalLayout.addComponent(buttonCinepo);
//        horizontalLayout.setComponentAlignment(buttonCinepo, Alignment.MIDDLE_CENTER);
//        horizontalLayout.addComponent(buttonCineCol);
//        horizontalLayout.setComponentAlignment(buttonCineCol, Alignment.MIDDLE_CENTER);
//        horizontalLayout.addComponent(buttonCineMark);
//        horizontalLayout.setComponentAlignment(buttonCineMark, Alignment.MIDDLE_CENTER);
//        horizontalLayout.addComponent(buttonProcinal);
//        horizontalLayout.setComponentAlignment(buttonProcinal, Alignment.MIDDLE_CENTER);
//        horizontalLayout.setMargin(true);
//        horizontalLayout.setSpacing(true);
        
        panel.setContent(horizontalLayout);
        
        HorizontalLayout horiCinema = new HorizontalLayout();
        horiCinema.addComponent(panel);
        horiCinema.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
        
        HorizontalLayout horiPeliculas = new HorizontalLayout();
//        horiPeliculas.setSizeFull();
//        horiPeliculas.setMargin(true);
        horiPeliculas.setSpacing(true);
        horiPeliculas.addComponent(combobox);
        horiPeliculas.setComponentAlignment(combobox, Alignment.TOP_LEFT);
//        horiPeliculas.addComponent(horizontalCinema);
//        horiPeliculas.setComponentAlignment(horizontalCinema, Alignment.MIDDLE_LEFT);
       
        horiPeliculas.addComponent(horiCinema);
        horiPeliculas.setComponentAlignment(horiCinema, Alignment.MIDDLE_CENTER);
        
        layout.addComponent(verticalGeneral);
        layout.setComponentAlignment(verticalGeneral, Alignment.MIDDLE_CENTER);
        layout.addComponent(horiPeliculas);
//        layout.setComponentAlignment(horiPeliculas, Alignment.MIDDLE_CENTER);
        layout.setMargin(true);
        layout.setSpacing(true);
				
		setCompositionRoot(layout);
		
	}

}
