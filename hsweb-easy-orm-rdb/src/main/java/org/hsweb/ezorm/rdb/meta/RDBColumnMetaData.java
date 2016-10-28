package org.hsweb.ezorm.rdb.meta;

import org.hsweb.ezorm.core.meta.ColumnMetaData;
import org.hsweb.ezorm.core.OptionConverter;
import org.hsweb.ezorm.core.PropertyWrapper;
import org.hsweb.ezorm.core.ValueConverter;
import org.hsweb.ezorm.rdb.meta.converter.DefaultValueConverter;
import org.hsweb.ezorm.rdb.meta.expand.SimplePropertyWrapper;

import java.io.Serializable;
import java.sql.JDBCType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RDBColumnMetaData implements ColumnMetaData, Serializable, Cloneable, Comparable<RDBColumnMetaData> {
    private static final DefaultValueConverter DEFAULT_VALUE_CONVERTER = new DefaultValueConverter();

    public RDBColumnMetaData() {
    }

    public RDBColumnMetaData(String name, Class javaType, String dataType, JDBCType jdbcType) {
        this.name = name;
        this.javaType = javaType;
        this.dataType = dataType;
        this.jdbcType = jdbcType;
    }

    private String name;

    private String alias;

    private String comment;

    private String dataType;

    /**
     * 长度
     *
     * @since 1.1
     */
    private int length;

    /**
     * 精度
     *
     * @since 1.1
     */
    private int precision;

    /**
     * 小数位数
     *
     * @since 1.1
     */
    private int scale;

    /**
     * 是否是索引字段
     *
     * @since 1.1
     */
    private boolean index;

    /**
     * 是否不能为空
     */
    private boolean notNull;

    /**
     * 是否主键
     */
    private boolean primaryKey;

    private JDBCType jdbcType;

    private Class javaType;

    private RDBTableMetaData tableMetaData;

    private OptionConverter optionConverter;

    private ValueConverter valueConverter = DEFAULT_VALUE_CONVERTER;

    private Set<String> validator;

    private int sortIndex;

    private Map<String, Object> properties = new HashMap<>();

    public PropertyWrapper getProperty(String name) {
        return new SimplePropertyWrapper(properties.get(name));
    }

    public PropertyWrapper getProperty(String name, Object defaultValue) {
        return new SimplePropertyWrapper(properties.getOrDefault(name, defaultValue));
    }

    public PropertyWrapper setProperty(String property, Object value) {
        return new SimplePropertyWrapper(properties.put(property, value));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        if (alias == null) alias = name;
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Class getJavaType() {
        return javaType;
    }

    public void setJavaType(Class javaType) {
        this.javaType = javaType;
    }

    public RDBTableMetaData getTableMetaData() {
        return tableMetaData;
    }

    public void setTableMetaData(RDBTableMetaData tableMetaData) {
        this.tableMetaData = tableMetaData;
    }

    public String getFullName() {
        return tableMetaData.getName() + "." + getName();
    }

    public String getFullAliasName() {
        return tableMetaData.getAlias() + "." + getAlias();
    }

    public JDBCType getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(JDBCType jdbcType) {
        this.jdbcType = jdbcType;
    }

    public Set<String> getValidator() {
        return validator;
    }

    public void setValidator(Set<String> validator) {
        this.validator = validator;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public OptionConverter getOptionConverter() {
        return optionConverter;
    }

    public void setOptionConverter(OptionConverter optionConverter) {
        this.optionConverter = optionConverter;
    }

    public ValueConverter getValueConverter() {
        return valueConverter;
    }

    public void setValueConverter(ValueConverter valueConverter) {
        this.valueConverter = valueConverter;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    @Override
    public int compareTo(RDBColumnMetaData o) {
        return Integer.compare(sortIndex, o.getSortIndex());
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public boolean isIndex() {
        return index;
    }

    public void setIndex(boolean index) {
        this.index = index;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public RDBColumnMetaData clone() {
        RDBColumnMetaData RDBColumnMetaData = new RDBColumnMetaData();
        RDBColumnMetaData.name = name;
        RDBColumnMetaData.alias = alias;
        RDBColumnMetaData.comment = comment;
        RDBColumnMetaData.javaType = javaType;
        RDBColumnMetaData.jdbcType = jdbcType;
        RDBColumnMetaData.dataType = dataType;
        RDBColumnMetaData.properties = properties;
        RDBColumnMetaData.optionConverter = optionConverter;
        RDBColumnMetaData.tableMetaData = tableMetaData;
        RDBColumnMetaData.sortIndex = sortIndex;
        RDBColumnMetaData.length = length;
        RDBColumnMetaData.scale = scale;
        RDBColumnMetaData.precision = precision;
        RDBColumnMetaData.index = index;
        RDBColumnMetaData.notNull = notNull;
        RDBColumnMetaData.primaryKey = primaryKey;
        return RDBColumnMetaData;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", comment='" + comment + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}