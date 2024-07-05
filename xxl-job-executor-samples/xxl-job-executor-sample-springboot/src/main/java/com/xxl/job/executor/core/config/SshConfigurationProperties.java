package com.xxl.job.executor.core.config;

import com.xxl.job.core.ssh.SshTool;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "ssh")
public class SshConfigurationProperties {
    private List<SshTool> list = new ArrayList<>();

    public List<SshTool> getList() {
        return this.list;
    }
}
