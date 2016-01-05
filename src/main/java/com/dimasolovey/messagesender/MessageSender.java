package com.dimasolovey.messagesender;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
/**
 * Created by dmitry.solovey on 16.12.2015.
 */
public class MessageSender {
    private final static int port = 10001;
    private final static String host = "192.168.5.155";

    public static synchronized void sendMessage(String message)   {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
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
