package com.property.application.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.property.application.VO.PropertyVO;
import com.property.application.constant.StatusConstants;
import com.property.application.model.Property;
import com.property.application.response.Response;
import com.property.application.response.Status;
import com.property.application.service.PropertyService;

@RestController
public class PropertyController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyController.class);
	@Autowired
	private PropertyService propertyService;

	@PostMapping(value = "/add")
	public ResponseEntity<Response> addProperty(@Valid @RequestBody PropertyVO propertyVO) throws Exception {
		final String method = "addProperty";
		LOGGER.info("Entering " + method);
		Property property = propertyService.saveOrUpdate(propertyVO);
		LOGGER.info("Moving Out " + method);
		String meassge = "Added Successfully";
		Status success = new Status(StatusConstants.HttpConstants.SUCCESS.getCode(),
				StatusConstants.HttpConstants.SUCCESS.getDesc());
		return new ResponseEntity<Response>(new Response<String>(success, meassge), HttpStatus.OK);
	}

	@GetMapping(value = "/search/{searchBy}")
	public ResponseEntity<Response> searchProperty(
			@PathVariable("searchBy") @NotNull(message = "{search.not-null}") String search) throws Exception {
		final String method = "searchProperty";
		LOGGER.info("Entering " + method);
		List<PropertyVO> list = propertyService.searchProperty(search);
		LOGGER.info("Moving Out " + method);
		Status success = new Status(StatusConstants.HttpConstants.SUCCESS.getCode(),
				StatusConstants.HttpConstants.SUCCESS.getDesc());
		return new ResponseEntity<Response>(new Response<List<PropertyVO>>(success, list), HttpStatus.OK);
	}

	@PutMapping(value = "/approve/{id}")
	public ResponseEntity<Response> approveProperty(@PathVariable("id") Long id) throws Exception {
		final String method = "approveProperty";
		LOGGER.info("Entering " + method);
		Property property = propertyService.approveProperty(id);
		String meassge = "Property Approved Successfully";
		LOGGER.info("Moving Out " + method);
		Status success = new Status(StatusConstants.HttpConstants.SUCCESS.getCode(),
				StatusConstants.HttpConstants.SUCCESS.getDesc());
		return new ResponseEntity<Response>(new Response<String>(success, meassge), HttpStatus.OK);
	}

	@PostMapping(value = "/update")
	public ResponseEntity<Response> updateProperty(@Valid @RequestBody PropertyVO propertyVO) throws Exception {
		final String method = "updateProperty";
		LOGGER.info("Entering " + method);
		Property property = propertyService.saveOrUpdate(propertyVO);
		LOGGER.info("Moving Out " + method);
		String meassge = "Updated Successfully";
		Status success = new Status(StatusConstants.HttpConstants.SUCCESS.getCode(),
				StatusConstants.HttpConstants.SUCCESS.getDesc());
		return new ResponseEntity<Response>(new Response<String>(success, meassge), HttpStatus.OK);
	}
}
