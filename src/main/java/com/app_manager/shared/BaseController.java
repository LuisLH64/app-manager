package com.app_manager.shared;

import java.util.Objects;

import org.springframework.hateoas.Link;

import com.app_manager.util.ResponseModel;

public abstract class BaseController {

    private ResponseModel responseModel;
    
    public BaseController(ResponseModel responseModel) {
		this.responseModel = responseModel;
    }

	public ResponseModel responseModel() {
		Objects.requireNonNull(responseModel, "The responseModel object must be initialized.");
		return responseModel;
	} 

	public void addLinksToModel(Link[] links) {
		
		responseModel = new ResponseModel(links);
	}
}
