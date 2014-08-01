/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator.fd;

import se.sics.kompics.PortType;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class FDPort extends PortType {
    {
        request(FDEvent.class);
        indication(FDEvent.class);
    }
}
