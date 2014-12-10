package streetnetwork.solver;

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

		Intersection[][] intersections = new Intersection[dimX][dimY];
		List<Street> streets = new LinkedList<Street>();
		List<Source> sources = new LinkedList<Source>();

		init(intersections, streets, sources);

		String lpString = new LpBuilder().createLp(dimX, dimY, intersections, streets, sources);

		try {
			PrintWriter writer = new PrintWriter("model.lp", "UTF-8");
			writer.print(lpString);
			writer.close();

			// Create a problem with 4 variables and 0 constraints
			LpSolve lp = LpSolve.readLp("model.lp", LpSolve.NORMAL, "intersection model");

			lp.setUseNames(true, true);
			// solve the problem
			lp.solve();

			// print solution
			System.out.println("Value of objective function: " + lp.getObjective());
			double[] var = lp.getPtrVariables();

			int index = lp.getNameindex("o5B", false);
			System.out.println("Value of o5B " + index + " " + var[index - 1]);

			// delete the problem and free memory
			lp.deleteLp();
		} catch (LpSolveException e) {
			// e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}



	private static void init(Intersection[][] intersections, List<Street> streets, List<Source> sources) {
		intersections[0][0] = new Intersection(0.5, 0, 0.5, 0, 1, 0, 0, 0, 0, 1, 0, 0);

		intersections[1][0] = new Intersection(0, 0, 0, 0.5, 0.5, 0, 0, 0.5, 0.5, 0.5, 0, 0.5);

		intersections[2][0] = new Intersection(0, 0.5, 0.5, 1, 0, 0, 0, 1, 0, 0, 0, 0);

		intersections[0][1] = new Intersection(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);

		intersections[1][1] = new Intersection(0.25, 0.25, 0.5, 0, 0, 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25);

		intersections[2][1] = new Intersection(0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);

		addBidirectional(streets, intersections[0][0].D, intersections[1][0].C, 10);
		addBidirectional(streets, intersections[1][0].D, intersections[2][0].C, 10);

		addBidirectional(streets, intersections[0][0].B, intersections[0][1].A, 10);
		addBidirectional(streets, intersections[1][0].B, intersections[1][1].A, 10);
		addBidirectional(streets, intersections[2][0].B, intersections[2][1].A, 10);

		addBidirectional(streets, intersections[0][1].D, intersections[1][1].C, 10);
		addBidirectional(streets, intersections[1][1].D, intersections[2][1].C, 10);

		sources.add(new Source(intersections[0][0].A, 5));
		sources.add(new Source(intersections[2][0].A, 1));
	}

	private static void addBidirectional(List<Street> streets, Direction from, Direction to, int max) {
		streets.add(new Street(from, to, max));
		streets.add(new Street(to, from, max));
	}
}