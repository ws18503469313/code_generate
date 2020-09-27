<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackagePath}.${table.moduleName}.mapper.${table.voName}Mapper">

    <resultMap id="BaseResultMap" type="${basePackagePath}.${table.moduleName}.pojo.${table.voName}">
        <!-- WARNING - @polunzi_auto_generated -->
        <#list details as cloum>
            <id column="${cloum.cloumnName}" jdbcType="${cloum.jdbcType}" property="${cloum.property}" />
        </#list>
    </resultMap>


</mapper>