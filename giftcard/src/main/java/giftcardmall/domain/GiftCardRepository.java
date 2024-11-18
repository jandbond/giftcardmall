package giftcardmall.domain;

import giftcardmall.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "giftCards", path = "giftCards")
public interface GiftCardRepository
    extends PagingAndSortingRepository<GiftCard, Long> {}
