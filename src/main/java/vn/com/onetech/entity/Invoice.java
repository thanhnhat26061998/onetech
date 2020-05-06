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
@Table(name = "invoice")
public class Invoice implements Serializable{
    @Id
    @Column(name = "invoidceId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoidceId;
    private String payments;
    @ManyToOne
    @JoinColumn(name="customersId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="OrdersId")
    private Order orders;
    @ManyToOne
    @JoinColumn(name="staffsId")
    private Staff staff;
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetail;
    

   
    
    
}
