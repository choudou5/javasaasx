package com.choudou5.javasaasx.framework.util;

import com.choudou5.javasaasx.framework.exception.BizException;
import com.choudou5.javasaasx.framework.util.ToolkitUtil;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @Name：断言工具类
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 15:39
 * @Site：http://www.javasaas.top
 * @License：MIT
 */
public class AssertUtil {

    /**
     * 是否为真
     *
     * @param expression - boolean
     * @param message - 错误提示
     */
    public static void isTrue( boolean expression, String message ) {
        if( !expression ) {
            throw new BizException( message );
        }
    }

    /**
     *
     * @param expression - boolean
     */
    public static void isTrue( boolean expression ) {
        isTrue( expression, "[Assertion failed] - this expression must be true" );
    }

    /**
     * 非空
     *
     * @param object
     * @param message
     */
    public static void isNotNull( Object object, String message ) {
        if( object == null ) {
            throw new BizException( message );
        }
    }

    /**
     * 非空
     *
     * @param object
     */
    public static void isNotNull( Object object ) {
        isNotNull( object,
                "[Assertion failed] - this argument is required; it must not be null" );
    }

    /**
     * 是否长度为空的字符串
     * @param text - string
     * @param message
     */
    public static void isNotEmpty( String text, String message ) {
        if(ToolkitUtil.isEmpty( text ) ) {
            throw new BizException( message );
        }
    }

    /**
     *
     *
     * @param text
     */
    public static void isNotEmpty( String text ) {
        isNotEmpty(text, "[Assertion failed] - this String argument must have length; it must not be null or empty" );
    }

    /**
     * 是否含有字符
     *
     * @param text
     * @param message
     */
    public static void hasText( String text, String message ) {
        if(ToolkitUtil.isBlank(text) ) {
            throw new BizException( message );
        }
    }

