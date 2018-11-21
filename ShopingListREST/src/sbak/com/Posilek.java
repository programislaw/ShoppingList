package sbak.com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;


@XmlRootElement(name = "posilek")
public class Posilek implements Serializable
{

  private static final long serialVersionUID = 1L;
  private String nazwa;
  private int id;
  
  private List<Skladnik> skladniki;

  public Posilek()
  {
  }

  public int getId()
  {
    return id;
  }
  
  @XmlAttribute
  public void setId(int id)
  {
    this.id = id;
  }

  public Posilek(int id, String nazwa)
  {
    this.id = id;
    this.nazwa = nazwa;
  }
  
  public Posilek(String nazwa)
  {
    this.nazwa = nazwa;
  }
  
  public String getNazwa()
  {
    return nazwa;
  }

  @XmlAttribute
  public void setNazwa(String nazwa)
  {
    this.nazwa = nazwa;
  }

  public List<Skladnik> getSkladniki()
  {
    if (skladniki == null)
      skladniki = new ArrayList<Skladnik>();
    return skladniki;
  }

  @XmlElement(name = "skladnik")
  public void setSkladniki(List<Skladnik> skladniki)
  {
    this.skladniki = skladniki;
  }

}
