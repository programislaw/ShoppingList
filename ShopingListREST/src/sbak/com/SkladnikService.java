package sbak.com;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/SkladnikService")
public class SkladnikService
{
  PosilekDao posilekDao = new PosilekDao();
  private static final String SUCCESS_RESULT = "<result>success</result>";
  private static final String FAILURE_RESULT = "<result>failure</result>";

  @GET
  @Path("/skladniki/{nazwaposilku}")
  @Produces(MediaType.APPLICATION_XML)
  public List<Skladnik> getSkladniki(
      @PathParam("nazwaposilku") String nazwaPosilku) throws Exception
  {
    return posilekDao.getPosilek(nazwaPosilku).getSkladniki();
  }

  @GET
  @Path("/skladniki/{nazwaposilku}/{nazwaskladnika}")
  @Produces(MediaType.APPLICATION_XML)
  public Skladnik getSkladnik(
      @PathParam("nazwaposilku") String nazwaPosilku,
      @PathParam("nazwaskladnika") String nazwaskladnika) throws Exception
  {
    List<Skladnik> skladniki = posilekDao.getPosilek(nazwaPosilku).getSkladniki();
    for (Skladnik skladnik : skladniki)
    {
      if(skladnik.getArtykul().equals(nazwaskladnika))
        return skladnik;
    }
    return null;
  }

  @PUT
  @Path("/skladniki")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Skladnik createSkladnik(
      @FormParam("idPosilku") int idPosilku,
      @FormParam("artykul") String artykul,
      @FormParam("ilosc") int ilosc,
      @FormParam("jednostka") String jednostka,
      @Context HttpServletResponse servletResponse)
      throws Exception
  {
    Posilek posilek = posilekDao.getPosilekById(idPosilku);
    Skladnik skladnik = new Skladnik(artykul, ilosc, jednostka);
    posilek.getSkladniki().add(skladnik);
    posilekDao.addPosilek(posilek);
    return skladnik;
  }

  @POST
  @Path("/skladniki")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String updateSkladnik(
      @FormParam("idposilku") int idPosilku, 
      @FormParam("artykul") String artykul,
      @FormParam("ilosc") int ilosc,
      @FormParam("jednostka") String jednostka,
      @Context HttpServletResponse servletResponse) throws Exception
  {
    Posilek posilek = posilekDao.getPosilekById(idPosilku);
    if (posilek != null)
    {
      for (Skladnik skladnik : posilek.getSkladniki())
      {
        if (skladnik.getArtykul().equals(artykul)){
          skladnik.setArtykul(artykul);
          skladnik.setIlosc(ilosc);
          skladnik.setJednostka(jednostka);
          posilekDao.updatePosilek(posilek);
          return SUCCESS_RESULT;
        }
      }
    }
    return FAILURE_RESULT;
  }

  @DELETE
  @Path("/skladniki/{idPosilku}/{artykul}")
  @Produces(MediaType.APPLICATION_XML)
  public String deleteSkladnik(@PathParam("idposilku") int idPosilku,
      @PathParam("artykul") int artykul) throws Exception
  {
    Posilek posilek = posilekDao.getPosilekById(idPosilku);
    if (posilek != null)
    {
      for (Skladnik skladnik : posilek.getSkladniki())
      {
        if (skladnik.getArtykul().equals(artykul)){
          posilek.getSkladniki().remove(artykul);
          posilekDao.updatePosilek(posilek);
          return SUCCESS_RESULT;
        }
      }
    }
    return FAILURE_RESULT;
  }

  @OPTIONS
  @Path("/skladniki")
  @Produces(MediaType.APPLICATION_XML)
  public String getSupportedOperations()
  {
    return "<operations>GET, PUT, POST, DELETE</operations>";
  }
}
