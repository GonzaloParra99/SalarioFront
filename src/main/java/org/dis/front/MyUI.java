package org.dis.front;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@Theme("mytheme")
public class MyUI extends UI {

    private TextField creaLabel(String texto){
        TextField etiqueta = new TextField();
        ;etiqueta.setCaption(texto);
        return etiqueta;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        TextField tipo = creaLabel("Tipo de empleado");
        TextField horasExtra = creaLabel("Horas trabajadas");
        TextField ventasMes = creaLabel("Ventas realizadas");


        Button button = new Button("Calcular");
        button.addClickListener(e -> {

        });
        
        layout.addComponents(tipo, horasExtra, ventasMes, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
