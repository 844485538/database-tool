package com.sijing.tools.entity.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author 李健新
 * @Date 2022/6/10
 * @Description
 */
public class ConnectionDatabaseVO {

    @NotEmpty(message = "host不可为空")
    private String host;

    @NotNull(message = "端口不可为空")
    private Integer port;

    @NotEmpty(message = "用户名不可为空")
    private String username;

    @NotEmpty(message = "密码不可为空")
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
