package com.proyecto.cineUnificado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.proyecto.cineUnificado.ImpInterface.ImpInterfaceCine;
import com.proyecto.cineUnificado.Interfaces.InterfaceCine;
import com.proyecto.cineUnificado.modelo.Horario;
import com.proyecto.cineUnificado.modelo.Peliculas;
import com.proyecto.cineUnificado.modelo.Sala;
import com.vaadin.cdi.CDIUI;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
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
	InterfaceCine interfaceCine;
	private Peliculas peliculaSeleccionada;
	
	public PeliculaView(Peliculas pelicula) {		
		this.peliculaSeleccionada = pelicula;
		interfaceCine = new ImpInterfaceCine();
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Notification.show("Estas en pelicula ");
		String[] cinema = event.getParameters().split("/");
		String cinemaId = cinema[0];
		
		VerticalLayout verticalGeneral = new VerticalLayout();
		verticalGeneral.setSizeFull();
		
		Panel panelPelicula = new Panel(this.peliculaSeleccionada.getNombre());
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
        resena.setHeight("200px");
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
        
        ComboBox combobox = new ComboBox("Seleccione un fecha");
        combobox.setInvalidAllowed(false);
        combobox.setNullSelectionAllowed(false);
        
        salas.addComponent(combobox);
        
        List<Horario> fechas = interfaceCine.consultarFechas();
    	for (Horario horario : fechas) {
    		if (!combobox.containsId(horario)){
    			combobox.addItems(formatoFecha.format(horario.getFecha()));
    		}        		
		}            
        
        List<Sala> salaPeli = interfaceCine.consultarSalaporPeliculasCinema(Integer.valueOf(cinemaId).intValue(), this.peliculaSeleccionada.getId());
        
        HorizontalLayout horariosSala = new HorizontalLayout();
        horariosSala.setSpacing(true);
         
        combobox.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				Notification.show("Selecciono fecha " +combobox.getValue());
				 for (Sala sala : salaPeli) {			        	
			        	Label nombreSala = new Label(sala.getNombre() + " " + sala.getIdioma());            
			            salas.addComponent(nombreSala);
			            List<Horario> horarios;
						try {
							horarios = interfaceCine.consultarHorariosPorSala(formatoFecha.parse((String) combobox.getValue()), sala.getId());
							for (Horario horaSala : horarios) {
								 Label hora = new Label(horaSala.getHora());
								 horariosSala.addComponent(hora);								 
							}
							salas.addComponent(horariosSala);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			           
					}				
			}
        	
        });
        
           
        horarios.addComponent(salas);
        
        panelHorarios.setContent(horarios);
        
		verti.addComponent(detallePeli);
		verti.addComponent(panelHorarios);
		
		panelPelicula.setContent(verti);
		
		verticalGeneral.addComponent(panelPelicula);
		
		setCompositionRoot(verticalGeneral);
		
			
	}
	
	
	

}
