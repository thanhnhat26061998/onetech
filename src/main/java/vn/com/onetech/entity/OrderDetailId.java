/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.onetech.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

import lombok.Data;
@Embeddable
@Data
public class OrderDetailId implements Serializable {
    private int customerId;
    private int orderId;

  

    
    
}