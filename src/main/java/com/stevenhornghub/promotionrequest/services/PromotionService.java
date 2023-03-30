package com.stevenhornghub.promotionrequest.services;

import com.stevenhornghub.promotionrequest.exceptions.ResourceNotFoundException;
import com.stevenhornghub.promotionrequest.exceptions.message.BaseResponse;
import com.stevenhornghub.promotionrequest.models.Promotion;

import java.util.List;

public interface PromotionService {


    List<Promotion> findPromotionList(int pageNo, int pageSize);

    Promotion addPromotion(Promotion promotion);

    Promotion updatePromotionById(Long id);

    BaseResponse deletePromotionById(Long id);
}
