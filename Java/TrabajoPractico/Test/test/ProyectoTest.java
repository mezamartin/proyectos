package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;


import Clases.Encuesta;
import Clases.Proyecto;
import Clases.ResultadoDeEncuesta;

public class ProyectoTest {
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	private Encuesta encuesta1;
	private Encuesta encuesta2;
	private Encuesta encuesta3;
	private Encuesta encuesta4;
	private ResultadoDeEncuesta resultado1;
	private ResultadoDeEncuesta resultado2;
	private ResultadoDeEncuesta resultado3;
	
	
	@Before 
	public void setUp() {
		proyecto1= new Proyecto ("este es un proyecto", "con un proposito");
		resultado1=new ResultadoDeEncuesta("pepe","Gonzales",encuesta1);
		resultado2=new ResultadoDeEncuesta("pepe","Gonzales",encuesta2);
		resultado3=new ResultadoDeEncuesta("pepa","Gonzales",encuesta2);
		encuesta1=new Encuesta(LocalDate.of(2018, 5, 22));
		encuesta2=new Encuesta(LocalDate.of(2018, 5, 22));
		encuesta3=new Encuesta(LocalDate.of(2018, 5, 22));
		encuesta4=new Encuesta(LocalDate.of(2018, 5, 22));
		proyecto2= new Proyecto ("este es un proyecto2", "con un proposito2");
		proyecto3= new Proyecto ("este es un proyecto3", "con un proposito3");
	}

	@Test
	public void testUnProyectoConoceSuProposito() {
		assertTrue(proyecto1.getProposito()=="con un proposito");
	}
	
	@Test
	public void testUnProyectoConoceSuDescripcion() {
		assertTrue(proyecto1.getDescripcion()=="este es un proyecto");
	}
	
	@Test
	public void testUnProyectoEmpiezaSinEncuestas(){
		assertTrue(proyecto1.getListaDeEncuestas().isEmpty());
	}
	
	@Test
	public void testUnProyectoAgregaUnaEncuesta(){
		proyecto1.agregarEncuesta(encuesta1);
		assertFalse(proyecto1.getListaDeEncuestas().isEmpty());
	}
	
	@Test
	public void testUnProyectoAgregaUnaEncuestaYLuegoLaRemueve(){
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.removerEncuesta(encuesta1);
		assertTrue(proyecto1.getListaDeEncuestas().isEmpty());
	}
	
	@Test
	public void testUnProyectoConoceLaCantidaSuCantidadDeEncuestas(){
		proyecto1.agregarEncuesta(encuesta1);
		assertTrue(proyecto1.getCantidadDeEncuestas()==1);
	}
	
	@Test
	public void testUnProyectoSabeSiUnaEncuestaEstaEnSuLista(){
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.agregarEncuesta(encuesta2);
		proyecto1.agregarEncuesta(encuesta3);
		assertTrue(proyecto1.getListaDeEncuestas().contains(encuesta1));
		assertTrue(proyecto1.getListaDeEncuestas().contains(encuesta2));
		assertTrue(proyecto1.getListaDeEncuestas().contains(encuesta3));
	}
	
	@Test
	public void testUnProyectoSabeSiUnaEncuestaNoEstaEnSuLista(){
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.agregarEncuesta(encuesta2);
		proyecto1.agregarEncuesta(encuesta3);
		assertFalse(proyecto1.getListaDeEncuestas().contains(encuesta4));
	}
	
	@Test
	public void testUnProyectoConoceLaEncuestaConMasResultados(){
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.agregarEncuesta(encuesta2);
		encuesta1.publicar();
		encuesta2.publicar();
		encuesta1.agregarResultado(resultado1);
		encuesta2.agregarResultado(resultado2);
		encuesta2.agregarResultado(resultado3);
		assertTrue(proyecto1.getEncuestaConMayorCantidadDeResultados()==encuesta2);
	}
	
	@Test
	public void testUnProyectoEmpiezaSinSubProyectos(){
		assertTrue(proyecto1.getListaDeSubproyectos().isEmpty());
	}
	
	@Test
	public void testUnPoryectoAgregaUnSubProyecto(){
		proyecto1.agregarSubproyecto(proyecto2);
		assertFalse(proyecto1.getListaDeSubproyectos().isEmpty());
	}
	
	@Test
	public void testUnProyectoAgregaUnSubProyectoYDespuesLoRemueve(){
		proyecto1.agregarSubproyecto(proyecto2);
		proyecto1.removerSubproyecto(proyecto2);
		assertTrue(proyecto1.getListaDeSubproyectos().isEmpty());
	}
	
	@Test
	public void testUnProyectoConoceLaCantidadDeSubProyectosQueTiene(){
		proyecto1.agregarSubproyecto(proyecto2);
		assertTrue(proyecto1.getCantidadDeSubproyectos()==1);
		
	}
	
	@Test
	public void testUnProyectoSabeQueSubProyectosTieneEnSuLista(){
		proyecto1.agregarSubproyecto(proyecto2);
		assertTrue(proyecto1.getListaDeSubproyectos().contains(proyecto2));
		assertFalse(proyecto1.getListaDeSubproyectos().contains(proyecto3));
	}
	
	@Test
	public void testUnProyectoNoPuedeAgregarASusSubProyectosSuProyectoContenedor(){
		proyecto1.agregarSubproyecto(proyecto2);
		proyecto2.agregarSubproyecto(proyecto1);
		assertTrue(proyecto2.getListaDeSubproyectos().isEmpty());
	}
	
	@Test
	public void testUnProyectoEstaFinalizadoCuandoTodosSusSubProyectosYTodasSusEncuestasEstanFinalizadas(){
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.agregarSubproyecto(proyecto2);
		proyecto2.agregarEncuesta(encuesta3);
		encuesta1.publicar();
		encuesta1.cerrar();
		encuesta3.publicar();
		encuesta3.cerrar();
		assertTrue(proyecto1.estaFinalizada());
	}
	
	
	@Test
	public void testUnProyectoNoEstaFinalizadoCuandoTodosSusSubProyectosYTodasSusEncuestasEstanFinalizadas(){
		proyecto1.agregarEncuesta(encuesta1);
		proyecto1.agregarSubproyecto(proyecto2);
		proyecto2.agregarEncuesta(encuesta3);
		encuesta1.publicar();
		encuesta1.cerrar();
		encuesta3.publicar();
		assertFalse(proyecto1.estaFinalizada());
	}
	
	
	
	
	
	
	

}
