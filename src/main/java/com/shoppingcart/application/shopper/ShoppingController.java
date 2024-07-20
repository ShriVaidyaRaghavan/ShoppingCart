package com.shoppingcart.application.shopper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingcart.application.shopper.models.ShoppingRequest;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ShoppingController {
	
	@Autowired
	ShoppingService shoppingService;

	@GetMapping("/shoppingCart")
	public ResponseEntity<Map<String, Object>> getShoppingList() {
		return shoppingService.getShoppingList();
	}

	@PostMapping("/shoppingCart")
	public ResponseEntity<Map<String, Object>> getShoppingListByType(@RequestBody ShoppingRequest type) {
		return shoppingService.getShoppingListByType(type);
	}

	@PostMapping("/addToCart")
	public ResponseEntity<Map<String, Object>> addToShoppingList(@RequestBody ShoppingRequest shoppingReq) {
		return shoppingService.addToShoppingList(shoppingReq);
	}

	@DeleteMapping("/shoppingCart/{id}")
	public ResponseEntity<Map<String, Object>> deleteShoppingItem(@PathVariable int id) {
		return shoppingService.deleteShoppingItem(id);
	}

}
