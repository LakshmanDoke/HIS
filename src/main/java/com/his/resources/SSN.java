package com.his.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SSN {

	@JsonProperty("ssnId")
	private Integer ssnId;
	@JsonProperty("state")
	private String state;

}
