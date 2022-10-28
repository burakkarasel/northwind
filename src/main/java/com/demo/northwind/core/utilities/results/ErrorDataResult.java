package com.demo.northwind.core.utilities.results;

public class ErrorDataResult<T> extends ErrorResult{
    private T data;

    public ErrorDataResult(T _data){
        super();
        this.setData(_data);
    }

    public ErrorDataResult(T _data, String _message){
        super(_message);
        this.setData(_data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
