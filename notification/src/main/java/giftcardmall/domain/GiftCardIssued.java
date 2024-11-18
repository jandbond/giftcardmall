package giftcardmall.domain;

import giftcardmall.domain.*;
import giftcardmall.infra.AbstractEvent;
import java.util.*;
import lombok.*;

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
}
