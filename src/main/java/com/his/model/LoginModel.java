package com.his.model;

import javax.persistence.Id;

import lombok.Data;

@Data
public class LoginModel {
	@Id
	String username;
	String pass;
}
