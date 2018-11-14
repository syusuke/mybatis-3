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

import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.impl.PerpetualCache;

import java.lang.annotation.*;

/**
 * @author Clinton Begin
 * @author Kazuki Shimizu
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CacheNamespace {
    /**
     * 负责存储的 Cache 实现类
     *
     * @return
     */
    Class<? extends org.apache.ibatis.cache.Cache> implementation() default PerpetualCache.class;

    /**
     * 负责过期的 Cache 实现类
     *
     * @return
     */
    Class<? extends org.apache.ibatis.cache.Cache> eviction() default LruCache.class;

    /**
     * 清空缓存的频率。0 代表不清空
     *
     * @return
     */
    long flushInterval() default 0;

    int size() default 1024;

    /**
     * 是否序列化。{@link org.apache.ibatis.cache.decorators.SerializedCache}
     *
     * @return
     */
    boolean readWrite() default true;

    boolean blocking() default false;

    /**
     * Property values for a implementation object.
     *
     * @since 3.4.2
     */
    Property[] properties() default {};

}
