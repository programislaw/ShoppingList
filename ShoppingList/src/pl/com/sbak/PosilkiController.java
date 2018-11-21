package pl.com.sbak;

import java.util.List;

import javax.faces.component.UICommand;
import javax.faces.component.UIForm;

public class PosilkiController {
  private List<Posilek> listaposilkow;
  private Posilek posilek;
  private Skladnik skladnik;
  
  private SpozadzaczListyZakupow spozadzaczListyZakupow;

//  private UIForm form;
//  private UIForm tableForm;
  private PosilkiRESTClient posilkiClient;
  private SkladnikiRESTClient skladnikiClient;
  private UICommand addCommand;

  public PosilkiController() {
    posilkiClient = new PosilkiRESTClient();
    listaposilkow = posilkiClient.getPosilki();
    skladnikiClient = new SkladnikiRESTClient();
    spozadzaczListyZakupow = new SpozadzaczListyZakupow();
    spozadzaczListyZakupow.addAll(listaposilkow);
    
  }
  
  public String generuj() {
    spozadzaczListyZakupow.generuj();
    //form.setRendered(false);
    return null;
  }
  
  public String szczegolyPosilku(Posilek posilek) {
    //form.setRendered(false);
    return "toposilek";
    //return "posilek.xhtml";
  }
  
  public String dodajPosilek() {
    posilek = new Posilek();
    return "toposilekedt";
  }
  
  public String dodajSkladnik() {
    skladnik = new Skladnik();
    return "toskladnikedt";
  }
 
  public String zapiszSkladnik() {
    if( !posilek.getSkladniki().contains(skladnik) ) {
      posilek.getSkladniki().add(skladnik);
      skladnikiClient.addSkladnik(posilek, skladnik);
    } else {
      skladnikiClient.updateSkladnik(posilek, skladnik);
    }
    return "posilekedt";
  }
  
  public String zapiszPosilek() {
    if( !listaposilkow.contains(posilek) ) {
      listaposilkow.add(posilek);
      posilkiClient.addPosilek(posilek);
    } else {
      posilkiClient.updatePosilek(posilek);
    }
    return "listaposilkow";
  }
  
  public String edytujPosilek(Posilek posilek) {
    return "toposilekedt";
  }
  
  public void usunPosilek(Posilek posilek) {
    listaposilkow.remove(posilek);
    posilkiClient.deletePosilek(posilek.getId());
  }
  
  public String szczegolySkladnika(Skladnik skladnik) {
    //form.setRendered(false);
    return "toskladnik";
    //return "posilek.xhtml";
  }
  
  public String edytujSkladni(Skladnik skladnik) {
    return "toskladnikedt";
  }

  public void usunSkladnik(Skladnik skladnik) {
    if (posilek != null) {
      posilek.getSkladniki().remove(skladnik);
      skladnikiClient.deleteSkladnik(posilek, skladnik);
    } else {
      throw new RuntimeException("Nie wybrano posi³ku");
    }
  }


  public List<Posilek> getListaposilkow()
  {
    return listaposilkow;
  }

  public void setListaposilkow(List<Posilek> listaposilkow)
  {
    this.listaposilkow = listaposilkow;
  }

//  public UIForm getTableForm()
//  {
//    return tableForm;
//  }
//
//  public void setTableForm(UIForm tableForm)
//  {
//    this.tableForm = tableForm;
//  }

  public SpozadzaczListyZakupow getSpozadzaczListyZakupow()
  {
    return spozadzaczListyZakupow;
  }

  public void setSpozadzaczListyZakupow(SpozadzaczListyZakupow spozadzaczListyZakupow)
  {
    this.spozadzaczListyZakupow = spozadzaczListyZakupow;
  }
//
//  public UIForm getForm()
//  {
//    return form;
//  }
//
//  public void setForm(UIForm form)
//  {
//    this.form = form;
//  }

  public Posilek getPosilek()
  {
    return posilek;
  }

  public void setPosilek(Posilek posilek)
  {
    this.posilek = posilek;
  }

  public Skladnik getSkladnik()
  {
    return skladnik;
  }

  public void setSkladnik(Skladnik skladnik)
  {
    this.skladnik = skladnik;
  }

  public UICommand getAddCommand()
  {
    return addCommand;
  }

  public void setAddCommand(UICommand addCommand)
  {
    this.addCommand = addCommand;
  }

} 


