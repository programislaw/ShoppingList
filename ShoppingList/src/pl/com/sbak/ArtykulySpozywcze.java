
package pl.com.sbak;

import java.util.EnumSet;

public enum ArtykulySpozywcze {

  MAKARON_SPAGETTI("Makaron spagetti"), MIESO_MIELONE("Miêso mielone"), PRZECIER_POMIDOROWY("Przecier pomidorowy"), SER_ZOLTY("Ser ¿ó³ty");

  private String nazwa;

  ArtykulySpozywcze(String nazwa)
  {
    this.nazwa = nazwa;
  }

  public String getNazwa()
  {
    return nazwa;
  }

  public static ArtykulySpozywcze StrToArtykul(String nazwa)
  {
    EnumSet<ArtykulySpozywcze> set = EnumSet.allOf(ArtykulySpozywcze.class);
    for (ArtykulySpozywcze artykulySpozywcze : set)
    {
      if(artykulySpozywcze.getNazwa().equals(nazwa))
      {
        return artykulySpozywcze;
      }
    }
    return null;
  }
}
