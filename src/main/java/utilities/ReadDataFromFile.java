package utilities;

import lombok.experimental.UtilityClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@UtilityClass
public class ReadDataFromFile {

    public static Properties readDataFromPropertiesFile(String path) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + path)) {
            properties.load(fileInputStream);
        }
        return properties;
    }

    public static Object readDataFromXmlFile(String path, Class<?> className) throws JAXBException {
        try {
            File file = new File(System.getProperty("user.dir") + path);
            JAXBContext jaxbContext = JAXBContext.newInstance(className);
            return jaxbContext.createUnmarshaller().unmarshal(file);

        } catch (JAXBException e) {
            throw new JAXBException("Error reading XML file: " + e.getMessage(), e);
        }
    }
}
