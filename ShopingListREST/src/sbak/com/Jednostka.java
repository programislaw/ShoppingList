
package sbak.com;

import java.util.EnumSet;

public enum Jednostka {

  GRAM("g"), KILOGRAM("kg"), MILILITR("ml"), LITR("L"), SZTUKA("szt.");

  private String skrot;

  Jednostka(String skrot)
  {
    this.skrot = skrot;
  }

  public String getSkrot()
  {
    return skrot;
  }
  public static Jednostka StrToJednostka(String nazwa)
  {
    EnumSet<Jednostka> set = EnumSet.allOf(Jednostka.class);
    for (Jednostka jednostka : set)
    {
      if(jednostka.getSkrot().equals(nazwa))
      {
        return jednostka;
      }
    }
    return null;
  }

  public void setSkrot(String skrot)
  {
    this.skrot = skrot;
  }
  
}
