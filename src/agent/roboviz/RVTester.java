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
package agent.roboviz;

/*
 *  Copyright 2011 RoboViz
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.Timer;

import perceptor.localization.Coordinate;
import connection.utils.ServerCyrcles;
import coordination.strategy.ActivePositions;

/**
 * Program for testing network drawing on RoboVis with all shapes both animated
 * and static
 * 
 * @author Justin Stoecker
 */
public class RVTester {

	// private static final int TEST_DURATION = 100000000;
	private static final int ROBOVIS_PORT = 32769;

	public static Vector<Coordinate> Coordinates = new Vector<Coordinate>();

	private DatagramSocket socket;
	private InetAddress address;
	private Timer animationTimer;

	public RVTester() throws SocketException, UnknownHostException {
		socket = new DatagramSocket();
		address = InetAddress.getLocalHost();

		animationTimer = new Timer(16, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					renderAnimatedShapes();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		animationTimer.setRepeats(true);
	}

	/** Method for all animated drawings */
	private void renderAnimatedShapes() throws IOException {

		// if (((!HeadMovement.HeadAtRight) || (!HeadMovement.HeadAtLeft))) {
		// if (ObstaclePerceptor.Obstacles != null) {
		//
		// for (int i = 0; i < ObstaclePerceptor.Obstacles.size(); i++) {
		//
		// drawCircle(
		// new float[] {
		// (float) TriangleLocalization
		// .get_det_with_distance_angle(
		// LocalizationFilter.MyFilteredPosition
		// .getX(),
		// LocalizationFilter.MyFilteredPosition
		// .getY(),
		// LocalizationFilter.MyFilteredPosition
		// .getTheta()
		// + ObstaclePerceptor.Obstacles
		// .elementAt(
		// i)
		// .getHorizontal_Angle(),
		// ObstaclePerceptor.Obstacles
		// .elementAt(i)
		// .getDistance())
		// .getX(),
		// (float) TriangleLocalization
		// .get_det_with_distance_angle(
		// LocalizationFilter.MyFilteredPosition
		// .getX(),
		// LocalizationFilter.MyFilteredPosition
		// .getY(),
		// LocalizationFilter.MyFilteredPosition
		// .getTheta()
		// + ObstaclePerceptor.Obstacles
		// .elementAt(
		// i)
		// .getHorizontal_Angle(),
		// ObstaclePerceptor.Obstacles
		// .elementAt(i)
		// .getDistance())
		// .getY() }, 0.2f, 3, Color.BLACK,
		// "animated.circles");
		//
		// }
		// }
		// }

		// this draws agent position and position through localization filter
		// if (!Double.isNaN(LocalizationResults.getCurrent_location().getX())
		// && !Double.isNaN(LocalizationResults.getCurrent_location()
		// .getY())) {
		//
		// drawCircle(new float[] {
		// (float) LocalizationResults.getCurrent_location().getX(),
		// (float) LocalizationResults.getCurrent_location().getY() },
		// 0.2f, 2, Color.YELLOW, "animated.circles");

		// drawLine(
		// new float[] {
		// (float) LocalizationResults.getCurrent_location()
		// .getX(),
		// (float) LocalizationResults.getCurrent_location()
		// .getY(), 0 },
		// new float[] {
		// (float) TriangleLocalization
		// .get_det_with_distance_angle(
		// LocalizationResults
		// .getCurrent_location()
		// .getX(),
		// LocalizationResults
		// .getCurrent_location()
		// .getY(),
		// LocalizationResults.getBody_angle(),
		// 1).getX(),
		// (float) TriangleLocalization
		// .get_det_with_distance_angle(
		// LocalizationResults
		// .getCurrent_location()
		// .getX(),
		// LocalizationResults
		// .getCurrent_location()
		// .getY(),
		// LocalizationResults.getBody_angle(),
		// 1).getY(), 0 }, 1.0f, Color.YELLOW,
		// "animated.lines.field");

		// }

		// if (LocalizationFilter.MyFilteredPosition != null) {
		//
		// drawCircle(new float[] {
		// (float) LocalizationFilter.MyFilteredPosition.getX(),
		// (float) LocalizationFilter.MyFilteredPosition.getY() },
		// 0.2f, 2, Color.RED, "animated.circles");

		// drawLine(
		// new float[] {
		// (float) LocalizationFilter.MyFilteredPosition
		// .getX(),
		// (float) LocalizationFilter.MyFilteredPosition
		// .getY(), 0 },
		// new float[] {
		// (float) TriangleLocalization
		// .get_det_with_distance_angle(
		// LocalizationFilter.MyFilteredPosition
		// .getX(),
		// LocalizationFilter.MyFilteredPosition
		// .getY(),
		// LocalizationFilter.MyFilteredPosition
		// .getTheta(), 1).getX(),
		// (float) TriangleLocalization
		// .get_det_with_distance_angle(
		// LocalizationFilter.MyFilteredPosition
		// .getX(),
		// LocalizationFilter.MyFilteredPosition
		// .getY(),
		// LocalizationFilter.MyFilteredPosition
		// .getTheta(), 1).getY(), 0 },
		// 1.0f, Color.RED, "animated.lines.field");

		// }

		// if (LocalizationResults.getBall_location()!=null){
		//
		// drawCircle(new float[] {
		// (float) LocalizationResults.getBall_location().getX(),
		// (float) LocalizationResults.getBall_location().getY() }, 0.1f, 3,
		// Color.yellow,
		// "animated.circles");
		//
		// }
		//
		//
		//
		// if(BallLocalizationFilter.MyFilteredBallPosition!=null){
		// drawCircle(new float[] {
		// (float) BallLocalizationFilter.MyFilteredBallPosition.getX(),
		// (float) BallLocalizationFilter.MyFilteredBallPosition.getY() }, 0.1f,
		// 3, Color.red,
		// "animated.circles");
		//
		//
		// }

		// if (ObstacleAvoidance.BestAlternative != null) {
		//
		// drawCircle(
		// new float[] {
		// (float) ObstacleAvoidance.BestAlternative.getX(),
		// (float) ObstacleAvoidance.BestAlternative.getY() },
		// 0.1f, 3, Color.RED, "animated.circles");
		//
		// }
		//
		// if (ObstacleAvoidance.Alternatives != null) {
		//
		// for (int i = 0; i < ObstacleAvoidance.Alternatives.size(); i++) {
		//
		// drawCircle(new float[] {
		// (float) ObstacleAvoidance.Alternatives.elementAt(i)
		// .getX(),
		// (float) ObstacleAvoidance.Alternatives.elementAt(i)
		// .getY() }, 0.1f, 3, Color.cyan,
		// "animated.circles");
		//
		// }
		//
		// }

		// if (ActiveCoordination.OptimizedActiveMap != null) {
		//
		// for (int i = 0; i < ActiveCoordination.OptimizedActiveMap.size();
		// i++) {
		//
		// if (ActiveCoordination.OnBallPlayer != 0
		// && ActiveCoordination.OnBallPlayer !=
		// ActiveCoordination.OptimizedActiveMap
		// .elementAt(i).getAgent().getNumber()) {
		//
		// drawCircle(new float[] {
		// (float) ActiveCoordination.OptimizedActiveMap
		// .elementAt(i).getPosition().getX(),
		// (float) ActiveCoordination.OptimizedActiveMap
		// .elementAt(i).getPosition().getY() }, 0.2f,
		// 2, Color.RED, "animated.circles");
		//
		// if (ActiveCoordination.OptimizedActiveMap.elementAt(i)
		// .getAgent().getType() == 0
		// || ActiveCoordination.OptimizedActiveMap
		// .elementAt(i).getAgent().getType() == 1) {
		//
		// drawLine(
		// new float[] {
		// (float) ActiveCoordination.OptimizedActiveMap
		// .elementAt(i).getAgent()
		// .getPlayer().X,
		// (float) ActiveCoordination.OptimizedActiveMap
		// .elementAt(i).getAgent()
		// .getPlayer().Y, 0 },
		// new float[] {
		// (float) ActiveCoordination.OptimizedActiveMap
		// .elementAt(i).getPosition()
		// .getX(),
		// (float) ActiveCoordination.OptimizedActiveMap
		// .elementAt(i).getPosition()
		// .getY(), 0 }, 1.0f, lightGreen,
		// "animated.lines.field");
		//
		// }
		//
		// }
		//
		// }
		//
		// }
		//
		// if (SupportCoordination.OptimizedSupportMap != null) {
		//
		// for (int i = 0; i < SupportCoordination.OptimizedSupportMap.size();
		// i++) {
		//
		// drawCircle(new float[] {
		// (float) SupportCoordination.OptimizedSupportMap
		// .elementAt(i).getPosition().getX(),
		// (float) SupportCoordination.OptimizedSupportMap
		// .elementAt(i).getPosition().getY() }, 0.2f, 2,
		// Color.YELLOW, "animated.circles");
		//
		// if (SupportCoordination.OptimizedSupportMap.elementAt(i)
		// .getAgent().getType() == 0
		// || SupportCoordination.OptimizedSupportMap.elementAt(i)
		// .getAgent().getType() == 1) {
		//
		// drawLine(
		// new float[] {
		// (float) SupportCoordination.OptimizedSupportMap
		// .elementAt(i).getAgent()
		// .getPlayer().X,
		// (float) SupportCoordination.OptimizedSupportMap
		// .elementAt(i).getAgent()
		// .getPlayer().Y, 0 },
		// new float[] {
		// (float) SupportCoordination.OptimizedSupportMap
		// .elementAt(i).getPosition().getX(),
		// (float) SupportCoordination.OptimizedSupportMap
		// .elementAt(i).getPosition().getY(),
		// 0 }, 1.0f, Color.YELLOW,
		// "animated.lines.field");
		//
		// }
		//
		// }
		//
		// }
		//
		//
		// if(Coordination.roboviz = true){
		// if (CoordinationBeliefs.Ball != null) {
		//
		// drawCircle(new float[] { (float) CoordinationBeliefs.Ball.getX(),
		// (float) CoordinationBeliefs.Ball.getY() }, 0.2f, 3,
		// Color.BLUE, "animated.circles");
		//
		// }
		//
		// if (BallObservationFilter.BallSampleVector != null) {
		//
		//
		// for (int i = 0; i < BallObservationFilter.BallSampleVector.size();
		// i++) {
		// if(BallObservationFilter.BallSampleVector.elementAt(i).getSamplesNum()>1){
		// drawCircle(new float[] { (float)
		// BallObservationFilter.BallSampleVector.elementAt(i).getBallPosition().getX(),
		// (float)
		// BallObservationFilter.BallSampleVector.elementAt(i).getBallPosition().getY()
		// }, 1.0f, 3,
		// Color.RED, "animated.circles");
		//
		// }else{
		//
		//
		// drawCircle(new float[] { (float)
		// BallObservationFilter.BallSampleVector.elementAt(i).getBallPosition().getX(),
		// (float)
		// BallObservationFilter.BallSampleVector.elementAt(i).getBallPosition().getY()
		// }, 1.0f, 3,
		// Color.CYAN, "animated.circles");
		//
		// }
		//
		// }
		//
		// }
		//
		//
		//
		//
		// if (CoordinationVectorUpdate.CoordinationVector.size() != 0) {
		//
		// for (int i = 0; i <
		// CoordinationVectorUpdate.CoordinationVector.size(); i++) {
		//
		//
		// if
		// (CoordinationVectorUpdate.CoordinationVector.elementAt(i).getType()
		// == 0){
		//
		// drawCircle(new float[] { (float)
		// CoordinationVectorUpdate.CoordinationVector.elementAt(i).getBall().getX(),
		// (float)
		// CoordinationVectorUpdate.CoordinationVector.elementAt(i).getBall().getY()
		// }, 0.1f, 2,
		// Color.WHITE, "animated.circles");
		//
		// }
		//
		// }
		//
		// }
		//
		// }

		if (ServerCyrcles.getCyrclesNow() > 100) {

			ActivePositions.Calculate();

			drawCircle(new float[] { (float) 8, (float) 6 }, 0.1f, 3,
					Color.RED, "animated.circles");

			for (int i = 0; i < ActivePositions.ActivePositions.size(); i++) {

				drawCircle(new float[] {
						(float) ActivePositions.ActivePositions.elementAt(i)
								.getX(),
						(float) ActivePositions.ActivePositions.elementAt(i)
								.getY() }, 0.2f, 4, Color.WHITE,
						"animated.circles");

			}

		}

		//
		// if (CoordinationVectorUpdate.CoordinationVector.size() != 0) {
		//
		// for (int i = 0; i < CoordinationVectorUpdate.CoordinationVector
		// .size(); i++) {
		//
		// if (RoleAssignmentFunction.ActiveRoles != null) {
		// for (int j = 0; j < RoleAssignmentFunction.ActiveRoles
		// .size(); j++) {
		// if (RoleAssignmentFunction.ActiveRoles.elementAt(j)
		// .getAgent().getNumber() ==
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getNumber()) {
		//
		// if (ActiveCoordination.OnBallPlayer ==
		// RoleAssignmentFunction.ActiveRoles
		// .elementAt(j).getAgent().getNumber()) {
		//
		// drawAgentAnnotation(
		// String.format(
		// "OB n:%d,r:%d,c:%d",
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i)
		// .getNumber(),
		// RoleAssignmentFunction.ActiveRoles
		// .elementAt(j).getRole(),
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getType()),
		// true,
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getNumber(),
		// Color.RED);
		// } else {
		//
		// drawAgentAnnotation(
		// String.format(
		// "A n:%d,r:%d,c:%d",
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i)
		// .getNumber(),
		// RoleAssignmentFunction.ActiveRoles
		// .elementAt(j).getRole(),
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getType()),
		// true,
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getNumber(),
		// Color.ORANGE);
		//
		// }
		//
		// }
		// }
		// }
		//
		// if (RoleAssignmentFunction.SupportRoles != null) {
		// for (int j = 0; j < RoleAssignmentFunction.SupportRoles
		// .size(); j++) {
		// if (RoleAssignmentFunction.SupportRoles.elementAt(j)
		// .getAgent().getNumber() ==
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getNumber()) {
		//
		// drawAgentAnnotation(String.format(
		// "S n:%d,r:%d,c:%d",
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getNumber(),
		// RoleAssignmentFunction.SupportRoles
		// .elementAt(j).getRole(),
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getType()), true,
		// CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getNumber(),
		// Color.YELLOW);
		//
		// }
		// }
		// }
		//
		// if (CoordinationVectorUpdate.CoordinationVector.elementAt(i)
		// .getType() == 0
		// || CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getType() == 1) {
		//
		// drawCircle(new float[] {
		// (float) CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getPlayer().getX(),
		// (float) CoordinationVectorUpdate.CoordinationVector
		// .elementAt(i).getPlayer().getY() }, 0.2f,
		// 2, Color.BLUE, "animated.circles");
		//
		// }
		//
		// }
		//
		// }

		// swap all sets starting with "animated"
		swapBuffers("animated");
	}

	/** Method for all static drawings */

	private void renderStaticShapes() throws IOException {
		swapBuffers("static");
	}

	public void runTest() throws IOException {
		animationTimer.start();
		renderStaticShapes();
	}

	private void swapBuffers(String group) throws IOException {
		byte[] buf = RVDraw.newBufferSwap(group);
		socket.send(new DatagramPacket(buf, buf.length, address, ROBOVIS_PORT));
	}

	public void drawCircle(float[] center, float radius, float thickness,
			Color color, String group) throws IOException {
		byte[] buf = RVDraw.newCircle(center, radius, thickness, color, group);
		socket.send(new DatagramPacket(buf, buf.length, address, ROBOVIS_PORT));
	}

	public void drawLine(float[] a, float[] b, float thickness, Color color,
			String group) throws IOException {
		byte[] buf = RVDraw.newLine(a, b, thickness, color, group);
		socket.send(new DatagramPacket(buf, buf.length, address, ROBOVIS_PORT));
	}

	public void drawPoint(float[] p, float size, Color color, String group)
			throws IOException {
		byte[] buf = RVDraw.newPoint(p, size, color, group);
		socket.send(new DatagramPacket(buf, buf.length, address, ROBOVIS_PORT));
	}

	public void drawSphere(float[] p, float radius, Color color, String group)
			throws IOException {
		byte[] buf = RVDraw.newSphere(p, radius, color, group);
		socket.send(new DatagramPacket(buf, buf.length, address, ROBOVIS_PORT));
	}

	public void drawPolygon(float[][] v, Color color, String set)
			throws IOException {
		byte[] buf = RVDraw.newPolygon(v, color, set);
		socket.send(new DatagramPacket(buf, buf.length, address, ROBOVIS_PORT));
	}

	public void drawAnnotation(String text, float[] pos, Color color, String set)
			throws IOException {
		byte[] buf = RVDraw.newAnnotation(text, pos, color, set);
		socket.send(new DatagramPacket(buf, buf.length, address, ROBOVIS_PORT));
	}

	public void drawAgentAnnotation(String text, boolean leftTeam,
			int agentNum, Color color) throws IOException {
		byte[] buf = RVDraw.newAgentAnnotation(text, leftTeam, agentNum, color);
		socket.send(new DatagramPacket(buf, buf.length, address, ROBOVIS_PORT));
	}

	public static void run(String[] args) throws Exception {
		RVTester tester = new RVTester();
		tester.runTest();
	}

}
