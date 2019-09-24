package ${packagePath};

import ${basePackagePath}.model.${table.tableName};

import java.util.ArrayList;
import java.util.List;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import com.cloud.util.JSONResult;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
*  auto genetated
* @author polunzi
* @Date: ${.now?string["yyyy-MM-dd"]}
*/
@FeignClient(name = "",  fallbackFactory = ${table.tableName}FactoryFallBack.class)
public interface ${table.tableName}FeginClient {
    /**
    *   findById
    * @author polunzi
    * @Date: ${.now?string["yyyy-MM-dd"]}
    */
    @RequestMapping(value = "/get${table.tableName}ById",method = RequestMethod.POST)
    public ${table.tableName} get${table.tableName}ById(@RequestParam("Id") Long Id)throws Exception;
    /**
    *   添加
    * @author polunzi
    * @Date: ${.now?string["yyyy-MM-dd"]}
    */
    @RequestMapping(value = "/add${table.tableName}",method = RequestMethod.POST)
    public JSONResult add${table.tableName}(@RequestBody ${table.tableName} ${table.tableName?uncap_first})throws Exception;
    /**
    *   通过条件查找,
    * @author polunzi
    * @Date: ${.now?string["yyyy-MM-dd"]}
    */
    @RequestMapping(value = "/find${table.tableName}",method = RequestMethod.POST)
    public List<${table.tableName}> find${table.tableName}(@RequestBody ${table.tableName} ${table.tableName?uncap_first})throws Exception;
    /**
    *   更新
    * @author polunzi
    * @Date: ${.now?string["yyyy-MM-dd"]}
    */
    @RequestMapping(value = "/update${table.tableName}",method = RequestMethod.POST)
    public JSONResult update${table.tableName}(@RequestBody ${table.tableName} ${table.tableName?uncap_first})throws Exception;


}
@Component
class  ${table.tableName}FactoryFallBack implements FallbackFactory<${table.tableName}FeginClient> {

    private static final Logger log = LoggerFactory.getLogger(${table.tableName}FeginClient.class);
    @Override
    public ${table.tableName}FeginClient create(Throwable cause) {
        log.info("=====================fallback cause is {}", cause.getMessage());
        return new ${table.tableName}FeginClient() {

            @Override
            public ${table.tableName} get${table.tableName}ById(@RequestParam("Id") Long Id)throws Exception{
                ${table.tableName} ${table.tableName?uncap_first} = new ${table.tableName}();
                return ${table.tableName?uncap_first};
            }

            @Override
            public JSONResult add${table.tableName}( ${table.tableName} ${table.tableName?uncap_first})throws Exception{
                return null;
            }

            @Override
            public JSONResult update${table.tableName}( ${table.tableName} ${table.tableName?uncap_first})throws Exception{
                return null;
            }

            @Override
            public List<${table.tableName}> find${table.tableName}( ${table.tableName} ${table.tableName?uncap_first})throws Exception{
                return new ArrayList<${table.tableName}>();
            }


        };
    }
}