package com.demo.northwind.core.utilities.results;

public class SuccessDataResult<T> extends SuccessResult{
    private T data;
    public SuccessDataResult(T _data){
        super();
        this.setData(_data);
    }

    public SuccessDataResult(T _data, String _message){
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
