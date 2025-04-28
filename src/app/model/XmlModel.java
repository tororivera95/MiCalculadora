package app.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.text.html.parser.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class XmlModel {

    public static Document leerXml() {
        Document document = null;
        try {
            // Cargar el archivo XML desde los recursos
            File inputStream = new File("src/resources/usuarios.xml");
            if (!inputStream.exists()) {
                throw new IllegalArgumentException("Archivo usuarios.xml no encontrado en los recursos.");
            }
            // Parsear el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true); // Opcional
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    public int obtenerCantUsuarios() {
        int cant = 0;
        Document document = null;
        try {
            document = leerXml();

            // Crear el objeto XPath
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // Compilar y evaluar la expresión XPath
            XPathExpression expr = xpath.compile("/users/user");
            NodeList userCant = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            cant = userCant.getLength();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cant;
    }

    public ArrayList<UsersModel> obtenerUsuarios() {
        ArrayList<UsersModel> users = new ArrayList<>();

        try {
            Document document = leerXml();

            // 2. Crear XPath y compilar la expresión de usuarios
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression exprUsers = xpath.compile("/users/user");

            // 3. Obtener la lista de nodos <user>
            NodeList userNodes = (NodeList) exprUsers.evaluate(document, XPathConstants.NODESET);

            // 4. Iterar cada <user> y extraer campos con XPath relativo
            for (int i = 0; i < userNodes.getLength(); i++) {
                Element userEl = (Element) userNodes.item(i);

                // XPath relativo para cada campo

                String id = userEl.getAttribute("id").trim();
                String name = xpath.compile("./name/text()")
                        .evaluate(userEl, XPathConstants.STRING)
                        .toString().trim();
                String lastName = xpath.compile("./lastName/text()")
                        .evaluate(userEl, XPathConstants.STRING)
                        .toString().trim();
                String nationality = xpath.compile("./nationality/text()")
                        .evaluate(userEl, XPathConstants.STRING)
                        .toString().trim();

                // Guardamos cada uno de los usuarios existentes dentro del XML
                UsersModel user = new UsersModel();
                user.setId(Integer.parseInt(id));
                user.setName(name);
                user.setLastName(lastName);
                user.setNationality(nationality);
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public String obtenerNacionalidad(String idUsuario) {
        String nacionalidad = "";
        Document document = null;
        try {
            document = leerXml();

            // Crear el objeto XPath
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // Compilar y evaluar la expresión XPath
            XPathExpression expr = xpath.compile("/users/user[@id='" + idUsuario + "']/nationality/text()");
            nacionalidad = (String) expr.evaluate(document, XPathConstants.STRING);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nacionalidad;
    }

}
