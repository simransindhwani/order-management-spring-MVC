package me.simran.ordermanagementspringboot.entity;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class OrderPage {
    private int pageNumber =0;
    private int pageSize = 10;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "id";
}
