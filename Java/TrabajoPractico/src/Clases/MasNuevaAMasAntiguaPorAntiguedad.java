package Clases;

import java.util.Comparator;

public class MasNuevaAMasAntiguaPorAntiguedad implements Comparator <Encuesta> {

	@Override
	public int compare(Encuesta e1, Encuesta e2) {
		if(e1.getAntiguedad() > e2.getAntiguedad())return 1;
		if(e1.getAntiguedad() < e2.getAntiguedad())return -1;
		return 0;
	}

}
