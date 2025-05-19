package com.m2ibank.controller;

import com.m2ibank.model.Loans;
import com.m2ibank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping
    public List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }

    @PostMapping
    public Loans createLoan(@RequestBody Loans loan) {
        return loanRepository.save(loan);
    }


}
