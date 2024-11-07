package org.dis.front;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;


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
        final HorizontalLayout salarioBruto = new HorizontalLayout();
        final HorizontalLayout salarioNeto = new HorizontalLayout();
        TextField tipo = creaLabel("Tipo de empleado");
        TextField horasExtra = creaLabel("Horas trabajadas");
        TextField ventasMes = creaLabel("Ventas realizadas");

        salarioBruto.addComponents(tipo, horasExtra, ventasMes);

        Button button = new Button("Calcular");
        button.addClickListener(e -> {

        });

        TabSheet tabs = new TabSheet();
        tabs.addTab(salarioBruto).setCaption("Calcula salario bruto");
        tabs.addTab(salarioNeto).setCaption("Calcula salario neto");
        
        layout.addComponents(tabs, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
