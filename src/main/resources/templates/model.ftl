package ${packagePath};
public ${table.tableName}{

    <#list details as cloum>
        /**
        *${cloum.comment}
        *
        **/
        private ${cloum.colunmType} ${ cloum.cloumnName};
        public void set${cloum.cloumnName}(${cloum.colunmType} ${cloum.cloumnName} ){
            this.${cloum.cloumnName} = ${cloum.cloumnName};
        }
        public ${cloum.colunmType} get${cloum.cloumnName}(){
            return this.${cloum.cloumnName};
        }
    </#list>

    public ${table.tableName}(Long id){
        this.id = id;
    }
}
