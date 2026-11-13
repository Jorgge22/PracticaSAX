package es.javafx;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ComponentesHandle extends DefaultHandler {
    public StringBuilder contenido = new StringBuilder();
    public String id, nombre, fabricante;
    public double precio, subtotal;
    public int cantidad;
    public int cantidadTotal;
    public double valorTotal = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Limpiamos, dejamos el contenido vacío
        contenido.setLength(0);

        // Si la etiqueta que lee es "componente" almacenaamos el valor del id
        if (qName.equals("componente")) {
            id = attributes.getValue("id");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Cuando llame al metodo, al contenido no sobreescriba
        contenido.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "nombre":
                nombre = contenido.toString().trim();
                break;

            case "fabricante":
                fabricante = contenido.toString().trim();
                break;

            case "precioUnitario":
                precio = Double.parseDouble(contenido.toString().trim());
                break;

            case "cantidad":
                cantidad = Integer.parseInt(contenido.toString().trim());
                cantidadTotal += cantidad;
                break;

            case "subtotal":
                subtotal = Double.parseDouble(contenido.toString().trim());
                break;

            case "componente":
                System.out.println("[Componente " + id + "]");
                System.out.println("- Nombre: " + nombre);
                System.out.println("- Fabricante: " + fabricante);
                System.out.println("- Precio unitario: " + precio);
                System.out.println("- Cantidad: " + cantidad + " unidades");
                System.out.println("- Subtotal: " + (precio*cantidad));

                valorTotal += precio*cantidad;
                break;
        }
    }

    @Override
    public void endDocument() {
        System.out.println("=== RESUMEN GLOBAL ===");
        System.out.println("- Total de artículos en stock: " + cantidadTotal);
        System.out.println("- Valor total del inventario: " + valorTotal);
    }
}
