<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackagePath}.mapper.${table.tableName}Mapper">

    <resultMap id="BaseResultMap" type="${basePackagePath}.model.${table.tableName}">
        <!-- WARNING - @polunzi_auto_generated -->
        <#list details as cloum>
            <id column="${cloum.cloumnName}" jdbcType="${cloum.jdbcType}" property="${cloum.property}" />
        </#list>
    </resultMap>


</mapper>