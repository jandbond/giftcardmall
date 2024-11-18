package giftcardmall.domain;

import giftcardmall.CustomerApplication;
import giftcardmall.domain.LimitDeducted;
import giftcardmall.domain.LimitRestored;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Customer_table")
@Data
//<<< DDD / Aggregate Root
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long purchaseLimit;

    private Long totalLimit;

    private String name;

    private String email;

    @PostPersist
    public void onPostPersist() {
        LimitDeducted limitDeducted = new LimitDeducted(this);
        limitDeducted.publishAfterCommit();

        LimitRestored limitRestored = new LimitRestored(this);
        limitRestored.publishAfterCommit();
    }

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = CustomerApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }

    //<<< Clean Arch / Port Method
    public static void restoreLimit(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Customer customer = new Customer();
        repository().save(customer);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(customer->{
            
            customer // do something
            repository().save(customer);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deductLimit(OrderCreated orderCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        Customer customer = new Customer();
        repository().save(customer);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCreated.get???()).ifPresent(customer->{
            
            customer // do something
            repository().save(customer);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
