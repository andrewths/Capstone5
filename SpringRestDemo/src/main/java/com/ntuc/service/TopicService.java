package com.ntuc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ntuc.model.Topic;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
				new Topic("Spring", "Spring Boot","Spring Framework description"),
				new Topic("Java", "Java 8","Java Framework description"),
				new Topic("JavaScript", "Java Script and HTML","JavaScript Framework description")
				));
	
	public List<Topic> showTopics(){
		return topics;
		
	}

	public Topic showTopicById(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	
	public void modifyTopic(Topic topic, String id) {
		for (int i=0; i<topics.size(); i++)
		{
			Topic t =topics.get(i);
					if (t.getId().equals(id)) {
						topics.set(i, topic);
						return;
					}
					
		}
	}

	public void removeTopic(String id) {
			topics.removeIf(t -> t.getId().equals(id));
	}
	
	
	
		
		
	}
