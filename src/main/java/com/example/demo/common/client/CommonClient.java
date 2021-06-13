package com.example.demo.common.client;

import com.example.demo.common.config.FeignClientConfig;
import com.insight.utils.pojo.Reply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 宣炳刚
 * @date 2019-08-31
 * @remark 消息中心Feign客户端
 */
@FeignClient(name = "common-basedata", configuration = FeignClientConfig.class)
public interface CommonClient {

    /**
     * 获取选项值
     *
     * @param moduleId 模块ID
     * @param keyword  参数键
     * @return Reply
     */
    @GetMapping("/common/param/v1.0/params/value")
    Reply getParamValue(@RequestParam String moduleId, @RequestParam String keyword);

    /**
     * 删除报表实例
     *
     * @param id   报表实例ID
     * @return Reply
     */
    @DeleteMapping("/common/report/v1.0/reports/{id}")
    Reply deleteReport(@PathVariable long id);

    /**
     * 获取日志列表
     *
     * @param business 业务类型
     * @param keyword  查询关键词
     * @param page     分页页码
     * @param size     每页记录数
     * @return Reply
     */
    @GetMapping("/common/log/v1.0/logs")
    Reply getLogs(@RequestParam String business, @RequestParam(required = false) String keyword, @RequestParam int page, @RequestParam int size);

    /**
     * 获取日志详情
     *
     * @param id 日志ID
     * @return Reply
     */
    @GetMapping("/common/log/v1.0/logs/{id}")
    Reply getLog(@PathVariable String id);
}
