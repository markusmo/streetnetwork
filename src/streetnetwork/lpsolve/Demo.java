package streetnetwork.lpsolve;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import lpsolve.LpSolve;
import lpsolve.LpSolveException;

public class Demo {
	public static void main(String[] args) {
		int dimX = 3;
		int dimY = 2;

		Kreuzung[][] kreuzungen = new Kreuzung[dimX][dimY];
		List<Strasse> strassen = new LinkedList<Strasse>();
		List<Source> sources = new LinkedList<Source>();

		init(kreuzungen, strassen, sources);

		String lpString = createLp(dimX, dimY, kreuzungen, strassen, sources);
		
		try {
			PrintWriter writer = new PrintWriter("model.lp", "UTF-8");
			writer.print(lpString);
			writer.close();

		      // Create a problem with 4 variables and 0 constraints
		      LpSolve lp = LpSolve.readLp("model.lp", LpSolve.NORMAL, "intersection model");

		      lp.setUseNames(true, true);
		      // solve the problem
		      lp.solve();

		      //lp.printLp();
		      
		      // print solution
		      System.out.println("Value of objective function: " + lp.getObjective());
		      double[] var = lp.getPtrVariables();
		      
		      int index = lp.getNameindex("o5B", false);
		      System.out.println("Value of o5B " + index + " " + var[index-1] );

		      // delete the problem and free memory
		      lp.deleteLp();
		    }
		    catch (LpSolveException e) {
		      // e.printStackTrace();
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			}
	}

	private static String createLp(int dimX, int dimY, Kreuzung[][] kreuzungen, List<Strasse> strassen, List<Source> sources) {
		StringBuilder sb = new StringBuilder();

		// Zielfunktion
		sb.append("max: ");

		for (int i = 0; i < sources.size(); i++) {
			Source source = sources.get(i);

			if (i > 0) {
				sb.append(" + ");
			}

			sb.append("i" + source.nach.kreuzungsid + source.nach.richtung + "");
		}

		sb.append(";\n\n");

		// Alle Kreuzungen hinzuf�gen
		for (int j = 0; j < dimY; j++) {
			for (int i = 0; i < dimX; i++) {
				sb.append(kreuzungen[i][j].print() + "\n");
			}
		}

		sb.append("\n\n");

		// Kreuzungen verbinden
		sb.append("\n\n");

		// Max Flow
		sb.append("// kreuzungen verbinden und max flow angeben\n");
		List<Zufahrt> zufahrtenBelegt = new LinkedList<Zufahrt>();

		for (Strasse strasse : strassen) {
			sb.append(strasse.print() + "\n");

			zufahrtenBelegt.add(strasse.von);
		}

		// zufl�sse
		sb.append("// Zufl�sse\n");

		for (Source source : sources) {
			sb.append(source.print() + "\n");

			zufahrtenBelegt.add(source.nach);
		}

		sb.append("\nc > 0; \n");
		sb.append("\n\n");

		// alle grenzen nullen
		sb.append("// Alle grenzen des systems nullen\n");

		for (int i = 0; i < dimX; i++) {
			for (int j = 0; j < dimY; j++) {
				Kreuzung kreuzung = kreuzungen[i][j];

				if (!zufahrtenBelegt.contains(kreuzung.A)) {
					sb.append("i" + kreuzung.A.kreuzungsid + kreuzung.A.richtung + " = 0;\n");
				}

				if (!zufahrtenBelegt.contains(kreuzung.B)) {
					sb.append("i" + kreuzung.B.kreuzungsid + kreuzung.B.richtung + " = 0;\n");
				}

				if (!zufahrtenBelegt.contains(kreuzung.C)) {
					sb.append("i" + kreuzung.C.kreuzungsid + kreuzung.C.richtung + " = 0;\n");
				}

				if (!zufahrtenBelegt.contains(kreuzung.D)) {
					sb.append("i" + kreuzung.D.kreuzungsid + kreuzung.D.richtung + " = 0;\n");
				}

				sb.append("\n");
			}
		}
	
		return sb.toString();
	}

	private static void init(Kreuzung[][] kreuzungen, List<Strasse> strassen, List<Source> sources) {
		kreuzungen[0][0] = new Kreuzung(0.5, 0, 0.5, 0, 1, 0, 0, 0, 0, 1, 0, 0);

		kreuzungen[1][0] = new Kreuzung(0, 0, 0, 0.5, 0.5, 0, 0, 0.5, 0.5, 0.5, 0, 0.5);

		kreuzungen[2][0] = new Kreuzung(0, 0.5, 0.5, 1, 0, 0, 0, 1, 0, 0, 0, 0);

		kreuzungen[0][1] = new Kreuzung(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);

		kreuzungen[1][1] = new Kreuzung(0.25, 0.25, 0.5, 0, 0, 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25);

		kreuzungen[2][1] = new Kreuzung(0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);

		addBidirectional(strassen, kreuzungen[0][0].D, kreuzungen[1][0].C, 10);
		addBidirectional(strassen, kreuzungen[1][0].D, kreuzungen[2][0].C, 10);

		addBidirectional(strassen, kreuzungen[0][0].B, kreuzungen[0][1].A, 10);
		addBidirectional(strassen, kreuzungen[1][0].B, kreuzungen[1][1].A, 10);
		addBidirectional(strassen, kreuzungen[2][0].B, kreuzungen[2][1].A, 10);

		addBidirectional(strassen, kreuzungen[0][1].D, kreuzungen[1][1].C, 10);
		addBidirectional(strassen, kreuzungen[1][1].D, kreuzungen[2][1].C, 10);

		sources.add(new Source(kreuzungen[0][0].A, 5));
		sources.add(new Source(kreuzungen[2][0].A, 1));
	}

	private static void addBidirectional(List<Strasse> strassen, Zufahrt zufahrt, Zufahrt c, int i) {
		strassen.add(new Strasse(zufahrt, c, i));
		strassen.add(new Strasse(c, zufahrt, i));
	}
}