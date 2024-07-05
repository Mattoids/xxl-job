package com.xxl.job.executor.listener;

import cn.hutool.json.JSONUtil;
import com.xxl.job.core.ssh.SshTool;
import com.xxl.job.executor.core.config.SshConfigurationProperties;
import com.xxl.job.executor.core.config.ssh.SshConnectionTool;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
@Log4j2
public class SshContextListener implements ServletContextListener {

    private SshConnectionTool conexionssh;

    @Autowired
    private SshConfigurationProperties sshConfigurationProperties;

    public SshContextListener() {
        super();
    }
    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        log.info("SSH Connection begin...");
        for (SshTool sshTool : sshConfigurationProperties.getList()) {
            if (!sshTool.getEnabled()) {
                continue;
            }
            try {
                conexionssh = new SshConnectionTool(sshTool);
            } catch (Throwable e) {
                e.printStackTrace(); // 连接失败
            }
        }

        log.info("SSH Connection initialized");
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        log.info("SSH Connection destroyed");
        conexionssh.closeSSH(); // 断开连接
    }


}
