package giftcardmall.infra;

import giftcardmall.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class GiftCardHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<GiftCard>> {

    @Override
    public EntityModel<GiftCard> process(EntityModel<GiftCard> model) {
        return model;
    }
}
