package com.p2p.service;
import com.p2p.domain.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {
    private static final Logger logger = LogManager.getLogger(LoanService.class);
    public Loan createLoan(Borrower borrower, BigDecimal amount){
        logger.info("Start loan creation process");
        //VALIDASI UTAMA (TC-01)
        //jika borrower belum terverifikasi, maka proses dihentikan
        validateBorrower(borrower);
        //VALIDASI AMOUNT (TC-02)
        //check apakah amount > 0, jika tidak loan akan ditolak
        validateAmount(amount);
        //membuat objek loan baru
        Loan loan = new Loan();
        logger.info("Loan object created");

        //CREDIT SCORING (TC-03 & TC-04)
        if (borrower.isEligibleForLoan()) {
            loan.approve();
            logger.info("Loan APPROVED for borrower with score: {}", borrower.getCreditScore());
        } else{
            loan.reject();
            logger.warn("Loan REJECTED for borrower with score: {}", borrower.getCreditScore());
        }
        logger.info("Loan creation process finished with status: {}", loan.getStatus());

        return loan;
    }

    private void validateBorrower(Borrower borrower){
        if (!borrower.canApplyLoan()) {
            logger.error("Borrower not verified");
            throw new IllegalArgumentException("Borrowed not verified");
        }
        logger.info("Borrower verified");
    }

    private void validateAmount(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Invalid loan amount: {}", amount);
            throw new IllegalArgumentException("Invalid loan amount.");
        }
        logger.info("Valid loan amount: {}", amount);
    }
}
