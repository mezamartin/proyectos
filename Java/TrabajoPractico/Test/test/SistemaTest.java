package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Clases.Encuesta;
import Clases.Investigador;
import Clases.Proyecto;
import Clases.Sistema;

public class SistemaTest {
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	private Investigador investigador1;
	private Sistema sistema1;
	private Encuesta encuesta1;
	private Encuesta encuesta2;
	private Encuesta encuesta3;
	private Encuesta encuesta4;
	private Encuesta encuesta5;
	private Encuesta encuesta6;
	private Encuesta encuesta7;
	private Encuesta encuesta8;
	private Encuesta encuesta9;
	private Encuesta encuesta10;
	private Encuesta encuesta11;
	private Encuesta encuesta12;
	private Encuesta encuesta13;
	private Encuesta encuesta14;
	private Encuesta encuesta15;
	private Encuesta encuesta16;
	private Encuesta encuesta17;
	private Encuesta encuesta18;
	private Encuesta encuesta19;
	private Encuesta encuesta20;
	private Encuesta encuesta21;
	private Encuesta encuesta22;
	private Encuesta encuesta23;
	private Encuesta encuesta24;
	private Encuesta encuesta25;
	private Encuesta encuesta26;
	private Encuesta encuesta27;
	



	@Before
	public void setUp(){
		
		
	}

