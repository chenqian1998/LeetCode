package 关键字;

public class ThrowsAndThrow {
    /*
    简单理解下异常体系：
    throwable接口有两个实现 Error and Exeception,
    Exception里面主要分为 RuntimeException 和 其他。
    RuntimeException：Java.lang.IndexOutOfBoundsException Java.lang.NullPointerException
     */

    public static double div(int a, int b) throws Exception{
        double res = a/b;
        return res;
    }

    public static void main(String[] args) throws Exception{
        // 1）throws： 作用在方法上，仅仅会将这个异常抛出，自己不处理让上级，其实就这个意思。。throws是很简单的
        // 调用者要么继续抛出，要么就try_catch处理掉
        // 2) throw :是抛出一个异常，抛出的是一个异常类的实例化对象，throw new GlobalExeception(CodeMsg.SessionError);
        //          try_catch 其实也是这样处理一个实例的异常
        //    一般要配一个相应的异常处理的类
        /*
        @ExceptionHandler(value = Exeception.class) 这说明对所有的异常都处理
        public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
            if (e instanceof GlobalException) {
                return Result.error(globalException.getCm());
            }
        }
         */
        System.out.println(div(10, 0));

    }
}
