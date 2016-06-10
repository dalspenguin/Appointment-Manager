package cbse.transportation;

import cbse.transportation.interfaces.MachineRemote;

/**
 * Created by dmitr on 6/8/2016.
 */

public class Robot {
    //  Business type

    public void move(MachineRemote from, MachineRemote to){
        to.setProduct(from.getProduct());   //  move the product
    }
}
