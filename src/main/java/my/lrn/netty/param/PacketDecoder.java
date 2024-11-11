package my.lrn.netty.param;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * @author dw113073.邓伟
 * @since 2024/11/1 16:50
 * @date 2024/11/01
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in , List<Object> out) {
        out.add(PacketCodeC.INSTANCE.decode(in));

    }
}
