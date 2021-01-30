package ${packagePath};

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
/**
 *  auto genetated
 *  @desc ${table.comments}
 *  @Date ${.now?string["yyyy-MM-dd"]}
 */
@Table(name = "${table.tableName}")
@Getter
@Setter
public class ${table.voName} implements Serializable{

    <#list details as cloum>
        /**
         * ${cloum.comments?if_exists}
         *
         */
        <#if cloum.pri == "TRUE">
        @Id
        </#if>
        @Column(name = "${cloum.cloumnName}")
        private ${cloum.colunmType} ${ cloum.property?uncap_first};
    </#list>

}
