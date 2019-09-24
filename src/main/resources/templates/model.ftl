package ${packagePath};

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
/**
*  auto genetated
* @author polunzi
* @Date: ${.now?string["yyyy-MM-dd"]}
*/
public class ${table.tableName} implements Serializable{

    <#list details as cloum>
        /**
        *${cloum.comment}
        *
        **/
        private ${cloum.colunmType} ${ cloum.property ?uncap_first};
        public void set${cloum.property}(${cloum.colunmType} ${cloum.property ?uncap_first} ){
            this.${cloum.property ?uncap_first} = ${cloum.property ?uncap_first};
        }
        public ${cloum.colunmType} get${cloum.property}(){
            return this.${cloum.property ?uncap_first};
        }
    </#list>

}
