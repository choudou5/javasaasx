package com.choudou5.javasaasx.service.impl.util;

import cn.hutool.dfa.SensitiveUtil;
import com.choudou5.base.util.CollUtil;
import com.choudou5.javasaasx.common.util.SpringContextHolder;
import com.choudou5.javasaasx.service.dic.DicSensitiveWordService;

import java.util.List;

/**
 * @Name：敏感词工具类
 * @Author：xuhaowen
 * @Date：2018-03-05
 */
public class SensitiveWordUtil {

    private static DicSensitiveWordService sysUserService = SpringContextHolder.getBean(DicSensitiveWordService.class);

    static {
        refresh();
    }

    public static void refresh(){
        List<String> list = sysUserService.findAllWord();
        if(CollUtil.isNotEmpty(list)){
            SensitiveUtil.init(list, true);
        }
    }

    /**
     * 是否包含敏感词
     * @param text 文本
     * @return 是否包含
     */
    public static boolean exist(String text) {
        return SensitiveUtil.containsSensitive(text);
    }

    /**
     * 查找敏感词，返回找到的第一个敏感词
     * @param text 文本
     * @return 敏感词
     */
    public static String getFirst(String text) {
        return SensitiveUtil.getFindedFirstSensitive(text);
    }

    /**
     * 查找敏感词，返回找到的所有敏感词
     * @param text 文本
     * @return 敏感词
     */
    public static List<String> getAll(String text) {
        return SensitiveUtil.getFindedAllSensitive(text);
    }

    /**
     * 查找敏感词，返回找到的所有敏感词<br>
     * 密集匹配原则：假如关键词有 ab,b，文本是abab，将匹配 [ab,b,ab]<br>
     * 贪婪匹配（最长匹配）原则：假如关键字a,ab，最长匹配将匹配[a, ab]
     * @param text 文本
     * @param isDensityMatch 是否使用密集匹配原则
     * @param isGreedMatch 是否使用贪婪匹配（最长匹配）原则
     * @return 敏感词
     */
    public static List<String> getAll(String text, boolean isDensityMatch, boolean isGreedMatch) {
        return SensitiveUtil.getFindedAllSensitive(text, isDensityMatch, isGreedMatch);
    }

}
