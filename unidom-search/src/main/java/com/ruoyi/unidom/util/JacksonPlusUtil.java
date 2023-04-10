package com.ruoyi.unidom.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Jackson工具栏，支持序列化和发序列化
 */
public class JacksonPlusUtil {
    private static final Logger log = LoggerFactory.getLogger(JacksonPlusUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        init();
    }

    private JacksonPlusUtil() {
        // 禁止私有化
    }

    private static void init() {
        // 这个特性，决定了解析器是否将自动关闭那些不属于parser自己的输入源。
        // 如果禁止，则调用应用不得不分别去关闭那些被用来创建parser的基础输入流InputStream和reader；
        // 默认是true
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        // 是否允许解析使用Java/C++ 样式的注释（包括'/'+'*' 和'//' 变量）
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

        // 设置为true时，属性名称不带双引号
        mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
        // 反序列化是是否允许属性名称不带双引号
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 序列化属性名称带有双引号
        mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
        // 是否允许单引号来包住属性名称和字符串值
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        // 是否允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符）
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        // 是否允许JSON整数以多个0开始
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);

        // null的属性不序列化
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // 按字母顺序排序属性,默认false
        mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);

        // 是否以类名作为根元素，可以通过@JsonRootName来自定义根元素名称,默认false
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        // 是否缩放排列输出,默认false
        mapper.configure(SerializationFeature.INDENT_OUTPUT, false);

        // 序列化Date日期时以timestamps输出，默认true
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        // 设置JSON时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        mapper.setDateFormat(df);
        //日期反序列化时兼容多种格式
        mapper.setConfig(mapper.getDeserializationConfig().with(new ObjectMapperDateFormatExtend(df)));

        // 序列化枚举是否以toString()来输出，默认false，即默认以name()来输出
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

        // 序列化枚举是否以ordinal()来输出，默认false
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false);

        // 序列化单元素数组时不以数组来输出，默认false
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

        // 序列化Map时对key进行排序操作，默认false
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        // 序列化char[]时以json数组输出，默认false
        mapper.configure(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS, true);

        //反序列化时,遇到未知属性时忽略
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        //mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);

        //mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    }

    /**
     * 序列化为json对象
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static String toJson(Object obj) {
        String json = null;
        try {
            if (log.isDebugEnabled()) {
                log.debug(" begin trasform into json from obj:{}", obj);
            }
            json = mapper.writeValueAsString(obj);
            if (log.isDebugEnabled()) {
                log.debug(" end trasform into json:{}", json);
            }
        } catch (JsonProcessingException e) {
            log.error("json序列化错误",e.getMessage(),e);
            throw new GenericException("json序列化错误", e);
        }
        return json;
    }

    /**
     * 从json字符串变回对象 如果是Map，List等请使用另外一个方法
     *
     * @param json
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        T t = null;
        try {
            if (log.isDebugEnabled()) {
                log.debug(" begin trasform [{}] into class:{}", json, clazz);
            }
            t = mapper.readValue(json, clazz);
            if (log.isDebugEnabled()) {
                log.debug(" end trasform [{}] into class:{}", json, clazz);
            }
        } catch (IOException e) {
            log.error("json反序列化错误",e.getMessage(),e);
            throw new GenericException("json反序列化错误", e);
        }

        return t;
    }

    /**
     * 根据类型进行json的反序列化，主要用于系列化为Map/List等之类含有类型定义的new TypeGetter<Map<String,
     * List<String>>>() { }
     *
     * @param json
     * @param type
     * @return
     * @throws Exception
     */
    public static <T> T fromJson(String json, TypeReference<T> type) {
        T t;
        try {
            if (log.isDebugEnabled()) {
                log.debug(" begin trasform [{}]into class:{}", json, type.getType());
            }
            t = mapper.readValue(json, type);
            if (log.isDebugEnabled()) {
                log.debug(" end trasform [{}]into class:{}", json, type.getType());
            }
        } catch (IOException e) {
            log.error("json反序列化错误",e.getMessage(),e);
            throw new GenericException("json反序列化错误", e);
        }

        return t;
    }

}


class ObjectMapperDateFormatExtend extends DateFormat {

    private static final long serialVersionUID = 1L;
    private DateFormat dateFormat;

    private List<SimpleDateFormat> extSimpleDateFormats=new ArrayList<>();

    /**
     * 构造函数传入objectmapper默认的dateformat
     * @param dateFormat
     */
    public ObjectMapperDateFormatExtend(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        buildExtDateFormat();

    }

    private void buildExtDateFormat() {
        SimpleDateFormat format0 = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format1 = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat format2 = new SimpleDateFormat(
                "yyyy-MM-dd");
        SimpleDateFormat format3 = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ssZZZ");
        SimpleDateFormat format4 = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");
        extSimpleDateFormats.add(format0);
        extSimpleDateFormats.add(format1);
        extSimpleDateFormats.add(format2);
        extSimpleDateFormats.add(format3);
        extSimpleDateFormats.add(format4);
    }

    // 序列化时会执行这个方法
    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo,
                               FieldPosition fieldPosition) {
        return dateFormat.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        Date date = null;

        try {
            date = dateFormat.parse(source, pos);
        } catch (Exception e) {
            // 不抛出异常,置空交给下个格式进行处理
            date = null;
        }
        if (date == null) {
            for(SimpleDateFormat sdf : extSimpleDateFormats){
                try {
                    date = sdf.parse(source, pos);
                    if(date!=null){
                        break;
                    }
                } catch (Exception ex) {
                    date = null;
                    continue;
                }
            }

        }

        return date;
    }

    // 此方法在objectmapper 默认的dateformat里边用到，这里也要重写
    @Override
    public Object clone() {
        DateFormat dateFormat = (DateFormat) this.dateFormat.clone();
        return new ObjectMapperDateFormatExtend(dateFormat);
    }
}
