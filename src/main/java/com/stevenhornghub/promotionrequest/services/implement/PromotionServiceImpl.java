package com.stevenhornghub.promotionrequest.services.implement;

import com.stevenhornghub.promotionrequest.exceptions.ResourceNotFoundException;
import com.stevenhornghub.promotionrequest.exceptions.message.BaseResponse;
import com.stevenhornghub.promotionrequest.exceptions.message.CustomMessage;
import com.stevenhornghub.promotionrequest.models.Promotion;
import com.stevenhornghub.promotionrequest.repositories.PromotionRepository;
import com.stevenhornghub.promotionrequest.services.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;


    @Override
    public List<Promotion> findPromotionList(int pageNo, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        return promotionRepository.findAll(pageable).getContent();
    }

    @Override
    public Promotion addPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion updatePromotionById(Long id) {
        if (promotionRepository.existsById(id)) {
        } else {
            try {
                throw new ResourceNotFoundException(CustomMessage.NO_RECORD_FOUND + id);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public BaseResponse deletePromotionById(Long id){
        if (promotionRepository.existsById(id)) {
            promotionRepository.deleteById(id);
        } else {
            try {
                throw new ResourceNotFoundException(CustomMessage.NO_RECORD_FOUND + id);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return new BaseResponse(CustomMessage.DELETE_SUCCESS_MESSAGE + id);

    }
}