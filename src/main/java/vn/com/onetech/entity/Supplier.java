
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
@Table(name = "supplier")
public class Supplier implements Serializable{
    @Id
    @Column(name = "supplierId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    private String name;
    private String notes;

    
    
}
