package my.lrn.netty.param;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 16:37
 * @date 2024/11/01
 */
public interface SerializerAlgorithm {
    //json序列化标识，如果你有其他的序列化方式可以在这注明标识，类似上面的登录指令
    byte JSON = 1;

}
