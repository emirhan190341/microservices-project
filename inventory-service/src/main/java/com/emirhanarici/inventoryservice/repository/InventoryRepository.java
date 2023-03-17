package com.emirhanarici.inventoryservice.repository;

import com.emirhanarici.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {



    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
