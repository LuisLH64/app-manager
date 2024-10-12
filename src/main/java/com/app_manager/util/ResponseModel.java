package com.app_manager.util;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ResponseModel {

    private static final NullableEntity NOT_FOUND = NullableEntity.nullable();
	private final Link[] links;
	
	public ResponseModel(Link[] links) {
		this.links = links;
	}
	
	@SuppressWarnings("unchecked")
	public <T> EntityModel<T> of(T obj) {
		if (obj == null)
			obj = (T)NOT_FOUND;
		
		return (EntityModel<T>)EntityModel.of(obj, links);
	}

	public <T> CollectionModel<T> of(Iterable<T> obj) {

		return (CollectionModel<T>)CollectionModel.of(obj, links);
	}
	
}
