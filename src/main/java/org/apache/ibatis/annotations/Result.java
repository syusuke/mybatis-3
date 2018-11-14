/**
 * Copyright 2009-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.annotations;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Clinton Begin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Result {
    /**
     * 是否是唯一ID的字段
     *
     * @return
     */
    boolean id() default false;

    /**
     * 数据库列名
     *
     * @return
     */
    String column() default "";

    /**
     * JavaBean属性名
     *
     * @return
     */
    String property() default "";

    /**
     * Java的数据类型
     *
     * @return
     */
    Class<?> javaType() default void.class;

    /**
     * 数据库的类型
     *
     * @return
     */
    JdbcType jdbcType() default JdbcType.UNDEFINED;

    /**
     * 类型转换器,互转
     * <pre>
     *      javaType <==> jdbcType
     * </pre>
     *
     * @return
     */
    Class<? extends TypeHandler> typeHandler() default UnknownTypeHandler.class;

    One one() default @One;

    Many many() default @Many;
}
