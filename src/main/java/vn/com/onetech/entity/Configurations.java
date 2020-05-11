package vn.com.onetech.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="configuration")
public class Configurations {
	@Id
	@Column(name = "configurationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String screen;
	private String cpu;
	private String ram;
	private String rom;
	private String cameraFront ;
	private String cameraRear;
	private String pin;
	private String chipset;
	private String systems;

}
