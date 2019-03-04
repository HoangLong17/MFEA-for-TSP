package com.ngm.mfea;

import java.util.ArrayList;

public class Chromosome {
    private ArrayList<Integer> data; //Chromosome's data.

    public Chromosome() {
        data = new ArrayList<>();
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public void setData(ArrayList<Integer> data) {
        this.data = data;
    }

    public int getData(int index) {
        return data.get(index);
    }

    public void setData(int index, int value) {
        if(index > data.size() - 1) this.data.add(value);
        else data.set(index, value);
    }
}
