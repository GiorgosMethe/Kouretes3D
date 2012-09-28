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

public class TriangleLocalization {

	// 9 players rcssserver 0.6.5
	public static Coordinate F1L_det = new Coordinate(-10.5, 7);
	public static Coordinate F1R_det = new Coordinate(10.5, 7);
	public static Coordinate F2L_det = new Coordinate(-10.5, -7);
	public static Coordinate F2R_det = new Coordinate(10.5, -7);
	public static Coordinate G1L_det = new Coordinate(-10.5, 1.05);
	public static Coordinate G2L_det = new Coordinate(-10.5, -1.05);
	public static Coordinate G1R_det = new Coordinate(10.5, 1.05);
	public static Coordinate G2R_det = new Coordinate(10.5, -1.05);

	public Coordinate Localize(Landmark lmark1, Landmark lmark2) {
		String mark1 = null;
		String mark2 = null;
		double F1L_distance = 0;
		double F2L_distance = 0;
		double F1R_distance = 0;
		double F2R_distance = 0;
		double G1L_distance = 0;
		double G2L_distance = 0;
		double G1R_distance = 0;
		double G2R_distance = 0;

		if (lmark1.getName().equalsIgnoreCase("f1l")) {
			mark1 = lmark1.getName();
			F1L_distance = lmark1.getDistance();
		} else if (lmark1.getName().equalsIgnoreCase("f2l")) {
			mark1 = lmark1.getName();
			F2L_distance = lmark1.getDistance();
		} else if (lmark1.getName().equalsIgnoreCase("f1r")) {
			mark1 = lmark1.getName();
			F1R_distance = lmark1.getDistance();
		} else if (lmark1.getName().equalsIgnoreCase("f2r")) {
			mark1 = lmark1.getName();
			F2R_distance = lmark1.getDistance();
		} else if (lmark1.getName().equalsIgnoreCase("g1l")) {
			mark1 = lmark1.getName();
			G1L_distance = lmark1.getDistance();
		} else if (lmark1.getName().equalsIgnoreCase("g1r")) {
			mark1 = lmark1.getName();
			G1R_distance = lmark1.getDistance();
		} else if (lmark1.getName().equalsIgnoreCase("g2l")) {
			mark1 = lmark1.getName();
			G2L_distance = lmark1.getDistance();
		} else if (lmark1.getName().equalsIgnoreCase("g2r")) {
			mark1 = lmark1.getName();
			G2R_distance = lmark1.getDistance();
		}

		if (lmark2.getName().equalsIgnoreCase("f1l")) {
			mark2 = lmark2.getName();
			F1L_distance = lmark2.getDistance();
		} else if (lmark2.getName().equalsIgnoreCase("f2l")) {
			mark2 = lmark2.getName();
			F2L_distance = lmark2.getDistance();
		} else if (lmark2.getName().equalsIgnoreCase("f1r")) {
			mark2 = lmark2.getName();
			F1R_distance = lmark2.getDistance();
		} else if (lmark2.getName().equalsIgnoreCase("f2r")) {
			mark2 = lmark2.getName();
			F2R_distance = lmark2.getDistance();
		} else if (lmark2.getName().equalsIgnoreCase("g1l")) {
			mark2 = lmark2.getName();
			G1L_distance = lmark2.getDistance();
		} else if (lmark2.getName().equalsIgnoreCase("g1r")) {
			mark2 = lmark2.getName();
			G1R_distance = lmark2.getDistance();
		} else if (lmark2.getName().equalsIgnoreCase("g2l")) {
			mark2 = lmark2.getName();
			G2L_distance = lmark2.getDistance();
		} else if (lmark2.getName().equalsIgnoreCase("g2r")) {
			mark2 = lmark2.getName();
			G2R_distance = lmark2.getDistance();
		}

		Coordinate Agent_Det = new Coordinate(200, 200);
		if ((mark1.equalsIgnoreCase("f1l") && mark2.equalsIgnoreCase("f2l"))
				|| (mark1.equalsIgnoreCase("f2l") && mark2
						.equalsIgnoreCase("f1l"))) {
			Agent_Det = trilateration(F1L_det.getX(), F1L_det.getY(),
					F2L_det.getX(), F2L_det.getY(), F1L_distance, F2L_distance);
		} else if ((mark1.equalsIgnoreCase("f1l") && mark2
				.equalsIgnoreCase("f1r"))
				|| (mark1.equalsIgnoreCase("f1r") && mark2
						.equalsIgnoreCase("f1l"))) {
			Agent_Det = trilateration(F1L_det.getX(), F1L_det.getY(),
					F1R_det.getX(), F1R_det.getY(), F1L_distance, F1R_distance);
		} else if ((mark1.equalsIgnoreCase("f1l") && mark2
				.equalsIgnoreCase("f2r"))
				|| (mark1.equalsIgnoreCase("f2r") && mark2
						.equalsIgnoreCase("f1l"))) {
			Agent_Det = trilateration(F1L_det.getX(), F1L_det.getY(),
					F2R_det.getX(), F2R_det.getY(), F1L_distance, F2R_distance);
		} else if ((mark1.equalsIgnoreCase("f1l") && mark2
				.equalsIgnoreCase("g1l"))
				|| (mark1.equalsIgnoreCase("g1l") && mark2
						.equalsIgnoreCase("f1l"))) {
			Agent_Det = trilateration(F1L_det.getX(), F1L_det.getY(),
					G1L_det.getX(), G1L_det.getY(), F1L_distance, G1L_distance);
		} else if ((mark1.equalsIgnoreCase("f1l") && mark2
				.equalsIgnoreCase("g2l"))
				|| (mark1.equalsIgnoreCase("g2l") && mark2
						.equalsIgnoreCase("f1l"))) {
			Agent_Det = trilateration(F1L_det.getX(), F1L_det.getY(),
					G2L_det.getX(), G2L_det.getY(), F1L_distance, G2L_distance);
		} else if ((mark1.equalsIgnoreCase("f1l") && mark2
				.equalsIgnoreCase("g1r"))
				|| (mark1.equalsIgnoreCase("g1r") && mark2
						.equalsIgnoreCase("f1l"))) {
			Agent_Det = trilateration(F1L_det.getX(), F1L_det.getY(),
					G1R_det.getX(), G1R_det.getY(), F1L_distance, G1R_distance);
		} else if ((mark1.equalsIgnoreCase("f1l") && mark2
				.equalsIgnoreCase("g2r"))
				|| (mark1.equalsIgnoreCase("g2r") && mark2
						.equalsIgnoreCase("f1l"))) {
			Agent_Det = trilateration(F1L_det.getX(), F1L_det.getY(),
					G2R_det.getX(), G2R_det.getY(), F1L_distance, G2R_distance);
		}

		else if ((mark1.equalsIgnoreCase("f2l") && mark2
				.equalsIgnoreCase("f1r"))
				|| (mark1.equalsIgnoreCase("f1r") && mark2
						.equalsIgnoreCase("f2l"))) {
			Agent_Det = trilateration(F1R_det.getX(), F1R_det.getY(),
					F2L_det.getX(), F2L_det.getY(), F1R_distance, F2L_distance);
		} else if ((mark1.equalsIgnoreCase("f2l") && mark2
				.equalsIgnoreCase("f2r"))
				|| (mark1.equalsIgnoreCase("f2r") && mark2
						.equalsIgnoreCase("f2l"))) {
			Agent_Det = trilateration(F2R_det.getX(), F2R_det.getY(),
					F2L_det.getX(), F2L_det.getY(), F2R_distance, F2L_distance);
		} else if ((mark1.equalsIgnoreCase("f2l") && mark2
				.equalsIgnoreCase("g1l"))
				|| (mark1.equalsIgnoreCase("g1l") && mark2
						.equalsIgnoreCase("f2l"))) {
			Agent_Det = trilateration(G1L_det.getX(), G1L_det.getY(),
					F2L_det.getX(), F2L_det.getY(), G1L_distance, F2L_distance);
		} else if ((mark1.equalsIgnoreCase("f2l") && mark2
				.equalsIgnoreCase("g2l"))
				|| (mark1.equalsIgnoreCase("g2l") && mark2
						.equalsIgnoreCase("f2l"))) {
			Agent_Det = trilateration(G2L_det.getX(), G2L_det.getY(),
					F2L_det.getX(), F2L_det.getY(), G2L_distance, F2L_distance);
		} else if ((mark1.equalsIgnoreCase("f2l") && mark2
				.equalsIgnoreCase("g1r"))
				|| (mark1.equalsIgnoreCase("g1r") && mark2
						.equalsIgnoreCase("f2l"))) {
			Agent_Det = trilateration(G1R_det.getX(), G1R_det.getY(),
					F2L_det.getX(), F2L_det.getY(), G1R_distance, F2L_distance);
		} else if ((mark1.equalsIgnoreCase("f2l") && mark2
				.equalsIgnoreCase("g2r"))
				|| (mark1.equalsIgnoreCase("g2r") && mark2
						.equalsIgnoreCase("f2l"))) {
			Agent_Det = trilateration(G2R_det.getX(), G2R_det.getY(),
					F2L_det.getX(), F2L_det.getY(), G2R_distance, F2L_distance);
		}

		else if ((mark1.equalsIgnoreCase("f1r") && mark2
				.equalsIgnoreCase("f2r"))
				|| (mark1.equalsIgnoreCase("f2r") && mark2
						.equalsIgnoreCase("f1r"))) {
			Agent_Det = trilateration(F1R_det.getX(), F1R_det.getY(),
					F2R_det.getX(), F2R_det.getY(), F1R_distance, F2R_distance);
		} else if ((mark1.equalsIgnoreCase("f1r") && mark2
				.equalsIgnoreCase("g1l"))
				|| (mark1.equalsIgnoreCase("g1l") && mark2
						.equalsIgnoreCase("f1r"))) {
			Agent_Det = trilateration(F1R_det.getX(), F1R_det.getY(),
					G1L_det.getX(), G1L_det.getY(), F1R_distance, G1L_distance);
		} else if ((mark1.equalsIgnoreCase("f1r") && mark2
				.equalsIgnoreCase("g2l"))
				|| (mark1.equalsIgnoreCase("g2l") && mark2
						.equalsIgnoreCase("f1r"))) {
			Agent_Det = trilateration(F1R_det.getX(), F1R_det.getY(),
					G2L_det.getX(), G2L_det.getY(), F1R_distance, G2L_distance);
		} else if ((mark1.equalsIgnoreCase("f1r") && mark2
				.equalsIgnoreCase("g1r"))
				|| (mark1.equalsIgnoreCase("g1r") && mark2
						.equalsIgnoreCase("f1r"))) {
			Agent_Det = trilateration(F1R_det.getX(), F1R_det.getY(),
					G1R_det.getX(), G1R_det.getY(), F1R_distance, G1R_distance);
		} else if ((mark1.equalsIgnoreCase("f1r") && mark2
				.equalsIgnoreCase("g2r"))
				|| (mark1.equalsIgnoreCase("g2r") && mark2
						.equalsIgnoreCase("f1r"))) {
			Agent_Det = trilateration(F1R_det.getX(), F1R_det.getY(),
					G2R_det.getX(), G2R_det.getY(), F1R_distance, G2R_distance);
		}

		else if ((mark1.equalsIgnoreCase("f2r") && mark2
				.equalsIgnoreCase("g1l"))
				|| (mark1.equalsIgnoreCase("g1l") && mark2
						.equalsIgnoreCase("f2r"))) {
			Agent_Det = trilateration(G1L_det.getX(), G1L_det.getY(),
					F2R_det.getX(), F2R_det.getY(), G1L_distance, F2R_distance);
		} else if ((mark1.equalsIgnoreCase("f2r") && mark2
				.equalsIgnoreCase("g2l"))
				|| (mark1.equalsIgnoreCase("g2l") && mark2
						.equalsIgnoreCase("f2r"))) {
			Agent_Det = trilateration(G2L_det.getX(), G2L_det.getY(),
					F2R_det.getX(), F2R_det.getY(), G2L_distance, F2R_distance);
		} else if ((mark1.equalsIgnoreCase("f2r") && mark2
				.equalsIgnoreCase("g1r"))
				|| (mark1.equalsIgnoreCase("g1r") && mark2
						.equalsIgnoreCase("f2r"))) {
			Agent_Det = trilateration(G1R_det.getX(), G1R_det.getY(),
					F2R_det.getX(), F2R_det.getY(), G1R_distance, F2R_distance);
		} else if ((mark1.equalsIgnoreCase("f2r") && mark2
				.equalsIgnoreCase("g2r"))
				|| (mark1.equalsIgnoreCase("g2r") && mark2
						.equalsIgnoreCase("f2r"))) {
			Agent_Det = trilateration(G2R_det.getX(), G2R_det.getY(),
					F2R_det.getX(), F2R_det.getY(), G2R_distance, F2R_distance);
		}

		else if ((mark1.equalsIgnoreCase("g1l") && mark2
				.equalsIgnoreCase("g2l"))
				|| (mark1.equalsIgnoreCase("g2l") && mark2
						.equalsIgnoreCase("g1l"))) {
			Agent_Det = trilateration(G1L_det.getX(), G1L_det.getY(),
					G2L_det.getX(), G2L_det.getY(), G1L_distance, G2L_distance);
		} else if ((mark1.equalsIgnoreCase("g1l") && mark2
				.equalsIgnoreCase("g1r"))
				|| (mark1.equalsIgnoreCase("g1r") && mark2
						.equalsIgnoreCase("g1l"))) {
			Agent_Det = trilateration(G1L_det.getX(), G1L_det.getY(),
					G1R_det.getX(), G1R_det.getY(), G1L_distance, G1R_distance);
		} else if ((mark1.equalsIgnoreCase("g1l") && mark2
				.equalsIgnoreCase("g2r"))
				|| (mark1.equalsIgnoreCase("g2r") && mark2
						.equalsIgnoreCase("g1l"))) {
			Agent_Det = trilateration(G1L_det.getX(), G1L_det.getY(),
					G2R_det.getX(), G2R_det.getY(), G1L_distance, G2R_distance);
		}

		else if ((mark1.equalsIgnoreCase("g1r") && mark2
				.equalsIgnoreCase("g2l"))
				|| (mark1.equalsIgnoreCase("g2l") && mark2
						.equalsIgnoreCase("g1r"))) {
			Agent_Det = trilateration(G1R_det.getX(), G1R_det.getY(),
					G2L_det.getX(), G2L_det.getY(), G1R_distance, G2L_distance);
		} else if ((mark1.equalsIgnoreCase("g1r") && mark2
				.equalsIgnoreCase("g2r"))
				|| (mark1.equalsIgnoreCase("g2r") && mark2
						.equalsIgnoreCase("g1r"))) {
			Agent_Det = trilateration(G1R_det.getX(), G1R_det.getY(),
					G2R_det.getX(), G2R_det.getY(), G1R_distance, G2R_distance);
		}

		return Agent_Det;
	}

