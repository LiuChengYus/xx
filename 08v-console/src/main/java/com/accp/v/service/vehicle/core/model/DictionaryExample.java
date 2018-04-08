package com.accp.v.service.vehicle.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 字段封装
 */
public class DictionaryExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDictypeIsNull() {
            addCriterion("DicType is null");
            return (Criteria) this;
        }

        public Criteria andDictypeIsNotNull() {
            addCriterion("DicType is not null");
            return (Criteria) this;
        }

        public Criteria andDictypeEqualTo(Integer value) {
            addCriterion("DicType =", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotEqualTo(Integer value) {
            addCriterion("DicType <>", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeGreaterThan(Integer value) {
            addCriterion("DicType >", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DicType >=", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeLessThan(Integer value) {
            addCriterion("DicType <", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeLessThanOrEqualTo(Integer value) {
            addCriterion("DicType <=", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeIn(List<Integer> values) {
            addCriterion("DicType in", values, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotIn(List<Integer> values) {
            addCriterion("DicType not in", values, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeBetween(Integer value1, Integer value2) {
            addCriterion("DicType between", value1, value2, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotBetween(Integer value1, Integer value2) {
            addCriterion("DicType not between", value1, value2, "dictype");
            return (Criteria) this;
        }

        public Criteria andDiccodeIsNull() {
            addCriterion("DicCode is null");
            return (Criteria) this;
        }

        public Criteria andDiccodeIsNotNull() {
            addCriterion("DicCode is not null");
            return (Criteria) this;
        }

        public Criteria andDiccodeEqualTo(String value) {
            addCriterion("DicCode =", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeNotEqualTo(String value) {
            addCriterion("DicCode <>", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeGreaterThan(String value) {
            addCriterion("DicCode >", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeGreaterThanOrEqualTo(String value) {
            addCriterion("DicCode >=", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeLessThan(String value) {
            addCriterion("DicCode <", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeLessThanOrEqualTo(String value) {
            addCriterion("DicCode <=", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeLike(String value) {
            addCriterion("DicCode like", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeNotLike(String value) {
            addCriterion("DicCode not like", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeIn(List<String> values) {
            addCriterion("DicCode in", values, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeNotIn(List<String> values) {
            addCriterion("DicCode not in", values, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeBetween(String value1, String value2) {
            addCriterion("DicCode between", value1, value2, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeNotBetween(String value1, String value2) {
            addCriterion("DicCode not between", value1, value2, "diccode");
            return (Criteria) this;
        }

        public Criteria andDicvalueIsNull() {
            addCriterion("DicValue is null");
            return (Criteria) this;
        }

        public Criteria andDicvalueIsNotNull() {
            addCriterion("DicValue is not null");
            return (Criteria) this;
        }

        public Criteria andDicvalueEqualTo(String value) {
            addCriterion("DicValue =", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotEqualTo(String value) {
            addCriterion("DicValue <>", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueGreaterThan(String value) {
            addCriterion("DicValue >", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueGreaterThanOrEqualTo(String value) {
            addCriterion("DicValue >=", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLessThan(String value) {
            addCriterion("DicValue <", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLessThanOrEqualTo(String value) {
            addCriterion("DicValue <=", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLike(String value) {
            addCriterion("DicValue like", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotLike(String value) {
            addCriterion("DicValue not like", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueIn(List<String> values) {
            addCriterion("DicValue in", values, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotIn(List<String> values) {
            addCriterion("DicValue not in", values, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueBetween(String value1, String value2) {
            addCriterion("DicValue between", value1, value2, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotBetween(String value1, String value2) {
            addCriterion("DicValue not between", value1, value2, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("Remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("Remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("Remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("Remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("Remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("Remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("Remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("Remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("Remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("Remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("Remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("Remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("Remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("Remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
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