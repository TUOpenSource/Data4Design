package com.Data4Design.results;


public class LongResult extends Result{
    
    private long data;

    public LongResult() {

    }

    public LongResult(long input) {
        this.data = input;
    }
    
    public long fetchData() {
        return data;
    }

    public void setData(long input) {
        this.data = input;
    }
    
}