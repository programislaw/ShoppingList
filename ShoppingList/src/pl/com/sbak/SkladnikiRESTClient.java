package pl.com.sbak;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class SkladnikiRESTClient
{
  private static String GET_SKLADNIKI_URL = "http://localhost:8080/ShopingListREST/rest/SkladnikService/skladniki";
  private static final String SUCCESS_RESULT="<result>success</result>";
  private static final String PASS = "pass";
  private static final String FAIL = "fail";
  private Client client;
  
  public SkladnikiRESTClient()
  {
    super();
    init();
  }

  private void init(){
    this.client = ClientBuilder.newClient();
  }
  
  public Skladnik addSkladnik(Posilek posilek, Skladnik skladnik){
    Form form = new Form();
    form.param("idPosilku", String.valueOf(posilek.getId()));
    form.param("artykul", skladnik.getArtykul());
    form.param("ilosc", String.valueOf(skladnik.getIlosc()));
    form.param("jednostka", skladnik.getJednostka());
    
    Skladnik s = client
       .target(GET_SKLADNIKI_URL)
       .request(MediaType.APPLICATION_XML)
       .put(Entity.entity(form,
          MediaType.APPLICATION_FORM_URLENCODED_TYPE),
           Skladnik.class);
 

    String result = FAIL;
    if(s != null){
       result = PASS;
    }

    System.out.println("addSkladnik: " + result );
    return s;
 }
  
  public String updateSkladnik(Posilek posilek, Skladnik skladnik){
    Form form = new Form();
    form.param("idPosilku", String.valueOf(posilek.getId()));
    form.param("artykul", skladnik.getArtykul());
    form.param("ilosc", String.valueOf(skladnik.getIlosc()));
    form.param("jednostka", skladnik.getJednostka());

    String callResult = client
       .target(GET_SKLADNIKI_URL)
       .request(MediaType.APPLICATION_XML)
       .post(Entity.entity(form,
          MediaType.APPLICATION_FORM_URLENCODED_TYPE),
          String.class);
    String result = PASS;
    if(!SUCCESS_RESULT.equals(callResult)){
       result = FAIL;
    }

    System.out.println("updateSkladnik: " + result );
    return result;
 }
  
  public void deleteSkladnik(Posilek posilek, Skladnik skladnik){
    String callResult = client
       .target(GET_SKLADNIKI_URL)
       .path("/{idPosilku}").path("/{artykul}")
       .resolveTemplate("idPosilku", posilek.getId())
       .resolveTemplate("artykul", skladnik.getArtykul())
       .request(MediaType.APPLICATION_XML)
       .delete(String.class);

    String result = PASS;
    if(!SUCCESS_RESULT.equals(callResult)){
       result = FAIL;
    }

    System.out.println("deleteSkladnik: " + result );
 }
}
