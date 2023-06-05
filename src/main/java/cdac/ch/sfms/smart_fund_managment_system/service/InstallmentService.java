package cdac.ch.sfms.smart_fund_managment_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.ch.sfms.smart_fund_managment_system.entity.Installment;
import cdac.ch.sfms.smart_fund_managment_system.repository.InstallmentRepository;



@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;

    public List<Long> getUsersByGroupIdAndInstallmentNumber(Long groupId, Long installmentNumber) {
        List<Installment> installments = installmentRepository.findByGroupIdAndInstallmentNumber(groupId, installmentNumber);
        List<Long> results = new ArrayList<>();
        List<String> statuses = new ArrayList<>();
        for (Installment installment : installments) {
            results.add(installment.getUserId());
            statuses.add(installment.getStatus());
        }

        return results;
    }
   
    public List<Installment> getInstallmentsByGroupIdAndInstallmentNumber(Long groupId, Long installmentNumber) {
        return installmentRepository.findByGroupIdAndInstallmentNumber(groupId, installmentNumber);
    }
   
}