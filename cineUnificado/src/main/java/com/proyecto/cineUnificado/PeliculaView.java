package com.proyecto.cineUnificado;

import com.proyecto.cineUnificado.modelo.Peliculas;
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
	private Peliculas peliculaSeleccionada;
	
	public PeliculaView(Peliculas pelicula) {		
		this.peliculaSeleccionada = pelicula;
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		Notification.show("Estas en pelicula ");
		
		VerticalLayout verticalGeneral = new VerticalLayout();
		verticalGeneral.setSizeFull();
		
		Panel panelPelicula = new Panel("Cinepolis");
		panelPelicula.setSizeFull();
		
		VerticalLayout verti = new VerticalLayout();
		verti.setSizeFull();
		
		HorizontalLayout detallePeli = new HorizontalLayout();
//		detallePeli.setSpacing(true);
		detallePeli.setSizeFull();
		
		HorizontalLayout horiImagePeli = new HorizontalLayout();		
		
		ThemeResource resourcePeli = new ThemeResource("images/" + this.peliculaSeleccionada.getImagen());
        Image imagePeli = new Image("", resourcePeli);
        
        horiImagePeli.addComponent(imagePeli);
        horiImagePeli.setComponentAlignment(imagePeli, Alignment.MIDDLE_CENTER);
        
        detallePeli.addComponent(horiImagePeli);
        detallePeli.setComponentAlignment(horiImagePeli, Alignment.MIDDLE_CENTER);
        
        
        VerticalLayout duraPeli = new VerticalLayout();
//        duraPeli.setSizeFull();
        
        Label nombre = new Label(this.peliculaSeleccionada.getNombre());
        Label duracion = new Label("Duracion: " + this.peliculaSeleccionada.getDuracion());
        Label genero = new Label("Genero: " + this.peliculaSeleccionada.getGenero());
        Label clasificacion = new Label("Clasificacion: " + this.peliculaSeleccionada.getClasificacion());
        Label calificacion = new Label("Calificacion: " + this.peliculaSeleccionada.getCalificacion());
        TextArea resena = new TextArea("Reseña ");
        resena.setWidth("500px");
        resena.setHeight("250px");
        resena.setValue(this.peliculaSeleccionada.getReseña());
        
        duraPeli.addComponent(nombre);
        duraPeli.addComponent(duracion);
        duraPeli.addComponent(genero);
        duraPeli.addComponent(clasificacion);
        duraPeli.addComponent(calificacion);
        duraPeli.addComponent(resena);
		
        detallePeli.addComponent(duraPeli);
        detallePeli.setComponentAlignment(duraPeli, Alignment.MIDDLE_CENTER);
        
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
	
	

}
