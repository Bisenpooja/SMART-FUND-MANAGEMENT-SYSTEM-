package cdac.ch.sfms.smart_fund_managment_system.service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.ch.sfms.smart_fund_managment_system.entity.GroupMember;
import cdac.ch.sfms.smart_fund_managment_system.entity.Installment;
import cdac.ch.sfms.smart_fund_managment_system.entity.WinnerHistory;
import cdac.ch.sfms.smart_fund_managment_system.repository.GroupMemberRepository;
import cdac.ch.sfms.smart_fund_managment_system.repository.InstallmentRepository;
import cdac.ch.sfms.smart_fund_managment_system.repository.WinnerHistoryRepository;

@Service
public class WinnerService {

  @Autowired
  private GroupMemberRepository groupMemberRepository;

  @Autowired
  private InstallmentRepository installmentRepository;

  @Autowired
  private WinnerHistoryRepository winnerHistoryRepository;

  private Set<Long> previousWinners = new HashSet<>();

  public Long saveWinners(long groupId, long installmentNumber) {
	  List<GroupMember> groupMembers = groupMemberRepository.findByGroupId(groupId);
	  List<Installment> paidInstallments = installmentRepository.findByGroupIdAndInstallmentNumberAndStatus(groupId, installmentNumber, "paid");

	  List<Long> eligibleCandidates = groupMembers.stream()
	    .filter(member -> paidInstallments.stream().anyMatch(installment -> installment.getUserId() == member.getUserId()))
	    .map(GroupMember::getUserId)
	    .filter(id -> !previousWinners.contains(id))
	    .collect(Collectors.toList());

    if (eligibleCandidates.isEmpty()) {
      // No eligible candidates available, reset previous winners and exit
      previousWinners.clear();
      return null;
    }

    // Select a random winner from eligible candidates
    int randomIndex = new Random().nextInt(eligibleCandidates.size());
    Long winnerId = eligibleCandidates.get(randomIndex);

    // Save winner and update previous winners
    WinnerHistory winner = new WinnerHistory();
    winner.setGroupId(groupId);
    winner.setInstallmentNumber(installmentNumber);
    winner.setWinnerId(winnerId);
    winnerHistoryRepository.save(winner);

    previousWinners.add(winnerId);
    return winnerId;
  }
}
