import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class MethodInterception {

    @Test
    public void annotationValue(){
        MainPage mainPage = createPage(MainPage.class);
        Assert.assertNotNull(mainPage);
        Assert.assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        Assert.assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    private MainPage createPage(Class clazz) {
        MainPageInvocationHandler handler = new MainPageInvocationHandler();
        return (MainPage)
                Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},handler);
    }
}
