package com.isha.prepare.uc;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int data;
    int index;
    GraphNode parent;
    List<GraphNode> childGraphs;

    GraphNode(int data){
        this.data = data;
        index = 0;
        parent = null;
        childGraphs = null;
    }

    public void insert(WeightsHelper weightsHelper){
        childGraphs = new ArrayList();
        for(int i = index-1; i >= 0; i--){
            int value = this.data+weightsHelper.getWeightValue(i);
            int median = weightsHelper.getSum()/2;
            if(value != weightsHelper.getSum()) {
                weightsHelper.setBestOption(value);
                if(value <= median){
                    GraphNode childNode = new GraphNode(value);
                    childNode.index = i;
                    childNode.parent = this;
                    childGraphs.add(childNode);
                }
            }
        }
        for(GraphNode childNode : childGraphs){
            childNode.insert(weightsHelper);
        }
    }
}
