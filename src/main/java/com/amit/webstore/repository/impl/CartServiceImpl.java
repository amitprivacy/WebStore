package com.amit.webstore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.webstore.domain.Cart;
import com.amit.webstore.dto.CartDto;
import com.amit.webstore.exception.InvalidCartException;
import com.amit.webstore.repository.CartRepository;
import com.amit.webstore.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	
	public void create(CartDto cartDto) { 
        cartRepository.create(cartDto); 
     } 

    @Override 
    public Cart read(String id) { 
        return cartRepository.read(id); 
     } 

     @Override 
     public void update(String id, CartDto cartDto) { 
       cartRepository.update(id, cartDto); 
     } 

    @Override 
    public void delete(String id) { 
        cartRepository.delete(id); 
    } 

     @Override 
    public void addItem(String cartId, String  
  productId) { 
        cartRepository.addItem(cartId, productId); 
    } 

    @Override 
     public void removeItem(String cartId, String  
  productId) { 
        cartRepository.removeItem(cartId, productId); 
     }

	@Override
	public void clearCart(String cartId) {
		cartRepository.clearCart(cartId);
		
	}

	@Override
	public Cart validate(String cartId) {
		
		Cart cart = cartRepository.read(cartId);
		
		if(cart==null || cart.getCartItem().size()==0)
		{
			throw new InvalidCartException(cartId);
		}
		return cart;
		
	} 
}
