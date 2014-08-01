/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.sics.simulator.fd;

import se.sics.kompics.Component;
import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Handler;
import se.sics.kompics.Positive;
import se.sics.kompics.network.Network;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class CC extends ComponentDefinition {

    Positive<FDPort> fdPort = requires(FDPort.class);
    Positive<Network> network = requires(Network.class);

    private final int id;

    public CC(CCInit init) {
        this.id = init.id;

        Component c1 = create(C.class, new CInit(10 * id));
        Component c2 = create(C.class, new CInit(10 * id + 1));
        connect(c1.getNegative(FDPort.class), fdPort);
        connect(c2.getNegative(FDPort.class), fdPort);
        connect(c1.getNegative(Network.class), network);
        connect(c2.getNegative(Network.class), network);

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
            if (event.id == id) {
                System.out.println("trigerring");
                trigger(new FDEvent(), fdPort);
            }
        }
    };
}
