package com.example.Vault1X.service;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.vaultX.Repository.WalletRepository;
// import com.example.vaultX.entity.Wallet;
// import com.example.vaultX.enums.CurrencyType;

// @Service
// public class WalletService{
// @Autowired
// private WalletRepository walletrepo;
// @Autowired
// private ExchangeRateService exchangeRateService;
// public Wallet createWallet(Long userId, CurrencyType currency){
// Wallet wallet = new Wallet();
// wallet.setbalance(BigDecimal.ZERO);
// wallet.setCurrency(currency);
// return walletrepo.save(wallet);
// }
// public Map<String,Object> getWalletwithAllCurrencies(int
// wallet_id,CurrencyType[] targetCurrencies){
// Wallet wallet= walletrepo.findById(wallet_id).orElseThrow(()->new
// RuntimeException("No Wallet found"));
// Map<String,Object> result= new HashMap<>();
// result.put("wallet",wallet);
// result.put("Get balances with All
// Currencies",exchangeRateService.getWalletInMultipleCurrencies(wallet,Arrays.asList(targetCurrencies)));
// return result;
// }
// public BigDecimal Transferbetweenwallets(Integer fromwallet_id,Integer
// towallet_id,BigDecimal amount){
// Wallet fromWallet = walletrepo.findById(fromwallet_id).orElseThrow(()->new
// RuntimeException("Source Not Found"));
// Wallet toWallet = walletrepo.findById(towallet_id).orElseThrow(()->new
// RuntimeException("Destination Not Found"));
// if (fromWallet.getbalance().compareTo(amount)<0){
// throw new RuntimeException("Insuffient Balance");
// }
// //currenices are different (from is different and to is different)
// BigDecimal amountToTransfer = amount;
// if (fromWallet.getCurrency()!=toWallet.getCurrency()){
// amountToTransfer =
// exchangeRateService.convertCurrency(amount,fromWallet.getCurrency(),toWallet.getCurrency());
// }
// fromWallet.setbalance(fromWallet.getbalance().subtract(amount));
// toWallet.setbalance(toWallet.getbalance().add(amountToTransfer));
// walletrepo.saveAll(List.of(fromWallet,toWallet));
// return amountToTransfer;
// }
// public Wallet deposit(Integer walletId, BigDecimal amount) {
// if (amount.compareTo(BigDecimal.ZERO) <= 0) {
// throw new IllegalArgumentException("Deposit amount must be positive");
// }

// Wallet wallet = walletrepo.findById(walletId)
// .orElseThrow(() -> new RuntimeException("Wallet not found with id: " +
// walletId));

// // Update balance
// wallet.setbalance(wallet.getbalance().add(amount));
// wallet.setupdatedAt(LocalDateTime.now());

// return walletrepo.save(wallet);
// }

// // Also add withdraw method
// public Wallet Withdrawal(Integer wallet_id, BigDecimal amount) {
// if (amount.compareTo(BigDecimal.ZERO) <= 0) {
// throw new IllegalArgumentException("Withdrawal amount must be positive");
// }

// Wallet wallet = walletrepo.findById(wallet_id)
// .orElseThrow(() -> new RuntimeException("Wallet not found with id: " +
// wallet_id));

// // Check sufficient balance
// if (wallet.getbalance().compareTo(amount) < 0) {
// throw new RuntimeException("Insufficient balance");
// }

// // Update balance
// wallet.setbalance(wallet.getbalance().subtract(amount));
// wallet.setupdatedAt(LocalDateTime.now());

// return walletrepo.save(wallet);
// }
// }
