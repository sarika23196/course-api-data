package com.sarika.springbootstarter.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.sarika.springbootstarter.dynamodb.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicRepository{

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Topic save(Topic topic){
        dynamoDBMapper.save(topic);
        return topic;
    }

    public Topic findById(String id) {
        return dynamoDBMapper.load(Topic.class, id);
    }

    public List<Topic> findAll(){
        return dynamoDBMapper.scan(Topic.class, new DynamoDBScanExpression());
    }
    public void update(Topic topic) {
        dynamoDBMapper.save(topic);
    }
    public void delete(String id) {
        Topic t = new Topic();
        t.setId(id);
        dynamoDBMapper.delete(t);
        //return "topic delete";
    }
}
