
package pl.com.sbak;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SpozadzaczListyZakupow extends ArrayList<Posilek>
{
  /**
   * 
   */
  private static final long serialVersionUID = 6121111806780087587L;
  List<Skladnik> listaArtykulow = new ArrayList<Skladnik>();

  @Override
  public boolean add(Posilek posilek)
  {
    dodajPosilekDoListyArtykolow(posilek);
    return super.add(posilek);
  }

  private void dodajPosilekDoListyArtykolow(Posilek posilek)
  {
    for (Skladnik skladnik : posilek.getSkladniki())
    {
      dodajSkladnikDoListyArtykolow(skladnik);
    }
  }

  @Override
  public boolean addAll(Collection<? extends Posilek> c)
  {
    for (Posilek posilek : c)
    {
      dodajPosilekDoListyArtykolow(posilek);
    }
    return super.addAll(c);
  }

  public void generuj()
  {

    for (Skladnik skladnik : listaArtykulow)
    {
      System.out.println("Artyku³: " + skladnik.getArtykul() + " " + skladnik.getIlosc() + " "
          + skladnik.getJednostka());
    }
  }

  private void dodajSkladnikDoListyArtykolow(Skladnik skladnikDodawany)
  {
    boolean dodalemSkladnik = false;
    for (Skladnik skladnikZListyArtykolow : listaArtykulow)
    {
      if(skladnikZListyArtykolow.getArtykul().equals(skladnikDodawany.getArtykul()))
      {
        if(skladnikZListyArtykolow.getJednostka() == skladnikDodawany.getJednostka())
        {
          skladnikZListyArtykolow.setIlosc(skladnikZListyArtykolow.getIlosc() + skladnikDodawany.getIlosc());
          dodalemSkladnik = true;
        }
        else
        {
          throw new UnsupportedOperationException("dodajSkladnikDoListyArtykolow");
        }
      }
    }
    if(!dodalemSkladnik)
    {
      listaArtykulow.add(skladnikDodawany);
    }
  }

}
