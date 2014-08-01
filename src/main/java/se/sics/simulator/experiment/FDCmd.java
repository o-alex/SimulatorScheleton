/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.sics.simulator.experiment;

import se.sics.kompics.KompicsEvent;

/**
 * @author Alex Ormenisan <aaor@sics.se>
 */
public class FDCmd implements KompicsEvent {
    public final int id;
    
    public FDCmd(int id) {
        this.id = id;
    }
}
