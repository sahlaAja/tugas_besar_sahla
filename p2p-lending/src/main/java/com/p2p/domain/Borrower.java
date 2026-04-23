package com.p2p.domain;

public class Borrower {
    //status verifikasi KYC
    private boolean verified;

    //nilai credit score borrower
    private int creditScore;

    //constructor untuk inisialisasi data borrower
    public Borrower(boolean verified, int creditScore){
        this.verified = verified;
        this.creditScore = creditScore;
    }

    //getter untuk mengecek apakah borrower sudah verified
    public boolean isVerified(){
        return verified;
    }

    //getter untuk mengambil credit score
    public int getCreditScore(){
        return creditScore;
    }
}
