package com.example.Vault1X.service;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// import org.springframework.data.domain.Page;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
// import org.springframework.stereotype.Service;
// import org.springframework.data.domain.Pageable;

// import com.example.vaultX.Repository.TransactionalRepository;
// import com.example.vaultX.Repository.WalletRepository;
// import com.example.vaultX.entity.Transactions;
// import com.example.vaultX.entity.Users;
// import com.example.vaultX.entity.Wallet;
// import com.example.vaultX.enums.TransactionalStatus;
// import com.example.vaultX.enums.TransactionalType;

// import jakarta.transaction.Transactional;

// @Service
// @Transactional
// public class TransactionalService {
// @Autowired
// private TransactionalRepository transacrepo;
// @Autowired
// private WalletRepository walletrepo;
// @Autowired
// private WalletService walletService;
// public Transactions createdepositTransaction(int wallet_id, BigDecimal
// amount){
// Wallet wallet = walletrepo.getwalletById(wallet_id);
// Users user = wallet.getuser();
// Transactions transaction = new Transactions(amount,TransactionalType.DEPOSIT,
// user);
// transaction.setToWallet(wallet);
// transaction.setDescription("Desposit amount");
// transaction.setstatus(TransactionalStatus.COMPLETED);
// transaction.setCompletedAt(LocalDateTime.now());
// return transacrepo.save(transaction);
// }
// public Transactions createWithdrawalTransaction(int wallet_id, BigDecimal
// amount){
// Wallet wallet = walletrepo.getwalletById(wallet_id);
// Users user = wallet.getuser();
// Transactions transaction = new Transactions(amount,
// TransactionalType.WITHDRAWAL, user);
// transaction.setfromWallet(wallet);
// transaction.setDescription("Withdrawal amount");
// transaction.setstatus(TransactionalStatus.COMPLETED);
// transaction.setCompletedAt(LocalDateTime.now());
// return transacrepo.save(transaction);
// }
// public Transactions createTransferFromwallet_idtoTo_wallet_id(int
// fromWallet_id,int toWallet_id,BigDecimal amount){
// Wallet fromwallet = walletrepo.getwalletById(fromWallet_id);
// Wallet towallet = walletrepo.getwalletById(toWallet_id);
// Users user = fromwallet.getuser();
// Transactions transaction = new Transactions
// (amount,TransactionalType.TRANSFER,user);
// transaction.setfromWallet(fromwallet);
// transaction.setToWallet(towallet);
// transaction.setDescription("Transfer amount");
// transaction.setstatus(TransactionalStatus.COMPLETED);
// transaction.setCompletedAt(LocalDateTime.now());
// return transacrepo.save(transaction);
// }
// public Page<Transactions> getallTransactionsWithPagination(int userId, int
// page, int size){
// Pageable pagable = PageRequest.of
// (page,size,Sort.by(Sort.Direction.DESC,"createdAt"));
// return transacrepo.findByUserUserIdOrderByCreatedAtDesc(userId,pagable);
// }
// // public List<Transactions> getallTransactionsByTransactionalType(int
// userId, TransactionalType type){
// // return
// transacrepo.findByUserUserIdAndTransactionalTypeOrderByCreatedAtDesc(userId,type);
// // }
// public List<Transactions> getallTransactionsByDateRange(int userId,LocalDate
// start, LocalDate end){
// return transacrepo.findByUserAndDateRange(userId,start,end);
// }
// public List<Transactions> getwallettransactionsById(int wallet_id){
// return transacrepo.findByWalletId(wallet_id);
// }
// public Map<String,Object> getallTransactionSummary(Integer userId){
// Map<String,Object> summary = new HashMap<>();
// BigDecimal totalDeposit =
// transacrepo.sumByUserandTypeandStatus(userId,TransactionalType.DEPOSIT,TransactionalStatus.COMPLETED);
// BigDecimal totalWithdrawal =
// transacrepo.sumByUserandTypeandStatus(userId,TransactionalType.WITHDRAWAL,TransactionalStatus.COMPLETED);
// BigDecimal totalTransfer =
// transacrepo.sumByUserandTypeandStatus(userId,TransactionalType.TRANSFER,TransactionalStatus.COMPLETED);
// List<Transactions> recentTransactions = transacrepo
// .findByUserUserIdOrderByCreatedAtDesc(userId)
// .stream()
// .limit(5)
// .collect(Collectors.toList());//getUserTransactions;
// summary.put("totalDeposits",totalDeposit);
// summary.put("totalWithdrawal",totalWithdrawal);
// summary.put("totalTransfer",totalTransfer);
// summary.put("recentTransactions",recentTransactions);
// summary.put("TotalTransactions",recentTransactions.size());
// return summary;
// }
// public Wallet DepositWithTransactions(Integer wallet_id, BigDecimal amount){
// Wallet wallet = walletService.deposit(wallet_id,amount);
// createdepositTransaction(wallet_id, amount);
// return wallet;
// }
// public Wallet WithdrawalWithTransactions(Integer wallet_id, BigDecimal
// amount){
// Wallet wallet = walletService.Withdrawal(wallet_id,amount);
// createWithdrawalTransaction(wallet_id, amount);
// return wallet;
// }
// public Wallet transferWithTransaction(int fromwallet_id, int towallet_id,
// BigDecimal amount) {
// BigDecimal transferredAmount =
// walletService.Transferbetweenwallets(fromwallet_id, towallet_id, amount);
// createTransferFromwallet_idtoTo_wallet_id(fromwallet_id, towallet_id,
// amount);

// // Return the updated from wallet
// return walletrepo.getwalletById(fromwallet_id);
// }

// }
