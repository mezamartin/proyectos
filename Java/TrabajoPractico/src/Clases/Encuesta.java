package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encuesta{
	private List<Pregunta> preguntas;
	private List <ResultadoDeEncuesta> resultados;
	private LocalDate fecha;
	//private AdministradorDeEncuesta administrador;
	private Etapa etapa;
	
	public Encuesta(LocalDate fecha){
		preguntas=new ArrayList<Pregunta>();
		resultados = new ArrayList <ResultadoDeEncuesta>();
		this.fecha=fecha;
		etapa=new EnEdicion();
	}
	
	public LocalDate getFecha(){
		return this.fecha;
	}
	
	public Integer getAntiguedad(){
		return LocalDate.now().getYear()-this.getFecha().getYear();
	}
	

	public List<Pregunta> getListaDePreguntas(){
		return this.preguntas;
	}
	
	public void agregarPregunta(Pregunta pregunta){
		this.etapa.agregarPregunta(pregunta, this);
	}
	

	
	public void removerPregunta(Pregunta pregunta){
		this.etapa.removerPregunta(pregunta, this);
		
	}
	
	public Integer getCantidadDePreguntas(){
		return this.preguntas.size();
	}

	public List<ResultadoDeEncuesta> getListaDeResultados() {
		return this.resultados;
	}

	public void agregarResultado(ResultadoDeEncuesta resultado) {
		this.etapa.agregarResultado(resultado, this);
	}

	public void removerResultado(ResultadoDeEncuesta resultado) {
		this.etapa.removerResultado(resultado, this);
		
	}

	public Integer getCantidadDeResultados() {
		return this.resultados.size();
	}
	
	public void incluirPregunta(Pregunta pregunta){
		this.preguntas.add(pregunta);
	}
	
	public void quitarPregunta(Pregunta pregunta){
		this.preguntas.remove(pregunta);
	}
	
	public void incluirResultado(ResultadoDeEncuesta resultado){
		this.resultados.add(resultado);
	}
	
	public void quitarResultado(ResultadoDeEncuesta resultado){
		this.resultados.remove(resultado);
	}
	
	public void publicar() {
		this.etapa.publicar(this);
	}
	
	public void cerrar() {
		this.etapa.cerrar(this);
	}
	
	public void setEstado(Etapa etapa) {
		this.etapa = etapa;
	}
	

	public Boolean encuestaFinalizada(){
		return this.etapa.estaFinalizada();
	}

	
	
	
}
