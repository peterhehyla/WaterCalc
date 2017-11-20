package com.hylamobile.test.watercalc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalcWater {
    private long sumTotalWater = 0;

    Node maxValueNode;
    long totalWater = 0;
    List<Long> inputList = new ArrayList<Long>();

    public CalcWater(List<Long> inputList){
        this.inputList = inputList;
    }

    public long calculateWater(){

        if(inputList==null || inputList.isEmpty()){
            return 0L;
        }
        //init value
        maxValueNode =null;
        totalWater = 0;
        maxValueNode = sumWaterFromBegin();
        sumWaterFromEnd(maxValueNode.getIndex());
        return totalWater;
    }

    public void setInputList(List<Long> inputList) {
        this.inputList = inputList;
    }

    private Node sumWaterFromBegin(){
        Node currentNode = findBeginningNode(true);
        List<Long> intervalList = new ArrayList<Long>();
        int size = inputList.size();

        for(int i=1; i<size; i++){
            if(currentNode.getValue()>inputList.get(i)){
                intervalList.add(inputList.get(i));
            }else{
                totalWater +=calWater(currentNode, intervalList);
                intervalList.clear();
                currentNode = new Node(inputList.get(i), i);
            }
        }

        return currentNode;
    }

    private void sumWaterFromEnd(long maxValueIndex){
        Node currentNode = findBeginningNode(false);
        List<Long> intervalList = new ArrayList<Long>();
        int size = inputList.size()-1;

        for(int i=size; i>=maxValueIndex; i--){
            if(currentNode.getValue()>inputList.get(i)){
                intervalList.add(inputList.get(i));
            }else{
                totalWater +=calWater(currentNode, intervalList);
                intervalList.clear();
                currentNode = new Node(inputList.get(i), i);
            }
        }
    }

    private long calWater(Node currentNode, List<Long> intervalList){
        int size = intervalList.size();
        return currentNode.getValue()* size - sumOfIntervalList(intervalList);
    }

    private long sumOfIntervalList(List<Long> intervalList){
        return intervalList.stream().mapToLong(l->(long)l).sum();
    }

    private Node findBeginningNode(boolean fromBeginningFlag){
        Node beggingNode = null;
        if(fromBeginningFlag){
            beggingNode = new Node(inputList.get(0), 0);
        }else{
            int index = inputList.size()-1;
            beggingNode = new Node(inputList.get(index), index);
        }

        return beggingNode;
    }

    class Node{
        private long value;
        private long index;

        public Node(long value, long index) {
            this.value = value;
            this.index = index;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public long getIndex() {
            return index;
        }

        public void setIndex(long index) {
            this.index = index;
        }
    }
}
