package my.lrn.netty.param;

import lombok.Data;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 16:30
 * @date 2024/11/01
 */
@Data
public abstract class Packet {
    // 协议版本
    private Byte version=1;
    // 获取数据类型
    public abstract Byte getCommand();
}