	public double universal_angle(Landmark lmark, Coordinate Current_Location) {
		double angle = 0;
		if (lmark.getName().equalsIgnoreCase("f1l")) {
			angle = universal__head_angle_l(F1L_det.getX(), F1L_det.getY(),
					Current_Location.getX(), Current_Location.Y,
					lmark.getHorizontal_Angle(), lmark.getDistance());
		} else if (lmark.getName().equalsIgnoreCase("f1r")) {
			angle = universal__head_angle_r(F1R_det.getX(), F1R_det.getY(),
					Current_Location.getX(), Current_Location.Y,
					lmark.getHorizontal_Angle(), lmark.getDistance());
		} else if (lmark.getName().equalsIgnoreCase("f2r")) {
			angle = universal__head_angle_r(F2R_det.getX(), F2R_det.getY(),
					Current_Location.getX(), Current_Location.Y,
					lmark.getHorizontal_Angle(), lmark.getDistance());
		} else if (lmark.getName().equalsIgnoreCase("f2L")) {
			angle = universal__head_angle_l(F2L_det.getX(), F2L_det.getY(),
					Current_Location.getX(), Current_Location.Y,
					lmark.getHorizontal_Angle(), lmark.getDistance());
		} else if (lmark.getName().equalsIgnoreCase("G2r")) {
			angle = universal__head_angle_r(G2R_det.getX(), G2R_det.getY(),
					Current_Location.getX(), Current_Location.Y,
					lmark.getHorizontal_Angle(), lmark.getDistance());
		} else if (lmark.getName().equalsIgnoreCase("G2L")) {
			angle = universal__head_angle_l(G2L_det.getX(), G2L_det.getY(),
					Current_Location.getX(), Current_Location.Y,
					lmark.getHorizontal_Angle(), lmark.getDistance());
		} else if (lmark.getName().equalsIgnoreCase("G1R")) {
			angle = universal__head_angle_r(G1R_det.getX(), G1R_det.getY(),
					Current_Location.getX(), Current_Location.Y,
					lmark.getHorizontal_Angle(), lmark.getDistance());
		} else if (lmark.getName().equalsIgnoreCase("G1L")) {
			angle = universal__head_angle_l(G1L_det.getX(), G1L_det.getY(),
					Current_Location.getX(), Current_Location.Y,
					lmark.getHorizontal_Angle(), lmark.getDistance());
		}
		return angle;
	}

