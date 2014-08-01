/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator.fd;

import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Handler;
import se.sics.kompics.Negative;

/**
 *
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class FDComp extends ComponentDefinition {
    Negative<FDPort> fdPort = provides(FDPort.class);
    
    public FDComp() {
        subscribe(handleFD, fdPort);
    }
    
    public Handler<FDEvent> handleFD = new Handler<FDEvent>() {

        @Override
        public void handle(FDEvent event) {
            trigger(event, fdPort);
        }
    };
}
