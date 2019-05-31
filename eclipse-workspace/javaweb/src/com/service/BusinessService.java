package com.service;

import java.util.Map;

import com.dao.GoodsDao;
import com.model.Good;
import com.model.Cart;
import com.model.CartItem;
//业务类，统一对web层提供所有服务
public class BusinessService {

    private GoodsDao dao = new GoodsDao();
    
    public Map getAllGood(){
        return dao.getAll();
    }
    
    public Good findGood(String id){
        return dao.find(id);
    }

    //删除购物车中的购物项
    public void deleteCartItem(String id, Cart cart) {
        cart.getMap().remove(id);
    }
    
    //清空购物车
    public void clearCart(Cart cart) {
        cart.getMap().clear();
    }
    
    //改变购物项的数量
    public void changeItemQuantity(String id, String quantity, Cart cart) {
        CartItem item = cart.getMap().get(id);
        item.setQuantity(Integer.parseInt(quantity));
    }
    
}