	@Test
	public void testUnSistemaPuedeOrdenarSusProyectosAlfabeticamente() {
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		encuesta4 = mock(Encuesta.class);
		encuesta5 = mock(Encuesta.class);
		encuesta6 = mock(Encuesta.class);
		encuesta7 = mock(Encuesta.class);
		encuesta8 = mock(Encuesta.class);
		encuesta9 = mock(Encuesta.class);
		encuesta10 = mock(Encuesta.class);
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		investigador1 = mock(Investigador.class);
		
       List<Encuesta> listaE1 = new ArrayList <Encuesta>();
       
       List <Encuesta> listaE2 = new ArrayList <Encuesta>();
       
       List <Encuesta> listaE3 = new ArrayList <Encuesta>();
		
		listaE1.add(encuesta1);
		listaE1.add(encuesta2);
		listaE1.add(encuesta3);
		listaE2.add(encuesta4);
		listaE2.add(encuesta5);
		listaE2.add(encuesta6);
		listaE3.add(encuesta7);
		listaE3.add(encuesta8);
		listaE3.add(encuesta9);
		listaE3.add(encuesta10);
		
		when(proyecto1.getListaDeEncuestas()).thenReturn(listaE1);
		when(proyecto2.getListaDeEncuestas()).thenReturn(listaE2);
		when(proyecto3.getListaDeEncuestas()).thenReturn(listaE3);
		when(proyecto1.getDescripcion()).thenReturn("politica");
		when(proyecto2.getDescripcion()).thenReturn("cocina");
		when(proyecto3.getDescripcion()).thenReturn("aumentos");
		
		List <Proyecto> listaP = new ArrayList <Proyecto>();
		listaP.add(proyecto1);
		listaP.add(proyecto2);
		listaP.add(proyecto3);
		
		when(investigador1.getListaDeProyectos()).thenReturn(listaP);
		
		sistema1 = new Sistema(investigador1);
		sistema1.ordenarAlfabeticamente();
		assertEquals(sistema1.ordenarAlfabeticamente().get(0), encuesta7);
		assertEquals(sistema1.ordenarAlfabeticamente().get(1), encuesta8);
	}
	
	
	@Test
	public void testUnSistemaConoceLasEncuestasMasNuevas() {
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		encuesta4 = mock(Encuesta.class);
		encuesta5 = mock(Encuesta.class);
		encuesta6 = mock(Encuesta.class);
		encuesta7 = mock(Encuesta.class);
		encuesta8 = mock(Encuesta.class);
		encuesta9 = mock(Encuesta.class);
		encuesta10 = mock(Encuesta.class);
		proyecto1 = mock(Proyecto.class);
		investigador1 = mock(Investigador.class);
		
       List<Encuesta> listaE = new ArrayList <Encuesta>();
       
        when(encuesta1.getAntiguedad()).thenReturn(3);
		when(encuesta2.getAntiguedad()).thenReturn(7);
		when(encuesta3.getAntiguedad()).thenReturn(5);
		when(encuesta4.getAntiguedad()).thenReturn(8);
		when(encuesta5.getAntiguedad()).thenReturn(1);
		when(encuesta6.getAntiguedad()).thenReturn(6);
		when(encuesta7.getAntiguedad()).thenReturn(4);
		when(encuesta8.getAntiguedad()).thenReturn(2);
		when(encuesta9.getAntiguedad()).thenReturn(10);
		when(encuesta10.getAntiguedad()).thenReturn(9);
		
		listaE.add(encuesta1);
		listaE.add(encuesta2);
		listaE.add(encuesta3);
		listaE.add(encuesta4);
		listaE.add(encuesta5);
		listaE.add(encuesta6);
		listaE.add(encuesta7);
		listaE.add(encuesta8);
		listaE.add(encuesta9);
		listaE.add(encuesta10);
		
		when(proyecto1.getListaDeEncuestas()).thenReturn(listaE);
		
		List <Proyecto> listaP = new ArrayList <Proyecto>();
		listaP.add(proyecto1);
		
		when(investigador1.getListaDeProyectos()).thenReturn(listaP);
		
		sistema1 = new Sistema(investigador1);
		
		sistema1.getEncuestasMasNuevas();
		
		assertEquals(sistema1.getEncuestasMasNuevas().get(0), encuesta5);
		assertEquals(sistema1.getEncuestasMasNuevas().get(1), encuesta8);
		assertEquals(sistema1.getEncuestasMasNuevas().get(2), encuesta1);
		assertEquals(sistema1.getEncuestasMasNuevas().get(3), encuesta7);
		assertEquals(sistema1.getEncuestasMasNuevas().get(4), encuesta3);
		assertEquals(sistema1.getEncuestasMasNuevas().get(5), encuesta6);
		assertEquals(sistema1.getEncuestasMasNuevas().get(6), encuesta2);
		assertEquals(sistema1.getEncuestasMasNuevas().get(7), encuesta4);
		assertEquals(sistema1.getEncuestasMasNuevas().get(8), encuesta10);
		assertEquals(sistema1.getEncuestasMasNuevas().get(9), encuesta9);
	}
	
	
	@Test
	public void testUnSistemaConoceLas20EncuestasMasNuevas() {
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		encuesta4 = mock(Encuesta.class);
		encuesta5 = mock(Encuesta.class);
		encuesta6 = mock(Encuesta.class);
		encuesta7 = mock(Encuesta.class);
		encuesta8 = mock(Encuesta.class);
		encuesta9 = mock(Encuesta.class);
		encuesta10 = mock(Encuesta.class);
		encuesta11 = mock(Encuesta.class);
		encuesta12 = mock(Encuesta.class);
		encuesta13 = mock(Encuesta.class);
		encuesta14 = mock(Encuesta.class);
		encuesta15 = mock(Encuesta.class);
		encuesta16 = mock(Encuesta.class);
		encuesta17 = mock(Encuesta.class);
		encuesta18 = mock(Encuesta.class);
		encuesta19 = mock(Encuesta.class);
		encuesta20 = mock(Encuesta.class);
		encuesta21 = mock(Encuesta.class);
		encuesta22 = mock(Encuesta.class);
		proyecto1 = mock(Proyecto.class);
		investigador1 = mock(Investigador.class);
		
       List<Encuesta> listaE = new ArrayList <Encuesta>();
       
        when(encuesta1.getAntiguedad()).thenReturn(3);
		when(encuesta2.getAntiguedad()).thenReturn(7);
		when(encuesta3.getAntiguedad()).thenReturn(5);
		when(encuesta4.getAntiguedad()).thenReturn(8);
		when(encuesta5.getAntiguedad()).thenReturn(1);
		when(encuesta6.getAntiguedad()).thenReturn(6);
		when(encuesta7.getAntiguedad()).thenReturn(4);
		when(encuesta8.getAntiguedad()).thenReturn(2);
		when(encuesta9.getAntiguedad()).thenReturn(10);
		when(encuesta10.getAntiguedad()).thenReturn(11);
		when(encuesta11.getAntiguedad()).thenReturn(12);
		when(encuesta12.getAntiguedad()).thenReturn(13);
		when(encuesta13.getAntiguedad()).thenReturn(14);
		when(encuesta14.getAntiguedad()).thenReturn(15);
		when(encuesta15.getAntiguedad()).thenReturn(16);
		when(encuesta16.getAntiguedad()).thenReturn(17);
		when(encuesta17.getAntiguedad()).thenReturn(18);
		when(encuesta18.getAntiguedad()).thenReturn(19);
		when(encuesta19.getAntiguedad()).thenReturn(20);
		when(encuesta20.getAntiguedad()).thenReturn(21);
		when(encuesta21.getAntiguedad()).thenReturn(22);
		when(encuesta22.getAntiguedad()).thenReturn(23);
		
		listaE.add(encuesta1);
		listaE.add(encuesta2);
		listaE.add(encuesta3);
		listaE.add(encuesta4);
		listaE.add(encuesta5);
		listaE.add(encuesta6);
		listaE.add(encuesta7);
		listaE.add(encuesta8);
		listaE.add(encuesta9);
		listaE.add(encuesta10);
		listaE.add(encuesta11);
		listaE.add(encuesta12);
		listaE.add(encuesta13);
		listaE.add(encuesta14);
		listaE.add(encuesta15);
		listaE.add(encuesta16);
		listaE.add(encuesta17);
		listaE.add(encuesta18);
		listaE.add(encuesta19);
		listaE.add(encuesta20);
		listaE.add(encuesta21);
		listaE.add(encuesta22);
		
		when(proyecto1.getListaDeEncuestas()).thenReturn(listaE);
		
		List <Proyecto> listaP = new ArrayList <Proyecto>();
		listaP.add(proyecto1);
		
		when(investigador1.getListaDeProyectos()).thenReturn(listaP);
		
		sistema1 = new Sistema(investigador1);
		
		sistema1.getEncuestasMasNuevas();
		
		
		assertEquals(sistema1.getEncuestasMasNuevas().get(0), encuesta5);
		assertEquals(sistema1.getEncuestasMasNuevas().get(1), encuesta8);
		assertEquals(sistema1.getEncuestasMasNuevas().get(2), encuesta1);
		assertEquals(sistema1.getEncuestasMasNuevas().get(3), encuesta7);
		assertEquals(sistema1.getEncuestasMasNuevas().get(4), encuesta3);
		assertEquals(sistema1.getEncuestasMasNuevas().get(5), encuesta6);
		assertEquals(sistema1.getEncuestasMasNuevas().get(6), encuesta2);
		assertEquals(sistema1.getEncuestasMasNuevas().get(7), encuesta4);
		assertEquals(sistema1.getEncuestasMasNuevas().get(8), encuesta9);
		assertEquals(sistema1.getEncuestasMasNuevas().get(9), encuesta10);
		assertEquals(sistema1.getEncuestasMasNuevas().get(10), encuesta11);
		assertEquals(sistema1.getEncuestasMasNuevas().get(11), encuesta12);
		assertEquals(sistema1.getEncuestasMasNuevas().get(12), encuesta13);
		assertEquals(sistema1.getEncuestasMasNuevas().get(13), encuesta14);
		assertEquals(sistema1.getEncuestasMasNuevas().get(14), encuesta15);
		assertEquals(sistema1.getEncuestasMasNuevas().get(15), encuesta16);
		assertEquals(sistema1.getEncuestasMasNuevas().get(16), encuesta17);
		assertEquals(sistema1.getEncuestasMasNuevas().get(17), encuesta18);
		assertEquals(sistema1.getEncuestasMasNuevas().get(18), encuesta19);
		assertEquals(sistema1.getEncuestasMasNuevas().get(19), encuesta20);
		assertFalse(sistema1.getEncuestasMasNuevas().contains(encuesta21));
		assertFalse(sistema1.getEncuestasMasNuevas().contains(encuesta22));
		
	}
	
