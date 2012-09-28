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
package action.simple;

import motion.utils.MotionTrigger;
import motion.xml.WalkLeaning;
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import perceptor.vision.Vision;

public class WalkToBallForKick {

	public static boolean Act() {

		if (Vision.isiSee()) {

			if (Ball.isSeeTheBall()) {

				if ((Ball.RealDistance() < 0.8)) {// &&(Math.abs(HingeJointPerceptor.getHj1()+Math.abs(Ball.getAngleX())))<15){

					if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) < -10) {

						MotionTrigger.setMotion("SideStepRight");
						return false;

					} else if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > -5) {

						MotionTrigger.setMotion("SideStepLeft");
						return false;

					} else {

						MotionTrigger.setMotion("");
						return true;
					}

				} else {

					float AngleThresholdBigTurn;
					float AngleThresholdWalkLeaningTurn;
					if (Ball.getDistance() < 1) {

						AngleThresholdBigTurn = 5;
						AngleThresholdWalkLeaningTurn = 2;

					} else {

						AngleThresholdBigTurn = 15;
						AngleThresholdWalkLeaningTurn = 5;
					}

					if ((Math.abs(HingeJointPerceptor.getHj1()
							+ Math.abs(Ball.getAngleX()))) > AngleThresholdBigTurn) {

						if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > 0) {

							MotionTrigger.setMotion("TurnLeft40");
							MotionTrigger.setTurn((float) (HingeJointPerceptor
									.getHj1() + Ball.getAngleX()));
							return false;

						} else {

							MotionTrigger.setMotion("TurnRight40");
							MotionTrigger.setTurn((float) (HingeJointPerceptor
									.getHj1() + Ball.getAngleX()));
							return false;

						}

					} else if ((Math.abs(HingeJointPerceptor.getHj1()
							+ Math.abs(Ball.getAngleX()))) > AngleThresholdWalkLeaningTurn) {

						if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > 0) {

							MotionTrigger.setMotion("Forwards50");
							// WalkLeaning.setLean("left");
							return false;

						} else {

							MotionTrigger.setMotion("Forwards50");
							// WalkLeaning.setLean("right");
							return false;

						}

					} else {

						if (Ball.getDistance() < 1) {
							MotionTrigger.setMotion("Forwards50");
							// WalkLeaning.setLean("slow");
						} else {
							MotionTrigger.setMotion("Forwards50");
							WalkLeaning.setLean("");
						}
						return false;
					}

				}

			}
			return false;

		}
		return false;

	}
}
