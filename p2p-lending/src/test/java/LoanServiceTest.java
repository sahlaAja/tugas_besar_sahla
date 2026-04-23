import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import com.p2p.domain.*; //tambahkan ini agar borrower bisa dipakai
import com.p2p.service.*; //tambahkan ini agar loanService bisa dipakai

public class LoanServiceTest {
    @Test

    void shouldRejectLoanWhenBorrowerNotVerified(){
        //skenario
        //borrower tidak terverifikasi (KYC=false)
        //ketika borrower mengajukan pinjaman, maka sistem harus menolak
        //dengan melempar exception

        //Arrange (Initial Condition)
        //Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);

        //serive untuk pengajuan loan
        LoanService loanService = new LoanService();

        //jumlah loan valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }
}
