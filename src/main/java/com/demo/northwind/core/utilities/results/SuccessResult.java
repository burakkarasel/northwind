package com.demo.northwind.core.utilities.results;

public class SuccessResult extends Result{
    public SuccessResult(){
        super(true);
    }
    public SuccessResult(String _message){
        super(true, _message);
    }
}
