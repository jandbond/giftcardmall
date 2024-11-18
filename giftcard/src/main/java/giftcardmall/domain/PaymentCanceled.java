package giftcardmall.domain;

import giftcardmall.domain.*;
import giftcardmall.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long amount;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
