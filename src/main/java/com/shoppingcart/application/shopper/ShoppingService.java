package com.shoppingcart.application.shopper;

import org.springframework.stereotype.Service;

import com.shoppingcart.application.shopper.models.ShoppingCartEntity;
import com.shoppingcart.application.shopper.models.ShoppingRequest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class ShoppingService {
	
	@Autowired
    ShoppingRepository shoppingRepository;

    public ResponseEntity<Map<String, Object>> getShoppingList() {
        try {
            return new ResponseEntity<>(getShoppingItems(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Map.of("error", ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Map<String, Object> getShoppingItems() {
        return Map.of("Items", shoppingRepository.findAll());
    }

    public ResponseEntity<Map<String, Object>> addToShoppingList(ShoppingRequest req) {
        try {
            return new ResponseEntity<>(addItemToShoppingList(req), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Map.of("error", ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Map<String, Object> addItemToShoppingList(ShoppingRequest request) {
        ShoppingCartEntity item = new ShoppingCartEntity();
        item.setName(request.getName());
        item.setLink(request.getLink());
        item.setType(request.getType());
        return Map.of("Item added", shoppingRepository.save(item));
    }

    public ResponseEntity<Map<String, Object>> getShoppingListByType(final ShoppingRequest type) {
        try {
            return new ResponseEntity<>(getShoppingItemsByType(type), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Map.of("error", ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Map<String, Object> getShoppingItemsByType(final ShoppingRequest req) {
        return Map.of("Items", shoppingRepository.getItemsByType(req.getType()));
    }

}
