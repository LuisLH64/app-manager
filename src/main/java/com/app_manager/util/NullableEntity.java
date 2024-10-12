package com.app_manager.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class NullableEntity {
    
    private Long id;
    private String name;
    private String state;

    public static NullableEntity nullable() {
        
        return new NullableEntity();
    }

    private NullableEntity() {
        this.id = Long.valueOf(0);
        this.name = "null";
        this.state = "empty";
    }
}
