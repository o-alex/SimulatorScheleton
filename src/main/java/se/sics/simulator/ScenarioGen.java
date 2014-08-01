/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator;

import se.sics.kompics.p2p.experiment.dsl.SimulationScenario;
import se.sics.kompics.p2p.experiment.dsl.adaptor.Operation1;
import se.sics.kompics.p2p.experiment.dsl.distribution.ConstantDistribution;
import se.sics.simulator.experiment.FDCmd;

/**
 *
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class ScenarioGen {
    static Operation1<FDCmd, Integer> doFD
            = new Operation1<FDCmd, Integer>() {

                @Override
                public FDCmd generate(Integer id) {
                    return new FDCmd(id);
                }
            };
    
      public static SimulationScenario simpleScenario(final long seed, int peers) {
        SimulationScenario scen = new SimulationScenario() {
            {
                SimulationScenario.StochasticProcess doFDProc = new SimulationScenario.StochasticProcess() {
                    {
                        eventInterArrivalTime(constant(1000));
                        raise(1, doFD, new ConstantDistribution<>(Integer.class, 1));
                    }
                };

                doFDProc.start();
                terminateAfterTerminationOf(1000, doFDProc);
            }
        };

        scen.setSeed(seed);

        return scen;
    }
}
