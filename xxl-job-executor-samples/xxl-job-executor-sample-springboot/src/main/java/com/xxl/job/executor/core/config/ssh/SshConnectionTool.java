package com.xxl.job.executor.core.config.ssh;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.xxl.job.core.ssh.SshTool;

import java.util.Properties;

public class SshConnectionTool {

    private Session sesion; //ssh 会话

    public void closeSSH ()
    {
        sesion.disconnect();
    }

    public SshConnectionTool(SshTool model) throws Throwable
    {

        JSch jsch = new JSch();

        if (model.getSshSecretKey()) {
            jsch.setKnownHosts(model.getSshKnownHosts());
            //设置私钥
            jsch.addIdentity(model.getSshPrivateKey());
        }

        sesion = jsch.getSession(model.getSshUser(), model.getSshHost(), model.getSshPort());

        if (!model.getSshSecretKey()) {
            sesion.setPassword(model.getSshPassword());
        }

        //设置连接过程不校验known_hosts文件中的信息
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        sesion.setConfig(config);

        sesion.connect(); //ssh 建立连接！

        //根据安全策略，您必须通过转发端口进行连接
        sesion.setPortForwardingL(model.getLocalMysqlPort(), model.getRemoteMysqlHost(), model.getRemoteMysqlPort());
    }
}
