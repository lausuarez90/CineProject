package com.proyecto.cineUnificado;

import java.util.List;

import com.proyecto.cineUnificado.ImpInterface.ImpInterfaceCine;
import com.proyecto.cineUnificado.Interfaces.InterfaceCine;
import com.proyecto.cineUnificado.modelo.Empresa;
import com.proyecto.cineUnificado.persistencia.ConexionBD;
import com.proyecto.cineUnificado.persistencia.EmpresasDAO;
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
	
	InterfaceCine interfaceCine;
	public final static String NAME = "";
	
	public EmpresaView() {		
		
    	interfaceCine = new ImpInterfaceCine();
    	List<Empresa> empresas = interfaceCine.consultarEmpresas();
		
		final VerticalLayout layout = new VerticalLayout();
        
        Panel panel = new Panel("Mis Cines");
        panel.setSizeUndefined();
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();        
        
        Label name = new Label();
        name.setCaption("Bienvenidos aqui puedes revisar la cartelera de tus cinemas favoritos!!!");
        name.addStyleName("mycaption");
        
        for (Empresa empresa : empresas) {
			
        	Button buttonCine = new Button();
        	ThemeResource resource = null;
        	
        	if (empresa.getNombreEmpresa().equals("Cinepolis")){
        		resource = new ThemeResource("images/cinepolis2.png");
        		buttonCine.setHeight("160px");
        		buttonCine.setWidth("160px");
        	}else if (empresa.getNombreEmpresa().equals("CineColombia")){
        		resource = new ThemeResource("images/cineColombia.jpg");
        		buttonCine.setHeight("160px");
        		buttonCine.setWidth("160px");
        	}else if (empresa.getNombreEmpresa().equals("CineMark")){
        		resource = new ThemeResource("images/cinemark.png");
        		buttonCine.setHeight("71px");
                buttonCine.setWidth("160px");
        	}else if (empresa.getNombreEmpresa().equals("Procinal")){
        		resource = new ThemeResource("images/Procinal.png");
        		buttonCine.setHeight("80px");
                buttonCine.setWidth("160px");
        	}
        	buttonCine.setIcon(resource);
        	buttonCine.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        	buttonCine.addStyleName(ValoTheme.BUTTON_BORDERLESS);
            
           
            buttonCine.addClickListener( e -> {
            	getUI().getNavigator().navigateTo(CinemaView.NAME + "/" + empresa.getIdEmpresa() + "/" + empresa.getNombreEmpresa() + "/" + empresa.getNit());
            });
		
      
        horizontalLayout.addComponent(buttonCine);
        horizontalLayout.setComponentAlignment(buttonCine, Alignment.MIDDLE_CENTER);
        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);
        
        }
        
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
