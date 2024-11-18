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

    @Autowired
    GiftCardRepository giftCardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCompleted'"
    )
    public void wheneverPaymentCompleted_IssueGiftCard(
        @Payload PaymentCompleted paymentCompleted
    ) {
        PaymentCompleted event = paymentCompleted;
        System.out.println(
            "\n\n##### listener IssueGiftCard : " + paymentCompleted + "\n\n"
        );

        // Sample Logic //
        GiftCard.issueGiftCard(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCanceled'"
    )
    public void wheneverPaymentCanceled_VoidGiftcard(
        @Payload PaymentCanceled paymentCanceled
    ) {
        PaymentCanceled event = paymentCanceled;
        System.out.println(
            "\n\n##### listener VoidGiftcard : " + paymentCanceled + "\n\n"
        );

        // Sample Logic //
        GiftCard.voidGiftcard(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
