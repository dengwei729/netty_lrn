package my.lrm.netty.param;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 16:52
 * @date 2024/11/01
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        if (packet == null) {
            return;
        }
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}
