package com.cbse;

import java.util.List;

/**
 * Created by dmitr on 6/8/2016.
 */
public class Process {
    //  business type

    public List<Product> getProduces() {
        return produces;
    }

    public void setProduces(List<Product> produces) {
        this.produces = produces;
    }

    public List<ProcessStep> getSteps() {
        return steps;
    }

    public void setSteps(List<ProcessStep> steps) {
        this.steps = steps;
    }


    private List<Product> produces;
    private List<ProcessStep> steps;
    private Transportation transportation;

//    public Product produce(){
//
//    }
}
