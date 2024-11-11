package my.lrn.netty.param;

import com.alibaba.fastjson2.JSON;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 16:38
 * @date 2024/11/01
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlgorithm.JSON;
    }
    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }
    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
