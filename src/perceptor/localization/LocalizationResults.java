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
package perceptor.localization;

import java.util.Vector;

public class LocalizationResults {
	public LocalizationResults() {
		// TODO Auto-generated constructor stub
	}

	public static Coordinate current_location, ball_location;

	public static Coordinate getBall_location() {
		return ball_location;
	}

	public static void setBall_location(Coordinate ball_location) {
		LocalizationResults.ball_location = ball_location;
	}

	public static double head_angle, body_angle, ball_angle;
	public static boolean KnowMyPosition;
	public static Vector<Landmark> landmarks = new Vector<Landmark>();
	public static Vector<Landmark> coplayers = new Vector<Landmark>();
	public static Vector<Landmark> rivals = new Vector<Landmark>();

	public static boolean isKnowMyPosition() {
		return KnowMyPosition;
	}

	public static void setKnowMyPosition(boolean knowMyPosition) {
		KnowMyPosition = knowMyPosition;
	}

	public static double getBall_angle() {
		return ball_angle;
	}

	public static void setBall_angle(double ball_angle) {
		LocalizationResults.ball_angle = ball_angle;
	}

	public static Coordinate getCurrent_location() {
		return current_location;
	}

	public static void setCurrent_location(Coordinate current_location) {
		LocalizationResults.current_location = current_location;
	}

	public static double getHead_angle() {
		return head_angle;
	}

	public static void setHead_angle(double head_angle) {
		LocalizationResults.head_angle = head_angle;
	}

	public static double getBody_angle() {
		return body_angle;
	}

	public static void setBody_angle(double body_angle) {
		LocalizationResults.body_angle = body_angle;
	}

	public static Vector<Landmark> getLandmarks() {
		return landmarks;
	}

	public static void setLandmarks(Vector<Landmark> landmarks) {
		LocalizationResults.landmarks = landmarks;
	}

	public static Vector<Landmark> getCoplayers() {
		return coplayers;
	}

	public static void setCoplayers(Vector<Landmark> coplayers) {
		LocalizationResults.coplayers = coplayers;
	}

	public static Vector<Landmark> getRivals() {
		return rivals;
	}

	public static void setRivals(Vector<Landmark> rivals) {
		LocalizationResults.rivals = rivals;
	}
}
