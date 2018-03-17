package com.choudou5.javasaasx.service.sys;

import com.choudou5.javasaasx.service.sys.bo.DingLinkMessageBo;

import java.util.List;

/**
 * @Name：钉钉接口
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
public interface DingTalkService {

    /**
     * 同步 数据
     */
    void synData();

    /**
     * 创建 群组
     * @param chatName
     * @param owner
     * @param userIdlist
     * @return 群组ID
     */
    String create(String chatName, String owner, List<String> userIdlist);

    /**
     * 发送 群组 文本消息
     * @param bizType
     * @param text
     */
    void sendTextMsg(String bizType, String text);


    /**
     * 发送 群组 链接消息
     * @param bizType
     * @param message
     */
    void sendLinkMsg(String bizType, DingLinkMessageBo message);

}
