
package sbak.com;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReaderWriter
{
  private static String DB_FILE = "c:/Users/sbak/workspace-neon/ShoppingList/posilki.xml";

  public static List<Posilek> readPosilki()
  {
    Posilki posilki = null;
    try
    {
      File fXmlFile = new File(DB_FILE);
      JAXBContext context = JAXBContext.newInstance(Posilki.class);
      Unmarshaller unMarshaller = context.createUnmarshaller();
      posilki = (Posilki) unMarshaller.unmarshal(fXmlFile);
    } catch (Exception e)
    {
      e.printStackTrace();
    }
    return posilki.getPosilki();
  }

  public static void writePosilki(List<Posilek> listaPosilkow) throws Exception {
    Posilki posilki = new Posilki();
    posilki.setPosilki(listaPosilkow);
    File fXmlFile = new File(DB_FILE);
    JAXBContext jaxbContext = JAXBContext.newInstance(Posilki.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    jaxbMarshaller.marshal(posilki, fXmlFile);
    jaxbMarshaller.marshal(posilki, System.out);
  }
}

