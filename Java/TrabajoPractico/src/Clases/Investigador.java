package Clases;

import java.util.ArrayList;
import java.util.List;

public class Investigador implements Interesado {

	private String nombre;
	private String apellido;
	private Integer dni;
	private List<Proyecto> proyectos;
	private Sistema sistema;
	
	public Investigador(String nombre, String apellido,Integer dni){
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.proyectos=new ArrayList<Proyecto>();
		this.sistema = new Sistema(this);
		
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellido(){
		return this.apellido;
	}
	
	public Integer getDni(){
		return this.dni;
	}
	
	public Sistema getSistema() {
		return this.sistema;
	}
	

  public List<Proyecto> getListaDeProyectos(){
		return this.proyectos;
  }
	
	public Integer getCantidadDeProyectos(){
		return this.proyectos.size();
	}
	
	
	public void agregarProyecto(Proyecto proyecto){
		this.proyectos.add(proyecto);		
	}
	
	
	public void sacarProyecto(Proyecto proyecto){
		this.proyectos.remove(proyecto);		
	}
	
	
	
}
