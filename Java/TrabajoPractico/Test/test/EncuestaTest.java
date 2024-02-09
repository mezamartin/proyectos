package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import Clases.Encuesta;
import Clases.PreguntaAbierta;
import Clases.ResultadoDeEncuesta;

public class EncuestaTest {
	private Encuesta encuesta1;
	private PreguntaAbierta pregunta1;
	private ResultadoDeEncuesta resultado1;
	private ResultadoDeEncuesta resultado2;
	
	@Before
	public void setUp(){
		encuesta1=new Encuesta(LocalDate.of(2018, 5, 22));
		pregunta1=new PreguntaAbierta("aca una Consigna");
		resultado1 = new ResultadoDeEncuesta("Juan", "Lopez", encuesta1);
		resultado2 = new ResultadoDeEncuesta("pepe", "Lopez", encuesta1);
	}
	
	@Test
	public void testUnaEncuestaConoceSuAntiguedad(){
		assertTrue(encuesta1.getAntiguedad()==1);
	}
	
	@Test
	public void testUnaEncuestaConoceSuFecha(){
		assertTrue(encuesta1.getFecha().isEqual(LocalDate.of(2018, 5, 22)));
	}

	@Test
	public void testUnaEncuestaEmpiezaConUnaListaDePreguntasVacia(){
		assertTrue(encuesta1.getListaDePreguntas().isEmpty());
		
	}
	
	@Test
	public void testUnaEncuestaAgregaUnaPreguntaASuListaDePreguntas(){
		encuesta1.agregarPregunta(pregunta1);
		assertFalse(encuesta1.getListaDePreguntas().isEmpty());
	}
	
	@Test
	public void testUnaEncuestaAgregaUnaPreguntaYDespuesLaRemueve(){
		encuesta1.agregarPregunta(pregunta1);
		encuesta1.removerPregunta(pregunta1);
		assertTrue(encuesta1.getListaDePreguntas().isEmpty());
	}
	
	@Test
	public void testUnaEncuestaConoceLaCantidadDePreguntasQueTiene(){
		encuesta1.agregarPregunta(pregunta1);
		assertTrue(encuesta1.getCantidadDePreguntas()==1);
		
	}
	
	@Test 
	public void testCuandoSeCreaUnaEncuestaTieneUnaListaDeResultadosVacia() {
		assertTrue(encuesta1.getListaDeResultados().isEmpty());
	}
	
	@Test
	public void testUnaEncuestaAgregaUnResultadoASuListaDeResultados() {
		encuesta1.publicar();
		encuesta1.agregarResultado(resultado1);
		assertFalse(encuesta1.getListaDeResultados().isEmpty());
	}
	
	@Test
	public void testUnaEncuestaAgregaUnResultadoYDespuesLoRemueve() {
		encuesta1.publicar();
		encuesta1.agregarResultado(resultado1);
		encuesta1.removerResultado(resultado1);
		assertTrue(encuesta1.getListaDeResultados().isEmpty());
	}
	
	
	@Test
	public void testUnaEncuestaConoceLaCantidadDeResultadosQueTiene(){
		encuesta1.publicar();
		encuesta1.agregarResultado(resultado1);
		encuesta1.agregarResultado(resultado2);
		assertTrue(encuesta1.getCantidadDeResultados()==2);
		
	}
	
	@Test
	public void testUnaEncuestaConoceQueResultadoTiene(){
		encuesta1.publicar();
		encuesta1.agregarResultado(resultado1);
		assertTrue(encuesta1.getListaDeResultados().contains(resultado1));
		
	}
	
	@Test
	public void testUnaEncuestaEnEtapaEnEdicionPuedeAgregarPreguntasPeroNoResultados(){
		encuesta1.agregarPregunta(pregunta1);
		encuesta1.agregarResultado(resultado1);
		assertTrue(encuesta1.getCantidadDePreguntas()==1);
		assertFalse(encuesta1.getCantidadDeResultados()==1);
	}
	
	@Test
	public void testUnaEncuestaEnEtapaActivaPuedeAgregarResultadosPeroNoPreguntas(){
		encuesta1.publicar();
		encuesta1.agregarPregunta(pregunta1);
		encuesta1.agregarResultado(resultado1);
		assertFalse(encuesta1.getCantidadDePreguntas()==1);
		assertTrue(encuesta1.getCantidadDeResultados()==1);
	}
	
	@Test
	public void testUnaEncuestaEnEtapaCerradaNoPuedeAgregarResultadosNiPreguntas(){
		encuesta1.publicar();
		encuesta1.cerrar();
		encuesta1.agregarPregunta(pregunta1);
		encuesta1.agregarResultado(resultado1);
		assertFalse(encuesta1.getCantidadDePreguntas()==1);
		assertFalse(encuesta1.getCantidadDeResultados()==1);
	}
	
	
	@Test
	public void testUnaEncuestaSabeCuandoEstaFinalizada(){
		encuesta1.publicar();
		encuesta1.cerrar();
		assertTrue(encuesta1.encuestaFinalizada());
	}
	
	@Test
	public void testUnaEncuestaCuandoNiBienSeCreaNoEstaFinalizada() {
		assertFalse(encuesta1.encuestaFinalizada());
	}
	
	
	
	
	
	

}
