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
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.vision.HeadMovement;

public class PrepareKick {

	public static boolean Act() {

		if (HeadMovement.HeadAtBall) {

			if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) < -15) {

				MotionTrigger.setMotion("SideStepRight");
				return false;

			} else if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > -10) {

				MotionTrigger.setMotion("SideStepLeft");
				return false;

			} else {

				if ((Ball.RealDistance() > 0.79)) {

					MotionTrigger.setMotion("Forwards50");
					return false;
				} else {

					MotionTrigger.setMotion("");
					return true;
				}
			}

		}
		return false;

	}

}
