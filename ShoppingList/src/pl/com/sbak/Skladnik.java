
package pl.com.sbak;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "skladnik")
public class Skladnik
{

  private static final long serialVersionUID = 6033614266932992416L;

  String artykul;

  float Ilosc;

  Jednostka jednostka;

  
  public Skladnik()
  {
    super();
  }

  public Skladnik(String artykul, float ilosc, Jednostka jednostka)
  {
    super();
    this.artykul = artykul;
    Ilosc = ilosc;
    this.jednostka = jednostka;
  }

  public String getArtykul()
  {
    return artykul;
  }

  public float getIlosc()
  {
    return Ilosc;
  }

  public String getJednostka()
  {
    if (jednostka == null)
      return null;
    else 
      return jednostka.getSkrot();
  }
  @XmlAttribute
  public void setIlosc(float ilosc)
  {
    Ilosc = ilosc;
  }
  @XmlAttribute
  public void setArtykul(String artykul)
  {
    this.artykul = artykul;
  }
  @XmlAttribute
  public void setJednostka(String skrot)
  {
    this.jednostka = Jednostka.StrToJednostka(skrot);
  }


}