	public static Coordinate trilateration(double ax, double ay, double bx,
			double by, double d1, double d2) {
		// vriskei tis suntetagmenes an kserei tis apostaseis apo 2 marks
		// mark1 (ax,ay)
		// mark2 (bx,by)
		// distance from mark1=d1
		// distance from mark2=d2

		double D = Math.sqrt((Math.pow((ax - bx), 2)) + Math.pow((ay - by), 2));
		double S = (Math.pow(D, 2) + Math.pow(d1, 2) - Math.pow(d2, 2))
				/ (2 * D);
		double cx = ax + (bx - ax) * S / D;
		double cy = ay + (by - ay) * S / D;
		double u = Math.sqrt((Math.pow(d1, 2) - Math.pow(S, 2)));
		double x = cx - (by - ay) * u / D;
		double y = cy + (bx - ax) * u / D;

		if ((x >= 10.5) || (x <= -10.5) || (y >= 8) || (y <= -8)) {
			x = cx + (by - ay) * u / D;
			y = cy - (bx - ax) * u / D;
		}

		Coordinate Det = new Coordinate(x, y);
		return Det;
	}

	public static double universal__head_angle_l(double ax, double ay,
			double x, double y, double f, double d) {
		// briskei tin gonia tou kefaliou se sxesi me ton aksona X tou gipedou
		// mark (ax,ay)
		// agent (x,y)
		// head angle from mark f
		// distance from mark d
		double univer_angle = 400;
		double angle_y = Math.asin(Math.sqrt(Math.pow(ay - y, 2)) / d); // ///prepei
		// na dw
		// poio
		// einai
		// to x
		// k
		// poio
		// to y
		// sto
		// gipedo
		if (f > 0 && y < ay) { // //an to kefali koitaei aristera apo tin simaia
			univer_angle = 180 - (Math.toDegrees(angle_y) + f);
		} else if (f < 0 && y > ay) { // // an to kefali koitaei deksia apo tin
			// simaia
			univer_angle = -180 + (Math.abs(f) + Math.toDegrees(angle_y));
		} else if (f > 0 && y > ay) {
			univer_angle = -180 + (Math.toDegrees(angle_y) - f);
		} else if (f < 0 && y < ay) {
			univer_angle = 180 - (Math.toDegrees(angle_y) - Math.abs(f));
		}

		if (univer_angle < -180) {
			univer_angle = univer_angle + 360;
		} else if (univer_angle > 180) {
			univer_angle = univer_angle - 360;
		}
		return univer_angle;

	}

