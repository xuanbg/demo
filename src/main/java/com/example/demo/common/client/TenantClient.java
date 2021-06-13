package com.example.demo.common.client;

import com.example.demo.common.config.FeignClientConfig;
import com.insight.utils.pojo.Reply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 宣炳刚
 * @date 2019-08-31
 * @remark 消息中心Feign客户端
 */
@FeignClient(name = "base-tenant", configuration = FeignClientConfig.class)
public interface TenantClient {

    /**
     * 获取所有用户
     *
     * @param id 租户ID
     * @return Reply
     */
    @GetMapping("/base/tenant/v1.0/tenants/{id}/users")
    Reply getUsers(@PathVariable String id);
}
