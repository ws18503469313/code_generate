package com.generater.core;

/**
 * 生成的文件类型
 * @author polunzi
 */
public enum FileType {
    MODEL("model", 0, ".java"),
    CLIENT("client", 1, "FeginClient.java"),
    MAPPER("mapper", 2, "Mapper.java"),
    XML("XML", 3, "Mapper.xml"),
    EXAMPLE("example", 4, "Example.java");
    /**
     * 生成的文件包位置
     */
    private String remarke;
    /**
     * 表示
     */
    private Integer value;
    /**
     * 生成的文件后缀
     */
    private String sufix;
    FileType(String remarke, Integer value, String sufix) {
        this.remarke = remarke;
        this.value = value;
        this.sufix = sufix;
    }
    public String getRemarke() {
        return remarke;
    }
    public Integer getValue() {
        return value;
    }
    public String getSufix() {
        return sufix;
    }

    FileType getByValue(int value){
        for(FileType one : FileType.values()){
            if(one.getValue().equals(value))
                return one;
        }
        return null;
    }
}
