package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.CardModel;

public interface CardDAO extends CrudRepository<CardModel,Long>{
    
}
