package com.emirhanarici.inventoryservice.controller;

import com.emirhanarici.inventoryservice.dto.InventoryResponse;
import com.emirhanarici.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryResponse>> isInStock(@RequestParam List<String> skuCode) {
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(inventoryService.isInStock(skuCode));
    }


}
