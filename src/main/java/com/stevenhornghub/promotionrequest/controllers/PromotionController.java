package com.stevenhornghub.promotionrequest.controllers;

import com.stevenhornghub.promotionrequest.exceptions.ResourceNotFoundException;
import com.stevenhornghub.promotionrequest.exceptions.message.BaseResponse;
import com.stevenhornghub.promotionrequest.models.Promotion;
import com.stevenhornghub.promotionrequest.services.PromotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Steven Horng
 */


@Slf4j
@RestController
@RequestMapping("/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Promotion>> findPromotionList(@Valid @RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return new ResponseEntity(promotionService.findPromotionList(pageNo, pageSize), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Promotion addPromotion(@Valid @RequestBody Promotion promotion) {
        promotionService.addPromotion(promotion);
        return promotion;
    }

    @PostMapping("/update/{id}")
    public Promotion updatePromotionById(@Valid @PathVariable(value = "id") Long id,
                                         @RequestBody Promotion promotion) {
        log.info("Promotion id: " + id);
        promotion.setId(id);
        promotionService.updatePromotionById(id);
        return promotion;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> deletePromotionById(@Valid @PathVariable(value = "id") Long id) {
        BaseResponse response = promotionService.deletePromotionById(id);
        return new ResponseEntity(response, HttpStatus.OK);


    }
}