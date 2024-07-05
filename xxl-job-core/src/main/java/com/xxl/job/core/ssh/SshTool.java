package com.xxl.job.core.ssh;

import lombok.Data;

@Data
public class SshTool {
    private Boolean enabled = true;

    private String sshHost;
    private Integer sshPort = 22;
    private String sshUser;
    private String sshPassword;

    private String sshKnownHosts = "~/.ssh/known_hosts";
    private String sshPrivateKey;

    private String remoteMysqlHost;
    private Integer remoteMysqlPort = 3306;
    private Integer localMysqlPort = 3307;
}
