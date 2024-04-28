import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

public class LangDetector {

    // Path to the directory containing language profiles
    private static final String PROFILES_DIRECTORY = "C:\\Users\\SAEEDH\\Downloads\\langProfiles"; // Provide the actual path here

    public  LangDetector(){ }

    // Metodo per rilevare la lingua di una stringa
    public  String detectLanguage(String testo) {
        try {
            // Inizializza il language detector
            DetectorFactory.loadProfile(PROFILES_DIRECTORY);

            // Crea il detector e rileva la lingua del testo
            Detector detector = DetectorFactory.create();
            detector.append(testo);
            return detector.detect();
        } catch (LangDetectException e) {
            e.printStackTrace();
            return "Unknown";

        }
    }


}