	public static double universal__head_angle_r(double ax, double ay,
			double x, double y, double f, double d) {
		// briskei tin gonia tou kefaliou se sxesi me ton aksona X tou gipedou
		// mark (ax,ay)
		// agent (x,y)
		// head angle from mark f
		// distance from mark d
		double univer_angle = 400;
		double angle_y = Math.asin(Math.sqrt(Math.pow(ay - y, 2)) / d); // ///prepei
		// na dw
		// poio
		// einai
		// to x
		// k
		// poio
		// to y
		// sto
		// gipedo
		if (f > 0 && y < ay) { // //an to kefali koitaei aristera apo tin simaia
			univer_angle = Math.toDegrees(angle_y) - f;
		} else if (f < 0 && y > ay) { // // an to kefali koitaei deksia apo tin
			// simaia
			univer_angle = Math.abs(f) - Math.toDegrees(angle_y);
		} else if (f > 0 && y > ay) {
			univer_angle = -(Math.toDegrees(angle_y) + f);
		} else if (f < 0 && y < ay) {
			univer_angle = Math.toDegrees(angle_y) + Math.abs(f);
		}
		if (univer_angle < -180) {
			univer_angle = univer_angle + 360;
		} else if (univer_angle > 180) {
			univer_angle = univer_angle - 360;
		}

		return univer_angle;

	}

