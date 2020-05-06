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
@Table(name = "couponDetail")
public class CouponDetail implements Serializable{
    @EmbeddedId
    CouponDetailId couponDetailId;
    private int amount;
    private Double price;
    @ManyToOne
    @JoinColumn(name="couponsId")
    private Coupon coupon;

   
    
    
}
