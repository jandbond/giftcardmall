package giftcardmall.domain;

import giftcardmall.domain.*;
import giftcardmall.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LimitRestored extends AbstractEvent {

    private Long id;
    private Long purchaseLimit;
    private Long totalLimit;
    private String name;
    private String email;

    public LimitRestored(Customer aggregate) {
        super(aggregate);
    }

    public LimitRestored() {
        super();
    }
}
//>>> DDD / Domain Event
