package com.p2p.service;
import com.p2p.domain.*;
import java.math.BigDecimal;

public class LoanService {
    public Loan createLoan(Borrower borrower, BigDecimal amount){
        //VALIDASI UTAMA (TC-01)
        //jika borrower belum terverifikasi, maka proses dihentikan
        validateBorrower(borrower);
        //membuat objek loan baru
        Loan loan = new Loan();
        if (borrower.getCreditScore() >= 600) {
            loan.approve();
        } else{
            loan.reject();
        }
        return loan;
    }

    private void validateBorrower(Borrower borrower){
        if (!borrower.canApplyLoan()) {
            throw new IllegalArgumentException("Borrowed not verified");
        }
    }
}
