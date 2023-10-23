package com.psj.web.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @ClassName MessageUtils
 * @Author Pengshj
 * @Description 
 * @Date 2023/8/16 16:19
 **/

public class MessageUtils {
    /**
     * 
     * @Author Pengshj
     * @Description 
     * @Date 2023/8/16 16:58
     * @Param [code, args]
     * @return java.lang.String
     **/
    public static String message(String code, Object[] args)
    {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }


}
