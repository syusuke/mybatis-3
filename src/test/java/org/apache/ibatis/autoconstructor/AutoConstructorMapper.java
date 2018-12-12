/**
 * Copyright 2009-2018 the original author or authors.
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
package org.apache.ibatis.autoconstructor;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface AutoConstructorMapper {
    @Select("SELECT * FROM subject WHERE id = #{id}")
    PrimitiveSubject getSubject(final int id);

    @Select("SELECT * FROM subject")
    List<PrimitiveSubject> getSubjects();

    @Select("SELECT * FROM subject")
    List<AnnotatedSubject> getAnnotatedSubjects();

    @Select("SELECT * FROM subject")
    List<BadSubject> getBadSubjects();

    @Select("SELECT * FROM extensive_subject")
    List<ExtensiveSubject> getExtensiveSubject();

    List<AnnotatedSubject> getAnnotatedSubjectsInXml();


    /**
     * SQL provider 测试
     *
     * @param id
     * @return
     */
    @SelectProvider(type = AutoProviderTest.class, method = "findByIdProvider")
    List<AnnotatedSubject> findById(Integer id);

    @SelectProvider(type = AutoProviderTest.class, method = "findMoreParamProvider0")
    List<AnnotatedSubject> findMoreParam0(Integer id, String name);

    @SelectProvider(type = AutoProviderTest.class, method = "findMoreParamProvider1")
    List<AnnotatedSubject> findMoreParam1(@Param("id") Integer id, @Param("name") String name);


    @SelectProvider(type = AutoProviderTest.class, method = "findMoreParamProvider2")
    List<AnnotatedSubject> findMoreParam2(Integer id, String name);

}
