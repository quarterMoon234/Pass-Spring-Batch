package com.example.passbatch.repository.pack;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {

    List<PackageEntity> findByCreatedAtAfter(LocalDateTime dateTime, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE PackageEntity p " +
            "          SET p.count = :count," +
            "              p.period = :period" +
            "       WHERE  p.packageSeq = :packageSeq")
    void updateCountAndPeriod(Integer packageSeq, int count, int period);
}
