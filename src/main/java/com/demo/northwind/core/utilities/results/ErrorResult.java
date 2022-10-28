package com.demo.northwind.core.utilities.results;

public class ErrorResult extends Result{
    public ErrorResult(){
        super(false);
    }
    public ErrorResult(String _message){
        super(false, _message);
    }
}
