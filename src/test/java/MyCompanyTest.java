
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class MyCompanyTest {

    @Test
    public void doRefresh() throws IllegalAccessException {
        Object[] expectedArray = new Object[] {"SuperSoft", "Johnie", "2019"};
        MyCompany.INSTANCE.doRefresh();
        Class<?> cl = MyCompany.INSTANCE.getClass();
        Field[] fields = cl.getDeclaredFields();
        for(Field field : fields)
        {
            if(field.isAnnotationPresent(Property.class))
            {
                field.setAccessible(true);
                if("address".equals(field.getName()))
                {
                    Address address = (Address) field.get(MyCompany.INSTANCE);
                    assertEquals(address.getStreet(), "Pushkina");
                    assertEquals(address.getHome(), Integer.valueOf(19));
                }
                else
                {
                    for(Object objectExpected : expectedArray)
                    {
                        if(field.get(MyCompany.INSTANCE).equals(objectExpected))
                        {
                            assertEquals(objectExpected, field.get(MyCompany.INSTANCE));
                        }
                    }
                }

            }
        }
    }
}