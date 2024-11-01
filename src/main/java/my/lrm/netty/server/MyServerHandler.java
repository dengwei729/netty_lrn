package my.lrm.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import my.lrm.netty.param.LoginRequestPacket;
import my.lrm.netty.param.LoginResponsePacket;
import my.lrm.netty.param.Packet;
import my.lrm.netty.param.PacketCodeC;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 15:37
 * @date 2024/11/01
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        // 解码
        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);
        // 判断是否是登录请求数据包
        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            LoginResponsePacket loginResponsePacket=new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            // 登录校验
            if (valid(loginRequestPacket)) {
                // 校验成功
                loginResponsePacket.setSuccess(true);
                System.out.println("客户端登录成功！");
            } else {
                // 校验失败
                loginResponsePacket.setReason("账号或密码错误");
                loginResponsePacket.setSuccess(false);
                System.out.println("客户端登录失败！");
            }
            // 编码，结果发送给客户端
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //发送消息给客户端
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端已收到消息，并给你发送一个问号?", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //发生异常，关闭通道
        ctx.close();
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
        //return "username".equals(loginRequestPacket.getUsername()) && "pwd".equals(loginRequestPacket.getPassword());
    }
}
