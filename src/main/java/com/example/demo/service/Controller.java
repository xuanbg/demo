package com.example.demo.service;

/**
 * @author 宣炳刚
 * @date 2021/7/16
 * @remark 服务控制器
 */
public class Controller {
    private final Service service;

    /**
     * 构造方法
     *
     * @param service Service
     */
    public Controller(Service service) {
        this.service = service;
    }

}
