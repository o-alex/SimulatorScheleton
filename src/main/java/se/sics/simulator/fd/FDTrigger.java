/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator.fd;

import se.sics.kompics.address.Address;
import se.sics.kompics.network.Message;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class FDTrigger extends Message {
    public final int id;
    
    public FDTrigger(Address src, Address dst, int id) {
        super(src, dst);
        this.id = id;
    }
}
