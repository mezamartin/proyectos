package Clases;

import java.util.ArrayList;
import java.util.List;

public class Proyecto implements Comparable <Proyecto>{
	private String descripcion;
	private String proposito;
	private List<Encuesta> encuestas;
	private List <Proyecto> subProyectos;
	
	public Proyecto(String descripcion, String proposito ){
		this.descripcion=descripcion;
		this.proposito=proposito;
		this.encuestas=new ArrayList<Encuesta>();
		this.subProyectos = new ArrayList <Proyecto>();
	}
	
	public String getProposito(){
		return this.proposito;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void agregarEncuesta(Encuesta encuesta) {
		this.encuestas.add(encuesta);
	}
	
	public void agregarSubproyecto(Proyecto proyecto) {
		if(proyecto.getListaDeSubproyectos().contains(this)) {
			
		}
		else {
			this.subProyectos.add(proyecto);
		}
	}
	
	public List<Encuesta> getListaDeEncuestas(){
		return this.encuestas;
	}
	
	public List <Proyecto> getListaDeSubproyectos(){
		return this.subProyectos;
	}
	
	public Integer getCantidadDeEncuestas(){
		return this.encuestas.size();
	}
	
	public Integer getCantidadDeSubproyectos() {
		return this.subProyectos.size();
	}
	
	public void removerEncuesta(Encuesta encuesta){
		this.encuestas.remove(encuesta);
	}
	
	public void removerSubproyecto(Proyecto proyecto) {
		this.subProyectos.remove(proyecto);
	}
	
	public Encuesta getEncuestaConMayorCantidadDeResultados(){
		Encuesta  mayor =  this.encuestas.get(0);
		for(Encuesta e:this.encuestas){
			if(e.getCantidadDeResultados() > mayor.getCantidadDeResultados()){
				mayor= e;	
			}
		}
		return mayor;
	}
	
	 public Boolean estaFinalizada(){
		  Boolean estaFinalizado=false;
		  	if(this.todasLasEncuestaEstanFinalizadas()&& this.todosLosSubProyectosEstanFinalizados()){
		  		estaFinalizado=true;
		  	}
		  	return estaFinalizado;
	 }
	
	public Boolean todosLosSubProyectosEstanFinalizados(){
		Boolean estaFinalizado=true;
			for(Proyecto p: subProyectos){
				if(p.estaFinalizada() == false){
					estaFinalizado=false;
				}
			}
		return estaFinalizado;
	}
	
	
	public Boolean todasLasEncuestaEstanFinalizadas(){
		Boolean estaFinalizado=true;
		for(Encuesta e:encuestas){
				if(e.encuestaFinalizada()==false){
					estaFinalizado=false;
				}
			}
		return estaFinalizado;
	}
	
	
	public int compareTo(Proyecto proyecto) {
		return this.getDescripcion().compareTo(proyecto.getDescripcion());
	}

	
	
	
  
}
