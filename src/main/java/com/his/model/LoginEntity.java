package com.his.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LoginEntity {
	@Id
	String username;
	String pass;
}
