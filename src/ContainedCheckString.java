import Algoritmi.CheckString;

public class ContainedCheckString extends CheckString {
    @Override
    public boolean check (String input, String standard) {

        return  standard.contains(input);
    }
}
