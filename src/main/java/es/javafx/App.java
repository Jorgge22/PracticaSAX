package es.javafx;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        /*
         * Implementar un analizador SAX que tome como parámetro de entrada un documento componentes.xml (toma el que te facilito si quieres)
         *
         * El documento contiene el nombre del componente, el fabricantes, precio unitario y la cantidad que hay en stock.
         *
         * Debes mostrar por pantalla un informe que muestre para cada componente lo siguiente:
         *
         *     Nombre
         *     Fabricante
         *     Precio unitario en €
         *     Cantidad de unidades en stock
         *     Subtotal del componente: Subtotal = precio unitario * Cantidad
         *
         * Debes mostrar al finalizar, un resumen general donde se vea:
         *
         * Total de unidades almacenadas (suma de todas las cantidades)
         * Valor total del inventario (suma de todos los subtotales)
         *
         * Ejemplo de salida por consola:
         *
         * === INFORME DE VALORACIÓN DE INVENTARIO ===
         *
         * [Componente C01]
         * - Nombre: Disco Duro SSD 1TB
         * - Fabricante: Crucial
         * - Precio unitario: 65.50 €
         * - Cantidad: 5 unidades
         * - Subtotal: 327.50 €
         * -------------------------------------------
         * [Componente C02]
         * - Nombre: Memoria RAM 16GB DDR5
         * - Fabricante: Corsair
         * - Precio unitario: 82.00 €
         * - Cantidad: 3 unidades
         * - Subtotal: 246.00 €
         * -------------------------------------------
         * === RESUMEN GLOBAL ===
         * - Total de artículos en stock: 14 unidades
         * - Valor total del inventario: 1,280.50 €
         *
         * */
        try {
            File inputFile = new File("componentes.xml");

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            ComponentesHandle componentesHandle = new ComponentesHandle();
            saxParser.parse(inputFile, componentesHandle);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}