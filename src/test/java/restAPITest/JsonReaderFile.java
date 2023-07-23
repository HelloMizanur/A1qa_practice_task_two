package restAPITest;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
public class JsonReaderFile {
	public String JsonReader(String filename, String key) {
		ISettingsFile environment = new JsonSettingsFile(filename);
		Object value = environment.getValue(key);
		return String.valueOf(value);
	}
}