package sbak.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PosilekDao
{
  public List<Posilek> getAllPosilki() throws Exception
  {
    List<Posilek> posilkiList = null;
    File fXmlFile = new File("c:/Users/sbak/workspace-neon/ShoppingList/posilki.xml ");
    if (!fXmlFile.exists())
    {
      Posilek posilek = new Posilek("Brak");
      posilek.getSkladniki().add(new Skladnik("-", 0, "g"));
      posilkiList = new ArrayList<Posilek>();
      posilkiList.add(posilek);
    } else
    {
      posilkiList = XMLReaderWriter.readPosilki();
    }
    return posilkiList;
  }

  public Posilek getPosilek(String nazwaPosilku) throws Exception
  {
    List<Posilek> posilki = getAllPosilki();
    Posilek wynik = null;
    for (Posilek posilek : posilki)
    {
      if (posilek.getNazwa().equals(nazwaPosilku))
      {
        return posilek;
      }
    }
    return wynik;
  }
  
  public Posilek getPosilekById(int idPosilku) throws Exception
  {
    List<Posilek> posilki = getAllPosilki();
    Posilek wynik = null;
    for (Posilek posilek : posilki)
    {
      if (posilek.getId() == idPosilku)
      {
        return posilek;
      }
    }
    return wynik;
  }
  
  public int generateId(List<Posilek> listaPosilkow) {
    int maxId = 1;
    for (Posilek posilek : listaPosilkow)
    {
      maxId = posilek.getId() > maxId ? posilek.getId() : maxId;
    }
    return maxId + 1;
  }
  
  public Posilek addPosilek(Posilek posilek) throws Exception
  {
    List<Posilek> listaPosilkow = getAllPosilki();
    int id = generateId(listaPosilkow);
    Posilek istniejacyPosilek = getPosilek(posilek.getNazwa());
    if (istniejacyPosilek == null)
    {
      posilek.setId(id);
      listaPosilkow.add(posilek);
      XMLReaderWriter.writePosilki(listaPosilkow);
      return posilek;
    }
    
    return istniejacyPosilek;
  }

  public int updatePosilek(Posilek posilek) throws Exception
  {
    List<Posilek> listaPosilkow = getAllPosilki();

    for (Posilek p : listaPosilkow)
    {
      if (p.getId() == posilek.getId())
      {
        p.setNazwa(posilek.getNazwa());
        XMLReaderWriter.writePosilki(listaPosilkow);
        return 1;
      }
    }
    return 0;
  }

  public int deletePosilek(int id) throws Exception
  {
    List<Posilek> listaPosilkow = getAllPosilki();
    Posilek posilekToRemove = null;
    for (Posilek p : listaPosilkow)
    {
      if (p.getId() == id)
      {
        posilekToRemove = p;
        break;
      }
    }
    if (posilekToRemove != null)
    {
      listaPosilkow.remove(posilekToRemove);
      XMLReaderWriter.writePosilki(listaPosilkow);
      return 1;
    }
    return 0;
  }

}
