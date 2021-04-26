package com.property.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.application.VO.PropertyVO;
import com.property.application.constant.StatusConstants;
import com.property.application.exception.NotFoundException;
import com.property.application.model.Property;
import com.property.application.repository.PropertyRepository;

@Service
public class PropertyService {
	@Autowired
	private PropertyRepository propertyRepository;
	private Property property;

	public Property saveOrUpdate(PropertyVO propertyVO) throws NotFoundException {
		if (propertyVO.getId() != null) {
			property = propertyRepository.findByIdAndActiveTrue(propertyVO.getId());
			if (property == null) {
				throw new NotFoundException(StatusConstants.HttpConstants.NOT_FOUND);
			}
			property.setModifiedAt(new Date());
		} else {
			property = new Property();
			property.setCreatedAt(new Date());
		}
		property.setState(propertyVO.getState());
		property.setZipcode(propertyVO.getZipcode());
		property.setCity(propertyVO.getCity());
		property.setPropertyName(propertyVO.getPropertyName());
		property.setPropertyType(propertyVO.getPropertyType());
		property.setNoOfRooms(propertyVO.getNoOfRooms());
		property.setAdditionalInfo(propertyVO.getAdditionalInfo());
		property.setPrice(propertyVO.getPrice());
		property.setApprove(false);
		property.setActive(true);
		return propertyRepository.save(property);
	}

	public Property approveProperty(Long id) throws NotFoundException {
		property = propertyRepository.findByIdAndActiveTrue(id);
		if (property == null) {
			throw new NotFoundException(StatusConstants.HttpConstants.NOT_FOUND);
		}
		property.setApprove(true);
		return propertyRepository.save(property);

	}

	public List<PropertyVO> searchProperty(String search) {
		List<Property> list = propertyRepository.findByInputSearch(search);
		return prepareList(list);

	}

	public List<PropertyVO> prepareList(List<Property> list) {
		List<PropertyVO> propertyVOList = new ArrayList<PropertyVO>();
		if (list != null && !list.isEmpty()) {
			for (Property property : list) {
				PropertyVO propertyvo = new PropertyVO();
				propertyvo.setId(property.getId());
				propertyvo.setPropertyName(property.getPropertyName());
				propertyvo.setPropertyType(property.getPropertyType());
				propertyvo.setNoOfRooms(property.getNoOfRooms());
				propertyvo.setPrice(property.getPrice());
				propertyvo.setAdditionalInfo(property.getAdditionalInfo());
				propertyvo.setMobileNumber(property.getMobileNumber());
				propertyvo.setContactemail(property.getContactemail());
				propertyvo.setCity(property.getCity());
				propertyvo.setState(property.getState());
				propertyvo.setZipcode(property.getZipcode());
				if (property.isApprove()) {
					propertyvo.setStatus("Sold");
				} else {
					propertyvo.setStatus("Avaliable");
				}
				propertyVOList.add(propertyvo);
			}

		}
		return propertyVOList;
	}

}