	@Test
	public void testUnSistemaConoceCualesSonLasEncuestasMasUsadas() {
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		encuesta4 = mock(Encuesta.class);
		encuesta5 = mock(Encuesta.class);
		encuesta6 = mock(Encuesta.class);
		encuesta7 = mock(Encuesta.class);
		encuesta8 = mock(Encuesta.class);
		encuesta9 = mock(Encuesta.class);
		encuesta10 = mock(Encuesta.class);
		proyecto1 = mock(Proyecto.class);
		investigador1 = mock(Investigador.class);
		
		List<Encuesta> listaE = new ArrayList <Encuesta>();
		
		when(encuesta1.getCantidadDeResultados()).thenReturn(7);
		when(encuesta2.getCantidadDeResultados()).thenReturn(5);
		when(encuesta3.getCantidadDeResultados()).thenReturn(6);
		when(encuesta4.getCantidadDeResultados()).thenReturn(3);
		when(encuesta5.getCantidadDeResultados()).thenReturn(1);
		when(encuesta6.getCantidadDeResultados()).thenReturn(2);
		when(encuesta7.getCantidadDeResultados()).thenReturn(8);
		when(encuesta8.getCantidadDeResultados()).thenReturn(9);
		when(encuesta9.getCantidadDeResultados()).thenReturn(4);
		when(encuesta10.getCantidadDeResultados()).thenReturn(10);
		
		listaE.add(encuesta1);
		listaE.add(encuesta2);
		listaE.add(encuesta3);
		listaE.add(encuesta4);
		listaE.add(encuesta5);
		listaE.add(encuesta6);
		listaE.add(encuesta7);
		listaE.add(encuesta8);
		listaE.add(encuesta9);
		listaE.add(encuesta10);
		
		
		when(proyecto1.getListaDeEncuestas()).thenReturn(listaE);
		
		List <Proyecto> listaP = new ArrayList <Proyecto>();
		listaP.add(proyecto1);
		
		when(investigador1.getListaDeProyectos()).thenReturn(listaP);
		
		
		sistema1 = new Sistema(investigador1);
		sistema1.getEncuestasMasUsadas();
		assertEquals(sistema1.getEncuestasMasUsadas().get(0), encuesta10);
		assertEquals(sistema1.getEncuestasMasUsadas().get(1), encuesta8);
		assertEquals(sistema1.getEncuestasMasUsadas().get(2), encuesta7);
		assertEquals(sistema1.getEncuestasMasUsadas().get(3), encuesta1);
		assertEquals(sistema1.getEncuestasMasUsadas().get(4), encuesta3);
		assertEquals(sistema1.getEncuestasMasUsadas().get(5), encuesta2);
		assertEquals(sistema1.getEncuestasMasUsadas().get(6), encuesta9);
		assertEquals(sistema1.getEncuestasMasUsadas().get(7), encuesta4);
		assertEquals(sistema1.getEncuestasMasUsadas().get(8), encuesta6);
		assertEquals(sistema1.getEncuestasMasUsadas().get(9), encuesta5);
	}
	
