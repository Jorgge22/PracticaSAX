package es.javafx;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ComponentesHandle extends DefaultHandler {
    public StringBuilder contenido = new StringBuilder();
    public String nombre, fabricante;
    public double precio, subtotal;
    public int cantidad;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        contenido.setLength(0);
    }

    @Override
    public void characteres(char[] ch, int start, int lenght) throws SAXException{
        contenido.append(ch, start, lenght);
    }
}
