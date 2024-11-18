package giftcardmall.domain;

import giftcardmall.GiftcardApplication;
import giftcardmall.domain.GiftCardIssued;
import giftcardmall.domain.GiftCardVoided;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "GiftCard_table")
@Data
//<<< DDD / Aggregate Root
public class GiftCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String status;

    private Long amount;

    private Date issuedAt;

    private Date voidedAt;

    private Date expirationDate;

    @PostPersist
    public void onPostPersist() {
        GiftCardIssued giftCardIssued = new GiftCardIssued(this);
        giftCardIssued.publishAfterCommit();

        GiftCardVoided giftCardVoided = new GiftCardVoided(this);
        giftCardVoided.publishAfterCommit();
    }

    public static GiftCardRepository repository() {
        GiftCardRepository giftCardRepository = GiftcardApplication.applicationContext.getBean(
            GiftCardRepository.class
        );
        return giftCardRepository;
    }

    //<<< Clean Arch / Port Method
    public static void issueGiftCard(PaymentCompleted paymentCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        GiftCard giftCard = new GiftCard();
        repository().save(giftCard);

        GiftCardIssued giftCardIssued = new GiftCardIssued(giftCard);
        giftCardIssued.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCompleted.get???()).ifPresent(giftCard->{
            
            giftCard // do something
            repository().save(giftCard);

            GiftCardIssued giftCardIssued = new GiftCardIssued(giftCard);
            giftCardIssued.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void voidGiftcard(PaymentCanceled paymentCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        GiftCard giftCard = new GiftCard();
        repository().save(giftCard);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCanceled.get???()).ifPresent(giftCard->{
            
            giftCard // do something
            repository().save(giftCard);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
