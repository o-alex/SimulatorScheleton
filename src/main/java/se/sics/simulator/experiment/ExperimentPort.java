/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator.experiment;

import se.sics.kompics.PortType;
import se.sics.kompics.p2p.experiment.dsl.events.TerminateExperiment;

/**
 *
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class ExperimentPort extends PortType {
    {
        positive(FDCmd.class);
        positive(TerminateExperiment.class);
        negative(TerminateExperiment.class);
    }
}