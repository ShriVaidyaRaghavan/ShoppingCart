package com.shoppingcart.application.shopper;

import com.shoppingcart.application.shopper.models.ShoppingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.application.shopper.models.ShoppingCartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ShoppingRepository extends JpaRepository<ShoppingCartEntity, Integer> {

    @Query(value = "SELECT * FROM shoppingcart WHERE type = :type", nativeQuery = true)
    List<Map<String, Object>> getItemsByType(@Param("type") String type);
}