	@Test
	public void testUnSistemaConoceCualesSonLas25EncuestasMasUsadas() {
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		encuesta4 = mock(Encuesta.class);
		encuesta5 = mock(Encuesta.class);
		encuesta6 = mock(Encuesta.class);
		encuesta7 = mock(Encuesta.class);
		encuesta8 = mock(Encuesta.class);
		encuesta9 = mock(Encuesta.class);
		encuesta10 = mock(Encuesta.class);
		encuesta11 = mock(Encuesta.class);
		encuesta12 = mock(Encuesta.class);
		encuesta13 = mock(Encuesta.class);
		encuesta14 = mock(Encuesta.class);
		encuesta15 = mock(Encuesta.class);
		encuesta16 = mock(Encuesta.class);
		encuesta17 = mock(Encuesta.class);
		encuesta18 = mock(Encuesta.class);
		encuesta19 = mock(Encuesta.class);
		encuesta20 = mock(Encuesta.class);
		encuesta21 = mock(Encuesta.class);
		encuesta22 = mock(Encuesta.class);
		encuesta23 = mock(Encuesta.class);
		encuesta24 = mock(Encuesta.class);
		encuesta25 = mock(Encuesta.class);
		encuesta26 = mock(Encuesta.class);
		encuesta27 = mock(Encuesta.class);
		proyecto1 = mock(Proyecto.class);
		investigador1 = mock(Investigador.class);
		
		List<Encuesta> listaE = new ArrayList <Encuesta>();
		
		when(encuesta1.getCantidadDeResultados()).thenReturn(7);
		when(encuesta2.getCantidadDeResultados()).thenReturn(5);
		when(encuesta3.getCantidadDeResultados()).thenReturn(6);
		when(encuesta4.getCantidadDeResultados()).thenReturn(3);
		when(encuesta5.getCantidadDeResultados()).thenReturn(1);
		when(encuesta6.getCantidadDeResultados()).thenReturn(2);
		when(encuesta7.getCantidadDeResultados()).thenReturn(8);
		when(encuesta8.getCantidadDeResultados()).thenReturn(9);
		when(encuesta9.getCantidadDeResultados()).thenReturn(4);
		when(encuesta10.getCantidadDeResultados()).thenReturn(10);
		when(encuesta11.getCantidadDeResultados()).thenReturn(13);
		when(encuesta12.getCantidadDeResultados()).thenReturn(14);
		when(encuesta13.getCantidadDeResultados()).thenReturn(15);
		when(encuesta14.getCantidadDeResultados()).thenReturn(16);
		when(encuesta15.getCantidadDeResultados()).thenReturn(17);
		when(encuesta16.getCantidadDeResultados()).thenReturn(18);
		when(encuesta17.getCantidadDeResultados()).thenReturn(19);
		when(encuesta18.getCantidadDeResultados()).thenReturn(20);
		when(encuesta19.getCantidadDeResultados()).thenReturn(21);
		when(encuesta20.getCantidadDeResultados()).thenReturn(22);
		when(encuesta21.getCantidadDeResultados()).thenReturn(23);
		when(encuesta22.getCantidadDeResultados()).thenReturn(24);
		when(encuesta23.getCantidadDeResultados()).thenReturn(25);
		when(encuesta24.getCantidadDeResultados()).thenReturn(26);
		when(encuesta25.getCantidadDeResultados()).thenReturn(27);
		when(encuesta26.getCantidadDeResultados()).thenReturn(28);
		when(encuesta27.getCantidadDeResultados()).thenReturn(29);
		
		listaE.add(encuesta1);
		listaE.add(encuesta2);
		listaE.add(encuesta3);
		listaE.add(encuesta4);
		listaE.add(encuesta5);
		listaE.add(encuesta6);
		listaE.add(encuesta7);
		listaE.add(encuesta8);
		listaE.add(encuesta9);
		listaE.add(encuesta10);
		listaE.add(encuesta11);
		listaE.add(encuesta12);
		listaE.add(encuesta13);
		listaE.add(encuesta14);
		listaE.add(encuesta15);
		listaE.add(encuesta16);
		listaE.add(encuesta17);
		listaE.add(encuesta18);
		listaE.add(encuesta19);
		listaE.add(encuesta20);
		listaE.add(encuesta21);
		listaE.add(encuesta22);
		listaE.add(encuesta23);
		listaE.add(encuesta24);
		listaE.add(encuesta25);
		listaE.add(encuesta26);
		listaE.add(encuesta27);
		
		
		when(proyecto1.getListaDeEncuestas()).thenReturn(listaE);
		
		List <Proyecto> listaP = new ArrayList <Proyecto>();
		listaP.add(proyecto1);
		
		when(investigador1.getListaDeProyectos()).thenReturn(listaP);
		
		
		sistema1 = new Sistema(investigador1);
		sistema1.getEncuestasMasUsadas();
		assertEquals(sistema1.getEncuestasMasUsadas().get(0), encuesta27);
		assertEquals(sistema1.getEncuestasMasUsadas().get(1), encuesta26);
		assertEquals(sistema1.getEncuestasMasUsadas().get(2), encuesta25);
		assertEquals(sistema1.getEncuestasMasUsadas().get(3), encuesta24);
		assertEquals(sistema1.getEncuestasMasUsadas().get(4), encuesta23);
		assertEquals(sistema1.getEncuestasMasUsadas().get(5), encuesta22);
		assertEquals(sistema1.getEncuestasMasUsadas().get(6), encuesta21);
		assertEquals(sistema1.getEncuestasMasUsadas().get(7), encuesta20);
		assertEquals(sistema1.getEncuestasMasUsadas().get(8), encuesta19);
		assertEquals(sistema1.getEncuestasMasUsadas().get(9), encuesta18);
		assertEquals(sistema1.getEncuestasMasUsadas().get(10), encuesta17);
		assertEquals(sistema1.getEncuestasMasUsadas().get(11), encuesta16);
		assertEquals(sistema1.getEncuestasMasUsadas().get(12), encuesta15);
		assertEquals(sistema1.getEncuestasMasUsadas().get(13), encuesta14);
		assertEquals(sistema1.getEncuestasMasUsadas().get(14), encuesta13);
		assertEquals(sistema1.getEncuestasMasUsadas().get(15), encuesta12);
		assertEquals(sistema1.getEncuestasMasUsadas().get(16), encuesta11);
		assertEquals(sistema1.getEncuestasMasUsadas().get(17), encuesta10);
		assertEquals(sistema1.getEncuestasMasUsadas().get(18), encuesta8);
		assertEquals(sistema1.getEncuestasMasUsadas().get(19), encuesta7);
		assertEquals(sistema1.getEncuestasMasUsadas().get(20), encuesta1);
		assertEquals(sistema1.getEncuestasMasUsadas().get(21), encuesta3);
		assertEquals(sistema1.getEncuestasMasUsadas().get(22), encuesta2);
		assertEquals(sistema1.getEncuestasMasUsadas().get(23), encuesta9);
		assertEquals(sistema1.getEncuestasMasUsadas().get(24), encuesta4);
		assertFalse(sistema1.getEncuestasMasUsadas().contains(encuesta5));
		assertFalse(sistema1.getEncuestasMasUsadas().contains(encuesta6));	
	}
	
	
	
