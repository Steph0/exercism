import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LanguageList {
    private final List<String> languages = new ArrayList<>();
    private Set<String> excitingOnes = Set.of("java", "kotlin");

    public boolean isEmpty() {
        return languages.isEmpty();
    }

    public void addLanguage(String language) {
        languages.add(language);
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    public String firstLanguage() {
        return languages.getFirst();
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        return languages.contains(language);
    }

    public boolean isExciting() {
        for (String currentLanguage : languages) {
            if(currentLanguage != null && excitingOnes.contains(currentLanguage.toLowerCase())){
                return true;
            }
        }

        return false;
    }
}