	public static Coordinate get_det_with_distance_angle(double ax, double ay,
			double f, double d) {
		// briskei tis suntetagmenes enos antikeimenou pou vriskete se apostasi
		// D upo gonia f (APO TON AKSONA X TOU GIPEDOU, oxi gonia kefaliou)
		// det agent (ax,ay)
		// D-> apostasi
		// F-> gonia
		double x = ax + d * Math.cos(Math.toRadians(f));
		double y = ay + d * Math.sin(Math.toRadians(f));
		Coordinate Det = new Coordinate(x, y);
		return Det;
	}

	public static double FindAngleFromBall(Coordinate target) {

		double dx = target.getX() - LocalizationResults.ball_location.getX();
		double dy = target.getY() - LocalizationResults.ball_location.getY();

		double ThetaToTarget = Math.toDegrees(Math.atan2(dx, dy));

		if (dy == 0 && dx == 0) {
			return 0;
		}

		if (ThetaToTarget >= 0 && ThetaToTarget < 90) {

			ThetaToTarget = 90 - ThetaToTarget;

		} else if (ThetaToTarget >= 90 && ThetaToTarget <= 180) {

			ThetaToTarget = -(ThetaToTarget - 90);

		} else if (ThetaToTarget < -90 && ThetaToTarget >= -180) {

			ThetaToTarget = -(ThetaToTarget + 270);

		} else if (ThetaToTarget >= -90 && ThetaToTarget < -0) {

			ThetaToTarget = -(ThetaToTarget - 90);

		}

		return ThetaToTarget;
	}

