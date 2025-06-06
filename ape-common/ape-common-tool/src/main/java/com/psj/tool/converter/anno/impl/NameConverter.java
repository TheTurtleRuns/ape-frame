package com.psj.tool.converter.anno.impl;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.psj.tool.converter.anno.CustomConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 名称转换器
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize
@CustomConverter(NameConverterImpl.class)
public @interface NameConverter {
}
