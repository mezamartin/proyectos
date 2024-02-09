package Clases;

import java.util.ArrayList;
import java.util.List;

public class RespuestaMultiple extends Respuesta {
	private List <Opcion> opciones;
	
	
	public RespuestaMultiple(Pregunta pregunta) {
        super(pregunta);
        this.opciones=new ArrayList<Opcion>();
	}
	
	public List <Opcion> getListaDeOpciones(){
		return this.opciones;
	}
	
	public void agregarOpcion(Opcion opcion) {
		this.opciones.add(opcion);
	}
	
	public void removerOpcion(Opcion opcion) {
		this.opciones.remove(opcion);
	}
	
	
	
	

}
