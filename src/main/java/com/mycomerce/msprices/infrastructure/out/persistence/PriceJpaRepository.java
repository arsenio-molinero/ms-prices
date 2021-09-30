package com.mycomerce.msprices.infrastructure.out.persistence;

import com.mycomerce.msprices.infrastructure.out.persistence.data.PriceDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface PriceJpaRepository extends JpaRepository<PriceDBO, UUID>  {
    @Query("select p from PriceDBO p where p.brandId = ?1 and p.productId = ?2 " +
            "and ?3 between p.startDate and p.endDate order by p.priority desc ")
    List<PriceDBO> findByBrandIdAndProductIdAndDateTime(
            int brandId, long productId, LocalDateTime dateTime);
}
