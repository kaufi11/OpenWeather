package net;

import data.Destination;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 * 
 * @author timon_kaufmann
 */

public class XML {

    private static XML theInstance;
    private final String PATH = "data/destinations.xml";
    private final Document doc;

    public XML() throws JDOMException, IOException {
        File f = new File(PATH);
        SAXBuilder builder = new SAXBuilder();
        doc = builder.build(f);
    }

    public synchronized static XML getInstance() throws JDOMException, IOException {
        if (theInstance == null) {
            theInstance = new XML();
        }
        return theInstance;
    }

    public void persistXML(List<Destination> destinations) throws IOException {
        doc.removeContent(doc.getRootElement());
        
        Element root = new Element("destinations");
        doc.setRootElement(root);
        for (Destination destination : destinations) {
            Element elemDest = new Element("destination");
            elemDest.setText(destination.getCity().getName());
            root.addContent(elemDest);
        }

        XMLOutputter out = new XMLOutputter();

        try (FileWriter fw = new FileWriter(new File(PATH));) {
            out.output(doc, fw);
        }
    }
    
    public List<String> loadFromXML() {
        ArrayList<String> destNames = new ArrayList<>();
        Element root = doc.getRootElement();
        for (Element element : root.getChildren()) {
            destNames.add(element.getText());
        }
        return destNames;
    }

}
