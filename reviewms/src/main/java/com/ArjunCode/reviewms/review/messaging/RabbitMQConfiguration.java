package com.ArjunCode.reviewms.review.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue companyRatingQueue(){
        return new Queue("companyRatingQueue");
    } //Creating Queue

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter(); //Jackson is popular library to handle JSON
    }//This converter will be used to serialize and deserialize messages

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate =
                new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter((jsonMessageConverter()));
        return rabbitTemplate;
    } //Helper class -> handles creation and release of resources
}
