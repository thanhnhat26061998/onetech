/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.onetech.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="product")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private String described;
    private String color;
    private String amount;
    private String price;
    @OneToMany(mappedBy = "product")
    private List<Review> review;
    @ManyToOne
    @JoinColumn(name="productTypesId")
    private ProductType productType;
    @ManyToOne
    @JoinColumn(name="salesId")
    private Sale sale;
    @OneToOne
    @JoinColumn(name="configurationId")
    private Configurations configuration;
    @OneToOne
    @JoinColumn(name="imageId")
    private Images images;
    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;
    

   
    
    
}
