package com.p2p.service;
import com.p2p.domain.*;
import java.math.BigDecimal;

public class LoanService {
    public Loan createLoan(Borrower borrower, BigDecimal amount){
        //VALIDASI UTAMA (TC-01)
        //jika borrower belum terverifikasi, maka proses dihentikan
        if(!borrower.isVerified()){
            throw new IllegalArgumentException("Borrower not verified");
        }
        //membuat objek loan baru
        Loan loan = new Loan();

        //LOGIC SEDERHANA (sementara)
        //jika credit score tinggi -> APPROVED
        //jika tidak -> REJECTED
        if (borrower.getCreditScore() >= 600) {
            loan.setStatus(Loan.Status.APPROVED);
        } else {
            loan.setStatus(Loan.Status.REJECTED);
        }
        return loan;
    }
}
