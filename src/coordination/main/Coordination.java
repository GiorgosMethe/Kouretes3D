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

import perceptor.utils.BallObservationFilter;
import coordination.TeamRoles.RoleAssignmentFunction;
import coordination.active.ActiveCoordination;
import coordination.strategy.ActivePositions;
import coordination.strategy.SupportPositions;
import coordination.strategy.TeamFormation;
import coordination.support.SupportCoordination;

public class Coordination {

	/*
	 * Here is the main coordination function, coordination administrator
	 * calculates the actions which maximize team reward
	 */
	public static boolean roboviz = false;

	public static long a, b;

	public static void MakeCoordination() {

		/*
		 * Admin agent updates his belief for the position of the ball and the
		 * players' position
		 */

		/*
		 * Players are going to be splitted in three coordination subsets.
		 * 
		 * Three vectors will be returned from this function. Each one of them
		 * will have a subset of agents which is going to coordinate together.
		 */

		if (CoordinationRun.getStep() == 1) {

			roboviz = false;

			a = System.currentTimeMillis();

			CoordinationType.AssignCoordinationType();

			BallObservationFilter.BallSampleVector.removeAllElements();

			CoordinationBeliefs.UpdateBeliefs();

			CoordinationRun.setStep(2);

			/*
			 * Players are going to be splitted in three coordination subsets.
			 * 
			 * Three vectors will be returned from this function. Each one of
			 * them will have a subset of agents which is going to coordinate
			 * together.
			 */
		} else if (CoordinationRun.getStep() == 2) {

			roboviz = true;

			CoordinationSplitter.Split();

			CoordinationRun.setStep(3);

			/*
			 * positions for active players are going to be calculated in
			 * relation with the ball position
			 * 
			 * Furthermore, a whole and independent team formation is going to
			 * be calculated
			 */
		} else if (CoordinationRun.getStep() == 3) {

			ActivePositions.Calculate();

			CoordinationRun.setStep(4);

			/*
			 * This function is called in order to find actions for all active
			 * agents which are going to minimize the global cost.
			 */

		} else if (CoordinationRun.getStep() == 4) {

			ActiveCoordination.Coordinate();

			CoordinationRun.setStep(5);

		} else if (CoordinationRun.getStep() == 5) {

			TeamFormation.Calculate();

			RoleAssignmentFunction.AssignRolesForPlayers();

			SupportPositions.Calculate();

			CoordinationRun.setStep(6);

		} else if (CoordinationRun.getStep() == 6) {

			SupportCoordination.Coordinate();

			CoordinationRun.setStep(0);

			b = System.currentTimeMillis();

			System.out.println("Coordination time: " + (b - a) + "ms"
					+ " (in 6 Simulation Cycles)");

			roboviz = true;

		} else {

		}

	}

}
