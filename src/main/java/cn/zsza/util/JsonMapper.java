package cn.zsza.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.TimeZone;

import cn.zsza.zs_base.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.StringUtils;
/**
 * Created by ZhangSong on 2017/9/9.
 * 15:27
 */
public class JsonMapper {
    private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);
    public static final JsonMapper INSTANCE = new JsonMapper();
    private static ObjectMapper mapper;

    public JsonMapper() {
        this(null);
    }

    public JsonMapper(Include include) {
        mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getDefault());
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        if(include != null) {
            mapper.setSerializationInclusion(include);
        }

        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static JsonMapper nonNullMapper() {
        return new JsonMapper(Include.NON_NULL);
    }

    public static JsonMapper nonEmptyMapper() {
        return new JsonMapper(Include.NON_EMPTY);
    }

    public static JsonMapper defaultMapper() {
        return new JsonMapper();
    }

    public static JsonMapper nonDefaultMapper() {
        return new JsonMapper(Include.NON_DEFAULT);
    }

    public String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException var3) {
            logger.warn("write to json string error:" + object, var3);
            return null;
        }
    }

    public <T> T fromJson(String jsonString, Class<T> clazz) {
        if(StringUtils.isEmpty(jsonString)) {
            return null;
        } else if(clazz.isAssignableFrom(String.class)) {
            return (T) jsonString;
        } else {
            try {
                return mapper.readValue(jsonString, clazz);
            } catch (IOException var4) {
                logger.warn("parse json string error:" + jsonString, var4);
                return null;
            }
        }
    }

    public <T> T fromJson(String jsonStr, JavaType javaType) {
        if(StringUtils.isEmpty(jsonStr)) {
            return null;
        } else {
            try {
                System.out.print("");
                return mapper.readValue(jsonStr, javaType);
            } catch (IOException var4) {
                logger.warn("parse json string error:" + jsonStr, var4);
                return null;
            }
        }
    }

    public <T> T fromJson(String jsonString, TypeReference<T> typeReference) {
        if(StringUtils.isEmpty(jsonString)) {
            return null;
        } else {
            try {
                return mapper.readValue(jsonString, typeReference);
            } catch (IOException var4) {
                logger.warn("parse json string error:" + jsonString, var4);
                return null;
            }
        }
    }

    public JavaType buildCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
        return mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    public JavaType buildMapType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        return mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
    }

    public void update(String jsonString, Object object) {
        try {
            mapper.readerForUpdating(object).readValue(jsonString);
        } catch (JsonProcessingException var4) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", var4);
        } catch (IOException var5) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", var5);
        }

    }

    public String toJsonP(String functionName, Object object) {
        return this.toJson(new JSONPObject(functionName, object));
    }

    public void enableEnumUseToString() {
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public static boolean isJSON(String string) {
        try {
            defaultMapper().getMapper().readTree(string);
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static <T> boolean isJSON(String string, Class<T> clazz) {
        if(StringUtils.isBlank(string)) {
            return false;
        } else {
            try {
                defaultMapper().getMapper().readValue(string, clazz);
                return true;
            } catch (Exception var3) {
                return false;
            }
        }
    }
}
