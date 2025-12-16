package com.example.Vault1X.repository;

// import java.math.BigDecimal;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.example.vaultX.entity.Wallet;
// import com.example.vaultX.enums.CurrencyType;

// public interface WalletRepository extends JpaRepository<Wallet,Integer> {

// // Basic CRUD methods (already provided by JpaRepository)
// // findById, save, delete, findAll, etc.

// // Get wallet by ID (required by your TransactionService)
// // Note: findById is already provided by JpaRepository, but you can add
// custom query
// default Wallet getwalletById(Integer wallet_id) {
// return findById(wallet_id)
// .orElseThrow(() -> new RuntimeException("Wallet not found"));
// }

// // Find wallet by user
// List<Wallet> findByUserUserId(Integer userId);

// // Find wallet by user and currency
// Optional<Wallet> findByUserUserIdAndCurrencyType(Integer userId, CurrencyType
// currencyType);

// // Check if wallet exists for user and currency
// boolean existsByUserUserIdAndCurrencyType(Integer userId, CurrencyType
// currencyType);

// // Find active wallets
// List<Wallet> findByUserUserIdAndIsActiveTrue(Integer userId);

// // Get total balance for user across all wallets
// @Query("SELECT SUM(w.balance) FROM Wallet w WHERE w.user.userId = :userId")
// Optional<BigDecimal> getTotalBalanceByUser(@Param("userId") Integer userId);

// // Get user's primary wallet (first wallet)
// @Query("SELECT w FROM Wallet w WHERE w.user.userId = :userId ORDER BY
// w.createdAt ASC LIMIT 1")
// Optional<Wallet> findPrimaryWallet(@Param("userId") Integer userId);

// // Find wallets with balance greater than amount
// List<Wallet> findByUserUserIdAndBalanceGreaterThan(Integer userId, BigDecimal
// amount);
// }