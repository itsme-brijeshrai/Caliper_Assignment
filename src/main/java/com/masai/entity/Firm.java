package com.masai.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Firm {
	
	private String firmName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer firmId;
	private String email;
	private String phone;
	@OneToOne (cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany (cascade = CascadeType.ALL)
	private List<Product> product;
	
	private ConsumerType FIRM;
}
