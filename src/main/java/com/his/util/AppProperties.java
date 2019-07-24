package com.his.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Application properties Helper class .
 * 
 * @author laksh
 *
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
@NoArgsConstructor
public class AppProperties {

	private String rootpath;
	private String mainexception;

}
