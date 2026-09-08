package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ORDER_ITEMS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @EmbeddedId
    private @Getter @Setter OrderItemKey key;

    @Column(name = "PRODUCT_NAME", length = 60)
    private @Getter @Setter String productName;

    @Column(name = "PRICE", precision = 10, scale = 2)
    private @Getter @Setter double price;

    @Column(name = "QUANTITY", scale = 0)
    private @Getter @Setter int quantity;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID"),
            @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    })
    private Order order;

}
