import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public enum MyCompany
{
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(MyCompany.class.getName());

    MyCompany() {}

    @Property(propertyName = "com.mycompany.name")
    private String myCompanyName;

    @Property(propertyName = "com.mycompany.owner")
    private String myCompanyOwner;

    @Property(propertyName = "com.mycompany.address")
    private Address address;

    @Property(propertyName = "com.mycompany.years.old")
    private int yearsOld;

    public void doRefresh()
    {
        try {
            Properties property = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("property.properties");
            property.load(inputStream);
            JSONParser parser = new JSONParser();

            Class<?> refClass = INSTANCE.getClass();
            Field[] fields = refClass.getDeclaredFields();

            for (Field field : fields)
            {
                Property AnnoProperty = field.getAnnotation(Property.class);
                if (field.isAnnotationPresent(Property.class))
                {
                    if ("yearsOld".equals(field.getName()))
                    {
                        field.set(INSTANCE, Integer.parseInt(property.getProperty(AnnoProperty.propertyName())));
                    }
                    else if ("address".equals(field.getName()))
                    {
                        JSONArray jsonArray = (JSONArray) parser.parse(property.getProperty("com.mycompany.address"));
                        address = new Address();
                        for (Object object : jsonArray)
                        {
                            JSONObject jsonObject = (JSONObject) object;
                            address.setStreet((String) jsonObject.get("street"));
                            address.setHome(Integer.parseInt((String) jsonObject.get("home")));
                        }
                    } else
                    {
                        field.setAccessible(true);
                        field.set(INSTANCE, property.getProperty(AnnoProperty.propertyName()));

                    }
                }
            }

        } catch (Exception e)
        {
            Handler handler = new ConsoleHandler();
            LOGGER.addHandler(handler);
            LOGGER.info("info");
        }
    }
}