	// public static double FindAngle(Coordinate target) {
	//
	// double dx = target.getX()
	// - LocalizationResults.getCurrent_location().getX();
	// double dy = target.getY()
	// - LocalizationResults.getCurrent_location().getY();
	//
	// double ThetaToTarget = Math.toDegrees(Math.atan2(dx, dy));
	//
	// if (dy == 0 && dx == 0) {
	// return 0;
	// }
	//
	// if (ThetaToTarget >= 0 && ThetaToTarget < 90) {
	//
	// ThetaToTarget = 90 - ThetaToTarget;
	//
	// } else if (ThetaToTarget >= 90 && ThetaToTarget <= 180) {
	//
	// ThetaToTarget = -(ThetaToTarget - 90);
	//
	// } else if (ThetaToTarget < -90 && ThetaToTarget >= -180) {
	//
	// ThetaToTarget = -(ThetaToTarget + 270);
	//
	// } else if (ThetaToTarget >= -90 && ThetaToTarget < -0) {
	//
	// ThetaToTarget = -(ThetaToTarget - 90);
	//
	// }
	//
	// return ThetaToTarget;
	// }

	public static double FindAngle(Coordinate target) {

		double dx = target.getX()
				- LocalizationFilter.MyFilteredPosition.getX();
		double dy = target.getY()
				- LocalizationFilter.MyFilteredPosition.getY();

		double ThetaToTarget = Math.toDegrees(Math.atan2(dx, dy));

		if (dy == 0 && dx == 0) {
			return 0;
		}

		if (ThetaToTarget >= 0 && ThetaToTarget < 90) {

			ThetaToTarget = 90 - ThetaToTarget;

		} else if (ThetaToTarget >= 90 && ThetaToTarget <= 180) {

			ThetaToTarget = -(ThetaToTarget - 90);

		} else if (ThetaToTarget < -90 && ThetaToTarget >= -180) {

			ThetaToTarget = -(ThetaToTarget + 270);

		} else if (ThetaToTarget >= -90 && ThetaToTarget < -0) {

			ThetaToTarget = -(ThetaToTarget - 90);

		}

		return ThetaToTarget;
	}

	public static double FindAngleBetweenCoordinates(Coordinate start,
			Coordinate target) {

		double dx = target.getX() - start.getX();
		double dy = target.getY() - start.getY();

		double ThetaToTarget = Math.toDegrees(Math.atan2(dx, dy));

		if (dy == 0 && dx == 0) {
			return 0;
		}

		if (ThetaToTarget >= 0 && ThetaToTarget < 90) {

			ThetaToTarget = 90 - ThetaToTarget;

		} else if (ThetaToTarget >= 90 && ThetaToTarget <= 180) {

			ThetaToTarget = -(ThetaToTarget - 90);

		} else if (ThetaToTarget < -90 && ThetaToTarget >= -180) {

			ThetaToTarget = -(ThetaToTarget + 270);

		} else if (ThetaToTarget >= -90 && ThetaToTarget < -0) {

			ThetaToTarget = -(ThetaToTarget - 90);

		}

		return ThetaToTarget;
	}

