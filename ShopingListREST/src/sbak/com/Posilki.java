package sbak.com;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "posilki")
public class Posilki
{
  private List<Posilek> posilki;

  public List<Posilek> getPosilki()
  {
    return posilki;
  }

  @XmlElement(name = "posilek")
  public void setPosilki(List<Posilek> posilki)
  {
    this.posilki = posilki;
  }
  
  
}
