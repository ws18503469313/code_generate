package ${packagePath};

import java.util.ArrayList;
import java.util.List;

/**
* ${table.comments?if_exists}
*  auto genetated
* @Date: ${.now?string["yyyy-MM-dd"]}
*/
public class ${table.voName}Example {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ${table.voName}Example() {
        oredCriteria = new ArrayList<Criteria>();
    }
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
        return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

    <#list details as cloum>
        public Criteria and${cloum.property}IsNull() {
            addCriterion("${cloum.cloumnName} is null");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}IsNotNull() {
            addCriterion("${cloum.cloumnName} is not null");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}EqualTo(String value) {
            addCriterion("${cloum.cloumnName} =", value, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}NotEqualTo(String value) {
            addCriterion("${cloum.cloumnName} <>", value, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}GreaterThan(String value) {
            addCriterion("${cloum.cloumnName} >", value, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}GreaterThanOrEqualTo(String value) {
            addCriterion("${cloum.cloumnName} >=", value, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}LessThan(String value) {
            addCriterion("${cloum.cloumnName} <", value, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}LessThanOrEqualTo(String value) {
            addCriterion("${cloum.cloumnName} <=", value, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}Like(String value) {
            addCriterion("${cloum.cloumnName} like", value, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}NotLike(String value) {
            addCriterion("${cloum.cloumnName} not like", value, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}In(List<String> values) {
            addCriterion("${cloum.cloumnName} in", values, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}NotIn(List<String> values) {
            addCriterion("${cloum.cloumnName} not in", values, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}Between(String value1, String value2) {
            addCriterion("${cloum.cloumnName} between", value1, value2, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }

        public Criteria and${cloum.property}NotBetween(String value1, String value2) {
            addCriterion("${cloum.cloumnName} not between", value1, value2, "${cloum.property ?uncap_first}");
            return (Criteria) this;
        }
    </#list>
    }
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
        return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

}