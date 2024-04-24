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
        for(Locale locale : locales){
            String countryCode = locale.getCountry();
            if (!countryCode.isEmpty()) {
                Standard standard = new Standard(locale.getCountry(), locale.getDisplayCountry());
                paroleStandard.add(standard);
            }
        }

        for( Standard standard : paroleStandard){
            System.out.println(standard.getCode() + "  " +  standard.getValue());
        }
    }

    @Override
    public List<Standard> getStandards() {
        return paroleStandard;
    }
}
