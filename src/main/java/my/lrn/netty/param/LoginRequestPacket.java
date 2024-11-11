package my.lrn.netty.param;

import lombok.Data;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 16:31
 * @date 2024/11/01
 */
@Data
public class LoginRequestPacket extends Packet {
    //定义用户信息
    private Integer userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
