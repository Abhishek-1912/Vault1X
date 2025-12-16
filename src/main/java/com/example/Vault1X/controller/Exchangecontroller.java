package com.example.Vault1X.controller;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.vaultX.Service.TransactionalService;
// import com.example.vaultX.dto.AmountRequest;
// import com.example.vaultX.entity.Transactions;
// import com.example.vaultX.enums.TransactionalType;

// import jakarta.validation.Valid;
// @RestController
// @RequestMapping("/api/VaultX")

// public class Exchangecontroller {

// @Autowired
// private TransactionalService transactionService;

// @PostMapping()
// public ResponseEntity<Transactions> deposit(@PathVariable int wallet_id,
// @Valid @RequestBody AmountRequest req) {
// Transactions t = transactionService.createdepositTransaction(wallet_id,
// req.getAmount());
// return ResponseEntity.status(HttpStatus.CREATED).body(t);
// }

// @PostMapping("/wallets/{walletId}/withdraw")
// public ResponseEntity<Transactions> withdraw(@PathVariable int wallet_id,
// @Valid @RequestBody AmountRequest req) {
// Transactions t = transactionService.createWithdrawalTransaction(wallet_id,
// req.getAmount());
// return ResponseEntity.status(HttpStatus.CREATED).body(t);
// }

// // @PostMapping("/wallets/transfer")
// // public ResponseEntity<Transactions> transfer(@Valid @RequestBody
// TransferRequest req) {
// // Transactions t =
// transactionService.createTransferTransaction(req.getFromWalletId(),
// req.getToWalletId(),
// // req.getAmount());
// // return ResponseEntity.status(HttpStatus.CREATED).build();
// // }

// // @GetMapping("/transactions")
// // public ResponseEntity<?> getTransactions(@RequestParam String userId,
// // @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue =
// "20") int size) {
// // return
// ResponseEntity.ok(transactionService.getAllTransactionsWithPagination(userId,
// page, size)
// // .map(TransactionMapper::toDto));
// // }

// // @GetMapping("/transactions/type")
// // public ResponseEntity<?> getTransactionsByType(@RequestParam String
// userId, @RequestParam String type) {
// // TransactionalType tt;
// // try {
// // tt = TransactionalType.valueOf(type.toUpperCase());
// // } catch (IllegalArgumentException e) {
// // return ResponseEntity.badRequest().body("Invalid transaction type");
// // }
// // List<Transactions> list =
// transactionService.getAllTransactionsByType(userId, tt);
// // return ResponseEntity.ok(TransactionMapper.toDtoList(list));
// // }

// }
