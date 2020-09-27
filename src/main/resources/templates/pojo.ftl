package ${packagePath};

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
/**
*  auto genetated
* @Date: ${.now?string["yyyy-MM-dd"]}
*/
@Table(name = "${table.tableName}")
public class ${table.voName} implements Serializable{

    <#list details as cloum>
        /**
        *${cloum.comments?if_exists}
        *
        **/
        <#if cloum.pri == "TRUE">
        @Id
        </#if>
        @Column(name = "${cloum.cloumnName}")
        private ${cloum.colunmType} ${ cloum.property ?uncap_first};
        public void set${cloum.property}(${cloum.colunmType} ${cloum.property ?uncap_first} ){
            this.${cloum.property ?uncap_first} = ${cloum.property ?uncap_first};
        }
        public ${cloum.colunmType} get${cloum.property}(){
            return this.${cloum.property ?uncap_first};
        }
    </#list>

}