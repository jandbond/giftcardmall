package giftcardmall.domain;

import giftcardmall.domain.*;
import giftcardmall.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class GiftCardIssued extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;
    private Long amount;
    private Date issuedAt;
    private Date voidedAt;
    private Date expirationDate;

    public GiftCardIssued(GiftCard aggregate) {
        super(aggregate);
    }

    public GiftCardIssued() {
        super();
    }
}
//>>> DDD / Domain Event
