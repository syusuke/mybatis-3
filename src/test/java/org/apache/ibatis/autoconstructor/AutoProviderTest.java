package org.apache.ibatis.autoconstructor;

import java.util.Map;

/**
 * @author Kerry on 18/12/10
 */

public class AutoProviderTest {
    public String findByIdProvider(Integer id) {
        //language=SQL
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
        //language=SQL
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
        //language=SQL
        return "select * from subject where id = " + data.get("id") + " and name = '" + data.get("name") + "'";
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
        //language=SQL
        return "select * from subject where id = " + data.get("param1") + " and name = '" + data.get("param2") + "'";
    }
}
