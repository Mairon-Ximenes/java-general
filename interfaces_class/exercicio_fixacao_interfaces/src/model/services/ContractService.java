package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    OnlinePaymentService service;

    public ContractService(OnlinePaymentService service) {
        this.service = service;
    }

    public void processContract(Contract contract, int months){
        for(int i = 1; i <= months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double dividedValue = contract.getTotalValue() / months;
            double amount = dividedValue + service.interest(dividedValue, i);
            amount += service.paymentFee(amount);
            Installment installment = new Installment(dueDate, amount);
            contract.getInstallmentList().add(installment);
        }
    }
}
