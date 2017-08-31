package cn.zsza.spring.zs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class BeanDefinition {
	private String id;
	private String className;
	private List<PropertyDefinition> propertys = new ArrayList<PropertyDefinition>();
	
	public BeanDefinition(String id, String className) {
		this.id = id;
		this.className = className;
	}

}
