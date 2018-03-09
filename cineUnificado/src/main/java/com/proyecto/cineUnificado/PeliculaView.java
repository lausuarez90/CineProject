package com.proyecto.cineUnificado;

import com.vaadin.cdi.CDIUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@CDIUI(value=PeliculaView.NAME)
public class PeliculaView extends CustomComponent implements View{
	
	private static final long serialVersionUID = 1L;
	public final static String NAME = "pelicula";
	
	public PeliculaView() {
		
		VerticalLayout verticalGeneral = new VerticalLayout();
		verticalGeneral.setSizeFull();
		
		Panel panelPelicula = new Panel("Cinepolis");
		panelPelicula.setSizeFull();
		
		VerticalLayout verti = new VerticalLayout();
		verti.setSizeFull();
		
		HorizontalLayout detallePeli = new HorizontalLayout();
		detallePeli.setSpacing(true);
		
		ThemeResource resourcePeli = new ThemeResource("images/cinepolis2.png");
        Image imagePeli = new Image("", resourcePeli);
        
        detallePeli.addComponent(imagePeli);
        detallePeli.setComponentAlignment(imagePeli, Alignment.MIDDLE_CENTER);
        
        VerticalLayout duraPeli = new VerticalLayout();
        
        Label nombre = new Label("Nombre");
        Label duracion = new Label("Duracion: " + "12");
        Label genero = new Label("Genero: " + "Terror");
        Label clasificacion = new Label("Clasificacion: " + "A12");
        Label calificacion = new Label("Calificacion: " + "Bueno");
        TextArea resena = new TextArea("Reseña ");
        
        duraPeli.addComponent(nombre);
        duraPeli.addComponent(duracion);
        duraPeli.addComponent(genero);
        duraPeli.addComponent(clasificacion);
        duraPeli.addComponent(calificacion);
        duraPeli.addComponent(resena);
		
        detallePeli.addComponent(duraPeli);
        detallePeli.setComponentAlignment(duraPeli, Alignment.MIDDLE_LEFT);
        
        Panel panelHorarios = new Panel("Horarios");
        
        VerticalLayout horarios = new VerticalLayout();
        
        VerticalLayout salas = new VerticalLayout();
        
        Label nombreSala = new Label("Digital " + "idioma");
        
        salas.addComponent(nombreSala);
        
        HorizontalLayout horariosSala = new HorizontalLayout();
        horariosSala.setSpacing(true);
        
        Label hora1 = new Label("12:30 pm");
        Label hora2 = new Label("03:15 pm");
        Label hora3 = new Label("06:00 pm");
        
        horariosSala.addComponent(hora1);
        horariosSala.addComponent(hora2);
        horariosSala.addComponent(hora3);
        
        salas.addComponent(horariosSala);
        
        horarios.addComponent(salas);
        
        panelHorarios.setContent(horarios);
        
		verti.addComponent(detallePeli);
		verti.addComponent(panelHorarios);
		
		panelPelicula.setContent(verti);
		
		verticalGeneral.addComponent(panelPelicula);
		
		setCompositionRoot(verticalGeneral);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Estas en pelicula");		
	}
	
	

}
