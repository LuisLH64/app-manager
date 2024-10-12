package com.app_manager.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomResponse {
    
    private final int linesChanged;
	private final String message;
	private Object content;
	private Map<String, Object> metadata;

    public CustomResponse() {
		this(0, "", Collections.emptyMap());
	}
	
	public CustomResponse(int linesChanged) {
		this(linesChanged, "", Collections.emptyMap());
	}
	
	public CustomResponse(int linesChanged, String message) {
		this(linesChanged, message, Collections.emptyMap());
	}
	
	public CustomResponse(int linesChanged, String message, Map<String, Object> metadata) {
		this.linesChanged = linesChanged;
		this.message = message;
		this.metadata = metadata;
	}
    
    public int getLinesChanged()
	{
		return linesChanged;
	}

	public String getMessage()
	{
		return message;
	}

	@SuppressWarnings("unchecked")
	public <T> T getContent()
	{
		return (T)content;
	}

	public <T> CustomResponse setContent(T content)
	{
		this.content = content;
		return this;
	}

	public Map<String, Object> getMetadata()
	{
		return metadata;
	}

	public CustomResponse addMetadata(String key, Object metadata)
	{
		if (this.metadata == Collections.EMPTY_MAP)
			this.metadata = new HashMap<>();
		
		this.metadata.put(key, metadata);
		return this;
	}
}
