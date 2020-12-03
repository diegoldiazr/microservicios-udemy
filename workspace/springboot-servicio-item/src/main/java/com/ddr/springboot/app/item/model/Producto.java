package com.ddr.springboot.app.item.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Producto {
	
	@Getter @Setter private Long id;
	@Getter @Setter private String nombre;
	@Getter @Setter private Double precio;
	@Getter @Setter private Date createAt;
	

}
