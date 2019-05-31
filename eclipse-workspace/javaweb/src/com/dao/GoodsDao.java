package com.dao;

import java.util.Map;
import com.DB.DB;
import com.model.Good;


public class GoodsDao {
 
 public Map<?, ?> getAll(){
 return DB.getAll();
 }
 
 public Good find(String id){
 return (Good) DB.getAll().get(id);
 }
} 