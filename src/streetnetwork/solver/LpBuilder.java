package streetnetwork.solver;

import java.util.LinkedList;
import java.util.List;

public class LpBuilder {
	public String createLp(int dimX, int dimY, Intersection[][] intersections, List<Street> streets,
			List<Source> sources) {
		StringBuilder sb = new StringBuilder();

		// Target function
		sb.append("max: ");

		for (int i = 0; i < sources.size(); i++) {
			Source source = sources.get(i);

			if (i > 0) {
				sb.append(" + ");
			}

			sb.append("i" + source.to.intersection_id + source.to.direction + "");
		}

		sb.append(";\n\n");

		// Add intersections
		for (int j = 0; j < dimY; j++) {
			for (int i = 0; i < dimX; i++) {
				sb.append(intersections[i][j].print() + "\n");
			}
		}

		sb.append("\n\n\n\n");

		// Max Flow
		sb.append("// connect intersections and add max flow\n");
		List<Direction> accessUsed = new LinkedList<Direction>();

		for (Street street : streets) {
			sb.append(street.print() + "\n");

			accessUsed.add(street.from);
		}

		// sources
		sb.append("// Sources\n");

		for (Source source : sources) {
			sb.append(source.print() + "\n");

			accessUsed.add(source.to);
		}

		sb.append("\nc > 0; \n");
		sb.append("\n\n");

		sb.append("// set all szstem borders to 0\n");

		for (int i = 0; i < dimX; i++) {
			for (int j = 0; j < dimY; j++) {
				Intersection intersection = intersections[i][j];

				if (!accessUsed.contains(intersection.A)) {
					sb.append("i" + intersection.A.intersection_id + intersection.A.direction + " = 0;\n");
				}

				if (!accessUsed.contains(intersection.B)) {
					sb.append("i" + intersection.B.intersection_id + intersection.B.direction + " = 0;\n");
				}

				if (!accessUsed.contains(intersection.C)) {
					sb.append("i" + intersection.C.intersection_id + intersection.C.direction + " = 0;\n");
				}

				if (!accessUsed.contains(intersection.D)) {
					sb.append("i" + intersection.D.intersection_id + intersection.D.direction + " = 0;\n");
				}

				sb.append("\n");
			}
		}

		return sb.toString();
	}
}
