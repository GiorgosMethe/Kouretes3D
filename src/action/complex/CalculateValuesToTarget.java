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
package action.complex;

import perceptor.localization.CompleteCoordinate;
import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import action.fsm.PKTGstates;
import action.vision.VisionType;

public class CalculateValuesToTarget {

	public static boolean Act(Coordinate Target) {

		VisionType.setType(3);

		if (PKTGstates.getTimeout() < 100) {

			int timeout = PKTGstates.getTimeout();
			PKTGstates.setTimeout((timeout + 1));
			Coordinate Co = TriangleLocalization
					.FindWalkingCoordinateToKick(Target);
			double X = PKTGstates.getProperPositionToWalk().getX() + Co.getX();
			double Y = PKTGstates.getProperPositionToWalk().getY() + Co.getY();
			PKTGstates.setProperPositionToWalk(new Coordinate(X, Y));

		} else {

			PKTGstates.setTimeout(0);
			PKTGstates.setResult(new CompleteCoordinate((PKTGstates
					.getProperPositionToWalk().X / 100), (PKTGstates
					.getProperPositionToWalk().Y / 100), TriangleLocalization
					.FindCoordinateAngleToKick(Target)));
			System.out.println("X:" + PKTGstates.getProperPositionToWalk().X
					/ 100);
			System.out.println("Y:" + PKTGstates.getProperPositionToWalk().Y
					/ 100);
			System.out.println("Theta:"
					+ TriangleLocalization.FindCoordinateAngleToKick(Target));
			return true;

		}
		return false;

	}
}
