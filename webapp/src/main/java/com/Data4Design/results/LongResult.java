package com.Data4Design.results;


public class LongResult extends Result{
    
    private long data;

    public LongResult(long input) {
        this.data = (double)input;
    }
    
    public long fetchData() {
        return data;
    }
    
}