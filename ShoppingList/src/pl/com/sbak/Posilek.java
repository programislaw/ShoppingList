
package pl.com.sbak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "posilek")
public class Posilek  implements Serializable
{

  private static final long serialVersionUID = -8893758342449364717L;
  private List<Skladnik> skladniki;
  private String nazwa;
  private int id;

  public Posilek()
  {
    super();
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
    {
      skladniki = new ArrayList<Skladnik>();
    }
    return skladniki;
  }
  @XmlElement(name = "skladnik")
  public void setSkladniki(List<Skladnik> skladniki)
  {
    this.skladniki = skladniki;
  }


}
