package com.app_manager.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app_manager.shared.BaseController;
import com.app_manager.util.CustomResponse;
import com.app_manager.util.ResponseModel;
import com.app_manager.util.Url;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    public UserController(UserService userService,
                          ResponseModel responseModel) 
    {
        super(responseModel);
        this.userService = userService;

        Link[] links = new Link[]
		{
			linkTo(methodOn(getClass())
					.findAll())
					.withSelfRel(),
			linkTo(methodOn(getClass())
					.findById(Long.valueOf(0)))
					.withSelfRel(),
			linkTo(methodOn(getClass())
					.findByEmail(""))
					.withSelfRel(),
			linkTo(methodOn(getClass())
					.findByName(""))
					.withSelfRel(),
			linkTo(methodOn(getClass())
					.findByUsername(""))
					.withSelfRel()
		};

        addLinksToModel(links);
    }
    
    @GetMapping(Url.FIND_ALL)
    public ResponseEntity<?> findAll() {

        try {
            List<UserEntity> users = userService.findAll();
            RepresentationModel<?> representationModel = responseModel().of(users);
            
            return ResponseEntity.ok(representationModel); 
        } 
        catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.ofNullable(e);
        }
    }

    @GetMapping(Url.FIND_BY_ID)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        
        try {
            UserEntity user = userService.findById(id);
            RepresentationModel<?> representationModel = responseModel().of(user);

            return ResponseEntity.ok(representationModel); 
        } 
        catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.ofNullable(e);
        }
    }

    @GetMapping(Url.FIND_BY_NAME)
    public ResponseEntity<?> findByName(@RequestParam String name) {
        
        try {
            List<UserEntity> users = userService.findByName(name);
            RepresentationModel<?> representationModel = responseModel().of(users);

            return ResponseEntity.ok(representationModel); 
        } 
        catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.ofNullable(e);
        }
    }

    @GetMapping(Url.FIND_BY_EMAIL)
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        
        try {
            UserEntity user = userService.findByEmail(email);
            RepresentationModel<?> representationModel = responseModel().of(user);

            return ResponseEntity.ok(representationModel); 
        } 
        catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.ofNullable(e);
        }
    }

    @GetMapping(Url.FIND_BY_USERNAME)
    public ResponseEntity<?> findByUsername(@RequestParam String username) {
        
        try {
            UserEntity user = userService.findByUsername(username);
            RepresentationModel<?> representationModel = responseModel().of(user);
            
            return ResponseEntity.ok(representationModel); 
        } 
        catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.ofNullable(e);
        }
    }

    @PostMapping(Url.INSERT)
    public ResponseEntity<?> insert(@RequestBody UserDTO userDTO) {
        try {
            userService.insert(userDTO.toUserEntity());
            return ResponseEntity.status(201).body(new CustomResponse(1));
        } 
        catch (Exception e) {
            logger.error("Error during insert", e);
            return ResponseEntity.ofNullable(e);
        }
    }
    
    
    
}
