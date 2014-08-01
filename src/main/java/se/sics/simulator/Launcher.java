/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator;

import se.sics.kompics.Component;
import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Init;
import se.sics.kompics.network.Network;
import se.sics.kompics.timer.Timer;
import se.sics.simulator.core.P2pSimulator;
import se.sics.simulator.core.P2pSimulatorInit;
import se.sics.simulator.core.UniformRandomModel;
import se.sics.simulator.experiment.ExperimentPort;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class Launcher extends ComponentDefinition {
    {
        P2pSimulator.setSimulationPortType(ExperimentPort.class);
        Component simulator = create(P2pSimulator.class,
                new P2pSimulatorInit(Main.scheduler, Main.scenario, new UniformRandomModel(1, 10)));
        Component simManager = create(SimManagerComp.class, Init.NONE);
        connect(simManager.getNegative(Network.class), simulator.getPositive(Network.class));
        connect(simManager.getNegative(ExperimentPort.class), simulator.getPositive(ExperimentPort.class));
    }   
}
