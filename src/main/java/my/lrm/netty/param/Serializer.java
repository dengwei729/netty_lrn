package my.lrm.netty.param;

import com.alibaba.fastjson2.JSON;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 16:33
 * @date 2024/11/01
 */
public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();
    //序列化算法
    byte getSerializerAlogrithm();
    //java 对象转换成二进制
    byte[] serialize(Object object);
    //二进制转换成 java 对象
    <T> T deserialize(Class<T> clazz, byte[] bytes);

}
