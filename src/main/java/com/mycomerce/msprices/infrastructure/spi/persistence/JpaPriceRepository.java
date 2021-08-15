package com.mycomerce.msprices.infrastructure.spi.persistence;

import com.mycomerce.msprices.infrastructure.spi.persistence.data.PriceDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface JpaPriceRepository extends JpaRepository<PriceDbo, UUID>  {
    @Query("select p from PriceDbo p where p.brandId = ?1 and p.productId = ?2 " +
            "and ?3 between p.startDate and p.endDate order by p.priority desc ")
    List<PriceDbo> findByBrandIdAndProductIdAndDateTime(
            int brandId, long productId, LocalDateTime dateTime);
}
