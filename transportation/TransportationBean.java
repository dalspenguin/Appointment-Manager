package cbse.transportation;

import cbse.transportation.interfaces.MachineRemote;

import javax.ejb.Stateful;

/**
 * Created by dmitr on 6/10/2016.
 */
@Stateful(name = "TransportationEJB")
public class TransportationBean implements TransportationRemote {
    //  Business type

    private Robot robot;

    public TransportationBean() {
        robot = new Robot();
    }

    @Override
    public void movePart(MachineRemote from, MachineRemote to) {
        robot.move(from, to);
    }


}
