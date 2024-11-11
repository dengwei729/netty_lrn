package my.lrn.netty.param;

import lombok.Data;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 16:32
 * @date 2024/11/01
 */
@Data
public class LoginResponsePacket extends Packet {

    //是否登录成功
    private boolean success;
    //如果失败，返回的信息
    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
