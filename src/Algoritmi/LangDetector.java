package  Algoritmi;
import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

public class LangDetector {

    // Path to the directory containing language profiles
    private static final String PROFILES_DIRECTORY = "C:\\Users\\DASILVAS\\Downloads\\langProfiles";
    // Provide the actual path here

    static {
        try {
            // Initialize the language detector once
            DetectorFactory.loadProfile(PROFILES_DIRECTORY);
        } catch (LangDetectException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    public LangDetector() {}

    // Method to detect the language of a string
    public String detectLanguage(String text) {
        try {
            // Create the detector and detect the language of the text
            Detector detector = DetectorFactory.create();
            detector.append(text);
            return detector.detect();
        } catch (LangDetectException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }
}
