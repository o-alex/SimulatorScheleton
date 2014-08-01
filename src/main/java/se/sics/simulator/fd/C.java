/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator.fd;

import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Handler;
import se.sics.kompics.Positive;
import se.sics.kompics.network.Network;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class C extends ComponentDefinition {
    Positive<FDPort> fdPort = requires(FDPort.class);
    Positive<Network> network = requires(Network.class);
    private final int id;
    
    public C(CInit init) {
        this.id = init.id;
        
        subscribe(handleFD, fdPort);
        subscribe(handleFDTrigger, network);
    }
    
    public Handler<FDEvent> handleFD = new Handler<FDEvent>() {

        @Override
        public void handle(FDEvent event) {
            System.out.println("in " + id);
        }
    };
    
    public Handler<FDTrigger> handleFDTrigger = new Handler<FDTrigger>() {

        @Override
        public void handle(FDTrigger event) {
            if(event.id == id) {
                System.out.println("trigerring");
                trigger(new FDEvent(), fdPort);
            }
        }
    };
    
}
