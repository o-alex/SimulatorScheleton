/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator.fd;

import se.sics.kompics.Init;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class CInit extends Init<C> {
    public final int id;
    
    public CInit(int id) {
        this.id = id;
    }
}
