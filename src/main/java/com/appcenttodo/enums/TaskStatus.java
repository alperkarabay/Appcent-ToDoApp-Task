package com.appcenttodo.enums;

public enum TaskStatus {
    TO_DO("TD") ,
    IN_PROGRESS("IP"),
    DONE("D");

    private String status;

    TaskStatus(String status){
        this.status=status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }


}
