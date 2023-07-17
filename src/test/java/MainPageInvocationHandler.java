import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MainPageInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Selector selectorAnnotation = method.getAnnotation(Selector.class); // Получаем аннотацию Selector для метода
            if(selectorAnnotation != null){
                return selectorAnnotation.xpath();// Возвращаем значение атрибута xpath из аннотации
            }
        return null;
    }
}