    /**
     *
     * @param text
     */
    public static void hasText( String text ) {
        hasText( text, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank" );
    }

    /**
     *
     * @param textToSearch
     * @param substring
     * @param message
     */
    public static void doesNotContain( String textToSearch, String substring,
                                       String message ) {
        if(ToolkitUtil.contains(textToSearch, substring) ) {
            throw new BizException( message );
        }
    }

    /**
     *
     *
     * @param textToSearch
     * @param substring
     */
    public static void doesNotContain( String textToSearch, String substring ) {
        doesNotContain( textToSearch, substring,
                "[Assertion failed] - this String argument must not contain the substring ["
                        + substring + "]" );
    }

    /**
     * 数组非空判定
     *
     * @param array
     * @param message
     */
    public static void notEmpty( Object[] array, String message ) {
        if(ToolkitUtil.isEmpty( array ) ) {
            throw new BizException( message );
        }
    }

    /**
     *
     * @param array
     */
    public static void notEmpty( Object[] array ) {
        notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element" );
    }

    /**
     *
     * @param array
     * @param message
     */
    public static void noNullElements( Object[] array, String message ) {
        if( array != null ) {
            for( int i = 0; i < array.length; i++ ) {
                if( array[ i ] == null ) {
                    throw new BizException( message );
                }
            }
        }
    }

    /**
     *
     * @param array
     */
    public static void noNullElements( Object[] array ) {
        noNullElements( array, "[Assertion failed] - this array must not contain any null elements" );
    }

    /**
     * 非空集合
     *
     * @param collection
     * @param message
     */
    public static <E> void notEmpty( Collection<E> collection, String message ) {
        isNotNull(collection, message);
        if( collection.isEmpty() ) {
            throw new BizException( message );
        }
    }

    /**
     *
     * @param collection
     */
    public static <E> void notEmpty( Collection<E> collection ) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    /**
     * 非空哈希
     *
     * @param map
     * @param message
     */
    public static <K, V> void notEmpty( Map<K, V> map, String message ) {
        isNotNull(map, message);
        if( map.isEmpty() ) {
            throw new BizException( message );
        }
    }

    /**
     *
     * @param map
     */
    public static <K, V> void notEmpty( Map<K, V> map ) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    /**
     * 是否是实例
     *
     * @param clazz
     * @param obj
     */
    public static void isInstanceOf( Class<?> clazz, Object obj ) {
        isInstanceOf(clazz, obj, "");
    }

    /**
     *
     * @param type
     * @param obj
     * @param message
     */
    public static void isInstanceOf( Class<?> type, Object obj, String message ) {
        isNotNull(type, "Type to check against must not be null");
        if( !type.isInstance( obj ) ) {
            throw new BizException( message + " Object of class ["
                    + ( obj != null ? obj.getClass().getName() : "null" )
                    + "] must be an instance of " + type );
        }
    }

    public static void isAssignable( Class<?> superType, Class<?> subType ) {
        isAssignable(superType, subType, "");
    }

    public static void isAssignable( Class<?> superType, Class<?> subType,
                                     String message ) {
        isNotNull(superType, "Type to check against must not be null");
        if( subType == null || !superType.isAssignableFrom( subType ) ) {
            throw new BizException( message + subType
                    + " is not assignable to " + superType );
        }
    }

    public static void state( boolean expression, String message ) {
        if( !expression ) {
            throw new BizException( message );
        }
    }

    public static void state( boolean expression ) {
        state( expression,
                "[Assertion failed] - this state invariant must be true" );
    }

    /**
     * 限定参数的长度不能超过指定值，否则抛出异常。 当 s 不等于null，并且长度超出maxLength才抛出异常。
     *
     * @param str - 要判断的字符串
     * @param maxLength  - 指定长度
     * @param message  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertMaxLength( String str, int maxLength, String message ) {
        if(ToolkitUtil.isEmpty(str) || str.length() > maxLength ) {
            throw new BizException( message );
        }
    }

    /**
     * 限定一个整数不能是负数，否则抛出BizException
     *
     * @param n  - 要判断的整数
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertNonnegativeInt( int n, String errorMessage ) {
        if( n < 0 ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 限定a必须大于等于b，否则抛出BizException
     *
     * @param a
     * @param b
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertGreaterThanOrEqual( int a, int b,
                                                 String errorMessage ) {
        assertGreaterThanOrEqual( Integer.valueOf( a ), Integer.valueOf( b ), errorMessage );
    }

    /**
     * 限定a必须大于等于b，否则抛出BizException
     *
     * @param a
     * @param b
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertGreaterThanOrEqual( Integer a, Integer b,
                                                 String errorMessage ) {
        isNotNull( a );
        isNotNull(b);
        if( a < b ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 限定a必须等于b，否则抛出BizException
     *
     * @param l
     * @param m
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertEqual( long l, long m, String errorMessage ) {
        assertEqual(Long.valueOf(l), Long.valueOf(m), errorMessage);
    }

    /**
     * 限定a必须等于b，否则抛出BizException
     *
     * @param l
     * @param m
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException  - 出错时抛出异常
     */
    public static void assertEqual( Long l, Long m, String errorMessage ) {
        isNotNull( l );
        isNotNull(m);
        if( !l.equals( m ) ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 限定a必须等于b，否则抛出BizException
     * @param l
     * @param m
     * @throws BizException - 出错时抛出异常
     */
    public static void assertEqual( String l, String m) {
        assertEqual(l, m, l + " not equal " + m);
    }

    /**
     * 限定a必须等于b，否则抛出BizException
     * @param l
     * @param m
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertEqual( String l, String m, String errorMessage ) {
        isNotNull( l );
        isNotNull(m);
        if( !l.equals( m ) ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 限定a必须大于等于b，否则抛出BizException
     *
     * @param a
     * @param b
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertGreaterThanOrEqual( long a, long b,
                                                 String errorMessage ) {
        assertGreaterThanOrEqual(Long.valueOf(a), Long.valueOf(b), errorMessage);
    }

    /**
     * 限定a必须大于等于b，否则抛出BizException
     *
     * @param a
     * @param b
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertGreaterThanOrEqual( Long a, Long b,
                                                 String errorMessage ) {
        isNotNull( a );
        isNotNull(b);
        if( a < b ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 限定a必须大于等于b，否则抛出BizException
     *
     * @param a
     * @param b
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertGreaterThan( long a, long b,
                                          String errorMessage ) {
        if( a <= b ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 限定a必须大于等于b，否则抛出BizException
     *
     * @param a
     * @param b
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertGreaterThan( Long a, Long b,
                                          String errorMessage ) {
        isNotNull( a );
        isNotNull( b );
        assertGreaterThan( a.longValue(), b.longValue(), errorMessage );
    }

    /**
     * 限定输入值必须是指定列表的其中之一，否则抛出BizException
     *
     * @param a - 输入值
     * @param errorMessage  - 出错时的异常错误信息
     * @param values - 指定列表
     * @throws BizException - 出错时抛出异常
     */
    public static void assertOneOfThem( short a, String errorMessage,
                                        short... values ) {
        boolean pass = false;
        if( values != null ) {
            for( short n : values ) {
                if( a == n ) {
                    pass = true;
                    break;
                }
            }
        } else {
            throw new BizException( "values为空" );
        }
        if( !pass ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 判断参数必须大于 0，否则抛出异常
     *
     * @param l  - 要判断的数字
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertGreaterThanZero( long l, String errorMessage ) {
        assertGreaterThanZero( Long.valueOf( l ), errorMessage );
    }

    /**
     * 判断参数必须大于 0，否则抛出异常
     *
     * @param l  - 要判断的数字
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertGreaterThanZero( Long l, String errorMessage ) {
        isNotNull(l, errorMessage);
        if( l < 1 ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 判断参数列表里必须有一个大于0
     *
     * @param values - 要判断的数字组合
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertOneOfThemThanZero( String errorMessage,
                                                int... values ) {
        boolean exception = true;
        if( values != null ) {
            for( int n : values ) {
                if( n >= 0 ) {
                    exception = false;
                    break;
                }
            }
        }
        if( exception ) {
            throw new BizException( errorMessage );
        }

    }

    /**
     * 判断参数不能为null，否则抛出异常
     *
     * @param o  - 要判断的参数
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertNotNull( Object o, String errorMessage ) {
        if( o == null ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 判断时间范围的合法性，end>=start，否则抛出异常
     * @param start - 开始时间，不能为null
     * @param end  - 结束时间，不能为null
     * @param errorMessage  - 出错时的异常错误信息
     * @throws BizException - 出错时抛出异常
     */
    public static void assertTimeRange( Date start, Date end, String errorMessage ) {
        if( start == null || end == null ) {
            throw new BizException( "start或end为空" );
        }
        if( start.after( end ) ) {
            throw new BizException( errorMessage );
        }
    }

    /**
     * 向外抛出异常
     * @param errorMessage
     */
    public static void outThrow(String errorMessage ) {
         throw new BizException( errorMessage );
    }
}
