package pl.com.sbak;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class PosilkiRESTClient
{
  private static String GET_POSILKI_URL = "http://localhost:8080/ShopingListREST/rest/PosilekService/posilki";
  private static final String SUCCESS_RESULT="<result>success</result>";
  private static final String PASS = "pass";
  private static final String FAIL = "fail";
  private Client client;
  
  public PosilkiRESTClient()
  {
    super();
    init();
  }

  private void init(){
    this.client = ClientBuilder.newClient();
  }

  public static int updatePosilki(Posilek posilek)
  {
    return 0;

  }

  public static int deletePosilek(String nazwaPosilku)
  {
    return 0;

  }

  public List<Posilek> getPosilki()
  {
    GenericType<List<Posilek>> list = new GenericType<List<Posilek>>()
    {
    };
    List<Posilek> posilki = client.target(GET_POSILKI_URL).request(MediaType.APPLICATION_XML).get(list);
    String result = PASS;
    if (posilki.isEmpty())
    {
      result = FAIL;
    }
    System.out.println("getPosilki: " + result);
    return posilki;
  }
  
  public Posilek getPosilek(String nazwaposilku)
  {
    Posilek posilek = client.target(GET_POSILKI_URL).path("/{nazwaposilku}")
        .resolveTemplate("nazwaposilku", nazwaposilku).request(MediaType.APPLICATION_XML).get(Posilek.class);
    String result = FAIL;
    if (posilek != null && posilek.getNazwa().equals(posilek.getNazwa()))
    {
      result = PASS;
    }
    System.out.println("getPosilek: " + result);
    return posilek;
  }
  
  public Posilek addPosilek(Posilek posilek){
    Form form = new Form();
    form.param("nazwa", posilek.getNazwa());

    Posilek p = client
       .target(GET_POSILKI_URL)
       .request(MediaType.APPLICATION_XML)
       .put(Entity.entity(form,
          MediaType.APPLICATION_FORM_URLENCODED_TYPE),
           Posilek.class);
 

    String result = FAIL;
    if(p != null){
      posilek.setId(p.getId());
       result = PASS;
    }

    System.out.println("addPosilek: " + result );
    return p;
 }
  
  public String updatePosilek(Posilek posilek){
    Form form = new Form();
    form.param("id", String.valueOf(posilek.getId()));
    form.param("nazwa", posilek.getNazwa());

    String callResult = client
       .target(GET_POSILKI_URL)
       .request(MediaType.APPLICATION_XML)
       .post(Entity.entity(form,
          MediaType.APPLICATION_FORM_URLENCODED_TYPE),
          String.class);
    String result = PASS;
    if(!SUCCESS_RESULT.equals(callResult)){
       result = FAIL;
    }

    System.out.println("updatePosilek: " + result );
    return result;
 }
  
  public void deletePosilek(int id){
    String callResult = client
       .target(GET_POSILKI_URL)
       .path("/{id}")
       .resolveTemplate("id", id)
       .request(MediaType.APPLICATION_XML)
       .delete(String.class);

    String result = PASS;
    if(!SUCCESS_RESULT.equals(callResult)){
       result = FAIL;
    }

    System.out.println("deletePosilek: " + result );
 }

}
