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

@Path("/PosilekService")
public class PosilekService
{

  PosilekDao posilekDao = new PosilekDao();
  private static final String SUCCESS_RESULT = "<result>success</result>";
  private static final String FAILURE_RESULT = "<result>failure</result>";

  @GET
  @Path("/posilki")
  @Produces(MediaType.APPLICATION_XML)
  public List<Posilek> getPosilki() throws Exception
  {
    return posilekDao.getAllPosilki();
  }

  @GET
  @Path("/posilki/{nazwaposilku}")
  @Produces(MediaType.APPLICATION_XML)
  public Posilek getPosilek(@PathParam("nazwaposilku") String nazwaPosilku) throws Exception
  {
    return posilekDao.getPosilek(nazwaPosilku);
  }

  @PUT
  @Path("/posilki")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Posilek createPosilek(@FormParam("nazwa") String nazwa, @Context HttpServletResponse servletResponse)
      throws Exception
  {
    Posilek posilek = new Posilek(nazwa);
    posilek = posilekDao.addPosilek(posilek);
    return posilek;
  }

  @POST
  @Path("/posilki")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String updatePosilek(@FormParam("id") int id, @FormParam("nazwa") String nazwa,
      @Context HttpServletResponse servletResponse) throws Exception
  {
    Posilek posilek = new Posilek(id, nazwa);
    int result = posilekDao.updatePosilek(posilek);
    if (result == 1)
    {
      return SUCCESS_RESULT;
    }
    return FAILURE_RESULT;
  }

  @DELETE
  @Path("/posilki/{id}")
  @Produces(MediaType.APPLICATION_XML)
  public String deletePosilek(@PathParam("id") int id) throws Exception
  {
    int result = posilekDao.deletePosilek(id);
    if (result == 1)
    {
      return SUCCESS_RESULT;
    }
    return FAILURE_RESULT;
  }

  @OPTIONS
  @Path("/posilki")
  @Produces(MediaType.APPLICATION_XML)
  public String getSupportedOperations()
  {
    return "<operations>GET, PUT, POST, DELETE</operations>";
  }
}
