package com.zjut.netty.server.base;

/**
 * @author yuanweipeng
 * @date 2017-12-13
 **/
public interface BaseServer {

    /**
     * 启动server服务，监听指定host和端口
     *
     * @param host server监听的host
     * @param port server 监听的端口
     * @throws Exception
     */
    void server(String host, int port) throws Exception;

    /**
     * 停止服务
     */
    void stopServer();
}
