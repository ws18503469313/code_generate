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

import com.qyy.market.ddd.AbstractEntity;

/**
 *  auto genetated
 *  @desc ${table.comments}
 *  @Date ${.now?string["yyyy-MM-dd"]}
 */
@Table(name = "${table.tableName}")
@Getter
@Setter
public class ${table.voName} extends AbstractEntity {

    <#list details as cloum>

        <#if !cloum.cloumnName?contains("last") && !cloum.cloumnName?contains("create") && cloum.pri != "TRUE">
        /**
         * ${cloum.comments?if_exists}
         *
         */
        @Column(name = "${cloum.cloumnName}")
        private ${cloum.colunmType} ${ cloum.property?uncap_first};
        </#if>
    </#list>

}
