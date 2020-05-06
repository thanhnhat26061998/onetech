
package vn.com.onetech.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "orderDetail")
public class OrderDetail implements Serializable{
    @EmbeddedId
    OrderDetailId orderDetailId;
    private int amount;
    @ManyToOne
    @JoinColumn(name="ordersId")
    private Order orders;
    @ManyToOne
    @JoinColumn(name="productsId")
    private Product product;

   
    
    
    
}
