package giftcardmall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import giftcardmall.config.kafka.KafkaProcessor;
import giftcardmall.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='GiftCardIssued'"
    )
    public void wheneverGiftCardIssued_SendNotification(
        @Payload GiftCardIssued giftCardIssued
    ) {
        GiftCardIssued event = giftCardIssued;
        System.out.println(
            "\n\n##### listener SendNotification : " + giftCardIssued + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='GiftCardVoided'"
    )
    public void wheneverGiftCardVoided_SendNotification(
        @Payload GiftCardVoided giftCardVoided
    ) {
        GiftCardVoided event = giftCardVoided;
        System.out.println(
            "\n\n##### listener SendNotification : " + giftCardVoided + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
