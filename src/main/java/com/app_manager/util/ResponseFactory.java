// package com.app_manager.util;

// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;

// import org.springframework.beans.factory.config.ConfigurableBeanFactory;
// import org.springframework.context.annotation.Scope;
// import org.springframework.context.annotation.ScopedProxyMode;
// import org.springframework.hateoas.MediaTypes;
// import org.springframework.hateoas.mediatype.problem.Problem;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Component;

// @Component
// @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.NO)
// public class ResponseFactory {
    
//     private static final int INITIAL_MAP_SIZE = 8;
// 	private static final Map<String, ResponseEntity<?>> RESPONSES;

//     static {
//         RESPONSES = new ConcurrentHashMap<>(INITIAL_MAP_SIZE, 0.7f, 4);
		
// 		createAndCacheResponse(HttpStatus.BAD_REQUEST, "Invalid ID");
// 		createAndCacheResponse(HttpStatus.BAD_REQUEST, "Id out of range");
// 		createAndCacheResponse(HttpStatus.BAD_REQUEST, "Invalid Param");
//     }

//     public ResponseEntity<?> get(String message) {
// 		ResponseEntity<?> response = RESPONSES.get(message);
		
// 		if (response == null)
// 			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
// 		return response;
// 	}

//     public ResponseEntity<?> of(Exception e, HttpStatus status) {
// 		CustomResponse response = new CustomResponse(-1, e.getMessage());
// 		return new ResponseEntity<>(response, status);
// 	}

//     public ResponseEntity<?> of(Exception e) {
// 		return of(e, HttpStatus.INTERNAL_SERVER_ERROR);
// 	}

//     @SuppressWarnings("unchecked")
// 	public static <T> ResponseEntity<T> createResponse(HttpStatus status, String message) {
// 		return (ResponseEntity<T>)ResponseEntity.status(status)
// 				.header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
// 				.body(Problem.create()
// 						.withTitle("")
// 						.withDetail(""));
// 	}

//     private static void createAndCacheResponse(HttpStatus status, String message) {
// 		ResponseEntity<?> response = createResponse(status, message);
// 		RESPONSES.put(message, response);
// 	}
    
// }
