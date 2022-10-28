package com.demo.northwind.core.utilities.results;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean _success){
        this.setSuccess(_success);
    }

    public Result(boolean _success, String _message){
        this(_success); // calling the one parameter constructor here
        this.setMessage(_message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
