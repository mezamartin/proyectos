package Clases;

import java.util.Comparator;

public class MayorAMenorCantidadDeResultados implements Comparator <Encuesta>{

	@Override
	public int compare(Encuesta e1, Encuesta e2) {
		if(e1.getCantidadDeResultados() > e2.getCantidadDeResultados()) return -1;
		if(e1.getCantidadDeResultados() < e2.getCantidadDeResultados()) return 1;
		return 0;
	}

}
