package pers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class Nio {
    public void nio() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress("localhost", 5050));

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();
                if (next.isAcceptable()) {
                    acceptHandler(next, selector);
                } else if (next.isReadable()) {
                    readHandler(next);
                }
            }
        }
    }

    private void readHandler(SelectionKey next) {}

    private void acceptHandler(SelectionKey next, Selector selector) throws IOException {
        SelectableChannel channel = next.channel();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
    }
}
