package com.ntuc.repository;

import org.springframework.data.repository.CrudRepository;

import com.ntuc.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

}
