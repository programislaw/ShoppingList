
package pl.com.sbak;

public class Spagetti extends Posilek
{

  /**
   * 
   */
  private static final long serialVersionUID = 7058658157623225779L;

  public Spagetti()
  {
    super();
    setNazwa("Spagetti");
    getSkladniki().add(new Skladnik(ArtykulySpozywcze.MAKARON_SPAGETTI.getNazwa(), 100, Jednostka.GRAM));
    getSkladniki().add(new Skladnik(ArtykulySpozywcze.MIESO_MIELONE.getNazwa(), 100, Jednostka.GRAM));
    getSkladniki().add(new Skladnik(ArtykulySpozywcze.PRZECIER_POMIDOROWY.getNazwa(), 100, Jednostka.GRAM));
    getSkladniki().add(new Skladnik(ArtykulySpozywcze.SER_ZOLTY.getNazwa(), 50, Jednostka.GRAM));
  }

}
