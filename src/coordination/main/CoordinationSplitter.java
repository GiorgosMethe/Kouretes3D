/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package coordination.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import coordination.communication.message.CoordinationMessage;
import coordination.communication.message.CoordinationVectorUpdate;

public class CoordinationSplitter {

	public static Vector<CoordinationMessage> ActiveSubset = new Vector<CoordinationMessage>();
	public static Vector<CoordinationMessage> SupportSubset = new Vector<CoordinationMessage>();
	public static Vector<CoordinationMessage> InactiveSubset = new Vector<CoordinationMessage>();

	public static void Split() {

		// clear previous created subsets
		ActiveSubset.clear();
		SupportSubset.clear();
		InactiveSubset.clear();

		final Comparator<CoordinationMessage> POSITIVE_ORDER = new Comparator<CoordinationMessage>() {

			@Override
			public int compare(CoordinationMessage e1, CoordinationMessage e2) {
				boolean Cmp = e2.getRealDistance() >= (e1.getRealDistance());
				if (Cmp != true) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		// sort coordination vector
		Collections.sort(CoordinationVectorUpdate.CoordinationVector,
				POSITIVE_ORDER);

		/*
		 * Creation of three subsets 3 players will be added into active subset
		 * the rest players will be added either into the passive subset or into
		 * the inactive subset
		 */

		if (CoordinationType.Type.equalsIgnoreCase("Active")) {

			ActiveSubset.addElement(CoordinationVectorUpdate.CoordinationVector
					.elementAt(0));
			ActiveSubset.addElement(CoordinationVectorUpdate.CoordinationVector
					.elementAt(1));
			ActiveSubset.addElement(CoordinationVectorUpdate.CoordinationVector
					.elementAt(2));

			for (int i = 3; i < CoordinationVectorUpdate.CoordinationVector
					.size(); i++) {

				if (CoordinationVectorUpdate.CoordinationVector.elementAt(i)
						.getType() != 3) {

					SupportSubset
							.addElement(CoordinationVectorUpdate.CoordinationVector
									.elementAt(i));

				} else {

					InactiveSubset
							.addElement(CoordinationVectorUpdate.CoordinationVector
									.elementAt(i));

				}
			}

		} else if (CoordinationType.Type.equalsIgnoreCase("Support")) {

			for (int i = 0; i < CoordinationVectorUpdate.CoordinationVector
					.size(); i++) {

				if (CoordinationVectorUpdate.CoordinationVector.elementAt(i)
						.getType() != 3) {

					SupportSubset
							.addElement(CoordinationVectorUpdate.CoordinationVector
									.elementAt(i));

				} else {

					InactiveSubset
							.addElement(CoordinationVectorUpdate.CoordinationVector
									.elementAt(i));

				}
			}

		} else if (CoordinationType.Type.equalsIgnoreCase("PassiveWait")) {

			for (int i = 0; i < CoordinationVectorUpdate.CoordinationVector
					.size(); i++) {

				if (CoordinationVectorUpdate.CoordinationVector.elementAt(i)
						.getType() != 3) {

					SupportSubset
							.addElement(CoordinationVectorUpdate.CoordinationVector
									.elementAt(i));

				} else {

					InactiveSubset
							.addElement(CoordinationVectorUpdate.CoordinationVector
									.elementAt(i));

				}
			}

		} else {
			System.err.println("ERROR UNKNOWN COORDINATION TYPE");
		}

	}

}
