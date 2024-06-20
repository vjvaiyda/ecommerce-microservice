package com.inventory.orderservice.controller;

import com.inventory.orderservice.dto.InventoryResponse;
import com.inventory.orderservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    //http://localhost:8082/api/inventory/iphone-12,Samsung-prod OR
    //http://localhost:8082/api/inventory/skuCode=iphone-12,skuCode=Samsung-prod
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
