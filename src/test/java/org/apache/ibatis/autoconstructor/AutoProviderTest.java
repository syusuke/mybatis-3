/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.autoconstructor;

import java.util.Map;

/** @author Kerry on 18/12/10 */
public class AutoProviderTest {
  public String findByIdProvider(Integer id) {
    // language=SQL
    return "SELECT * FROM subject where id = " + id;
  }

  /**
   * mapper.findMoreParam2(1, "a");
   *
   * @param id
   * @param name
   * @return
   */
  public String findMoreParamProvider0(Integer id, String name) {
    // language=SQL
    return "select * from subject where id = " + id + " and name = '" + name + "'";
  }

  /**
   * mapper.findMoreParam1(1, "a");
   *
   * @param data
   * @return
   */
  public String findMoreParamProvider1(Map<String, Object> data) {
    System.out.println(data);
    // {name=a, id=1, param1=1, param2=a}
    // language=SQL
    return "select * from subject where id = "
        + data.get("id")
        + " and name = '"
        + data.get("name")
        + "'";
  }

  /**
   * mapper.findMoreParam2(1, "a");
   *
   * @param data
   * @return
   */
  public String findMoreParamProvider2(Map<String, Object> data) {
    System.out.println(data);
    // {arg1=a, arg0=1, param1=1, param2=a}
    // language=SQL
    return "select * from subject where id = "
        + data.get("param1")
        + " and name = '"
        + data.get("param2")
        + "'";
  }
}
