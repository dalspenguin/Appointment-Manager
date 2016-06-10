package cbse.transportation;

import cbse.transportation.interfaces.MachineRemote;

/**
 * Created by dmitr on 6/10/2016.
 */
public interface TransportationRemote {
//    public void movePart();
    public void movePart(MachineRemote from, MachineRemote to);
}
