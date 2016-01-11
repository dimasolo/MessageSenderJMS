package com.dimasolovey.messagesender_and_queues.sender;

import com.dimasolovey.messagesender_and_queues.Start;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
/**
 * Created by dmitry.solovey on 16.12.2015.
 */
public class MessageSender {
    private static int port;
    private static String host;

    public static synchronized void sendMessage(String message)   {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            port = Start.getPort();
            host = Start.getHost();
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientInitializer());
            Channel channel = bootstrap.connect(host,port).sync().channel();
            channel.write(message);
            channel.flush();
        } catch (Exception ex) {
            return;
        }
        finally {
            group.shutdownGracefully();
        }
    }
}
