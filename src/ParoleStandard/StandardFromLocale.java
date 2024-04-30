package ParoleStandard;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StandardFromLocale implements ParoleStandard {

    String[] countryCodes;
    List<Standard> paroleStandard = new ArrayList<>();

    public StandardFromLocale(){
        countryCodes = Locale.getISOCountries();
        Locale[] locales = Locale.getAvailableLocales();
        int id = 1;
        for(Locale locale : locales){
            String countryCode = locale.getCountry();
            if (!countryCode.isEmpty()) {
                Standard standard = new Standard(id,locale.getCountry(), locale.getDisplayCountry(), 0);
                paroleStandard.add(standard);
                id = id + 1;
            }
        }


    }

    @Override
    public List<Standard> getStandards() {
        return paroleStandard;
    }
}
