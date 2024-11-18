package giftcardmall.domain;

import giftcardmall.domain.*;
import giftcardmall.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private Long customerId;
    private String status;
    private Long voucherAmount;
    private Date createdAt;
    private Date updatedAt;
}
