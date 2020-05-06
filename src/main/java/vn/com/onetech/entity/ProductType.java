/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.onetech.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "productType")
public class ProductType implements Serializable{
    @Id
    @Column(name = "productTypeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productTypeId;
    private String name;
    private String notes;

   
    
    
}