	// public static double FindDistanceToTarget(Coordinate target) {
	//
	// double dx = target.getX()
	// - LocalizationResults.getCurrent_location().getX();
	// double dy = target.getY()
	// - LocalizationResults.getCurrent_location().getY();
	// double DistanceToTarget = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	//
	// return DistanceToTarget;
	//
	// }

	public static double FindDistanceToTarget(Coordinate target) {

		double dx = target.getX()
				- LocalizationFilter.MyFilteredPosition.getX();
		double dy = target.getY()
				- LocalizationFilter.MyFilteredPosition.getY();
		double DistanceToTarget = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

		return DistanceToTarget;

	}

	public static double FindDistanceAmong2Coordinates(Coordinate start,
			Coordinate end) {

		double dx = end.getX() - start.getX();
		double dy = end.getY() - start.getY();
		double DistanceToTarget = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

		return DistanceToTarget;

	}

	// public static double FindAngleDifference(double ThetaToTarget) {
	//
	// double BodyAngle = LocalizationResults.getBody_angle();
	// double DesirableAngle = ThetaToTarget;
	// double AngleDifference = DesirableAngle - BodyAngle;
	//
	// if (AngleDifference > 180) {
	// AngleDifference = AngleDifference - 360;
	// }
	//
	// return AngleDifference;
	//
	// }

	public static double FindAngleDifference(double ThetaToTarget) {

		double BodyAngle = LocalizationFilter.MyFilteredPosition.getTheta();

		double DesirableAngle = ThetaToTarget;

		double AngleDifference = DesirableAngle - BodyAngle;

		if (AngleDifference > 180) {
			AngleDifference = AngleDifference - 360;
		} else if (AngleDifference < -180) {
			AngleDifference = AngleDifference + 360;
		}

		return AngleDifference;

	}

	public static double FindAngleDifference2(double ThetaToTarget,
			double myBodyTheta) {

		double DesirableAngle = ThetaToTarget;
		double AngleDifference = DesirableAngle - myBodyTheta;

		if (AngleDifference > 180) {
			AngleDifference = AngleDifference - 360;
		}

		return AngleDifference;

	}

	public static double FindCoordinateAngleToKick(Coordinate Target) {

		double TargetFromBall = FindAngleFromBall(Target);

		return TargetFromBall;

	}

	public static Coordinate FindWalkingCoordinateToKick(Coordinate Target) {

		double TargetFromBall = FindAngleFromBall(Target);

		Coordinate WalkingCoordinateToKick = get_det_with_distance_angle(
				LocalizationResults.ball_location.X,
				LocalizationResults.ball_location.Y, TargetFromBall, -1);

		return WalkingCoordinateToKick;

	}

	public static Coordinate addCoordinates(Coordinate a, Coordinate b) {

		double resultX;
		double resultY;

		resultX = a.X + b.X;

		resultY = a.Y + b.Y;

		return new Coordinate(resultX, resultY);
	}

	public static Coordinate getOpposite(Coordinate a) {

		Coordinate result = new Coordinate(-a.X, a.Y);

		return result;
	}

	public static boolean equal(Coordinate a, Coordinate b) {

		if (a.X == b.X && a.Y == b.Y) {
			return true;
		} else {
			return false;
		}

	}

	public static double FindAngleAVG(double angle1, double angle2) {

		if (Double.isNaN(angle1) || Double.isNaN(angle1)) {

			return Double.NaN;

		}

		double xxx = Math.cos(Math.toRadians(angle1))
				+ Math.cos(Math.toRadians(angle2));

		double yyy = Math.sin(Math.toRadians(angle1))
				+ Math.sin(Math.toRadians(angle2));

		double result = Math.toDegrees(Math.atan2(yyy, xxx));

		return result;

	}

	public static double NormalizeAngle(double angle) {

		if (angle < -180) {
			angle = angle + 360;
		} else if (angle > 180) {
			angle = angle - 360;
		}

		return angle;
	}

	public static boolean CheckIfContained(double start, double end,
			double theta) {

		if (start > 0 && end > 0) {

			if (theta > start && theta < end) {

				return true;
			}

		} else if (start < 0 && end < 0) {

			if (theta > start && theta < end) {

				return true;
			}

		} else if (start > 0 && end < 0) {

			if (theta > 0) {

				if (theta > start && theta > end) {

					return true;
				}

			} else {

				if (theta < start && theta < end) {

					return true;
				}

			}
		} else if (start < 0 && end > 0) {

			if (theta > start && theta < end) {

				return true;
			}

		}
		return false;
	}

}
