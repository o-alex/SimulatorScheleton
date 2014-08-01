/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator;

import se.sics.kompics.Kompics;
import se.sics.kompics.p2p.experiment.dsl.SimulationScenario;
import se.sics.kompics.simulation.SimulatorScheduler;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class Main {
    public static SimulatorScheduler scheduler;
    public static SimulationScenario scenario;
    public static long seed;
    
    public static void main(String[] args) {
        seed = 123;
        start();
        try {
            Kompics.waitForTermination();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static void stop() {
        Kompics.shutdown();
    }
    
    public static void start() {
        scheduler = new SimulatorScheduler();
        scenario = ScenarioGen.simpleScenario(seed, 10);
        
        Kompics.setScheduler(scheduler);
        Kompics.createAndStart(Launcher.class, 1);
    }
}

