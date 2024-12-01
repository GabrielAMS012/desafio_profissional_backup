package br.com.unicesumar.magic.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final String QUEUE_NAME = "notificationQueue";
    private final String UPDATE_QUEUE_NAME = "deck_updates_queue";

    public void sendNotification(String message) {
        amqpTemplate.convertAndSend(QUEUE_NAME, message);
        System.out.println("Mensagem de notificação enviada: " + message);
    }

    public void sendDeckUpdate(String message) {
        amqpTemplate.convertAndSend(UPDATE_QUEUE_NAME, message);
        System.out.println("Notificação de atualização enviada: " + message);
    }
}
