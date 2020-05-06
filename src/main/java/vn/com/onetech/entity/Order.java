/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.onetech.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order implements Serializable{
    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String nameReceiver;
    private String deliveryAdress;
    private String deliveryTime;
    private String status;
    private String payments;
    private String notes;
    @ManyToOne
    @JoinColumn(name="customersId")
    private Customer customer;
    @OneToMany(mappedBy = "orders")
    private List<Invoice> invoice;
    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetail;

  
    
    
}