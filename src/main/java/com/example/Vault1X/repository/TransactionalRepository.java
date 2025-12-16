package com.example.Vault1X.repository;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.example.vault1X.entity.Transactions;
// import com.example.vault1X.enums.TransactionalStatus;
// import com.example.vault1X.enums.TransactionalType;

// public interface TransactionalRepository extends
// JpaRepository<Transactions,Long> {

// List<Transactions> findByUserUserIdOrderByCreatedAtDesc(Integer userId);
// // Find transactions with pagination
// Page<Transactions> findByUserUserIdOrderByCreatedAtDesc(Integer userId,
// Pageable pageable);

// // Find transactions by type and user
// // List<Transactions>
// findByUserUserIdAndTransactionalTypeOrderByCreatedAtDesc(Integer userId,
// TransactionalType type);

// // Find transactions by status and user
// List<Transactions> findByUserUserIdAndStatusOrderByCreatedAtDesc(Integer
// userId, TransactionalStatus status);

// // Find transactions within date range
// @Query("SELECT t FROM Transactions t WHERE t.user.userId = :userId " +
// "AND DATE(t.createdAt) BETWEEN :startDate AND :endDate " +
// "ORDER BY t.createdAt DESC")
// List<Transactions> findByUserAndDateRange(@Param("userId") Integer userId,
// @Param("startDate") LocalDate startDate,
// @Param("endDate") LocalDate endDate);

// // Find transactions by wallet ID (both from and to)
// @Query("SELECT t FROM Transactions t WHERE " +
// "t.fromWallet.walletId = :walletId OR t.toWallet.walletId = :walletId " +
// "ORDER BY t.createdAt DESC")
// List<Transactions> findByWalletId(@Param("walletId") Integer walletId);

// // Find transaction by reference ID
// Optional<Transactions> findByReferenceId(String referenceId);

// // Sum amounts by user, type, and status
// @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transactions t " +
// "WHERE t.user.userId = :userId " +
// "AND t.transactionType = :type " +
// "AND t.status = :status")
// BigDecimal sumByUserandTypeandStatus(@Param("userId") Integer userId,
// @Param("type") TransactionalType type,
// @Param("status") TransactionalStatus status);

// // Count transactions by user
// Long countByUserUserId(Integer userId);

// // Find recent transactions (last N)
// @Query("SELECT t FROM Transactions t WHERE t.user.userId = :userId " +
// "ORDER BY t.createdAt DESC LIMIT :limit")
// List<Transactions> findRecentTransactions(@Param("userId") Integer userId,
// @Param("limit") int limit);

// // Find transactions by amount range
// List<Transactions> findByUserUserIdAndAmountBetween(Integer userId,
// BigDecimal minAmount,
// BigDecimal maxAmount);

// // Get transaction statistics
// @Query("SELECT t.transactionType, COUNT(t), SUM(t.amount) " +
// "FROM Transactions t WHERE t.user.userId = :userId " +
// "GROUP BY t.transactionType")
// List<Object[]> getTransactionStatistics(@Param("userId") Integer userId);

// // Find transactions for admin dashboard (all users)
// @Query("SELECT t FROM Transactions t ORDER BY t.createdAt DESC")
// Page<Transactions> findAllTransactions(Pageable pageable);
// }