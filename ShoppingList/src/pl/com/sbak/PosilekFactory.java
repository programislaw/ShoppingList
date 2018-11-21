package pl.com.sbak;

public class PosilekFactory
{

  public Posilek create(ListaPosilkow posilek)
  {
    if(posilek == ListaPosilkow.SPAGETTI) {
      return new Spagetti();
    }
    if(posilek == ListaPosilkow.PIZZA) {
      return new Pizza();
    }
    return null;
  }

}
