package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sistema {
	private List<Proyecto> proyectos;
	private Investigador investigador;
	
	public Sistema(Investigador investigador1){
		this.investigador=investigador1;
		proyectos = investigador.getListaDeProyectos();
	}
	
	
	public List<Encuesta> todasLasEncuestas(){
		List<Proyecto> proyectos=this.proyectos;  
		List<Encuesta>encuestas=new ArrayList<Encuesta>();
		for(Proyecto p:proyectos) {
			encuestas.addAll(p.getListaDeEncuestas());
		}
		return encuestas;
			}

	
	
	public List<Encuesta> getEncuestasMasNuevas(){
		List<Encuesta> encuestas = this.todasLasEncuestas();
		Integer cantidad = this.todasLasEncuestas().size();
		  if(cantidad >=20) {
			  cantidad = 20;
		  }
		  else {
			  cantidad=this.todasLasEncuestas().size();
		  }
		Collections.sort(encuestas, new MasNuevaAMasAntiguaPorAntiguedad());
		return encuestas.subList(0, cantidad);	         
	}
	


  public List <Encuesta> getEncuestasMasUsadas() {
	  List <Encuesta> encuestas = this.todasLasEncuestas();
	  Integer cantidad = this.todasLasEncuestas().size();
	  if(cantidad >=25) {
		  cantidad = 25;
	  }
	  else {
		  cantidad=this.todasLasEncuestas().size();
	  }
	  Collections.sort(encuestas, new MayorAMenorCantidadDeResultados());
	  return encuestas.subList(0, cantidad);
  }

  public List <Encuesta> ordenarAlfabeticamente(){
	  List <Proyecto> todosLosProyectos = this.proyectos;
	  List <Encuesta> encuestas = new ArrayList <Encuesta>();
	  Collections.sort(todosLosProyectos, (o1, o2) -> o1.getDescripcion().compareTo(o2.getDescripcion()));
	  for(Proyecto p:todosLosProyectos) {
		  encuestas.addAll(p.getListaDeEncuestas());
	  }
	  return encuestas;	  
  }
  
  public List <Proyecto> getProyectos(){
	  return this.proyectos;
  }

	
	
	
}
