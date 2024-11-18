package giftcardmall.domain;

import giftcardmall.domain.*;
import giftcardmall.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long amount;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public PaymentCompleted(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