	@Test
	public void testUnSistemaConoceTodasLasEncuestas() {
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		encuesta4 = mock(Encuesta.class);
		encuesta5 = mock(Encuesta.class);
		encuesta6 = mock(Encuesta.class);
		encuesta7 = mock(Encuesta.class);
		encuesta8 = mock(Encuesta.class);
		encuesta9 = mock(Encuesta.class);
		encuesta10 = mock(Encuesta.class);
		proyecto1 = mock(Proyecto.class);
		investigador1 = mock(Investigador.class);
		
		List<Encuesta> listaE = new ArrayList <Encuesta>();
		
		listaE.add(encuesta1);
		listaE.add(encuesta2);
		listaE.add(encuesta3);
		listaE.add(encuesta4);
		listaE.add(encuesta5);
		listaE.add(encuesta6);
		listaE.add(encuesta7);
		listaE.add(encuesta8);
		listaE.add(encuesta9);
		listaE.add(encuesta10);
		
		when(proyecto1.getListaDeEncuestas()).thenReturn(listaE);
		
		List <Proyecto> listaP = new ArrayList <Proyecto>();
		listaP.add(proyecto1);
		
		when(investigador1.getListaDeProyectos()).thenReturn(listaP);
		
		sistema1 = new Sistema(investigador1);
		
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta1));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta2));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta3));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta4));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta5));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta6));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta7));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta8));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta9));
		assertTrue(sistema1.todasLasEncuestas().contains(encuesta10));
	}

}
