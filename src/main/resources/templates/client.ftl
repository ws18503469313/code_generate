package ${packagePath};

import ${basePackagePath}.${table.moduleName}.model.${table.voName};

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
 * @Date: ${.now?string["yyyy-MM-dd"]}
 */
@FeignClient(name = "",  fallbackFactory = ${table.voName}FactoryFallBack.class)
public interface ${table.voName}FeginClient {
    /**
     *   findById
     * @author polunzi
     * @Date: ${.now?string["yyyy-MM-dd"]}
     */
    @RequestMapping(value = "/get${table.voName}ById",method = RequestMethod.POST)
    public ${table.voName} get${table.voName}ById(@RequestParam("Id") Long Id)throws Exception;
    /**
     *   添加
     * @author polunzi
     * @Date: ${.now?string["yyyy-MM-dd"]}
     */
    @RequestMapping(value = "/add${table.voName}",method = RequestMethod.POST)
    public JSONResult add${table.voName}(@RequestBody ${table.voName} ${table.voName?uncap_first})throws Exception;
    /**
     *   通过条件查找,
     * @author polunzi
     * @Date: ${.now?string["yyyy-MM-dd"]}
     */
    @RequestMapping(value = "/find${table.voName}",method = RequestMethod.POST)
    public List<${table.voName}> find${table.voName}(@RequestBody ${table.voName} ${table.voName?uncap_first})throws Exception;
    /**
     *   更新
     * @author polunzi
     * @Date: ${.now?string["yyyy-MM-dd"]}
     */
    @RequestMapping(value = "/update${table.voName}",method = RequestMethod.POST)
    public JSONResult update${table.voName}(@RequestBody ${table.voName} ${table.voName?uncap_first})throws Exception;


}
@Component
class  ${table.voName}FactoryFallBack implements FallbackFactory<${table.voName}FeginClient> {

    private static final Logger log = LoggerFactory.getLogger(${table.voName}FeginClient.class);
    @Override
    public ${table.voName}FeginClient create(Throwable cause) {
        log.info("=====================fallback cause is {}", cause.getMessage());
        return new ${table.voName}FeginClient() {

            @Override
            public ${table.voName} get${table.voName}ById(@RequestParam("Id") Long Id)throws Exception{
                ${table.voName} ${table.voName?uncap_first} = new ${table.voName}();
                return ${table.voName?uncap_first};
            }

            @Override
            public JSONResult add${table.voName}( ${table.voName} ${table.voName?uncap_first})throws Exception{
                return null;
            }

            @Override
            public JSONResult update${table.voName}( ${table.voName} ${table.voName?uncap_first})throws Exception{
                return null;
            }

            @Override
            public List<${table.voName}> find${table.voName}( ${table.voName} ${table.voName?uncap_first})throws Exception{
                return new ArrayList<${table.voName}>();
            }


        };
    }
}