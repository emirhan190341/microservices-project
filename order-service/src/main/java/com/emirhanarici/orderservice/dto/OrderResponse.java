package com.emirhanarici.orderservice.dto;

import com.emirhanarici.orderservice.entity.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {


    private Long id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItemsList;
}
