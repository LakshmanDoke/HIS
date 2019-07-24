package com.his.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.his.model.ApplicationOfPlanEntity;
import com.his.model.ApplicationOfPlanModel;
import com.his.repository.ApplicationOfPlanEntityRepo;
import com.his.resources.SSN;
import com.his.service.CaseUserService;

import reactor.core.publisher.Mono;

@Service
public class CaseUserServiceImpl implements CaseUserService {
	@Autowired
	ApplicationOfPlanEntityRepo applicationOfPlanEntityRepo;

	private static final String SSN_MIME_TYPE = "application/json";
	private static final String SSN_API_BASE_URL = "http://localhost:8082";
	private static final String USER_AGENT = "Spring 5 WebClient";
	private static final Logger logger = LoggerFactory.getLogger(CaseUserServiceImpl.class);
	private final WebClient webClient;

	public CaseUserServiceImpl() {
		this.webClient = WebClient.builder().baseUrl(SSN_API_BASE_URL).defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, SSN_MIME_TYPE).build();
	}

	@Override
	public Mono<SSN> isSsnBelongsToWashingtonState(Integer ssnNo) {
		SSN sSN = new SSN();
		sSN.setSsnId(ssnNo);
		sSN.setState("This id is not belongs to any state !");
		return webClient.post().uri("/rest/authenticate/" + ssnNo).retrieve().bodyToMono(SSN.class).onErrorReturn(sSN);

	}

	@Override
	public Integer saveApplication(ApplicationOfPlanModel ofPlanModel) {
		ApplicationOfPlanEntity applicationOfPlanEntity = new ApplicationOfPlanEntity();
		BeanUtils.copyProperties(ofPlanModel, applicationOfPlanEntity);
		applicationOfPlanEntity.setAppliedDate(LocalDate.now());
		applicationOfPlanEntityRepo.save(applicationOfPlanEntity);
		return applicationOfPlanEntity.getApplicationId();
	}

	@Override
	public List<ApplicationOfPlanEntity> getDataTableData() {
		return applicationOfPlanEntityRepo.findAll();
	}

}
