package com.example.demo.common.client;

import com.insight.utils.Json;
import com.insight.utils.pojo.Log;
import com.insight.utils.pojo.LoginInfo;
import com.insight.utils.pojo.OperateType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 宣炳刚
 * @date 2019-09-03
 * @remark RabbitMQ客户端
 */
@Component
public class LogClient {
    private final RabbitTemplate template;

    /**
     * 构造方法
     *
     * @param template RabbitTemplate
     */
    public LogClient(RabbitTemplate template) {
        this.template = template;
    }

    /**
     * 记录操作日志
     *
     * @param info     用户关键信息
     * @param business 业务类型
     * @param type     操作类型
     * @param id       业务ID
     * @param content  日志内容
     */
    public void writeLog(LoginInfo info, String business, OperateType type, String id, Object content) {
        Log log = new Log();
        log.setAppId(info.getAppId());
        log.setTenantId(info.getTenantId());
        log.setType(type);
        log.setBusiness(business);
        log.setBusinessId(id);
        log.setContent(Json.clone(content, Object.class));
        log.setCreator(info.getUserName());
        log.setCreatorId(info.getUserId());

        template.convertAndSend("amq.topic", "insight.log", log);
    }
}
