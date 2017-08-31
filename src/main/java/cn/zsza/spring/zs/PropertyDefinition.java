package cn.zsza.spring.zs;

import lombok.Data;

@Data
public class PropertyDefinition {
	private String name;
	private String ref;
	
	public PropertyDefinition(String name, String ref) {
		this.name = name;
		this.ref = ref;
	}
	

	
}
