package com.appcenttodo.enums;
//optional enumları TO_DO("todo") olarak tanımla

/***
 * örnek:
 * TO_DO("T"),
 * IN_PrOGRESS(I),
 *
 */
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
