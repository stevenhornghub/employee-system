package com.stevenhornghub.promotionrequest.repositories;

import com.stevenhornghub.promotionrequest.models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {


}
