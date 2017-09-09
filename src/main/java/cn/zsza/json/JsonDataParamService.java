package cn.zsza.json;

import cn.zsza.util.JsonMapper;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Created by ZhangSong on 2017/9/9.
 * 15:15
 */
public class JsonDataParamService {

    public <T> T getValue(String value, Class<T> clazz){
        return JsonMapper.nonDefaultMapper().fromJson(value,clazz);
    }

    public <T> T getValue(String value, TypeReference<T> typeReference){
        return JsonMapper.nonDefaultMapper().fromJson(value,typeReference);
    }


}
