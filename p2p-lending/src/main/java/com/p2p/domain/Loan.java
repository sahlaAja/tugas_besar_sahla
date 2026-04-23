package com.p2p.domain;

public class Loan {
    //enum untuk status loan
    public enum Status{
        PENDING, APPROVED, REJECTED
    }

    private Status status;

    //saat loan dibuat, status awal adalah PENDING
    public Loan(){
        this.status = Status.PENDING;
    }

    //setter untuk mengubah status loan
    public void setStatus(Status status){
        this.status = status;
    }

    //getter untuk membaca status Loan
    public Status getStatus(){
        return status;
    }
}
