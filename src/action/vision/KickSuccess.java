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
package action.vision;

import perceptor.localization.Coordinate;

public class KickSuccess {

	public static Coordinate start;
	public static Coordinate end;

	public static boolean Check() {

		float movementX = (float) Math.abs(getEnd().X - getStart().X);
		float movementY = (float) Math.abs(getEnd().Y - getStart().Y);

		float move = (float) Math.sqrt(Math.pow(movementX, 2)
				+ Math.pow(movementY, 2));

		if (move > 1) {
			return true;
		} else {
			return false;
		}

	}

	public static Coordinate getStart() {
		return start;
	}

	public static void setStart(Coordinate start) {
		KickSuccess.start = start;
	}

	public static Coordinate getEnd() {
		return end;
	}

	public static void setEnd(Coordinate end) {
		KickSuccess.end = end;
	}

}
