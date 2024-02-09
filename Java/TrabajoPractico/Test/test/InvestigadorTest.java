package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import Clases.Encuesta;
import Clases.Investigador;
import Clases.Proyecto;
import Clases.ResultadoDeEncuesta;

public class InvestigadorTest {
	private Investigador investigador1;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	private Proyecto proyecto4;
	private Encuesta encuesta1;
	private Encuesta encuesta2;
	private Encuesta encuesta3;
	private Encuesta encuesta4;
	private ResultadoDeEncuesta resultado1;
	private ResultadoDeEncuesta resultado2;
	private ResultadoDeEncuesta resultado3;
	private ResultadoDeEncuesta resultado4;
	private ResultadoDeEncuesta resultado5;
	private ResultadoDeEncuesta resultado6;
	
	
	@Before
	public void setUp(){
		investigador1=new Investigador("pepe","rodriguez",25567900);
		encuesta1 = new Encuesta(LocalDate.of(2010, 04, 27));
		encuesta2 = new Encuesta(LocalDate.of(2016, 06, 20));
		encuesta3 = new Encuesta(LocalDate.of(2012, 03, 12));
		encuesta4 = new Encuesta(LocalDate.of(2013, 10, 23));
		resultado1 = new ResultadoDeEncuesta("juan" , "lopez", encuesta1);
		resultado2 = new ResultadoDeEncuesta("diego" , "sanchez", encuesta2);
		resultado3 = new ResultadoDeEncuesta("jose", "martinez", encuesta3);
		resultado4 = new ResultadoDeEncuesta("jose", "martinez", encuesta1);
		resultado5 = new ResultadoDeEncuesta("jose", "martinez", encuesta1);
		resultado6 = new ResultadoDeEncuesta("jose", "martinez", encuesta3);
		proyecto1=new Proyecto("politica","proposito");
		proyecto2=new Proyecto("cocina","proposito2");
		proyecto3=new Proyecto("economia","proposito3");
		proyecto4 = new Proyecto("religion", "proposito4");
	}
	

	@Test
	public void testUnInvestigadorTieneUnNombre() {
		assertTrue(investigador1.getNombre()=="pepe");
	}
	
	@Test
	public void testUnInvestigadorTieneUnApellido() {
		assertTrue(investigador1.getApellido()=="rodriguez");
	}
	
	@Test
	public void testUnInvestigadorTieneUnDni() {
		assertTrue(investigador1.getDni()==25567900);
	}
	
	@Test
	public void testUnInvestigadorTieneUnaListaDeProyectosVacia() {
		assertTrue(investigador1.getListaDeProyectos().isEmpty());
	}
	
	@Test
	public void testUnInvestigadorAgregaUnProyectoAsuLista() {
		investigador1.agregarProyecto(proyecto1);
		assertFalse(investigador1.getListaDeProyectos().isEmpty());
	}
	
	@Test
	public void testUnInvestigadorAgregaUnProyectoAsuListaYDespuesLoSaca() {
		investigador1.agregarProyecto(proyecto1);
		investigador1.sacarProyecto(proyecto1);
		assertTrue(investigador1.getListaDeProyectos().isEmpty());
	}
	
	@Test
	public void testUnInvestigadorConoceLaCantidadDeProyectosQueTieneEnSuLista() {
		investigador1.agregarProyecto(proyecto1);
		assertTrue(investigador1.getCantidadDeProyectos()==1);
	}
	@Test
	public void testUnInvestigadorSabeSiUnProyectoEstaEnSuLista(){
		investigador1.agregarProyecto(proyecto1);
		investigador1.agregarProyecto(proyecto2);
		assertTrue(investigador1.getListaDeProyectos().contains(proyecto1));
		assertTrue(investigador1.getListaDeProyectos().contains(proyecto2));
	}
	
	@Test
	public void testUnInvestigadorSabeSiUnProyectoNoEstaEnSuLista(){
		investigador1.agregarProyecto(proyecto1);
		investigador1.agregarProyecto(proyecto2);
		assertFalse(investigador1.getListaDeProyectos().contains(proyecto3));
	}
	
	
	@Test
	public void testUnInvestigadorConoceSusProyectosYLosSubproyectosDeLosMismos(){
		proyecto1.agregarSubproyecto(proyecto2);
		investigador1.agregarProyecto(proyecto1);
		assertTrue(investigador1.getCantidadDeProyectos()==1);
		assertTrue(investigador1.getListaDeProyectos().contains(proyecto1));
		assertFalse(investigador1.getListaDeProyectos().contains(proyecto2));
	}
	
	

}
