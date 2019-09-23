package com.generater.core;

public enum FileType {
    MODEL("model", 0, ".java"),
    CLIENT("client", 1, "Client.java"),
    MAPPER("mapper", 2, "Mapper.java");
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

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getSufix() {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix = sufix;
    }

    FileType getByValue(int value){
        for(FileType one : FileType.values()){
            if(one.getValue().equals(value))
                return one;
        }
        return null;
    }
}
