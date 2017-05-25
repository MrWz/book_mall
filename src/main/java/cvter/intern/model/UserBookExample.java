package cvter.intern.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserBookExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserUidIsNull() {
            addCriterion("user_uid is null");
            return (Criteria) this;
        }

        public Criteria andUserUidIsNotNull() {
            addCriterion("user_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUserUidEqualTo(String value) {
            addCriterion("user_uid =", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotEqualTo(String value) {
            addCriterion("user_uid <>", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidGreaterThan(String value) {
            addCriterion("user_uid >", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidGreaterThanOrEqualTo(String value) {
            addCriterion("user_uid >=", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidLessThan(String value) {
            addCriterion("user_uid <", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidLessThanOrEqualTo(String value) {
            addCriterion("user_uid <=", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidLike(String value) {
            addCriterion("user_uid like", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotLike(String value) {
            addCriterion("user_uid not like", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidIn(List<String> values) {
            addCriterion("user_uid in", values, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotIn(List<String> values) {
            addCriterion("user_uid not in", values, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidBetween(String value1, String value2) {
            addCriterion("user_uid between", value1, value2, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotBetween(String value1, String value2) {
            addCriterion("user_uid not between", value1, value2, "userUid");
            return (Criteria) this;
        }

        public Criteria andBookUidIsNull() {
            addCriterion("book_uid is null");
            return (Criteria) this;
        }

        public Criteria andBookUidIsNotNull() {
            addCriterion("book_uid is not null");
            return (Criteria) this;
        }

        public Criteria andBookUidEqualTo(String value) {
            addCriterion("book_uid =", value, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidNotEqualTo(String value) {
            addCriterion("book_uid <>", value, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidGreaterThan(String value) {
            addCriterion("book_uid >", value, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidGreaterThanOrEqualTo(String value) {
            addCriterion("book_uid >=", value, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidLessThan(String value) {
            addCriterion("book_uid <", value, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidLessThanOrEqualTo(String value) {
            addCriterion("book_uid <=", value, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidLike(String value) {
            addCriterion("book_uid like", value, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidNotLike(String value) {
            addCriterion("book_uid not like", value, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidIn(List<String> values) {
            addCriterion("book_uid in", values, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidNotIn(List<String> values) {
            addCriterion("book_uid not in", values, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidBetween(String value1, String value2) {
            addCriterion("book_uid between", value1, value2, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBookUidNotBetween(String value1, String value2) {
            addCriterion("book_uid not between", value1, value2, "bookUid");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNull() {
            addCriterion("buy_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNotNull() {
            addCriterion("buy_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceEqualTo(Integer value) {
            addCriterion("buy_price =", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotEqualTo(Integer value) {
            addCriterion("buy_price <>", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThan(Integer value) {
            addCriterion("buy_price >", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_price >=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThan(Integer value) {
            addCriterion("buy_price <", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThanOrEqualTo(Integer value) {
            addCriterion("buy_price <=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIn(List<Integer> values) {
            addCriterion("buy_price in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotIn(List<Integer> values) {
            addCriterion("buy_price not in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceBetween(Integer value1, Integer value2) {
            addCriterion("buy_price between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_price not between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNumsIsNull() {
            addCriterion("buy_nums is null");
            return (Criteria) this;
        }

        public Criteria andBuyNumsIsNotNull() {
            addCriterion("buy_nums is not null");
            return (Criteria) this;
        }

        public Criteria andBuyNumsEqualTo(Integer value) {
            addCriterion("buy_nums =", value, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsNotEqualTo(Integer value) {
            addCriterion("buy_nums <>", value, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsGreaterThan(Integer value) {
            addCriterion("buy_nums >", value, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_nums >=", value, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsLessThan(Integer value) {
            addCriterion("buy_nums <", value, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsLessThanOrEqualTo(Integer value) {
            addCriterion("buy_nums <=", value, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsIn(List<Integer> values) {
            addCriterion("buy_nums in", values, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsNotIn(List<Integer> values) {
            addCriterion("buy_nums not in", values, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsBetween(Integer value1, Integer value2) {
            addCriterion("buy_nums between", value1, value2, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_nums not between", value1, value2, "buyNums");
            return (Criteria) this;
        }

        public Criteria andBuyWayIsNull() {
            addCriterion("buy_way is null");
            return (Criteria) this;
        }

        public Criteria andBuyWayIsNotNull() {
            addCriterion("buy_way is not null");
            return (Criteria) this;
        }

        public Criteria andBuyWayEqualTo(Boolean value) {
            addCriterion("buy_way =", value, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayNotEqualTo(Boolean value) {
            addCriterion("buy_way <>", value, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayGreaterThan(Boolean value) {
            addCriterion("buy_way >", value, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("buy_way >=", value, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayLessThan(Boolean value) {
            addCriterion("buy_way <", value, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayLessThanOrEqualTo(Boolean value) {
            addCriterion("buy_way <=", value, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayIn(List<Boolean> values) {
            addCriterion("buy_way in", values, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayNotIn(List<Boolean> values) {
            addCriterion("buy_way not in", values, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayBetween(Boolean value1, Boolean value2) {
            addCriterion("buy_way between", value1, value2, "buyWay");
            return (Criteria) this;
        }

        public Criteria andBuyWayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("buy_way not between", value1, value2, "buyWay");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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