/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.sics.simulator;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.sics.kompics.Component;
import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Handler;
import se.sics.kompics.Init;
import se.sics.kompics.Positive;
import se.sics.kompics.address.Address;
import se.sics.kompics.network.Network;
import se.sics.simulator.experiment.ExperimentPort;
import se.sics.simulator.experiment.FDCmd;
import se.sics.simulator.fd.CC;
import se.sics.simulator.fd.CCInit;
import se.sics.simulator.fd.FDComp;
import se.sics.simulator.fd.FDEvent;
import se.sics.simulator.fd.FDPort;
import se.sics.simulator.fd.FDTrigger;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class SimManagerComp extends ComponentDefinition {

    Positive<ExperimentPort> expPort = requires(ExperimentPort.class);
    Positive<Network> network = requires(Network.class);

    public SimManagerComp() {
        Component fd = create(FDComp.class, Init.NONE);
        Component c1 = create(CC.class, new CCInit(1));
        Component c2 = create(CC.class, new CCInit(2));
        connect(c1.getNegative(FDPort.class), fd.getPositive(FDPort.class));
        connect(c2.getNegative(FDPort.class), fd.getPositive(FDPort.class));
        connect(c1.getNegative(Network.class), network);
        connect(c2.getNegative(Network.class), network);

        subscribe(handleFDCmd, expPort);
    }

    public Handler<FDCmd> handleFDCmd = new Handler<FDCmd>() {

        @Override
        public void handle(FDCmd event) {
            try {
                InetAddress ip = InetAddress.getByName("127.0.0.1");
                Address adr = new Address(ip, 0, 0);
                trigger(new FDTrigger(adr, adr, event.id), network);
            } catch (UnknownHostException ex) {
                throw new RuntimeException(ex);
            }
        }
    };
}
