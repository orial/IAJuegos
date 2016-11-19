package EspacioBaldurGate;

import java.util.List;

public class TestMapaBaldur {
	public static final int tam = 512;
	public static final int fini = 395;
	public static final int cini = 210;
	public static final int ffin = 201;
	public static final int cfin = 87;
	public static String nombMapa = "AR0011SR.map";

	public static int[] sol = new int[2];


	public static void main(String[] args) {

		int[] init = { fini, cini };
		MapaBaldur m = new MapaBaldur(nombMapa, init);

		PMapaBaldur pM = new PMapaBaldur(m, ffin, cfin);

		List<MapaBaldur> lm = pM.aMono();
		if (lm != null) {
			int fi = lm.get(0).getSolucion()[0];
			int ci = lm.get(0).getSolucion()[1];
			int ff = fi;
			int cf = ci;
			for (int i = 1; i < lm.size(); i++) {
				if (lm.get(i).getSolucion()[0] < fi) {
					fi = lm.get(i).getSolucion()[0];
				}
				if (lm.get(i).getSolucion()[0] > ff) {
					ff = lm.get(i).getSolucion()[0];
				}
				if (lm.get(i).getSolucion()[1] < ci) {
					ci = lm.get(i).getSolucion()[1];
				}
				if (lm.get(i).getSolucion()[1] > cf) {
					cf = lm.get(i).getSolucion()[1];
				}
			}

			for (MapaBaldur mb : lm) {
				MapaBaldur.mostrar[mb.getSolucion()[0]][mb.getSolucion()[1]] = "o";

				// mb.ver();
			}
			for (int i = fi; i < ff; i++) {
				for (int j = ci; j < cf; j++) {
					System.out.print(MapaBaldur.mostrar[i][j]);
				}
				System.out.println("\n");
			}
		} else {
			System.out.println("No se ha encontrado solucion");
		}
	}
}
