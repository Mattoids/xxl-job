package com.xxl.job.executor.core.config.ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.xxl.job.core.ssh.SshTool;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;
import java.util.Properties;

@Log4j2
public class SshConnectionTool {

    private Session sesion; //ssh 会话

    public void closeSSH ()
    {
        sesion.disconnect();
    }

    public SshConnectionTool(SshTool model) throws Throwable
    {
        JSch jsch = new JSch();
        if (Objects.nonNull(model.getSshPrivateKey()) && !model.getSshPrivateKey().isEmpty()) {
            jsch.setKnownHosts(model.getSshKnownHosts());
            jsch.addIdentity(model.getSshPrivateKey());
        }
        sesion = jsch.getSession(model.getSshUser(), model.getSshHost(), model.getSshPort());
        if (Objects.nonNull(model.getSshPassword()) && !model.getSshPassword().isEmpty()) {
            sesion.setPassword(model.getSshPassword());
        }

        //设置连接过程不校验known_hosts文件中的信息
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        sesion.setConfig(config);
        //ssh 建立连接！
        sesion.connect(10000);
        //根据安全策略，您必须通过转发端口进行连接
        sesion.setPortForwardingL(model.getLocalMysqlPort(), model.getRemoteMysqlHost(), model.getRemoteMysqlPort());
        log.info(sesion);
    }
}
