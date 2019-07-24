package com.his.model;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ForgotPassModel {
	@Id
	private String email;
}
