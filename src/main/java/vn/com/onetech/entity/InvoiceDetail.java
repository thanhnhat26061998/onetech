/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "invoiceDetail")
public class InvoiceDetail implements Serializable{
    @EmbeddedId
    InvoiceDetailId invoiceDetailId;
    private int amount;
    @ManyToOne
    @JoinColumn(name="invoidcesId")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name="productsId")
    private Product product;

   
    
}
