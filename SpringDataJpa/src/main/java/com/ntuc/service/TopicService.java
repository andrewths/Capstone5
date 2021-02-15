package com.ntuc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntuc.model.Topic;
import com.ntuc.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository tr;

	public List<Topic> showTopics() {
		List<Topic> topics = new ArrayList<>();
		tr.findAll().forEach(topics::add);
		return topics;

	}

	public Optional<Topic> showTopicById(String id) {
		return tr.findById(id);
	}

//	public Topic showTopicById(String id) {
//		return tr.findById(id).orElse(null);
//	}

	public void addTopic(Topic topic) {
		tr.save(topic);
	}

	public void modifyTopic(Topic topic, String id) {
		tr.save(topic);
	}

	public void removeTopic(String id) {
		tr.deleteById(id);

	}

}
